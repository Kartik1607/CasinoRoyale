package com.example.demo.models;


import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String contactNumber;
	private Date dateOfBirth;
	private String emailAddress;
	private MultipartFile idProof;

	public User() {
		super();
	}

	public MultipartFile getIdProof() {
		return idProof;
	}

	public void setIdProof(MultipartFile idProof) {
		this.idProof = idProof;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public UserModel generateUserModel() {
		UserModel model = new UserModel();
		model.setName(this.name);
		model.setContactNumber(this.contactNumber);
		model.setDateOfBirth(this.dateOfBirth);
		model.setEmailAddress(this.emailAddress);
		return model;
	}
}
