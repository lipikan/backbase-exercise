package com.test.backbase.entity;

public class Address {
	private String street;
	private String housenumber;
	private String postalcode;
	private String city;
	private GeoLocation geoLocation;
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the houseNumber
	 */
	public String getHousenumber() {
		return housenumber;
	}
	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalcode() {
		return postalcode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalcode(String postalCode) {
		this.postalcode = postalCode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the geoLocation
	 */
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	/**
	 * @param geoLocation the geoLocation to set
	 */
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	
	public String toString() {
		return "Street: " + this.street + "House Number: " + this.housenumber + "Postal Code: " + this.postalcode + "City: " + this.city ;
	}

}
