package org.example.WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StaticWebTable2 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://awesomeqa.com/webtable1.html");
        WebElement tableBody=driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));

        for(int i=0;i<rows.size();i++){
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            for(WebElement colEle:cols){
                System.out.println(colEle.getText());
            }
        }
    }
}
