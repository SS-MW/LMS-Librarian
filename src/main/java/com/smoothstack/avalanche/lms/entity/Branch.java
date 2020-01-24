package com.smoothstack.avalanche.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_library_branch")
public class Branch {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;



	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
