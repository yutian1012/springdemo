package spittr.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Id
    @GeneratedValue
	private Long id;
	private String address;
	private String zipcode;
	private String city;
	@ManyToOne
	private User user;
}
