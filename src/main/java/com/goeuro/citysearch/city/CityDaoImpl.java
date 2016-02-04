package com.goeuro.citysearch.city;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.goeuro.citysearch.country.Country;
import com.goeuro.citysearch.country.CountryDao;
import com.goeuro.citysearch.geoposition.GeoPosition;
import com.goeuro.citysearch.geoposition.GeoPositionDao;

@Repository
public class CityDaoImpl implements CityDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private CountryDao countryDao;
	private GeoPositionDao geoPositionDao;

	@Autowired
	public CityDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, CountryDao countryDao, GeoPositionDao geoPositionDao) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.countryDao = countryDao;
		this.geoPositionDao = geoPositionDao;
	}

	@Override
	public List<City> findByName(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);

		String sql = "SELECT * FROM city WHERE name=:name";

		
		List<City> result = namedParameterJdbcTemplate.query(sql, params, new CityMapper());
		return result;
	}

	private final class CityMapper implements RowMapper<City> {

		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
			City city = new City();
			city.setAirportCode(rs.getString("airportCode"));
			city.setCitytype(rs.getString("citytype"));
			city.setFullName(rs.getString("fullname"));
			city.setId(rs.getLong("id"));
			city.setName(rs.getString("name"));
			Country country = countryDao.findById(rs.getLong("countryId"));
			city.setCountry(country);
			GeoPosition geoPosition = geoPositionDao.findById(rs.getLong("geoPositionid"));
			city.setGeoPosition(geoPosition);
			return city;
		}
	}

}
