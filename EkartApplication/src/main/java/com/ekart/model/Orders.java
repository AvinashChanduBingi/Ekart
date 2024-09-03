package com.ekart.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderID;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="userId")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Products productId;
	
	@NotNull
	private int quantity;
	
	@NotNull
	private LocalDate orderDate;
	
	@NotNull
	private LocalDate deliveryDate;
	

}
