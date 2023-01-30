package br.com.course.customerapi.service;

import br.com.course.customerapi.controller.request.CustomerRequest;
import br.com.course.customerapi.controller.response.CustomerResponse;
import br.com.course.customerapi.model.Customer;
import br.com.course.customerapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customerSaved = customerRepository.save(Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .build());

        return CustomerResponse.convertCustomer(customerSaved);
    }

    public CustomerResponse returnCustomerById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer is not found!"));

        return CustomerResponse.convertCustomer(customer);
    }

}
