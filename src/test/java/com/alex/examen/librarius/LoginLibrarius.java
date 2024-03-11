package com.alex.examen.librarius;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginLibrarius {

   // @FindBy(id = "email")
   WebElement userEmailElem;
   // @FindBy(xpath = "//*[@id='password']")
    WebElement userPasswordElem;

    //@FindBy(id = "my-form__button")
    WebElement submitButton;

   // @FindBy(xpath = "//*[@class = 'sl-username-link']")
    WebElement emailProfile;

    WebElement basketImg;

    WebDriver driver;
    Wait<WebDriver> wait ;

    public LoginLibrarius(WebDriver driver){
        this.driver = driver;
        getInitialWebElement();
        final int TIMEOUT = 5;
        wait =  new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
    }

    public void getInitialWebElement(){
        userEmailElem = driver.findElement(new By.ById("email"));
        userPasswordElem = driver.findElement(new By.ById("password"));
        submitButton = driver.findElement(new By.ByClassName("my-form__button"));

    }
    public void setUserEmailElem(String userEmailParam){

        userEmailElem.sendKeys(userEmailParam);
    }

    public void setUserPasswordElem(String userPasswordParam){
        userPasswordElem.sendKeys(userPasswordParam);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }
    public void clickBasket(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("show-basket")));
        WebElement basketDiv = driver.findElement(By.className("show-basket"));
        basketImg = basketDiv.findElement(By.tagName("img"));
        basketImg.click();
    }

    public String getEmailProfile() {
        clickBasket();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'sl-username-link']")));
        emailProfile = driver.findElement(By.xpath("//*[@class = 'sl-username-link']"));
        return emailProfile.getText();
    }




}
