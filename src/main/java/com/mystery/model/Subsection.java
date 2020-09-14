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
@Table(name = "mst_subsection")
public class Subsection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column
	private Integer sk_subsection_id;
	@Column
	private String subsection_name;
	@Column
	private String section_id;
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
	private long subsection_status;
	@ManyToOne()
	@JoinColumn(name="section_id", referencedColumnName = "sk_section_id", insertable = false, updatable = false)    
	@JsonManagedReference
	private Section section;
	public Subsection() {
    }
	
	public Integer getSk_subsection_id() {
		return sk_subsection_id;
	}
	public void setSk_subsection_id(Integer sk_subsection_id) {
		this.sk_subsection_id = sk_subsection_id;
	}
	public String getSubsection_name() {
		return subsection_name;
	}
	public void setSubsection_name(String subsection_name) {
		this.subsection_name = subsection_name;
	}
	public String getSection_id() {
		return section_id;
	}
	public void setSection_id(String section_id) {
		this.section_id = section_id;
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
	public long getSubsection_status() {
		return subsection_status;
	}
	public void setSubsection_status(long subsection_status) {
		this.subsection_status = subsection_status;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Subsection [sk_subsection_id=" + sk_subsection_id + ", subsection_name=" + subsection_name
				+ ", section_id=" + section_id + ", status=" + status + ", created_by=" + created_by + ", created_date="
				+ created_date + ", statusCode=" + statusCode + ", statusmessage=" + statusmessage
				+ ", subsection_status=" + subsection_status + ", section=" + section + "]";
	}
	
	
	
}
