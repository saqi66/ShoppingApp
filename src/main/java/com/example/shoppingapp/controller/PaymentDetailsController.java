package com.example.shoppingapp.controller;

import com.example.shoppingapp.dto.PaymentDetailsDto;
import com.example.shoppingapp.dto.request.PaymentDetailsRequest;
import com.example.shoppingapp.service.PaymentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/paymentDetails")
public class PaymentDetailsController {

    final PaymentDetailsService paymentDetailsService;

    @GetMapping(value = "/paymentDetailsList")
    public List<PaymentDetailsDto> getPaymentDetailsInfo() {
        return paymentDetailsService.getAll();
    }

    @GetMapping(value = "/getPaymentDetailsById/{id}")
    public PaymentDetailsDto getPaymentDetailsById(@PathVariable(value = "id") Long id) {
        return paymentDetailsService.getPaymentDetailsById(id);
    }

    @PostMapping(value = "/savePaymentDetails")
    public void savePaymentDetails(@RequestBody PaymentDetailsRequest paymentDetailsRequest) {
        paymentDetailsService.savePaymentDetails(paymentDetailsRequest);
    }

    @PostMapping(value = "/updatePaymentDetails")
    public void updatePaymentDetails(@RequestBody PaymentDetailsRequest paymentDetailsRequest) {
        paymentDetailsService.updatePaymentDetails(paymentDetailsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        paymentDetailsService.deleteById(id);
    }

}

