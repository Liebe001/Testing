package com.alex.examen.librarius;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public LoginLibrarius(WebDriver driver){
        this.driver = driver;
        getInitialWebElement();
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
        WebElement basketDiv = driver.findElement(new By.ByClassName("show-basket"));

        basketImg = basketDiv.findElement(new By.ByTagName("img"));
        basketImg.click();
    }

    public String getEmailProfile() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
       // Thread.sleep(2000);
        clickBasket();
        emailProfile = driver.findElement(new By.ByXPath("//*[@class = 'sl-username-link']"));
        return emailProfile.getText();
    }




}
