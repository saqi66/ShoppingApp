package com.example.shoppingapp.service.impl;

import com.example.shoppingapp.dto.PaymentDetailsDto;
import com.example.shoppingapp.dto.request.PaymentDetailsRequest;
import com.example.shoppingapp.model.PaymentDetails;
import com.example.shoppingapp.repository.PaymentDetailsRepository;
import com.example.shoppingapp.service.PaymentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    private final PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public PaymentDetailsDto getPaymentDetailsById(Long id) {
        PaymentDetails paymentDetails = paymentDetailsRepository.getPaymentDetailsById(id);
        return PaymentDetailsDto.builder()
                .amount(paymentDetails.getAmount())
                .provider(paymentDetails.getProvider())
                .status(paymentDetails.getStatus())
                .createdAt(paymentDetails.getCreatedAt())
                .modifiedAt(paymentDetails.getModifiedAt())
                .build();
    }

    @Override
    public void savePaymentDetails(PaymentDetailsRequest paymentDetailsRequest) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .amount(paymentDetailsRequest.getAmount())
                .provider(paymentDetailsRequest.getProvider())
                .status(paymentDetailsRequest.getStatus())
                .createdAt((Date) paymentDetailsRequest.getCreatedAt())
                .modifiedAt((Date) paymentDetailsRequest.getModifiedAt())
                .build();

        paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public void updatePaymentDetails(PaymentDetailsRequest paymentDetailsRequest) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .id(paymentDetailsRequest.getId())
                .amount(paymentDetailsRequest.getAmount())
                .provider(paymentDetailsRequest.getProvider())
                .status(paymentDetailsRequest.getStatus())
                .createdAt((Date) paymentDetailsRequest.getCreatedAt())
                .modifiedAt((Date) paymentDetailsRequest.getModifiedAt())
                .build();

        paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public List<PaymentDetailsDto> getAll() {
        List<PaymentDetails> paymentDetails = paymentDetailsRepository.findAll();
        List<PaymentDetailsDto> paymentDetailsDtos = new ArrayList<>();

        for (PaymentDetails paymentDetail : paymentDetails) {
            PaymentDetailsDto paymentDetailsDto = PaymentDetailsDto.builder()
                    .amount(paymentDetail.getAmount())
                    .provider(paymentDetail.getProvider())
                    .status(paymentDetail.getStatus())
                    .createdAt(paymentDetail.getCreatedAt())
                    .modifiedAt(paymentDetail.getModifiedAt())
                    .build();

            paymentDetailsDtos.add(paymentDetailsDto);
        }

        return paymentDetailsDtos;
    }


    @Override
    public void deleteById(Long id) {
        PaymentDetails paymentDetails = paymentDetailsRepository.getPaymentDetailsById(id);
        if (paymentDetails == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            paymentDetailsRepository.deleteById(id);
        }
    }
}
