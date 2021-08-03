package com.example.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	@NonNull
	private String userName ;
	@JsonIgnore
	private String password ;
	private boolean active;
    private String roles;       // "ADMIN_ROLE" , "USER_ROLE"
	private Date created ;

	public Users(String userName, String password , boolean active , String roles) {
		
		this.userName = userName;
		this.password = password;
		this.active = active ;
		this.roles = roles ;
		this.created = new Date ();
	}
	
	public Users() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	

}
