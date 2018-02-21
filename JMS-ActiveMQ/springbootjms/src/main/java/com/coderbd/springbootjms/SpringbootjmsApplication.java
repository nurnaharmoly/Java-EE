package com.coderbd.springbootjms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.util.ErrorHandler;
import javax.jms.ConnectionFactory;


@EnableJms
@ComponentScan(basePackages = "com.coderbd.springbootjms")
@EnableMongoRepositories(basePackages = "com.coderbd.springbootjms")
@SpringBootApplication
public class SpringbootjmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjmsApplication.class, args);
	}

	// Only required due to defining myFactory in the receiver
	@Bean
	public JmsListenerContainerFactory<?> myFactory(
			ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

		// anonymous class
		factory.setErrorHandler(
				new ErrorHandler() {
					@Override
					public void handleError(Throwable t) {
						System.err.println("An error has occurred in the transaction");
					}
				});

		// lambda function
		factory.setErrorHandler(t -> System.out.println("An error has occurred in the transaction"));

		configurer.configure(factory, connectionFactory);
		return factory;
	}

	// Serialize message content to json using TextMessage
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	//https://lankydanblog.com/2017/06/18/using-jms-in-spring-boot/
}
