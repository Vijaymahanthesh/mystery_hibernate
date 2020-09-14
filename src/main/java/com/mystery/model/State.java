package com.mystery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "mst_geo_states")
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	
	@Column
	private Integer sk_state_id;
	@Column
	private String state_name;
	@Column
	private String status="active";
	@Column
	private int created_by;
	@Column
	private String created_date;
	@Transient
	private String statusCode;
	@Transient
	private String statusmessage;
	@Transient
	private long state_status;
	
	@OneToMany(targetEntity=City.class, mappedBy="state",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	 @JsonBackReference
	private List<City>city;
	public State() {

    }
	public Integer getSk_state_id() {
		return sk_state_id;
	}
	public void setSk_state_id(Integer sk_state_id) {
		this.sk_state_id = sk_state_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
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
	
	public long getState_status() {
		return state_status;
	}
	public void setState_status(long state_status) {
		this.state_status = state_status;
	}
	
	public List<City> getCity() {
		return city;
	}
	public void setCity(List<City> city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "State [sk_state_id=" + sk_state_id + ", state_name=" + state_name + ", status=" + status
				+ ", created_by=" + created_by + ", created_date=" + created_date + ", statusCode=" + statusCode
				+ ", statusmessage=" + statusmessage + ", state_status=" + state_status + ", city=" + city + "]";
	}
	
	
	
	
}
