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
@Table(name = "mst_brand")
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column
	private Integer sk_brand_id;
	@Column
	private String brand_name;
	@Column
	private String brand_description;
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
	private long brand_status;
	
	@OneToMany(targetEntity=Model.class, mappedBy="brand",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	 @JsonBackReference
	private List<Model> model;

	public Brand() {

    }
	@OneToMany(targetEntity=Variant.class, mappedBy="brand",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	 @JsonBackReference
	 private List<Variant>variant;
	
	
	public Integer getSk_brand_id() {
		return sk_brand_id;
	}
	public void setSk_brand_id(Integer sk_brand_id) {
		this.sk_brand_id = sk_brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getBrand_description() {
		return brand_description;
	}
	public void setBrand_description(String brand_description) {
		this.brand_description = brand_description;
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
	
	public long getBrand_status() {
		return brand_status;
	}
	public void setBrand_status(long brand_status) {
		this.brand_status = brand_status;
	}
	
	public List<Model> getModel() {
		return model;
	}
	public void setModel(List<Model> model) {
		this.model = model;
	}
	
	public List<Variant> getVariant() {
		return variant;
	}
	public void setVariant(List<Variant> variant) {
		this.variant = variant;
	}
	@Override
	public String toString() {
		return "Brand [sk_brand_id=" + sk_brand_id + ", brand_name=" + brand_name + ", brand_description="
				+ brand_description + ", status=" + status + ", created_by=" + created_by + ", created_date="
				+ created_date + ", statusCode=" + statusCode + ", statusmessage=" + statusmessage + ", brand_status="
				+ brand_status + ", model=" + model + "]";
	}
	
	
	
	
}
