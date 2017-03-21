package com.mkaminski.hermes.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mkaminski.hermes.model.Courier;
import com.mkaminski.hermes.model.Order;
import com.mkaminski.hermes.service.CourierService;
import com.mkaminski.hermes.service.EmailService;
import com.mkaminski.hermes.service.OrderService;

@Service
public class SchedulerService {
	@Autowired
	private CourierService courierService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private EmailService emailService;

	@Scheduled(fixedDelay = 120 * 1000)
	public void mailReminder() {
		List<Courier> couriers = courierService.findAll();
		List<Order> orders = orderService.findAll();
		String infoOrder;
		String infoId;
		String sign = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		if (couriers == null) {
			return;
		}

		for (Courier courier : couriers) {
			infoId = "Courier: " + courier.getFirstName() + " " + courier.getLastName() + " with id: "
					+ courier.getId();
			for (Order order : orders) {
				if (order.getCourier().getFirstName().equals(courier.getFirstName())) {

					infoOrder = order.getPack() + "\n" + order.getStatus() + "\n" + order.getCreatedDate();

					emailService.sendEmail("hermes.delivery.noreply@gmail.com", courier.getEmail(), "ORDER-REMINDER!",
							infoId + "\n" + sign + "\n" + infoOrder);
				}
			}
		}
	}
}
