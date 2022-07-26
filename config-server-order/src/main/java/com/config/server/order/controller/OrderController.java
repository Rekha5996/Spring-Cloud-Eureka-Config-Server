package com.config.server.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.server.order.dto.OrderDto;
import com.config.server.order.exception.ResourceNotFoundException;
import com.config.server.order.model.Order;
import com.config.server.order.repository.OrderRepo;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepo orepo;
	
	//get order details based on user id
	@GetMapping("/orderdetails/{uid}")
	public Order getOrderDetails(@PathVariable("uid") int user_id){
		return orepo.findById((long) user_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id:"+user_id)); 
	}
	//place an order
		@PostMapping("/placeorder")
		public String CreateProduct(@RequestBody OrderDto order) {
			 orepo.save(order.getOrder());
               return "Your order is placed";	
		}
		//update order details
		@PutMapping("/updateorder/{oid}")
		public Order updateUser(@RequestBody Order order, @PathVariable("oid") long id) {
			Order oorder=orepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Order not found with id:"+id)); 			
			
			oorder.setOrder_date(order.getOrder_date());
			oorder.setOrder_details(order.getOrder_details());
			oorder.setOrder_status(order.getOrder_status());
			oorder.setBill_amount(order.getBill_amount());
			oorder.setProduct(order.getProduct());
			return orepo.save(oorder);
			
			}
		//cancel the order
			@DeleteMapping("/cancelorder/{oid}")
			public ResponseEntity<Order> deleteUser(@PathVariable("oid")long id) {
				Order oorder=orepo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Order not found with id:"+id));
				orepo.delete(oorder);
				return ResponseEntity.ok().build();
			}
		
}
