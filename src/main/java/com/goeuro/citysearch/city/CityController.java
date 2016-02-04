package com.goeuro.citysearch.city;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class CityController {

	private final Logger log = LoggerFactory.getLogger(CityController.class);

	@Autowired
	private CityDao cityDao;

	/**
	 * GET /city/:name -> get the "name" cites.
	 */
	@RequestMapping(value = "/city/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<City>> get(@PathVariable String name) {
		log.info("REST request to get City : {}", name);
		return Optional.ofNullable(cityDao.findByName(name)).map(city -> new ResponseEntity<>(city, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
