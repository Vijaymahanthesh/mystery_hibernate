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
@Table(name = "mst_section")
public class Section {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column
	private Integer sk_section_id;
	@Column
	private String section_name;
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
	private long section_status;
	
	@OneToMany(targetEntity=Subsection.class, mappedBy="section",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	 @JsonBackReference
	private List<Subsection>subsection;

	public Section() {

   }
	
	
	public Integer getSk_section_id() {
		return sk_section_id;
	}
	public void setSk_section_id(Integer sk_section_id) {
		this.sk_section_id = sk_section_id;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
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
	public long getSection_status() {
		return section_status;
	}
	public void setSection_status(long section_status) {
		this.section_status = section_status;
	}


	public List<Subsection> getSubsection() {
		return subsection;
	}

	public void setSubsection(List<Subsection> subsection) {
		this.subsection = subsection;
	}


	@Override
	public String toString() {
		return "Section [sk_section_id=" + sk_section_id + ", section_name=" + section_name + ", status=" + status
				+ ", created_by=" + created_by + ", created_date=" + created_date + ", statusCode=" + statusCode
				+ ", statusmessage=" + statusmessage + ", section_status=" + section_status + ", subsection="
				+ subsection + "]";
	}
	
	

}
