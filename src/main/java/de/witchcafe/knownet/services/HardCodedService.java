package de.witchcafe.knownet.services;

import java.util.HashMap;

import de.witchcafe.knownet.Service;

public class HardCodedService extends Service {

	public HardCodedService() {
		super();
		add(new HashMap<String,Object>() {{
			put("id","42");
			put("name","test");
		}});
		add(new HashMap<String,Object>() {{
			put("id","43");
			put("name","qa");
		}});
		add(new HashMap<String,Object>() {{
			put("id","44");
			put("name","prod");
		}});
	}

}
