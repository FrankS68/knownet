package de.witchcafe.knownet.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import de.witchcafe.base.StatusController.Status;
import de.witchcafe.knownet.Service;

public class PegelOnlineService extends Service {
	List<String> list;
	public PegelOnlineService() {
		super();
		RestTemplate restTemplate = new RestTemplate();
		URI url = null;
		try {
			url = new URI("https://pegelonline.wsv.de/webservices/rest-api/v2/waters.json");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statusController.log(getClass().getCanonicalName(), Status.info, "load service");
		ResponseEntity<List> resp = restTemplate.getForEntity(url, List.class);
		list = resp.getBody();
		statusController.log(getClass().getCanonicalName(), Status.info, String.format("loaded %s entries",list.size()));
	}
	
	@Override
	public Collection getEntries() {
		return list;
	}

	@Override
	public String getNameKey() {
		return "longname";
	}

	@Override
	public String getIdKey() {
		return "shortname";
	}
		
}
