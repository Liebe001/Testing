package com.alex.examen.tests;

import com.alex.examen.librarius.LoginLibrarius;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class BasicTest {
    WebDriver driver;

    static final String USER_EMAIL = "melnica456@gmail.com";

    static final String USER_PASS = "TrefUiok0102";

    @BeforeTest
    public void setProperties(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
    }

    public LoginLibrarius login(){
        driver.get("https://librarius.md/ro/login");
        LoginLibrarius loginLibrarius = new LoginLibrarius(driver);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginLibrarius.setUserEmailElem(USER_EMAIL);
        loginLibrarius.setUserPasswordElem(USER_PASS);
        loginLibrarius.clickSubmitButton();

        return loginLibrarius;
    }


    @AfterClass
    public void destroy(){
        driver.quit();
    }
}
