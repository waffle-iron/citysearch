package com.goeuro.cityquery;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import au.com.bytecode.opencsv.CSVWriter;

public class CityqueryApplication {

	private static final Logger log = LoggerFactory.getLogger(CityqueryApplication.class);

	public static void main(String[] args) throws IOException, URISyntaxException {
		if (args.length == 0) {
			log.error("Please Provide The name of the city you are willing to search.");
			System.exit(0);
		}

		CityqueryApplication application = new CityqueryApplication();
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder url = new StringBuilder("http://localhost:8080/api/city/");
		url.append(args[0]);
		City[] result = restTemplate.getForObject(url.toString(), City[].class);

		application.writeCSVData(Arrays.asList(result));

	}

	private List<String[]> toStringArray(List<City> cities) {
		List<String[]> records = new ArrayList<String[]>();
		// add header record
		records.add(new String[] { "ID", "Name", "Key", "Full name", "Airport Code", "Type", "Country Id",
				"Country Name", "Country Code", "Country Distance", "Geo Position Id", "latitude", "longitude" });
		Iterator<City> it = cities.iterator();
		while (it.hasNext()) {
			City city = it.next();
			records.add(new String[] { city.getId().toString(), city.getName(), city.getCitykey(), city.getFullName(),
					city.getAirportCode(), city.getCitytype(), city.getCountry().getId().toString(),
					city.getCountry().getName(), city.getCountry().getCountryCode(),
					city.getCountry().getDistance().toString(), city.getGeoPosition().getId().toString(),
					city.getGeoPosition().getLatitude().toString(), city.getGeoPosition().getLongitute().toString() });
		}
		return records;
	}

	private void writeCSVData(List<City> cities) throws IOException, URISyntaxException {
		File file = new File("/cities/cities.csv");
		CSVWriter csvWriter = new CSVWriter(new FileWriter(file), ',');
		List<String[]> data = toStringArray(cities);
		log.info("Writing query results to file {}", file.getPath());
		csvWriter.writeAll(data);
		csvWriter.close();
	}
}
