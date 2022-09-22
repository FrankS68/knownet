package de.witchcafe.knownet;

import java.util.Collection;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import de.witchcafe.knownet.services.PegelOnlineService;

@SpringBootTest
class KnownetApplicationTests {

	@Test
	void testPegelOnlineService() {
		Collection entries = new PegelOnlineService().getEntries(5);
		entries.forEach(new Consumer<Object>() {

			@Override
			public void accept(Object obj) {
				System.out.println(obj);
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
