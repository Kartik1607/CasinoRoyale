package com.example.demo.models;


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
	private String dateOfBirth;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
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
