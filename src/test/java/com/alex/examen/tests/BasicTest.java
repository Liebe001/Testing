package com.alex.examen.tests;

import com.alex.examen.librarius.LoginLibrarius;
import com.alex.examen.utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class BasicTest {
    WebDriver driver;
    String USER_EMAIL;

    String USER_PASS ;
    @BeforeTest
    public void setProperties(){
        driver = WebDriverManager.firefoxdriver().create();
        driver.manage().window().maximize();
        USER_EMAIL = ConfigProperties.getProperty("user.email");
        USER_PASS = ConfigProperties.getProperty("user.password");
    }

    public LoginLibrarius login(){
        driver.get(ConfigProperties.getProperty("loginpage"));
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
