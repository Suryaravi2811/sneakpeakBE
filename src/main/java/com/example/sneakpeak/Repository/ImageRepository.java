package com.example.sneakpeak.Repository;

import com.example.sneakpeak.Entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image,Long> {
}
