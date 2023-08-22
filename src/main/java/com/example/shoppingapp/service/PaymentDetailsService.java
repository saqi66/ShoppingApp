package com.example.shoppingapp.service;

import com.example.shoppingapp.dto.PaymentDetailsDto;
import com.example.shoppingapp.dto.request.PaymentDetailsRequest;

import java.util.List;

public interface PaymentDetailsService {
    PaymentDetailsDto getPaymentDetailsById(Long id);

    void savePaymentDetails(PaymentDetailsRequest paymentDetailsRequest);

    void updatePaymentDetails(PaymentDetailsRequest paymentDetailsRequest);

    List<PaymentDetailsDto> getAll();

    void deleteById(Long id);

}
