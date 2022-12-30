package com.pixel.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResource extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);
        rest("/say")
                .get().to("direct:hello");

        from("direct:hello")
                .transform().constant("Hello World");
    }
}
