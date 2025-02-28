package poly.edu.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Categories")
public class CategoryEntity implements Serializable{
	@Id
	String id;
	String name;
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	List<ProductEntity> products;
	
}
