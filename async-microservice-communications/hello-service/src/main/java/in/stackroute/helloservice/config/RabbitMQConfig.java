package in.stackroute.helloservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "Audit_Info_Q";
    // An exchange is a very simple thing. On one side it receives messages from producers
    // and the other side it pushes them to queues.
    public static final String EXCHANGE = "Audit_Info_Direct_Exchange";

    // We will create a bean for the queue, the exchange and the binding between them.
    @Bean
    public Queue queue() {
        // The first argument is the name of the queue and the second argument is a boolean value
        // which indicates whether the queue is durable or not. Durability means that the queue will
        // survive a broker restart.
        return new Queue(QUEUE, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    // The binding between the queue and the exchange is done in the following method.
    // The first argument is the queue and the second argument is the exchange.
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        // The third argument is the routing key. The routing key is a message attribute the
        // exchange looks at when deciding how to route the message to queues (depending on exchange type).
        return BindingBuilder.bind(queue).to(exchange).with("audit.trail.routingkey");
    }
}

