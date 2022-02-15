package com.rscoe.admissionsystem.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "COLLEGES")
public class College implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8633423450390966715L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "COLLEGE_NAME", length = 255)
	private String collegeName;

	@Column(name = "CITY")
	private String city;

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(name = "COLLEGE_ID")
	private String collegeId;

	
	 @OneToMany(mappedBy = "college", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	private Set<Branches> branches;
	
	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "ACTIVE")
	private Boolean active;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "COLLEGE_ROLE", joinColumns = @JoinColumn(name = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USERNAME")
	private String userName;
	

	public Set<Branches> getBranches() {
		return branches;
	}

	public void setBranches(Set<Branches> branches) {
		this.branches = branches;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
}
