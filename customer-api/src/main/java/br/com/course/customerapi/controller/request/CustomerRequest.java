package br.com.course.customerapi.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {

    private String name;
    private Integer age;
    private String city;
    private String state;

}
