package org.example.WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OrangeHRM {
    WebDriver driver;
    @BeforeClass
    public void openUrl(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
    }

    @Test(priority = 1)
    public void doLogin(){
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[contains(normalize-space(.),'Login')]")).click();
    }

    @Test(priority = 2)
    public void getEmployeeDetails(){
        WebElement tableBody=driver.findElement(By.xpath("//div[@class='oxd-table orangehrm-employee-list']/div[@class='oxd-table-body']"));

        List<WebElement> rows = tableBody.findElements(By.xpath(".//div[contains(@class,'oxd-table-row')]"));

        for(int i=0;i<rows.size();i++){
            List<WebElement> cols = rows.get(i).findElements(By.xpath(".//div[contains(@class,'oxd-table-cell')]/div"));
            for(WebElement colEle:cols){
                if(colEle.getText().equals("Terminated"))
                {
                    WebElement firstName=colEle.findElement(By.xpath("./parent::div/preceding-sibling::div[3]"));
                    System.out.println(firstName.getText() + " has been terminated");
                }
            }
        }
    }

}
