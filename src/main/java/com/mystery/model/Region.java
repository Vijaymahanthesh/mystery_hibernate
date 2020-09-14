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
@Table(name="mst_geo_region")
public class Region  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column
	private Integer sk_region_id;
	@Column
	private String region_name;	
	@Column
	private int city_id;	
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
	private long region_status;
//	@OneToMany(targetEntity=City.class, mappedBy="region",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
//	 @JsonBackReference
//	private List<City>city;
	
	@ManyToOne()
	@JoinColumn(name="city_id", referencedColumnName ="sk_city_id", insertable = false, updatable = false)    
	@JsonManagedReference
	private City city;
	
	public Region() {

    }

	public Integer getSk_region_id() {
		return sk_region_id;
	}

	public void setSk_region_id(Integer sk_region_id) {
		this.sk_region_id = sk_region_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
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

	public long getRegion_status() {
		return region_status;
	}

	public void setRegion_status(long region_status) {
		this.region_status = region_status;
	}
	
	

//	public List<City> getCity() {
//		return city;
//	}
//
//	public void setCity(List<City> city) {
//		this.city = city;
//	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Region [sk_region_id=" + sk_region_id + ", region_name=" + region_name + ", city_id=" + city_id
				+ ", status=" + status + ", created_by=" + created_by + ", created_date=" + created_date
				+ ", statusCode=" + statusCode + ", statusmessage=" + statusmessage + ", region_status=" + region_status
				+ ", city=" + city + "]";
	}

     
}
