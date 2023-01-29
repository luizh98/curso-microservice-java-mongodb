package br.com.course.gatewayapi.controller;

import br.com.course.gatewayapi.controller.response.CustomerResponse;
import br.com.course.gatewayapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse returnAllCustomers() {

        return customerService.returnAllCustomers();
    }

}
