package com.alex.examen.librarius;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchBox {


    private WebDriver driver;

    @FindBy(xpath = "//*[@id='searchbox']")
    private WebElement searchBoxElem;

   // @FindBy(xpath = "//*[@class= 'product-info'][position()<=5]")
    private List<WebElement> books;




    public SearchBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void setSearchBox(String searchBoxParam){
        searchBoxElem.sendKeys(searchBoxParam, Keys.ENTER);
    }
    public void setAllBooks(){
        books = driver.findElements(By.xpath("//*[@class= 'product-info']/div[@class='card-title'][1]"));
    }
    public void showBooks() throws InterruptedException {
        Thread.sleep(3000);
        setAllBooks();

        books.stream().map(WebElement::getText).forEach(System.out::println);
    }





}
