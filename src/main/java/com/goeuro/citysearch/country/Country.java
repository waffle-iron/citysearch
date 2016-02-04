package com.goeuro.citysearch.country;

public class Country {
	
	private Long id;
	private String name;
	private boolean isInEurope;
	private String countryCode;
	private Long distance;
	private boolean coreCountry;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInEurope() {
		return isInEurope;
	}

	public void setInEurope(boolean isInEurope) {
		this.isInEurope = isInEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public boolean isCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

}
