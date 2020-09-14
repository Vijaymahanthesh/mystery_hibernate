package com.mystery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mst_brand_model_variant")
public class Variant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column
	private Integer sk_variant_id;
	@Column
	private Integer brand_id;
	@Column
	private Integer model_id;
	@Column
	private String variant_name;
	@Column
	private String status="active";
	@Column
	private Integer created_by;
	@Column
	private String created_date;
	@Transient
	private String statusCode;
	@Transient
	private String statusmessage;
	@Transient
	private long variant_status;
	
	@ManyToOne()
	@JoinColumn(name="model_id", referencedColumnName = "sk_model_id", insertable = false, updatable = false)    
	@JsonManagedReference
	private Model model;
	
	@ManyToOne()
	@JoinColumn(name="brand_id", referencedColumnName = "sk_brand_id", insertable = false, updatable = false)    
	@JsonManagedReference
	private Brand brand;
	public Integer getSk_variant_id() {
		return sk_variant_id;
	}
	public void setSk_variant_id(Integer sk_variant_id) {
		this.sk_variant_id = sk_variant_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public Integer getModel_id() {
		return model_id;
	}
	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}
	public String getVariant_name() {
		return variant_name;
	}
	public void setVariant_name(String variant_name) {
		this.variant_name = variant_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Integer created_by) {
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
	public long getVariant_status() {
		return variant_status;
	}
	public void setVariant_status(long variant_status) {
		this.variant_status = variant_status;
	}
	
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}

	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Variant [sk_variant_id=" + sk_variant_id + ", brand_id=" + brand_id + ", model_id=" + model_id
				+ ", variant_name=" + variant_name + ", status=" + status + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", statusCode=" + statusCode + ", statusmessage=" + statusmessage
				+ ", variant_status=" + variant_status + ", model=" + model + "]";
	}
	
	
	
	
}
