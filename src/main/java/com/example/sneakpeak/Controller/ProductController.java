package com.example.sneakpeak.Controller;

import com.example.sneakpeak.DTO.ProductDTO;
import com.example.sneakpeak.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "postApi",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = "application/json")
    public ResponseEntity postProductsOfDB(@RequestBody  ProductDTO productDTO, @RequestParam MultipartFile[] files){
       for (MultipartFile file:files) {
           productService.postProducts(productDTO);
       }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping(value = "uploadImage",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = "application/json")
    public String uploadProductImage(@RequestParam MultipartFile[] files) throws IOException {
        for (MultipartFile file:files){
            productService.uploadImagesOfProducts(file);
        }
        return "image successfully uploaded";
    }


//@PostMapping(value = "/postApi", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity<Void> postProductsOfDB(@RequestPart("productDTO") ProductDTO productDTO, @RequestPart("file") MultipartFile file) throws IOException {
//    System.out.println("Received productDTO: " + productDTO);
//    System.out.println("Received file: " + file.getOriginalFilename());
////    productService.postProducts(productDTO, file);
//    productService.postDataAndImages(productDTO,file);
//    return ResponseEntity.status(HttpStatus.CREATED).build();
//}



    @GetMapping
    public List<ProductDTO> getProdutsOFDB(){
        return productService.getAllProducts();
    }
}
