package com.example.restservice;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Employee {

    private String employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;

}
