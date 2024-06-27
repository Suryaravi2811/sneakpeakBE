package com.example.sneakpeak.Controller;

import com.example.sneakpeak.DTO.SellerDTO;
import com.example.sneakpeak.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seller")
public class SellerController {
    @Autowired
    SellerService sellerService;
    @PostMapping("postApi")
    public String postApi(@RequestBody SellerDTO sellerDTO){
        return sellerService.sellerPostApi(sellerDTO);
    }
}
