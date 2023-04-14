package day07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _05_WishListElements {

    public _05_WishListElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "input[name='search']")
    private WebElement searchBox;

    @FindBy(css = "button[class=\"btn btn-default btn-lg\"]")
    private WebElement searchButton;
    @FindBy(css = "button[data-original-title=\"Add to Wish List\"]")
    private List<WebElement> productsList;

    @FindBy(xpath = "//div[@class='caption']//a")
    private List<WebElement> productNameList;


    @FindBy(id = "wishlist-total")
    private WebElement wishListButton;


    @FindBy(css = ".text-left>a")
    private WebElement wishListProduct;

    @FindBy(xpath = "//a[@data-original-title='Remove']")
    private WebElement removeFromWishListButton;

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public List<WebElement> getProductsList() {
        return productsList;
    }

    public List<WebElement> getProductNameList() {
        return productNameList;
    }

    public WebElement getWishListButton() {
        return wishListButton;
    }

    public WebElement getWishListProduct() {
        return wishListProduct;
    }

    public WebElement getRemoveFromWishListButton() {
        return removeFromWishListButton;
    }
}
