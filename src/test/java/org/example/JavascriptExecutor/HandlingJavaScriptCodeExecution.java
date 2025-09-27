package org.example.JavascriptExecutor;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlingJavaScriptCodeExecution {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void openBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait=new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    @Test
    @Description("Execute JS code")
    public void test_HandlingJavaScript() throws InterruptedException {
        driver.get("https://selectorshub.com/xpath-practice-page");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement username=driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);",username);
        js.executeScript("window.scrollBy(0,500);");
        //js.executeScript("alert(1)");
        System.out.println(js.executeScript("return document.title").toString());
        System.out.println(js.executeScript("return document.URL").toString());
        js.executeScript("window.location='https://google.com';");
    }

    @AfterTest
    public void closeTest(){
       // driver.quit();
    }
}
