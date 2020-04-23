package com.lab.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.message.Message;

@RestController
@EnableBinding(Source.class)
public class MessagePublisherApi {
	
	@Autowired
	private Source source;

	@GetMapping(value = "/api/publish")
	public void sendMessage(){
		Message message = new Message("Hello World from MessagePublisherApi");

		source.output().send(MessageBuilder.withPayload(message).build());

	}

}
