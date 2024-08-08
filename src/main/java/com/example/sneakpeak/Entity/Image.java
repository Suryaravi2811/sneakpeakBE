package com.example.sneakpeak.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private byte[] data;
}
