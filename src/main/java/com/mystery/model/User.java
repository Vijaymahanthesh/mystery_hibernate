package com.mystery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mst_users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column
	private Integer sk_user_id;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String email;
	@Column
	private String mobile_number;
	@Column
	private String password;
	@Column
	private String user_status="active";
	@Transient
	private String statusCode;
	@Transient
	private String statusmessage;
	public Integer getSk_user_id() {
		return sk_user_id;
	}
	public void setSk_user_id(Integer sk_user_id) {
		this.sk_user_id = sk_user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusmessage() {
		return statusmessage;
	}
	public void setStatusmessage(String statusmessage) {
		this.statusmessage = statusmessage;
	}
	
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	@Override
	public String toString() {
		return "User [sk_user_id=" + sk_user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", mobile_number=" + mobile_number + ", password=" + password + ", user_status=" + user_status
				+ ", statusCode=" + statusCode + ", statusmessage=" + statusmessage + "]";
	}
	
	
	
}
