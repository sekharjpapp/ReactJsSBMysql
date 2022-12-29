package com.pixel.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pixel.model.EmpJson;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeJsonDB {

    public static List<EmpJson> fetchEmployees() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("empData.json"), new TypeReference<List<EmpJson>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
