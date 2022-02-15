package com.rscoe.admissionsystem.model;

public class SearchData {

	private double entc;

	private double civil;

	private double computer;

	private double mechanical;

	private double electrical;

	private double it;

	private String categeory;

	private String city;
	
	private String branch;
	
	

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getCategeory() {
		return categeory;
	}

	public void setCategeory(String categeory) {
		this.categeory = categeory;
	}

}
