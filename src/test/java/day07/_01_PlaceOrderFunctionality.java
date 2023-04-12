package day07;

import UtilitiesClass.ParameterDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class _01_PlaceOrderFunctionality extends ParameterDriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Search for ipod
     * Add the first result to cart
     * Click on cart icon
     * Click on Check Out
     * Fill the form
     * Click on Confirm and verify that your order is successful
     */

    @Test(dataProvider = "getData")
    void checkOutTest(String searchKeyWord) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement searchBox = driver.findElement(By.cssSelector("input[name='search']"));
        searchBox.sendKeys(searchKeyWord);

        WebElement searchButton = driver.findElement(By.cssSelector("button[class=\"btn btn-default btn-lg\"]"));
        searchButton.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToCartButton.click();

        WebElement cartTotal = driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
        cartTotal.click();

        WebElement checkOutButton = driver.findElement(By.linkText("Checkout"));
        checkOutButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));

        WebElement continueAddress = driver.findElement(By.id("button-payment-address"));
        continueAddress.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));

        WebElement continueShippingAddress = driver.findElement(By.id("button-shipping-address"));
        continueShippingAddress.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));

        WebElement continueShippingMethod = driver.findElement(By.id("button-shipping-method"));
        continueShippingMethod.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox'")));

        WebElement paymentRadioButton = driver.findElement(By.cssSelector("input[type='checkbox'"));
        paymentRadioButton.click();

        WebElement paymentContinue = driver.findElement(By.id("button-payment-method"));
        paymentContinue.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));

        WebElement confirmOrderButton = driver.findElement(By.id("button-confirm"));
        confirmOrderButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1[text()='Your order has been placed!']")));
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='content']/h1[text()='Your order has been placed!']"));
        Assert.assertTrue(successMessage.getText().equals("Your order has been placed!"));
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] myData = {{"ipod"}};
        return myData;
    }
}
