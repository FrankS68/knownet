package de.witchcafe.po;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import com.google.gson.Gson;

@Controller
@SessionScope
public class PoController {
	
	@Autowired
	private PoDocumentService poDocumentService;

	@PostConstruct
	public void init() {
		readStations();
		root = poDocumentService.createDocuments(stations,rivers.values());
	}

	protected HashMap<String , Water> rivers;
	protected List<Region> regions;
	protected List<Station> stations;
	
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    private PoDocument selectedDocument;

    public PoDocument getSelectedDocument() {
        return selectedDocument;
    }
 
    public void setSelectedDocument(PoDocument selectedDocument) {
        this.selectedDocument = selectedDocument;
    }

	public Collection<Water> getRivers() {
		return rivers.values();
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	protected void readStations() {
		String ROOT_URI = "https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json";
	    try {
	    	System.out.println("starting test");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.getForEntity(ROOT_URI, String.class);
			System.out.println("Response is "+response.getBody());
			List resultList = new Gson().fromJson(response.getBody(), List.class);
			rivers = new HashMap<String, Water>();
			stations = new ArrayList<Station>();
			for (Object result : resultList) {
				consumeStation(result);
			}
			System.out.println("number of stations:"+stations.size());
			System.out.println("number of rivers:"+rivers.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void consumeStation(Object result) {
		if (result instanceof Map) {
			Map resultMap = (Map) result;
			System.out.println(result.toString());
			Station station = new Station((String)resultMap.get("longname"),(String)resultMap.get("number"));
			station.setKm((Double)resultMap.get("km"));
			station.setLongitude((Double)resultMap.get("longitude"));
			station.setLatitude((Double)resultMap.get("latitude"));
			String waterLongName = (String) ((Map)resultMap.get("water")).get("longname");
			String waterShortName = (String) ((Map)resultMap.get("water")).get("shortname");
			Water river = rivers.get(waterShortName);
			if (river == null) {
				river = new Water(waterLongName, waterShortName);
				rivers.put(waterShortName, river);
			}
			station.setRiver(river);
			stations.add(station);
		}
		else {
			System.out.println(result.getClass().getName());
		}
	}
	
}
