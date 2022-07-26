package com.config.client.cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.config.client.cart.dto.CartDto;
import com.config.client.cart.exception.ResourceNotFoundException;
import com.config.client.cart.model.Cart;
import com.config.client.cart.repository.CartRepository;


@RestController
@RequestMapping("/cartmain")
@RefreshScope
public class CartController {
	
	@Autowired
	private CartRepository crepo;
	
    
	//load cart items
	@GetMapping("/loaditemsincart")
	public List <Cart> GetItems(){
		List<Cart> lst=crepo.findAll();
		return lst;
		
	}
	//add product to cart
	@PostMapping("/addproduct")
	public Cart AddProduct(@RequestBody CartDto reg) {
		return crepo.save(reg.getCart());
			}
	//update items quantity in cartitem
	@PutMapping("/updateitems/{id}")
	public Cart UpdateItems(@RequestBody Cart cart,@PathVariable ("id") long id){
		Cart ocart= crepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found with id:"+id)); 
		ocart.setCartitems(cart.getCartitems());
		return crepo.save(ocart);
		}
	//remove items from cart
	@DeleteMapping("/removeitems/{id}")
	public ResponseEntity<Cart> RemoveItems(@PathVariable("id") long id){
			Cart ocart= crepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Item not found with id:"+ id));
            crepo.delete(ocart);
			return ResponseEntity.ok().build();
		}
	//configuration between order and cart
	 @Value("${msg}")
	   private String msg;
	 
	 @RequestMapping(value = "/db", method = RequestMethod.GET)
		public String getProperties() {
			Map<String, String> mymap = new HashMap<String, String>();
			mymap.put("msg", msg);
			return mymap.toString();
		}
		
	}
	



