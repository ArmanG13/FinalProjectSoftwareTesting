package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.util.List;
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void search(String query) {
        WebElement searchInput = driver.findElement(Locators.searchInput);
        searchInput.clear();
        searchInput.sendKeys(query);
        driver.findElement(Locators.searchButton).click();
    }
    public void addToBag() {
        driver.findElement(Locators.addToBagButton).click();
    }
    public void changeItemQuantityInBag(String newQuantity) {
        driver.findElement(Locators.bagIcon).click();
        WebElement quantitySpinner = driver.findElement(Locators.changeQuantityDropdown);

        int currentQuantity = Integer.parseInt(quantitySpinner.getAttribute("value"));
        int desiredQuantity = Integer.parseInt(newQuantity);

        while (currentQuantity != desiredQuantity) {
            if (currentQuantity > desiredQuantity) {
                quantitySpinner.sendKeys(Keys.ARROW_DOWN);
                currentQuantity--;
            } else if (currentQuantity < desiredQuantity) {
                quantitySpinner.sendKeys(Keys.ARROW_UP);
                currentQuantity++;
            }
        }
    }
    public void filterSearchResultsByPrice(String minPrice, String maxPrice) {
        WebElement minPriceFilterInput = driver.findElement(Locators.minPriceFilterInput);
        WebElement maxPriceFilterInput = driver.findElement(Locators.maxPriceFilterInput);

        minPriceFilterInput.clear();
        minPriceFilterInput.sendKeys(minPrice);
        minPriceFilterInput.sendKeys(Keys.ENTER);

        maxPriceFilterInput.clear();
        maxPriceFilterInput.sendKeys(maxPrice);
        maxPriceFilterInput.sendKeys(Keys.ENTER);
    }

    public void selectBrandFilterCheckbox(String brandName) {
        By brandCheckboxLocator = Locators.brandFilterCheckbox(brandName);
        WebElement brandCheckbox = driver.findElement(brandCheckboxLocator);
        if (!brandCheckbox.isSelected()) {
            brandCheckbox.click();
        }
    }

    public List<WebElement> getDisplayedProducts() {
        return driver.findElements(Locators.product);
    }

    public String getProductBrand(WebElement product) {
        return product.findElement(Locators.product).getText();
    }
    public void removeFromBag() {
        driver.findElement(Locators.bagIcon).click();
        WebElement removeButton = driver.findElement(Locators.removeItemButton);
        removeButton.click();
    }
}
