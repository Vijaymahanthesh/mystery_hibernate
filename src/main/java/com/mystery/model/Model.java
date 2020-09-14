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
@Table(name = "mst_brand_model")
public class Model {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column
	private Integer sk_model_id;
	@Column
	private Integer brand_id;
	@Column
	private String model_name;
	@Column
	private int created_by;
	@Column
	private String created_date;
	@Column
	private String status="active";
	@Transient
	private String statusCode;
	@Transient
	private String statusmessage;
	@Transient
	private long model_status;
	
	@ManyToOne()
	@JoinColumn(name="brand_id", referencedColumnName = "sk_brand_id", insertable = false, updatable = false)    
	@JsonManagedReference
	private Brand brand;
	public Model() {
    }
	@OneToMany(targetEntity=Variant.class, mappedBy="model",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	 @JsonBackReference
	private List<Variant>variant;
	
	public Integer getSk_model_id() {
		return sk_model_id;
	}
	public void setSk_model_id(Integer sk_model_id) {
		this.sk_model_id = sk_model_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public long getModel_status() {
		return model_status;
	}
	public void setModel_status(long model_status) {
		this.model_status = model_status;
	}
	public List<Variant> getVariant() {
		return variant;
	}
	public void setVariant(List<Variant> variant) {
		this.variant = variant;
	}
	@Override
	public String toString() {
		return "Model [sk_model_id=" + sk_model_id + ", brand_id=" + brand_id + ", model_name=" + model_name
				+ ", created_by=" + created_by + ", created_date=" + created_date + ", status=" + status
				+ ", statusCode=" + statusCode + ", statusmessage=" + statusmessage + ", model_status=" + model_status
				+ ", brand=" + brand + ", variant=" + variant + "]";
	}
	
	
	
	
	
}
