package com.example.sneakpeak.Controller;

import com.example.sneakpeak.DTO.ProductDTO;
import com.example.sneakpeak.Entity.Product;
import com.example.sneakpeak.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("postApi")
    public Product postProductsOfDB(@RequestBody  ProductDTO productDTO){
        return productService.postProducts(productDTO);
    }

    @GetMapping
    public List<ProductDTO> getProdutsOFDB(){
        return productService.getAllProducts();
    }
}
