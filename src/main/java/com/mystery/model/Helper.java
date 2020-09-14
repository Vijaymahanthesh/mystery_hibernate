package com.mystery.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Helper {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sk_region_id;
	private String region_name;
	private String city_id;
	private String city_name;
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
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
	@Override
	public String toString() {
		return "Helper [sk_region_id=" + sk_region_id + ", region_name=" + region_name + ", city_id=" + city_id
				+ ", city_name=" + city_name + "]";
	}
	
	

}
