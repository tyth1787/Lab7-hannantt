//package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;
import org.openqa.selenium.server.SeleniumServer;

public class Task4 extends SeleneseTestCase {
	
	static SeleniumServer server = null;
	@Before
	public void setUp() throws Exception {
		try {
			if(server == null) {
				server = new SeleniumServer();
				server.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setUp("http://webtesting.idyll.org/", "*chrome");
	}

	@Test
	public void testTask4() throws Exception {
		selenium.open("/");
		selenium.click("link=Log in");
		selenium.waitForPageToLoad("30000");
		selenium.click("create");
		selenium.waitForPageToLoad("30000");
		selenium.type("name", "Mark");
		selenium.type("username", "mark");
		selenium.type("password", "mark");
		selenium.click("create");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", "mark");
		selenium.type("password", "mark");
		selenium.click("login");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Welcome"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}