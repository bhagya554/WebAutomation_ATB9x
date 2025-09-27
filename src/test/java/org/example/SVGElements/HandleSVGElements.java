package org.example.SVGElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandleSVGElements {
    @Test
    @Description("Handling SVG elements")
    public void test_svg_elements(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("macmini");
        List<WebElement> allSVG=driver.findElements(By.xpath("//*[local-name()='svg']"));
        allSVG.get(0).click();
        driver.quit();
    }
}
