package day02;

import UtilitiesClass.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _03_ValidateMenu extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * * email:  testngusbatch@gmail.com
     *      * password: usbatch1234
     * Validate that you see all menu options
     * */

    @Test(groups = "SmokeTest")
    void validate(){
        List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class=\"nav navbar-nav\"]/li"));
        List<String> expectedMenuList = new ArrayList<>(List.of("Desktops", "Laptops & Notebooks", "Components", "Tablets", "Software", "Phones & PDAs", "Cameras", "MP3 Players"));
        for(WebElement menu:menuList){
            Assert.assertTrue(expectedMenuList.contains(menu.getText()));
        }


    }
}
