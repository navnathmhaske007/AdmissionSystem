package com.rscoe.admissionsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCHES")
public class Branches implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8633423450390966715L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "ENTC")
	private double entc;

	@Column(name = "CIVIL")
	private double civil;

	@Column(name = "COMPUTER")
	private double computer;

	@Column(name = "MECHANICAL")
	private double mechanical;

	@Column(name = "ELECTRICAL")
	private double electrical;

	@Column(name = "IT")
	private double it;

	@Column(name = "CATEGEORY")
	private String categeory;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "COLLEGE_ID", nullable = false)
	private College college;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getEntc() {
		return entc;
	}

	public void setEntc(double entc) {
		this.entc = entc;
	}

	public double getCivil() {
		return civil;
	}

	public void setCivil(double civil) {
		this.civil = civil;
	}

	public double getComputer() {
		return computer;
	}

	public void setComputer(double computer) {
		this.computer = computer;
	}

	public double getMechanical() {
		return mechanical;
	}

	public void setMechanical(double mechanical) {
		this.mechanical = mechanical;
	}

	public double getElectrical() {
		return electrical;
	}

	public void setElectrical(double electrical) {
		this.electrical = electrical;
	}

	public double getIt() {
		return it;
	}

	public void setIt(double it) {
		this.it = it;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public String getCategeory() {
		return categeory;
	}

	public void setCategeory(String categeory) {
		this.categeory = categeory;
	}

	

	public Branches(int id, double entc, double civil, double computer, double mechanical, double electrical, double it,
			String categeory, College college) {
		super();
		this.id = id;
		this.entc = entc;
		this.civil = civil;
		this.computer = computer;
		this.mechanical = mechanical;
		this.electrical = electrical;
		this.it = it;
		this.categeory = categeory;
		this.college = college;
	}

	public Branches() {
		super();
		// TODO Auto-generated constructor stub
	}

}
