package org.example.fileUpload;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload {
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
    @Description("File Upload")
    public void test_FileUpload(){
        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement uploadFileInpt = driver.findElement(By.id("fileToUpload"));

        System.out.println(System.getProperty("user.dir"));
        uploadFileInpt.sendKeys(System.getProperty("user.dir")+"/src/test/resources/fileUpload/data.txt");
    }
}
