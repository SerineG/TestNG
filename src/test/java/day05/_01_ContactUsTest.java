package day05;

import UtilitiesClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_ContactUsTest extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * login
     * click on Contact Us
     * send a message from xml file
     * check if the url has "success" key word
     */
    @Test
    @Parameters({"message1"})
    void contactUs(String message1) throws InterruptedException {
        WebElement contactUS = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUS.click();
        WebElement messageType = driver.findElement(By.id("input-enquiry"));
        messageType.sendKeys(message1);
        Thread.sleep(3000);
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();


        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }

    @Test
    @Parameters({"message1", "message2"})
    void contactUs1(String message1, String message2) throws InterruptedException {
        WebElement contactUS = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUS.click();
        WebElement messageType = driver.findElement(By.id("input-enquiry"));
        messageType.sendKeys(message1);
        messageType.sendKeys(message2);

        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }
}
