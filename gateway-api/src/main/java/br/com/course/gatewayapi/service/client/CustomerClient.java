package br.com.course.gatewayapi.service.client;

import br.com.course.gatewayapi.controller.request.CustomerRequest;
import br.com.course.gatewayapi.controller.response.CustomerResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Logger;

@FeignClient(name = "customer-api", url = "${apis.customer-api.url}")
public interface CustomerClient {

    Logger LOGGER = Logger.getLogger(CustomerClient.class.getName());

    @CircuitBreaker(name = "create-customer", fallbackMethod = "fallbackCreateCustomer")
    @PostMapping("/api/v1/customer")
    CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest);

    default CustomerResponse fallbackCreateCustomer(Throwable throwable) {
        LOGGER.warning("CustomerClient - method fallbackCreateCustomer");
        return null;
    }

    @CircuitBreaker(name = "get-customer-by-id", fallbackMethod = "fallbackGetCustomerById")
    @GetMapping("/api/v1/customer/{customerId}")
    CustomerResponse getCustomerById(@PathVariable String customerId);

    default CustomerResponse fallbackGetCustomerById(Throwable throwable) {
        LOGGER.warning("CustomerClient - method fallbackGetCustomerById");
        return null;
    }

}
