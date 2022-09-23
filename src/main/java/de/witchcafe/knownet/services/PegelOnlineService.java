package de.witchcafe.knownet.services;

public class PegelOnlineService extends RestProxy {
	public PegelOnlineService() {
		super(
				"de.wsv.pegelonline.Waters","Waters",
				"shortname","longname",
				"https://pegelonline.wsv.de/webservices/rest-api/v2/waters.json");
	}
	
}
