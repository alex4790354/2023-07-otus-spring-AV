package ru.otus.spring.integration.services;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.spring.integration.domain.Food;
import ru.otus.spring.integration.domain.OrderItem;

import java.util.Collection;

@MessagingGateway
public interface CafeGateway {

	@Gateway(requestChannel = "itemsChannel", replyChannel = "foodChannel")
	Collection<Food> process(Collection<OrderItem> orderItem);
}
