package org.example.SVGElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AdvancedSvgHandling {

   @Test
   public  void test_svg() {
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://www.amcharts.com/svg-maps/?map=india");

       List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g'][1]/*[name()='path']"));
        for(WebElement state:states){
            if(state.getAttribute("aria-label").contains("Tripura")){
                state.click();
                break;
            }
        }
        driver.quit();

   }
}
