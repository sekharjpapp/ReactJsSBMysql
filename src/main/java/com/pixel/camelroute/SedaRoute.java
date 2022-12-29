package com.pixel.camelroute;

import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.DefaultMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConditionalOnProperty(name = "jss.camel.seda.enabled" , havingValue = "true", matchIfMissing = true)
public class SedaRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:ping:period=200")
                .process(exchange -> {
                    Message message = new DefaultMessage(exchange);
                    message.setBody(new Date());
                    exchange.setMessage(message);
                })
                        .to("seda:weightLifter?multipleConsumers=true");
         from("seda:weightLifter?multipleConsumers=true")
                .to("direct:complexProcess");
        from("direct:complexProcess")
                .log(LoggingLevel.ERROR,"${body}")
                .process(exchange -> Thread.sleep(20000))
                .end();
    }
}
