package br.com.course.customerapi.controller.response;

import br.com.course.customerapi.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerResponse {

    private String name;
    private Integer age;
    private Integer number;
    private String state;
    private String city;

    public static CustomerResponse convertCustomer(Customer customer, AddressResponse addressResponse) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .city(!isNull(addressResponse) ? addressResponse.getCity() : "")
                .state(!isNull(addressResponse) ? addressResponse.getState() : "")
                .build();
    }

}
