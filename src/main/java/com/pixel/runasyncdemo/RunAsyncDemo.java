package com.pixel.runasyncdemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pixel.model.EmpJson;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class RunAsyncDemo {

    public Void saveEmployees(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        CompletableFuture<Void> runAyncFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    List<EmpJson> empJsonList = mapper.readValue(jsonFile, new TypeReference<List<EmpJson>>() {
                    });
                    //repository.saveAll(empJsonList);
                    System.out.println("Thread " + Thread.currentThread().getName());
                    empJsonList.stream().forEach(System.out::println);
                    System.out.println(empJsonList.stream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
      return   runAyncFuture.get();
    }
}
