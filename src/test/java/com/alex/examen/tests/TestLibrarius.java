package com.alex.examen.tests;

import com.alex.examen.librarius.LibrariusCss;
import com.alex.examen.librarius.LoginLibrarius;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLibrarius {
    private WebDriver driver;

    static final String USER_EMAIL = "melnica456@gmail.com";
    String actualEmailProfile;
    public final String EXPECTED_FONT_TOP_MENU= "15px";

    public final String EXPECTED_FONT_CARD= "16px";
    static final String USER_PASS = "TrefUiok0102";

    @BeforeTest
    public void setProperties(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://librarius.md/ro/login");
        LoginLibrarius loginLibrarius = new LoginLibrarius(driver);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginLibrarius.setUserEmailElem(USER_EMAIL);
        loginLibrarius.setUserPasswordElem(USER_PASS);
        loginLibrarius.clickSubmitButton();
        actualEmailProfile = loginLibrarius.getEmailProfile();
        String expectedEmailProfile = "Bine ați venit! %s".formatted(USER_EMAIL);
        Assert.assertEquals(actualEmailProfile,expectedEmailProfile);



    }
    @Test
    public void cssRequirementsTest(){
        driver.get("https://librarius.md/ro/");
        LibrariusCss librariusCss = new LibrariusCss(driver);
        String actualResultFontTopMenu =  librariusCss.getSizeOfTopMenu();


        String fontSizeOfCardTitle = librariusCss.getSizeOfCardTitle();
        String fontSizeOfCardPrice = librariusCss.getSizeOfCardPrice();
        Assert.assertEquals(actualResultFontTopMenu,EXPECTED_FONT_TOP_MENU);
        Assert.assertEquals(fontSizeOfCardTitle,EXPECTED_FONT_CARD);
        Assert.assertEquals(fontSizeOfCardPrice,EXPECTED_FONT_CARD);


    }

    public void destroy(){
        driver.quit();
    }

}
