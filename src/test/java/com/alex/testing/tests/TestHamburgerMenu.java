package com.alex.testing.tests;

import com.alex.testing.librarius.HamburgerMenuLibrarius;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestHamburgerMenu extends BasicTest{
    public final int NUMBER_OF_BOOKS_FROM_TYPE= 11;
    @Test(testName = "hamburgerMenuTest", groups = "basicUI")
    public void testHamburgerMenu(){
        logger.info("Start HamburgerMenu test");
        login();
        HamburgerMenuLibrarius hamburgerMenuLibrarius= new HamburgerMenuLibrarius(driver);
        hamburgerMenuLibrarius.clickOnSideBar();
        List<String> booksListType = hamburgerMenuLibrarius.getBookTypeList();
        Assert.assertEquals(booksListType.size(),NUMBER_OF_BOOKS_FROM_TYPE);
        logger.info("Finish HamburgerMenu test");
    }


}
