package de.witchcafe.knownet.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import de.witchcafe.base.StatusController.Status;
import de.witchcafe.knownet.Service;

public class RestProxy extends Service {

	private String idKey;
	private String nameKey;
	private String id;
	private String name;
	protected List<Map<String, Object>> list;
	protected RestTemplate restTemplate = new RestTemplate();
	private String endPoint;


	public RestProxy(String a, String b, String c, String d, String e) {
		setId(a);
		setName(b);
		setIdKey(c);
		setNameKey(d);
		setEndPoint(e);
		loadData();
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setIdKey(String idKey) {
		this.idKey = idKey;
	}

	@Override
	public String getIdKey() {
		return idKey;
	}

	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}

	@Override
	public String getNameKey() {
		return nameKey;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Collection getEntries() {
		return list;
	}

	protected String getEndPoint() {
		return endPoint;
	}

	protected void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	protected void loadData() {
		URI url = null;
		try {
			url = new URI(getEndPoint());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statusController.log(getClass().getCanonicalName(), Status.info, "load service");
		ResponseEntity<java.util.List> resp = restTemplate.getForEntity(url, java.util.List.class);
		list = resp.getBody();
		statusController.log(getClass().getCanonicalName(), Status.info, String.format("loaded %s entries",list.size()));
	}
}
