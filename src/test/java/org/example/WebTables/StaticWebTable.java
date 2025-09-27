package org.example.WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticWebTable {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://awesomeqa.com/webtable.html");
        //Print the Country when Helen Bennett lives - Output: UK

        String xPathfirstPart="//table[@id='customers']/tbody/tr[";
        String xPathSecondPart="]/td[";
        String xPathThirdPart="]";

        int rows=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int cols=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        for(int i=2;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                String xpathValue=xPathfirstPart+i+xPathSecondPart+j+xPathThirdPart;
                //System.out.println(xpathValue);
                WebElement ele=driver.findElement(By.xpath(xpathValue));
                if(ele.getText().equals("Helen Bennett")){
                    String countryName=driver.findElement(By.xpath(xpathValue+"/following-sibling::td")).getText();
                    System.out.println("Helen Bennett lives in " + countryName);
                }
            }
        }
    }
}
