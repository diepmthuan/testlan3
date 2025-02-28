package poly.edu.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public interface ReportEntity {
	Serializable getGroup();
	Double getSum();
	Long getCount();
}
