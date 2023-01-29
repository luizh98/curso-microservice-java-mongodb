package br.com.course.gatewayapi.service;

import br.com.course.gatewayapi.controller.request.CustomerRequest;
import br.com.course.gatewayapi.controller.response.CustomerResponse;
import br.com.course.gatewayapi.exception.runtime.ObjectNotFoundException;
import br.com.course.gatewayapi.service.client.CustomerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerClient customerClient;

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        CustomerResponse customer = customerClient.createCustomer(customerRequest);
        if (isNull(customer)) {
            throw new ObjectNotFoundException("Customer is null!");
        }

        return customer;
    }

    public CustomerResponse returnCustomerById(String id) {
        CustomerResponse customer = customerClient.getCustomerById(id);
        if (isNull(customer)) {
            throw new ObjectNotFoundException("Customer is null!");
        }

        return customer;
    }

}
