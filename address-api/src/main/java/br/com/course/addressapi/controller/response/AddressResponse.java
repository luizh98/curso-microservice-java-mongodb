package br.com.course.addressapi.controller.response;

import br.com.course.addressapi.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {

    private String city;
    private String state;

    public static AddressResponse convertAddress(Address address) {
        return AddressResponse.builder()
                .city(address.getCity())
                .state(address.getState())
                .build();
    }

}
