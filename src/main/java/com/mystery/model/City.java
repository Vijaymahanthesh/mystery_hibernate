package com.mystery.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="mst_geo_city")
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column
	private Integer sk_city_id;
	@Column
	private String city_name;
	@Column
	private int state_id;
	@Column
	private String tier;
	@Column
	private String metro;
	@Column
	private String status="active";
	@Column
	private int  created_by;
	@Column
	private String created_date;
	@Transient
	private String statusCode;
	@Transient
	private String statusmessage;
	@Transient
	private long city_status;
	@ManyToOne()
	@JoinColumn(name="state_id", referencedColumnName ="sk_state_id", insertable = false, updatable = false)    
	@JsonManagedReference
	private State state;
	
	@OneToMany(targetEntity=Region.class, mappedBy="city",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	 @JsonBackReference
	 private List<Region>region;
	
//	@ManyToOne()
//	@JoinColumn(name="sk_city_id", referencedColumnName="city_id", insertable = false, updatable = false)    
//	@JsonManagedReference
//	private Region region;
//	public City() {
//
//    }
	
	public Integer getSk_city_id() {
		return sk_city_id;
	}
	public void setSk_city_id(Integer sk_city_id) {
		this.sk_city_id = sk_city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getMetro() {
		return metro;
	}
	public void setMetro(String metro) {
		this.metro = metro;
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
	public long getCity_status() {
		return city_status;
	}
	public void setCity_status(long city_status) {
		this.city_status = city_status;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
//	public Region getRegion() {
//		return region;
//	}
//
//	public void setRegion(Region region) {
//		this.region = region;
//	}
	

	
	@Override
	public String toString() {
		return "City [sk_city_id=" + sk_city_id + ", city_name=" + city_name + ", state_id=" + state_id + ", tier="
				+ tier + ", metro=" + metro + ", status=" + status + ", created_by=" + created_by + ", created_date="
				+ created_date + ", statusCode=" + statusCode + ", statusmessage=" + statusmessage + ", city_status="
				+ city_status + ", state=" + state + ", region=" + region + "]";
	}
	public List<Region> getRegion() {
		return region;
	}
	public void setRegion(List<Region> region) {
		this.region = region;
	}

	
}
