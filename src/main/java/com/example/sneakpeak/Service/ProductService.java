package com.example.sneakpeak.Service;

import com.example.sneakpeak.DTO.ProductDTO;
import com.example.sneakpeak.Entity.Product;
import com.example.sneakpeak.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
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
//        productDTO.setImage(product.getImage());
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
//        product.setDetails(productDTO.getDetails());
//        try {
//            product.setImage(file.getBytes());
//        } catch ( IOException e) {
//            throw new RuntimeException("Failed to store file data", e);
//        }
        product.setType(productDTO.getType());
        product.setPrice(productDTO.getPrice());
        product.setWater(productDTO.getWater());
        product.setStyle(productDTO.getStyle());
        product.setName(productDTO.getName());
        product.setManufacturerDetails(productDTO.getManufacturerDetails());
        productRepository.save(product);
        return product;

    }

    public void uploadImagesOfProducts(MultipartFile file) throws IOException {
        Product product = new Product();
        product.setImage(file.getBytes());
        productRepository.save(product);
    }

//    public String postDataAndImages(ProductDTO productDTO,MultipartFile file) throws IOException {
//        productRepository.save(Product.builder().brand(productDTO.getBrand()).color(productDTO.getColor()).
//                id(productDTO.getId()).heel(productDTO.getHeel()).price(productDTO.getPrice()).name(productDTO.getName())
//                .style(productDTO.getStyle()).closure(productDTO.getClosure()).type(productDTO.getType())
//                .water(productDTO.getWater()).details(productDTO.getDetails()).manufacturerDetails(productDTO.getManufacturerDetails()).delivery(productDTO.getDelivery())
//                .description(productDTO.getDescription()).image(file.getBytes()).build());
//        return "successfully uploaded";
//    }
}
