import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Main {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set up the wWebDriverManager for chrome driver
		WebDriverManager.chromedriver().setup();
		// Create the driver object
		driver = new ChromeDriver();

		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
	}

}
