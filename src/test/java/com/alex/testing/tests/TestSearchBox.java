package com.alex.testing.tests;

import com.alex.testing.librarius.SearchBox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchBox extends BasicTest{


    @Test(testName = "searchBoxTest", groups = "basicUI")
    public void searchBox()  {
        logger.info("Start Search Box test");
        login();
        SearchBox searchBox = new SearchBox(driver);
        searchBox.setSearchBox("Edgar Allan Poe");
        searchBox.showBooks();
        Assert.assertEquals(searchBox.getNumberOfBooks(),36);
        logger.info("Finish Search Box test");
    }
}
