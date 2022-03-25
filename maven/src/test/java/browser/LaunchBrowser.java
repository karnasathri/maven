package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser
{
    WebDriver driver; 
	@Test
     
     public void setUp()
     {
    	 WebDriverManager.chromedriver().setup();
    	 driver=new ChromeDriver();
    	 driver.get("https://www.google.co.in/");
     }
}
