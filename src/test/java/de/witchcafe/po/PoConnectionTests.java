package de.witchcafe.po;

import static org.junit.Assert.fail;

import org.junit.Test;

public class PoConnectionTests {

	private static final String ROOT_URI = "https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json";

	public class TestPoController extends PoController{

		@Override
		protected void consumeStation(Object result) {
			// TODO Auto-generated method stub
			super.consumeStation(result);
		}
		
	}
	
	@Test
	public void test() {
	    try {
	    	TestPoController testy = new TestPoController();
	    	testy.readStations();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
