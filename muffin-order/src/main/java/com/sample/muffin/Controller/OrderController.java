package com.sample.muffin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.muffin.domain.model.Order;
import com.sample.muffin.domain.service.OrderService;

@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/")
	public void createOrder(@RequestBody Order order) {
		orderService.placeOrder(order);
	}

//	@GetMapping("")
//	public Page<Order> findOrder(@RequestParam Integer page, @RequestParam Integer size) {
//		return this.orderService.findAllOrders(page, size);
//	}
//
//	@GetMapping("/{id}")
//	public Order findOrder(@PathVariable Long id) {
//		return this.orderService.findOrder(id);
//	}
//
//	@GetMapping("/test")
//	public ResponseEntity<String> test() {
//		/* Sending to Message Queue */
//		try {
//			orderProducer.sendMessage("", "Hello world");
//			return new ResponseEntity<>("IN_QUEUE", HttpStatus.OK);
//		} catch (Exception ex) {
//			log.error("Exception occurred while sending message to the queue. Exception= {}", ex);
//			return new ResponseEntity<>("MESSAGE_QUEUE_SEND_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
