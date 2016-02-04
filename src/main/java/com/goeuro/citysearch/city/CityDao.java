package com.goeuro.citysearch.city;

import java.util.List;

public interface CityDao {

	List<City> findByName(String name);

}
