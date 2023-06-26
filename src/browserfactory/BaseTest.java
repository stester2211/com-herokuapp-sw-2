package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest
{
    public String browser="Chrome";
    public WebDriver driver;
    public String baseUrl="http://the-internet.herokuapp.com/login";

    public void setBrowser()
    {
        //launch browser

        if (browser.equalsIgnoreCase("Chrome"))
        {
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Edge"))
        {
            driver=new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Firefox"))
        {
            driver=new FirefoxDriver();
        }
        else
        {
            System.out.println("Enter only Chrome, Firefox or Edge Browser");
        }

        //Open Url
        driver.get(baseUrl);

        //Maximize the browser screen
        driver.manage().window().maximize();

        //Implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //close all browser open by selenium
    public void closeBrowser()
    {
        driver.quit();
    }
}
