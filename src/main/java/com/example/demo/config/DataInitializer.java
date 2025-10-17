package com.example.demo.config;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() > 0) {
            System.out.println("✅ Data already exists, skipping fetch.");
            return;
        }

        String url = "https://famme.no/products.json";
        RestTemplate restTemplate = new RestTemplate();

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            List<Map<String, Object>> products = (List<Map<String, Object>>) response.get("products");

            for (Map<String, Object> productData : products) {
                String title = (String) productData.get("title");
                String handle = (String) productData.get("handle");
                String vendor = (String) productData.get("vendor");

                List<Map<String, Object>> variants = (List<Map<String, Object>>) productData.get("variants");
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(variants.get(0).get("price").toString()));

                List<Map<String, Object>> images = (List<Map<String, Object>>) productData.get("images");
                String image = images.isEmpty() ? null : (String) images.get(0).get("src");

                Product product = new Product(title, price, handle, vendor, image);
                productRepository.save(product);
            }

            System.out.println("✅ Products fetched and saved successfully!");

        } catch (Exception e) {
            System.err.println("❌ Failed to fetch products: " + e.getMessage());
        }
    }
}
