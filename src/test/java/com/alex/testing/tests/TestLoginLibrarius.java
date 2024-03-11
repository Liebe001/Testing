package com.alex.testing.tests;



import com.alex.testing.librarius.LoginLibrarius;


import org.testng.Assert;

import org.testng.annotations.Test;



public class TestLoginLibrarius extends BasicTest{
    String actualEmailProfile;
    @Test(testName = "login",groups = "login")
    public void loginTest() {
        logger.info("Start Login test");
        driver.get("https://librarius.md/ro/login");
        LoginLibrarius loginLibrarius = login();
        actualEmailProfile = loginLibrarius.getEmailProfile();
        String expectedEmailProfile = "Bine ați venit! %s".formatted(USER_EMAIL);
        Assert.assertEquals(actualEmailProfile,expectedEmailProfile);
        logger.info("Finish Login test");
    }




}
