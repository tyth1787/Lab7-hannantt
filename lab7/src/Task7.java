
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;


public class Task7 extends SeleneseTestCase {
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
		setUp("http://www.rose-hulman.edu/", "*chrome");
	}

	@Test
	public void testTask7() throws Exception {
		selenium.open("/");
		selenium.click("link=Current Students");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=a[title=Registrar]");
		selenium.waitForPageToLoad("30000");
		selenium.click("//li[6]/a/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=h2 > a");
		selenium.waitForPageToLoad("30000");
		selenium.type("id1", "vitalema");
		selenium.click("bt1");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("CSSE376"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
