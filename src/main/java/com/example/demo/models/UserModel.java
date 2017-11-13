package com.example.demo.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "user_tbl")
public class UserModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Column(unique = true)
	private String contactNumber;
	
	@NotNull
	private Date dateOfBirth;
	
	@NotNull
	@Column(unique = true)
	private String emailAddress;
	
	@NotNull
	private String idProofLocation;
	
	@NotNull
	private BigDecimal balanceAmount;
	
	@NotNull
	private BigDecimal blockedAmount;

	@NotNull
	@Column(unique = true)
	private long UID;

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public BigDecimal getBlockedAmount() {
		return blockedAmount;
	}

	public void setBlockedAmount(BigDecimal blockedAmount) {
		this.blockedAmount = blockedAmount;
	}

	public long getUID() {
		return UID;
	}

	public void setUID(long uID) {
		UID = uID;
	}

	public UserModel() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdProofLocation() {
		return idProofLocation;
	}

	public void setIdProofLocation(String idProofLocation) {
		this.idProofLocation = idProofLocation;
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
}
