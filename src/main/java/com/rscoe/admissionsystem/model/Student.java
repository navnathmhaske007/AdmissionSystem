package com.rscoe.admissionsystem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STUDENTS")
public class Student implements Serializable {

	private static final long serialVersionUID = 8633415090390966715L;
	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "MOTHER_NAME")
	private String motherName;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "CET_MARKS")
	private double cetMarks;

	@Column(name = "DOB")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "CATEGEORY")
	private String categeory;

	@Column(name = "SSC_MARKS")
	private double sscMarks;

	@Column(name = "HSC_MARKS")
	private double hscMarks;

	@Column(name = "CHEMISTRY_MARKS")
	private double chemistryCetMarks;

	@Column(name = "MATHS_MARKS")
	private double mathCetMarks;

	@Column(name = "PHYSICS_MARKS")
	private double physicsCetmarks;

	@Column(name = "ACTIVE")
	private Boolean active;
	
	@Column(name = "UNIVERSITY")
	private String university;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "STUDENT_ROLE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USERNAME")
	private String userName;


	
	
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getCetMarks() {
		return cetMarks;
	}

	public void setCetMarks(double cetMarks) {
		this.cetMarks = cetMarks;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategeory() {
		return categeory;
	}

	public void setCategeory(String categeory) {
		this.categeory = categeory;
	}

	public double getSscMarks() {
		return sscMarks;
	}

	public void setSscMarks(double sscMarks) {
		this.sscMarks = sscMarks;
	}

	public double getHscMarks() {
		return hscMarks;
	}

	public void setHscMarks(double hscMarks) {
		this.hscMarks = hscMarks;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public double getChemistryCetMarks() {
		return chemistryCetMarks;
	}

	public void setChemistryCetMarks(double chemistryCetMarks) {
		this.chemistryCetMarks = chemistryCetMarks;
	}

	public double getMathCetMarks() {
		return mathCetMarks;
	}

	public void setMathCetMarks(double mathCetMarks) {
		this.mathCetMarks = mathCetMarks;
	}

	public double getPhysicsCetmarks() {
		return physicsCetmarks;
	}

	public void setPhysicsCetmarks(double physicsCetmarks) {
		this.physicsCetmarks = physicsCetmarks;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

}
