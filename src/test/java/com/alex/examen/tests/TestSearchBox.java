package com.alex.examen.tests;

import com.alex.examen.librarius.SearchBox;
import org.testng.annotations.Test;

public class TestSearchBox extends BasicTest{


    @Test(testName = "searchBoxTest")
    public void searchBox() throws InterruptedException {
        login();
        SearchBox searchBox = new SearchBox(driver);
        searchBox.setSearchBox("Edgar Allan Poe");
        searchBox.showBooks();
    }

}