package com.goeuro.citysearch.geoposition;

public class GeoPosition {

	private Long id;
	private Float latitude;
	private Float longitute;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitute() {
		return longitute;
	}

	public void setLongitute(Float longitute) {
		this.longitute = longitute;
	}

	@Override
	public String toString() {
		return "GeoPosition [latitude=" + latitude + ", longitute=" + longitute + "]";
	}

}
