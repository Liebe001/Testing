package com.alex.examen.librarius;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LibrariusCss {
    private final WebDriver driver;
    private WebElement topMenu;
    private WebElement cardTitle;
    private WebElement cardPrice;

    public LibrariusCss(WebDriver driver){
        this.driver = driver;
        setupInitialValue();
    }
    public void setupInitialValue(){
        topMenu = driver.findElement(By.id("topmenu"));
        cardTitle = driver.findElement(By.className("card-title"));
        cardPrice = driver.findElement(By.className("card-price"));
    }
    public String getSizeOfTopMenu(){
        return topMenu.findElement(By.tagName("a")).getCssValue("font-size");
    }

    public String getSizeOfCardTitle(){
        return cardTitle.getCssValue("font-size");
    }
    public String getSizeOfCardPrice(){
        return cardPrice.getCssValue("font-size");
    }

}
