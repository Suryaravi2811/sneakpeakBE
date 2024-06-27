package com.example.sneakpeak.Controller;

import com.example.sneakpeak.client.StripeClient;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class StripeController {

    private final StripeClient stripeClient;

    @Autowired
    StripeController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("/charge")
    public ResponseEntity chargeCard(@RequestHeader(value="token") String token, @RequestHeader(value="amount") Double amount) {
        try {
            System.out.println("Token: " + token);
            System.out.println("Amount: " + amount);
            Charge charge = this.stripeClient.chargeNewCard(token, amount);
            return new ResponseEntity<>(charge, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
