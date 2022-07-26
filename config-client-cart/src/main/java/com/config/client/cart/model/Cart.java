package com.config.client.cart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name="cart_table")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long cart_id;
	@OneToMany(targetEntity = CartItems.class  ,cascade = CascadeType.ALL)
	@JoinColumn(name="cart_fk",referencedColumnName = "cart_id")
	@JoinColumn(name="user_fk",referencedColumnName = "user_id")
	private List<CartItems> cartitems;
	private  int user_id;
	

}
