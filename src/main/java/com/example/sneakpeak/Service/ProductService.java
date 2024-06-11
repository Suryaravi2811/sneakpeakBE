package com.example.sneakpeak.Service;

import com.example.sneakpeak.DTO.ProductDTO;
import com.example.sneakpeak.Entity.Product;
import com.example.sneakpeak.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
   private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setImage(product.getImage());
        productDTO.setType(product.getType());
        productDTO.setPrice(product.getPrice());
        productDTO.setDelivery(product.getDelivery());
        productDTO.setDescription(product.getDescription());
        productDTO.setDetails(product.getDetails());
        productDTO.setWater(product.getWater());
        productDTO.setStyle(product.getStyle());
        productDTO.setClosure(product.getClosure());
        productDTO.setHeel(product.getHeel());
        productDTO.setCountry(product.getCountry());
        productDTO.setColor(product.getColor());
        productDTO.setBrand(product.getBrand());
        productDTO.setManufacturerDetails(product.getManufacturerDetails());
        return productDTO;
    }

    @Transactional
    public Product postProducts(ProductDTO productDTO) {
        Product product = new Product();

        product.setBrand(productDTO.getBrand());
        product.setClosure(productDTO.getClosure());
        product.setColor(productDTO.getColor());
        product.setDescription(productDTO.getDescription());
        product.setDelivery(productDTO.getDelivery());
        product.setCountry(productDTO.getCountry());
        product.setHeel(productDTO.getHeel());
        product.setDetails(productDTO.getDetails());
        product.setImage(productDTO.getImage());
        product.setType(productDTO.getType());
        product.setPrice(productDTO.getPrice());
        product.setWater(productDTO.getWater());
        product.setStyle(productDTO.getStyle());
        product.setName(productDTO.getName());
        product.setManufacturerDetails(productDTO.getManufacturerDetails());
        productRepository.save(product);
        return product;

    }
}
