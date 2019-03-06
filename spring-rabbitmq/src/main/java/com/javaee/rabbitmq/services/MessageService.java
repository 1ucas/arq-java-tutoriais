package com.javaee.rabbitmq.services;

import com.javaee.rabbitmq.domain.Message;

public interface MessageService {

	void sendMessage(Message message);
}
