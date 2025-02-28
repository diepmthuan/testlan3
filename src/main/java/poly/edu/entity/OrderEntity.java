package poly.edu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@Entity
@ToString(exclude = "account")
@Table(name = "Orders")
public class OrderEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String address;
	@Temporal(TemporalType.DATE)
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Createdate",updatable = false)
	Date createDate;
	@ManyToOne @JoinColumn(name = "Username")
	AccountEntity account;
	@OneToMany(mappedBy = "order")
	@JsonIgnore
	List<OrderDetailEntity> orderDetails;
	@PrePersist
	    protected void onCreate() {
	        createDate = new Date(); // Set thời gian hiện tại khi tạo mới đơn hàng
	    }
}
