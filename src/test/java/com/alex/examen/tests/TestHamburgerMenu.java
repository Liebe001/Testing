package com.alex.examen.tests;

import com.alex.examen.librarius.HamburgerMenuLibrarius;
import com.alex.examen.librarius.LoginLibrarius;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestHamburgerMenu extends BasicTest{

    public final int NUMBER_OF_BOOKS_FROM_TYPE= 11;

    @Test(testName = "hamburgerMenuTest")
    public void testHamburgerMenu(){
        login();
        HamburgerMenuLibrarius hamburgerMenuLibrarius= new HamburgerMenuLibrarius(driver);
        hamburgerMenuLibrarius.clickOnSideBar();
        List<String> booksListType = hamburgerMenuLibrarius.getBookTypeList();
        Assert.assertEquals(booksListType.size(),NUMBER_OF_BOOKS_FROM_TYPE);

    }


}
