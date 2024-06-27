package com.example.sneakpeak.Repository;

import com.example.sneakpeak.Entity.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller,Long> {
}
