package Selenium;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class obstacle41036 {
	//Test1
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://obstaclecourse.tricentis.com/Obstacles/Next?oId=41036");

	}

	@Test
	public void numberinTable() {
		WebElement table = driver.findElement(By.id("randomTable"));
		List<WebElement> tablerow = table.findElements(By.tagName("tr"));
		WebElement resulttext = driver.findElement(By.id("resulttext"));
		// System.out.println(tablerow.get(0).getText());
		for (int i = 0; i < tablerow.size(); i++) {
			String[] tmpSValue = tablerow.get(i).getText().split(" ");
			for (int j = 0; j < tmpSValue.length; j++) {
				int tmpValue = Integer.parseInt(tmpSValue[j]);
				if (tmpValue == 15) {
					resulttext.sendKeys("True");
					WebElement successPopup = driver.findElement(By.className("sa-placeholder"));
					assertEquals(true, successPopup.isDisplayed());
				}
			}
		}
		resulttext.sendKeys("False");
		WebElement successPopup = driver.findElement(By.className("sa-placeholder"));
		assertEquals(true, successPopup.isDisplayed());

	}

}
