package poly.edu.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
@Data
@Entity
@ToString(exclude = {"order","product"})

@Table(name = "Orderdetails")
public class OrderDetailEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Double price;
	Integer quantity;
	@ManyToOne @JoinColumn(name = "Productid")
	ProductEntity product;
	@ManyToOne 
	@JoinColumn(name = "Orderid")
	
	OrderEntity order;
}