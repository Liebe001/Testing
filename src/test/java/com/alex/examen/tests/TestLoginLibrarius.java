package com.alex.examen.tests;


import com.alex.examen.librarius.LibrariusCss;
import com.alex.examen.librarius.LoginLibrarius;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestLoginLibrarius extends BasicTest{

    //Your username

    String actualEmailProfile;
    public final String EXPECTED_FONT_TOP_MENU= "15px";

    public final String EXPECTED_FONT_CARD= "16px";
    //Your password





    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://librarius.md/ro/login");
        LoginLibrarius loginLibrarius = login();
        actualEmailProfile = loginLibrarius.getEmailProfile();
        String expectedEmailProfile = "Bine ați venit! %s".formatted(USER_EMAIL);
        Assert.assertEquals(actualEmailProfile,expectedEmailProfile);



    }
//    @Test
//    public void cssRequirementsTest(){
//        driver.get("https://librarius.md/ro/");
//        LibrariusCss librariusCss = new LibrariusCss(driver);
//        String actualResultFontTopMenu =  librariusCss.getSizeOfTopMenu();
//
//
//        String fontSizeOfCardTitle = librariusCss.getSizeOfCardTitle();
//        String fontSizeOfCardPrice = librariusCss.getSizeOfCardPrice();
//        Assert.assertEquals(actualResultFontTopMenu,EXPECTED_FONT_TOP_MENU);
//        Assert.assertEquals(fontSizeOfCardTitle,EXPECTED_FONT_CARD);
//        Assert.assertEquals(fontSizeOfCardPrice,EXPECTED_FONT_CARD);
//
//
//
//    }



}
