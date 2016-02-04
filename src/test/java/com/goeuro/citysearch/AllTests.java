package com.goeuro.citysearch;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CityRepositoryIntegrationTest.class, CountryRepositoryIntegrationTest.class,
		GeoPositionRepositoryIntegrationTest.class })
public class AllTests {

}
