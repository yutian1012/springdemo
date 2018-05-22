package spittr.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable { 
    private static final long serialVersionUID = 1L;    
    
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)    
    private String userName;    
    @Column(nullable = false)    
    private String passWord;    
    @Column(nullable = false, unique = true)    
    private String email;    
    @Column(nullable = true, unique = true)    
    private String nickName;    
    @Column(nullable = false)    
    private String regTime;
    @OneToOne(optional=true,cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
    @JoinColumn(name="account_id")
    private Account account;
    @OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private List<Address> addressList;
}
