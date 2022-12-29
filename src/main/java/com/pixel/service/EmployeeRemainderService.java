package com.pixel.service;

import com.pixel.model.EmpJson;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class EmployeeRemainderService {

    public CompletableFuture<Void> sendRemainderToEmployee() {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("fetch Employee jsonDB " + Thread.currentThread().getName());
            return EmployeeJsonDB.fetchEmployees();
        }).thenApplyAsync((emp) -> {
            System.out.println("filter NewJoiner " + Thread.currentThread().getName());
            return emp.stream().filter(e -> "TRUE".equals(e.getNewJoiner()))
                    .collect(Collectors.toList());
        }).thenApplyAsync((emp) -> {
            System.out.println("filter LearningPending " + Thread.currentThread().getName());
            return emp.stream().filter(e -> "TRUE".equals(e.getLearningPending()))
                    .collect(Collectors.toList());

        }).thenApplyAsync((emp) -> {
            System.out.println("filter  Emails " + Thread.currentThread().getName());
            return emp.stream().map(EmpJson::getEmail).collect(Collectors.toList());
        }).thenAcceptAsync((emails) -> {
            System.out.println("sending remainder emails  Emails " + Thread.currentThread().getName());
            emails.forEach(email -> sendEmail(email));
        });
        return voidCompletableFuture;
    }
    public static void sendEmail(String email) {
        System.out.println("sending training remainder emails to : " + email);
    }
}
