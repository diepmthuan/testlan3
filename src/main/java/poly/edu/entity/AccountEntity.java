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

@Table(name = "Accounts")
public class AccountEntity implements Serializable{
	@Id
	String username;
	String password;
	String fullname;
	String email;
	String photo;
	boolean activated;
	boolean admin;
	@OneToMany(mappedBy = "account")
	@JsonIgnore
	List<OrderEntity> orders;
}
