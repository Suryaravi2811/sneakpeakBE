package com.example.sneakpeak.Service;

import com.example.sneakpeak.DTO.SellerDTO;
import com.example.sneakpeak.Entity.Seller;
import com.example.sneakpeak.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellerService {
    @Autowired
   SellerRepository sellerRepository;

    @Transactional
    public String sellerPostApi(SellerDTO sellerDTO){
        Seller seller = new Seller();
        seller.setId(sellerDTO.getId());
        seller.setSellerName(sellerDTO.getSellerName());
        seller.setAge(sellerDTO.getAge());
        seller.setCompanyName(sellerDTO.getCompanyName());
        seller.setAddress(sellerDTO.getAddress());
        seller.setUserName(sellerDTO.getUserName());
        sellerRepository.save(seller);
        return "registered successfully";
    }
}
