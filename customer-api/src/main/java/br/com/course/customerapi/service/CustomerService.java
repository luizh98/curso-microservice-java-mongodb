package br.com.course.customerapi.service;

import br.com.course.customerapi.controller.request.AddressRequest;
import br.com.course.customerapi.controller.request.CustomerRequest;
import br.com.course.customerapi.controller.response.AddressResponse;
import br.com.course.customerapi.controller.response.CustomerResponse;
import br.com.course.customerapi.model.Customer;
import br.com.course.customerapi.repository.CustomerRepository;
import br.com.course.customerapi.service.client.AddressClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final AddressClient addressClient;

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customerSaved = customerRepository.save(Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .build());

        AddressResponse addressResponse = addressClient.createAddress(AddressRequest.builder()
                .customerId(customerSaved.getId())
                .city(customerRequest.getCity())
                .state(customerRequest.getState())
                .build());

        return CustomerResponse.convertCustomer(customerSaved, addressResponse);
    }

    public CustomerResponse returnCustomerById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer is not found!"));

        return CustomerResponse.convertCustomer(customer, null);
    }

}
