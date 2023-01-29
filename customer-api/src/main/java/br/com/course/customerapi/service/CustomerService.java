package br.com.course.gatewayapi.service;

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

    public CustomerResponse returnAllCustomers() {
        CustomerResponse allCustomer = customerClient.getAllCustomers();
        if (isNull(allCustomer)) {
            throw new ObjectNotFoundException("All customers are null!");
        }

        return allCustomer;
    }

}
