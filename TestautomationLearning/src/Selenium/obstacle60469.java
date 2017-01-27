package Selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class obstacle60469 {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://obstaclecourse.tricentis.com/Obstacles/Next?oId=60469");

	}
	
	@Test
	public void dragElement(){
		WebElement from = driver.findElement(By.id("toscabot"));
		WebElement to = driver.findElement(By.id("to"));
		Actions builder = new Actions(driver);
		builder.clickAndHold(from).moveToElement(to).release().build().perform();
		WebElement successPopup = driver.findElement(By.className("sa-placeholder"));
		assertEquals(true, successPopup.isDisplayed());
	}
}
