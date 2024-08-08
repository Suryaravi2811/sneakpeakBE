package com.example.sneakpeak.Controller;

import com.example.sneakpeak.Service.PayPalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/payments")
public class PayPalController {

    @Autowired
    private PayPalService payPalService;

    @PostMapping("/pay")
    public String pay(@RequestParam("sum") Double sum, HttpServletRequest request) {
        String cancelUrl = "http://localhost:3000/cancel";
        String successUrl = "http://localhost:3000/success";
        try {
            Payment payment = payPalService.createPayment(sum, "USD", "paypal", "sale", "Payment description", cancelUrl, successUrl);
            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/success")
    public String success(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = payPalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "cancel";
    }
}

