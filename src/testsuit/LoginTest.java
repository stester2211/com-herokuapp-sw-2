package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest
{
    @Before
    public void openBrowser()
    {
        setBrowser();
    }

    //1. userShouldLoginSuccessfullyWithValidCredentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException
    {
        //1.1 Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        //1.2 Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        //1.3 Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        //1.4 Verify the text “Secure Area”
        String expectedText="Secure Area";
        String actualText= driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();
        Assert.assertEquals("Secure area text not found",expectedText,actualText);

        //Hold the browser screen for sometime
        Thread.sleep(2000);
    }

    //2. verifyTheUsernameErrorMessage
    @Test
    public void verifyTheUsernameErrorMessage() throws InterruptedException
    {
        //2.1 Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");

        //2.2 Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        //2.3 Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();

        //2.4 Verify the error message “Your username is invalid!”
        String expectedInvalidText="Your username is invalid!";
        String actualText= driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("Username invalid message not found",expectedInvalidText,actualText);

        //Holding the screen
        Thread.sleep(2000);
    }

    //3. verifyThePasswordErrorMessage
    @Test
    public void verifyThePasswordErrorMessage() throws InterruptedException {
        //3.1 Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        //3.2 Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");

        //3.3 Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();

        //3.4 Verify the error message “Your password is invalid!”
        String expectedText="Your password is invalid!";
        String actualText=driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("Password invalid message not display",expectedText,actualText);

        //Hold screen
        Thread.sleep(2000);
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
