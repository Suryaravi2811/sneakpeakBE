package com.example.sneakpeak.Controller;

import com.example.sneakpeak.DTO.StripeChargeDTO;
import com.example.sneakpeak.DTO.StripeTokenDTO;
import com.example.sneakpeak.Service.StripeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stripe")
@AllArgsConstructor
public class StripeApiController {

    private final StripeService stripeService;
//    @PostMapping("/card/token")
//    public StripeTokenDTO createCardToken(@RequestBody StripeTokenDTO stripeTokenDTO){
//        return stripeService.createCardToken(stripeTokenDTO);
//    }
//
//    @PostMapping("/charge")
//
//    public StripeChargeDTO charge(@RequestBody StripeChargeDTO stripeChargeDTO){
//        return stripeService.charge(stripeChargeDTO);
//    }
@PostMapping("/card/token")
@ResponseBody
public StripeTokenDTO createCardToken(@RequestBody StripeTokenDTO model) {


    return stripeService.createCardToken(model);
}

    @PostMapping("/charge")
    @ResponseBody
    public StripeChargeDTO charge(@RequestBody StripeChargeDTO model) {

        return stripeService.charge(model);
    }

}
