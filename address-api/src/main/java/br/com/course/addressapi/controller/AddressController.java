package br.com.course.addressapi.controller;

import br.com.course.addressapi.controller.request.AddressRequest;
import br.com.course.addressapi.controller.response.AddressResponse;
import br.com.course.addressapi.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponse createAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.createAddress(addressRequest);
    }

}
