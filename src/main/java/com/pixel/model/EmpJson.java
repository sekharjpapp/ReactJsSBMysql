package com.pixel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpJson {

    public String employeeId;
    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String newJoiner;
    public String learningPending;
    public int salary;
    public int rating;
}
