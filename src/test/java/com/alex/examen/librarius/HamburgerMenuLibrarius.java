package com.alex.examen.librarius;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HamburgerMenuLibrarius {
    WebDriver driver;
    @FindBy(xpath = "//*[@class = 'showsidebar']")
    private WebElement sideBarElem;
    //*[@class='sb-category-item ']/a[@class='sb-show-subcategory']
    @FindBy(xpath = "//*[@class = 'sb-category-tree']/div/a")
    private List<WebElement> booksTypeListElem;


    public HamburgerMenuLibrarius(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnSideBar(){
        sideBarElem.click();
    }


    public List<String> getBookTypeList(){
        return booksTypeListElem.stream().map(WebElement::getText).toList();
    }

}
