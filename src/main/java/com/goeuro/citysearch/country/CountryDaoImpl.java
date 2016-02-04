package com.goeuro.citysearch.country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDaoImpl implements CountryDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public CountryDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Country findById(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM country WHERE id=:id";

		Country result = namedParameterJdbcTemplate.queryForObject(sql, params, new CountryMapper());
		return result;
	}

	private static final class CountryMapper implements RowMapper<Country> {

		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			Country country = new Country();
			country.setCoreCountry(rs.getBoolean("coreCountry"));
			country.setCountryCode(rs.getString("countryCode"));
			country.setDistance(rs.getLong("distance"));
			country.setId(rs.getLong("id"));
			country.setInEurope(rs.getBoolean("isEurope"));
			country.setName(rs.getString("name"));
			return country;
		}
	}

}
