package org.sjq.test.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Spitter {
	 private Spitter() {}

	  private Long id;

	  private String username;

	  private String password;

	  private String fullName;

	  private String email;

	  private boolean updateByEmail;
	  
	  private String status;
}
	  
	 