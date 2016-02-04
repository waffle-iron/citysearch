package com.goeuro.cityquery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

	private Long id;
	private String citykey;
	private String name;
	private String fullName;
	private String airportCode;
	private String citytype;
	private Country country;
	private GeoPosition geoPosition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCitykey() {
		return citykey;
	}

	public void setCitykey(String citykey) {
		this.citykey = citykey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCitytype() {
		return citytype;
	}

	public void setCitytype(String citytype) {
		this.citytype = citytype;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", citykey=" + citykey + ", name=" + name + ", fullName=" + fullName
				+ ", airportCode=" + airportCode + ", citytype=" + citytype + ", country=" + country + ", geoPosition="
				+ geoPosition + "]";
	}

}
