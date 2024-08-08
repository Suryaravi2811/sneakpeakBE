package com.example.sneakpeak.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    @Lob
    private byte[] image;
    private String type;
    private String price;
    private String delivery;
    private String description;
    private String details;
    private String water;
    private String style;
    private String closure;
    private String heel;
    private String country;
    private String color;
    private String brand;
    private String manufacturerDetails;


}
