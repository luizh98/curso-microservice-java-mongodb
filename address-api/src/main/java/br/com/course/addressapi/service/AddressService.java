package br.com.course.addressapi.service;

import br.com.course.addressapi.controller.request.AddressRequest;
import br.com.course.addressapi.controller.response.AddressResponse;
import br.com.course.addressapi.model.Address;
import br.com.course.addressapi.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressResponse createAddress(AddressRequest addressRequest) {
        Address address = addressRepository.save(Address.builder()
                .customerId(addressRequest.getCustomerId())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .build());

        return AddressResponse.convertAddress(address);
    }

}
