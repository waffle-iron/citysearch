package com.goeuro.citysearch.geoposition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GeoPositionDaoImpl implements GeoPositionDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public GeoPositionDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public GeoPosition findById(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM geoposition WHERE id=:id";

		GeoPosition result = namedParameterJdbcTemplate.queryForObject(sql, params, new GeoPositionMapper());
		return result;
	}

	private final class GeoPositionMapper implements RowMapper<GeoPosition> {

		public GeoPosition mapRow(ResultSet rs, int rowNum) throws SQLException {
			GeoPosition geoPosition = new GeoPosition();
			geoPosition.setId(rs.getLong("id"));
			geoPosition.setLatitude(rs.getFloat("latitude"));
			geoPosition.setLongitute(rs.getFloat("longitude"));
			return geoPosition;
		}
	}

}
