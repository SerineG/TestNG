package day06;

import UtilitiesClass.ParameterDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _05_SearchFunctionalityWithDataProvider2 extends ParameterDriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for mac, samsung, ipod by using data provider
     * Check all results contains these keywords
     * Use ParameterDriverClass and run the tests for different browsers parallel
     * */
    @Test(dataProvider = "myData")
    void searchFunctionality(String searchWord) throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//input[@name='search']"));
        search.clear();
        search.sendKeys(searchWord);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> resultList = driver.findElements(By.cssSelector("h4>a"));

        for (WebElement element : resultList) {
            Assert.assertTrue(element.getText().toLowerCase().contains(searchWord));
        }
        Thread.sleep(3000);

    }
    @DataProvider
    public Object[][] myData() {

        Object[][] dataList = {{"mac"}, {"samsung"}, {"ipod"}};

        return dataList;
    }

}
