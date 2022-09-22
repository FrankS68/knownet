package de.witchcafe.knownet.services;

public class PegelOnlineService extends RestProxy {
	public PegelOnlineService() {
		super();
		setNameKey("longname");
		setIdKey("shortname");
		setName("Waters");
		setId("de.wsv.pegelonline.Waters");
		setEndPoint("https://pegelonline.wsv.de/webservices/rest-api/v2/waters.json");
		loadData();
	}
	
}
