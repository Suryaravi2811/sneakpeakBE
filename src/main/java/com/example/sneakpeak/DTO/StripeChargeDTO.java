package com.example.sneakpeak.DTO;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class StripeChargeDTO {
    private String stripeToken;
    private String userName;
    private Double amount;
    private Boolean success;
    private String message;
    private String chargeId;
    private Map<String,Object> additionalInfo= new HashMap<>();
}
