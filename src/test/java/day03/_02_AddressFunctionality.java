package day03;

import UtilitiesClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _02_AddressFunctionality extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Address Book
     * Add a new address
     * Edit the address
     * Delete the address
     */
    @Test
    void addAddress() {
//        <a href="https://opencart.abstracta.us:443/index.php?route=account/address">Address Book</a>

        WebElement book=driver.findElement(By.partialLinkText("Address Book"));
        book.click();

//        <a href="https://opencart.abstracta.us:443/index.php?route=account/address/add" class="btn btn-primary">New Address</a>
        WebElement add=driver.findElement(By.partialLinkText("New Address"));
        add.click();

//        <input type="text" name="firstname" value="" placeholder="First Name" id="input-firstname" class="form-control" fdprocessedid="47o85j">
        WebElement name=driver.findElement(By.id("input-firstname"));
        name.sendKeys("John");
//        <input type="text" name="lastname" value="" placeholder="Last Name" id="input-lastname" class="form-control" fdprocessedid="8di70g">

        WebElement lastName=driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Doe");

//        <input type="text" name="address_1" value="" placeholder="Address 1" id="input-address-1" class="form-control" fdprocessedid="flq0j2">
        WebElement address=driver.findElement(By.id("input-address-1"));
        address.sendKeys("Gaviota");
//        <input type="text" name="city" value="" placeholder="City" id="input-city" class="form-control" fdprocessedid="p0frch">
        WebElement city=driver.findElement(By.id("input-city"));
        city.sendKeys("Encino");
//        <input type="text" name="postcode" value="" placeholder="Post Code" id="input-postcode" class="form-control" fdprocessedid="4e02gb">
        WebElement postcode=driver.findElement(By.id("input-postcode"));
        postcode.sendKeys("952154");
        WebElement country=driver.findElement(By.id("input-country"));

        Select countrySelect=new Select(country);
        int random=((int)(Math.random()*253))+1;
        countrySelect.selectByIndex(random);


        WebElement region = driver.findElement(By.id("input-zone"));
        Select selectRegion=new Select(region);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.
                not(ExpectedConditions.numberOfElementsToBe(By.xpath("//select[@id='input-zone']//option"),
                        driver.findElements(By.xpath("//select[@id='input-zone']//option")).size())));
        List<WebElement> listOfRegions = driver.findElements(By.xpath("//select[@id='input-zone']//option"));
        int randomRegionIndex = ((int) (Math.random()*listOfRegions.size()-1))+1;

        selectRegion.selectByIndex(randomRegionIndex);

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"))));
        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(successMessage.getText().contains("successfully"));
    }


    @Test(dependsOnMethods = "addAddress")
    void EditAddress(){

        WebElement editButton = driver.findElement(By.xpath("(//a[text()='Edit'][2]"));
        editButton.click();
        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.clear();
        address1.sendKeys("5884 Snow St.");

        WebElement city = driver.findElement(By.id("input-city"));
        city.clear();
        city.sendKeys("New York");

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"))));
        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(successMessage.getText().contains("successfully"));

    }


    @Test(dependsOnMethods = "addAddress")
    void DeleteAddress(){
        WebElement deleteButton = driver.findElement(By.xpath("(//a[text()='Delete'])[2]"));
        deleteButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"))));
        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(successMessage.getText().contains("successfully"));
    }

}
