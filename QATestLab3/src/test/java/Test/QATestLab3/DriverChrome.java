package Test.QATestLab3;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverChrome {

	final static String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
	final static String login = "webinar.test@gmail.com";
	final static String password = "Xcg7299bnSmMuRLp9ITw";
	final static String newCategory = "Jewellery";

	public static EventFiringWebDriver getEventDriver(String urlPage) {

		System.setProperty("webdriver.chrome.driver", "DriverChrome" + File.separator + "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

		eventDriver.register(new EventDriver());

		eventDriver.manage().window().maximize();

		eventDriver.get(urlPage);

		return eventDriver;
	}

}
