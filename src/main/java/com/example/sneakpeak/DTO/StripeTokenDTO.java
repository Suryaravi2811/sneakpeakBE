package com.example.sneakpeak.DTO;

import lombok.Data;

@Data
public class StripeTokenDTO {
    private String cardNumber;
    private String expMonth;
    private String expYear;
    private String cvc;
    private String token;
    private String userName;
    private Boolean success;

}
