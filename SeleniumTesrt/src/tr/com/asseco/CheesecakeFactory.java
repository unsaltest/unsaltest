package tr.com.asseco;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheesecakeFactory {
	private static WebDriver driver;
	private static final String GIFT_LIST_NUMBER = "istanblue34tr";
	private static final String GIFT_LIST_PASSWORD = "26642554";

	public static void main(String[] args) {
		// open browser
		driver = new FirefoxDriver();

		// set implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// login
		driver.get("http://www.istanbul.net/giris");

		driver.findElement(By.name("username")).sendKeys(GIFT_LIST_NUMBER);
		driver.findElement(By.name("password")).sendKeys(GIFT_LIST_PASSWORD);
		driver.findElement(By.linkText("Giriþ yapýn")).click();

		// get purchased items
		driver.findElement(By.linkText("Arama")).click();
		List<WebElement> purchasedItems = driver.findElements(By.xpath("//tr[td[2] and @class='item']"));

		// output purchased items
		for (WebElement item : purchasedItems) {
			System.out.println(item.findElement(By.xpath("/td[1]")).getText());
		}

		// log out
		driver.findElement(By.linkText("Log out")).click();

		// close browser
		driver.close();
	}
}
