package com.alex.examen.librarius;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchBox {
    private final WebDriver driver;
    @FindBy(xpath = "//*[@id='searchbox']")
    private WebElement searchBoxElem;
   // @FindBy(xpath = "//*[@class= 'product-info'][position()<=5]")
    private List<WebElement> books;
    Wait<WebDriver> wait;
    public SearchBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void setSearchBox(String searchBoxParam){
        searchBoxElem.sendKeys(searchBoxParam, Keys.ENTER);
    }
    public void setAllBooks(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class= 'product-info']/div[@class='card-title'][1]")));
        books = driver.findElements(By.xpath("//*[@class= 'product-info']/div[@class='card-title'][1]"));
    }
    public void showBooks() {
        setAllBooks();
        books.stream().map(WebElement::getText).forEach(System.out::println);
    }
    public int getNumberOfBooks(){
        wait.until(d-> (long) books.size() >0);
        return books.size();
    }





}
