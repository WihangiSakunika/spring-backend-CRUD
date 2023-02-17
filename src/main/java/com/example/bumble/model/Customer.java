package com.example.bumble.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FullName")
	private String FullName;
	@Column(name = "Dob")
	private LocalDate Dob;
	@Column(name = "LoanAmount")
	private float LoanAmount;
	@Column(name = "Installment")
	private int Installment;
	@Column(name = "email_Id")
	private String emailId;

	public Customer() {}

	public Customer(String fullName, LocalDate dob, float loanAmount, int installment, String emailId) {
		super();
		this.FullName = fullName;
		this.Dob = dob;
		this.LoanAmount = loanAmount;
		this.Installment = installment;
		this.emailId = emailId;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public LocalDate getDob() {
		return Dob;
	}

	public void setDob(LocalDate dob) {
		Dob = dob;
	}

	public float getLoanAmount() {
		return LoanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		LoanAmount = loanAmount;
	}

	public int getInstallment() {
		return Installment;
	}

	public void setInstallment(int installment) {
		Installment = installment;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
