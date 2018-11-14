package soft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hooks
{

    public static WebDriver driver;


   @BeforeMethod

    public static void SetUp ()
    {


       driver = new SafariDriver();
       Utility.WaitImplicitly(10); // implicity methord call from utility calss
       //driver.navigate().to("http://demo.nopcommerce.com/");
       // driver.navigate().to("http://www.swamimanagement.com/");

        driver.navigate().to("http://www.jsnice.co.uk/");

        driver.manage().deleteAllCookies();
       driver.getTitle();

    }

//    @Test
//    public static void run ()
//    {
//       driver.findElement(By.className("ico-login")).click();
//        System.out.println("Pass");
//    }


    @AfterMethod
    public static void tearDown()
    {
        driver.quit();
    }







}
