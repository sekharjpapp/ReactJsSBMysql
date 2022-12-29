package com.pixel.camelroute;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RestConsumerRouter extends RouteBuilder {
    private final String url = "http://localhost:8080/car/api";
    @Override
    public void configure() throws Exception {
        from("timer://test-rest-api?period=1000")
                .log("Rest Consumer from Spring boot")
                .setHeader(Exchange.HTTP_METHOD,simple("GET"))
                .to(url)
                .process(exchange -> {
                    String output = exchange.getIn().getBody(String.class);
                    System.out.println("output is " + output);
                });
    }
}
