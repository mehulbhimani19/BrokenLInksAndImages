package soft;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

public class Utility extends Hooks
{


    public static void WaitImplicitly(int time)
    {

        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    public static void WaitExplicitly(WebElement element , int time)
    {
        WebDriverWait explicitlyWait = new WebDriverWait(driver,time);
        explicitlyWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void enterText (WebElement element,String text )
    {
        element.clear();
        element.sendKeys(text);

    }
    public static void clickOnElement (WebElement element)
    {
        element.click();
    }

    public static String randomDate (){
        DateFormat Randomdate = new SimpleDateFormat("ddMMYYHHMMss");
        return Randomdate.format(new Date());
    }

    public static void selectbyVisibleText (WebElement element , String text)
    {
        Select select = new Select(element);

    }


    public static void captureScreenShort(WebDriver driver , String name)  //
    {
        TakesScreenshot ts =  (TakesScreenshot) Hooks.driver;
        File source = ts.getScreenshotAs((OutputType.FILE));

        try {
            FileUtils.copyFile(source,new File("src\\test\\ScreenSort"+random()+name+".jpg"));
        }
        catch (IOException e)
        {System.out.println("Exeption while taking screenshort" + e.getMessage());
            System.out.println("Screen Short taken ");
        }
    }
}
