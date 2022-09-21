package de.witchcafe.knownet.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import de.witchcafe.knownet.Service;

public class PegelOnlineService extends Service {
	public PegelOnlineService() {
		super();
		RestTemplate restTemplate = new RestTemplate();
		ParameterizedTypeReference<List<String>> responseType = new ParameterizedTypeReference<List<String>>() {};
		URI url = null;
		try {
			url = new URI("https://pegelonline.wsv.de/webservices/rest-api/v2/waters.json");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseEntity<List<String>> resp = restTemplate.exchange(new RequestEntity(HttpMethod.GET, url), responseType);
		List<String> list = resp.getBody();
	}
}
