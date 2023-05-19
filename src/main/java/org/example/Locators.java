package org.example;

import org.openqa.selenium.By;

public class Locators {
    public static final By searchInput =By.cssSelector(".search_form form input");
    public static final By searchButton = By.cssSelector("#searchForm button");
    public static final By bagIcon = By.cssSelector("#basketIcon");
    public static final By removeItemButton = By.cssSelector(".delete_basket_item span");

    public static final By changeQuantityDropdown = By.cssSelector(".spinner button");
    public static final By searchResults = By.id("searchResult");
    public static By bagCount= By.xpath("//div[@class='small_info']//span[contains(text(), 'Item number')]/strong");
    public static By productPrice=By.cssSelector("meta[property='product:price:amount']");
    public static final By noResultsMessage = By.cssSelector(".error_page.result_error");

    public static final By addToBagButton =By.cssSelector("a[onclick=\"addSingleProduct(event)\"]");

    public static By minPriceFilterInput = By.xpath("//div[@class='price_filter']//div[@class='min']/input[@id='value']");
    public static By maxPriceFilterInput = By.xpath("//div[@class='price_filter']//div[@class='max']/input[@id='value']");

    public static By product= By.xpath("//div[@class='item_img']/a[@href='/en/product/pen-green-creative-studio-recycled']");
    public static By productQuantityInBag(String productId) {
        return By.xpath("//div[@id='basketIcon']//div[@id='productQuantity']");
    }
    public static By brandFilterCheckbox(String brandName) {
        return By.xpath("//a[normalize-space()='" + brandName + "']");
    }
}
