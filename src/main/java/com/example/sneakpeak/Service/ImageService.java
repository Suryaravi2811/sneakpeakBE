package com.example.sneakpeak.Service;

import com.example.sneakpeak.Entity.Image;
import com.example.sneakpeak.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setData(file.getBytes());
        return imageRepository.save(image);
    }
    public Image getImage(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public List<Image> getAllImages() {
        return (List<Image>) imageRepository.findAll();
    }
}
