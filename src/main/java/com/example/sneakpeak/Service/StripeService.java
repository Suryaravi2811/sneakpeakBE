package com.example.sneakpeak.Service;

import com.example.sneakpeak.DTO.StripeChargeDTO;
import com.example.sneakpeak.DTO.StripeTokenDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class StripeService {
    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostConstruct
    public  void  init(){
        Stripe.apiKey = stripeApiKey;
    }

//   public StripeTokenDTO createCardToken(StripeTokenDTO stripeTokenDTO) {
//
//       try {
//
//           Map<String,Object> card = new HashMap<>();
//            card.put("number",stripeTokenDTO.getCardNumber());
//            card.put("exp_month",Integer.parseInt(stripeTokenDTO.getExpMonth()));
//            card.put("exp_year",Integer.parseInt(stripeTokenDTO.getExpYear()));
//            card.put("cvc",stripeTokenDTO.getCvc());
//            Map<String,Object> params = new HashMap<>();
//            params.put("card",card);
//           Token token = Token.create(params);
//           if (token != null && token.getId()!= null){
//               stripeTokenDTO.setSuccess(true);
//               stripeTokenDTO.setToken(token.getId());
//           }
//            return stripeTokenDTO;
//       }  catch (StripeException e) {
//           log.error("stripeService (createCardToken)",e);
//           throw new RuntimeException(e);
//       }
//   }
//
//   public StripeChargeDTO charge(StripeChargeDTO stripeChargeDTO){
//        try {
//            stripeChargeDTO.setSuccess(false);
//            Map<String,Object> chargeParams = new HashMap<>();
//            chargeParams.put("amount",(int)(stripeChargeDTO.getAmount() *100));
//            chargeParams.put("description", "Payment for id " + stripeChargeDTO.getAdditionalInfo().getOrDefault("ID_TAG", ""));
//            chargeParams.put("source",stripeChargeDTO.getStripeToken());
//            Map<String,Object> metaData = new HashMap<>();
//            metaData.put("id",stripeChargeDTO.getChargeId());
//            metaData.putAll(stripeChargeDTO.getAdditionalInfo());
//            chargeParams.put("metaData",metaData);
//            Charge charge = Charge.create(chargeParams);
//            stripeChargeDTO.setMessage(charge.getOutcome().getSellerMessage());
//
//            if (charge.getPaid()){
//                stripeChargeDTO.setChargeId(charge.getId());
//                stripeChargeDTO.setSuccess(true);
//            }
//            return stripeChargeDTO;
//        } catch (StripeException e) {
//            throw new RuntimeException(e);
//        }
//
//   }

    public StripeTokenDTO createCardToken(StripeTokenDTO model) {

        try {
            Map<String, Object> card = new HashMap<>();
            card.put("number", model.getCardNumber());
            card.put("exp_month", Integer.parseInt(model.getExpMonth()));
            card.put("exp_year", Integer.parseInt(model.getExpYear()));
            card.put("cvc", model.getCvc());
            Map<String, Object> params = new HashMap<>();
            params.put("card", card);
            Token token = Token.create(params);
            if (token != null && token.getId() != null) {
                model.setSuccess(true);
                model.setToken(token.getId());
            }
            return model;
        } catch (StripeException e) {
            log.error("StripeService (createCardToken)", e);
            throw new RuntimeException(e.getMessage());
        }

    }

    public StripeChargeDTO charge(StripeChargeDTO chargeRequest) {


        try {
            chargeRequest.setSuccess(false);
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", (int) (chargeRequest.getAmount() * 100));
            chargeParams.put("currency", "USD");
            chargeParams.put("description", "Payment for id " + chargeRequest.getAdditionalInfo().getOrDefault("ID_TAG", ""));
            chargeParams.put("source", chargeRequest.getStripeToken());
            Map<String, Object> metaData = new HashMap<>();
            metaData.put("id", chargeRequest.getChargeId());
            metaData.putAll(chargeRequest.getAdditionalInfo());
            chargeParams.put("metadata", metaData);
            Charge charge = Charge.create(chargeParams);
            chargeRequest.setMessage(charge.getOutcome().getSellerMessage());

            if (charge.getPaid()) {
                chargeRequest.setChargeId(charge.getId());
                chargeRequest.setSuccess(true);

            }
            return chargeRequest;
        } catch (StripeException e) {
            log.error("StripeService (charge)", e);
            throw new RuntimeException(e.getMessage());
        }

    }

}
