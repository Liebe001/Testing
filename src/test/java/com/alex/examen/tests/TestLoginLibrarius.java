package com.alex.examen.tests;



import com.alex.examen.librarius.LoginLibrarius;


import org.testng.Assert;

import org.testng.annotations.Test;



public class TestLoginLibrarius extends BasicTest{



    String actualEmailProfile;



    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://librarius.md/ro/login");
        LoginLibrarius loginLibrarius = login();
        actualEmailProfile = loginLibrarius.getEmailProfile();
        String expectedEmailProfile = "Bine ați venit! %s".formatted(USER_EMAIL);
        Assert.assertEquals(actualEmailProfile,expectedEmailProfile);

    }




}
