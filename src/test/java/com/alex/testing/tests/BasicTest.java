package com.alex.testing.tests;

import com.alex.testing.librarius.LoginLibrarius;
import com.alex.testing.utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicTest {
    WebDriver driver;
    String USER_EMAIL;
    String USER_PASS ;
    static Logger logger = Logger.getLogger(BasicTest.class);

    @BeforeClass(alwaysRun = true)
    public void setProperties(){
        logger.info("Initialize test");
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

    @AfterClass(alwaysRun = true)
    public void destroy(){
        logger.info("Close test");
        driver.quit();
    }
}
