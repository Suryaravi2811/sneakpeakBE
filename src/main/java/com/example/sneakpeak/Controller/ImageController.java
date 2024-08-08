package com.example.sneakpeak.Controller;

import com.example.sneakpeak.Entity.Image;
import com.example.sneakpeak.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadImage(@RequestParam(value = "file") MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {
                imageService.saveImage(file);
            }
            return new ResponseEntity<>("Images uploaded successfully", HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload images", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Image image = imageService.getImage(id);
        if (image == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(image.getData(), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.getAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

}
