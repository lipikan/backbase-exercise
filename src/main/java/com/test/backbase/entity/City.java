package com.test.backbase.entity;

import java.util.List;

public class City {
	private String cityName;
	private List<Bank> banks;
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the banks
	 */
	public List<Bank> getBanks() {
		return banks;
	}
	/**
	 * @param banks the banks to set
	 */
	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}
	

}
