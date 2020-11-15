package com.mallplanet.api.virus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VirusApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void virusFamilyContainsRecord() throws Exception {
		assert(this.restTemplate.getForObject("http://localhost:" + port + "/virus/family",
				String.class)).contains("family");
	}

	@Test
	public void virusContainsRecord() throws Exception {
		assert(this.restTemplate.getForObject("http://localhost:" + port + "/virus/",
				String.class)).contains("virus");
	}

}
