package br.com.course.customerapi.service.client;

import br.com.course.customerapi.controller.request.AddressRequest;
import br.com.course.customerapi.controller.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Logger;

@FeignClient(name = "address-api", url = "${apis.address-api.url}")
public interface AddressClient {

    Logger LOGGER = Logger.getLogger(AddressClient.class.getName());

    @CircuitBreaker(name = "create-address", fallbackMethod = "fallbackCreateAddress")
    @PostMapping(value = "/api/v1/address")
    AddressResponse createAddress(@RequestBody AddressRequest addressRequest);

    default AddressResponse fallbackCreateAddress(Throwable throwable) {
        LOGGER.warning("AddressClient - method fallbackCreateAddress");
        return null;
    }

}
