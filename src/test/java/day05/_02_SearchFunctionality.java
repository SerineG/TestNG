package day05;

import UtilitiesClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_SearchFunctionality extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Search for "mac"
     * Check if all results contains mac key word
     * */

    @Test
    @Parameters(value = "searchKeyWord")
    void searchFunctionality(String str){
        WebElement search=driver.findElement(By.xpath("//input[@name='search']"));
        search.sendKeys(str);

        WebElement searchButton=driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]"));
        searchButton.click();

        List<WebElement> resultList=driver.findElements(By.cssSelector("h4>a"));

        for (WebElement element:resultList){
            Assert.assertTrue(element.getText().toLowerCase().contains(str));
        }




    }
}
