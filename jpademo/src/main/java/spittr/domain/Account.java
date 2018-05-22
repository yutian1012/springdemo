package spittr.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Long id ;
    @Column
    private String name ;
    @Column
    private double money;
    @OneToOne(cascade=CascadeType.PERSIST,optional=false,mappedBy="account")
    private User user;
}