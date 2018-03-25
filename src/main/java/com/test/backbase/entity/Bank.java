package com.test.backbase.entity;

import java.util.List;

public class Bank {
	 private String bankName;
	 List<AtmAddress> atmAddress;
	
	 
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the atmAddress
	 */
	public List<AtmAddress> getAtmAddress() {
		return atmAddress;
	}
	/**
	 * @param atmAddress the atmAddress to set
	 */
	public void setAtmAddress(List<AtmAddress> atmAddress) {
		this.atmAddress = atmAddress;
	}
	 

}
