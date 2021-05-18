package Tests;

import PageObjects.main;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    @Test
    public void youtubeHamburgerMenu() {
        //Initialize chromedriver
        WebDriver driver = chromeDriver();

        //Go to youtube
        openURL(driver, "https://www.youtube.com");

        //Click Hamburger Menu
        main main = new main(driver);
        main.clickHamburgerMenu();

        //We out here sleepin
        sleepPageTwoSeconds();

        //Close the browser
        main.closeBrowser();
    }

    @Test
    public void youtubeSearchCats() {
        //Initialize chromedriver
        WebDriver driver = chromeDriver();

        //Go to youtube
        openURL(driver, "https://www.youtube.com");

        //Click Hamburger Menu
        main main = new main(driver);
        main.searchFor("Cats");
        main.clickSearch();

        //We sleepin
        sleepPageTwoSeconds();

        //Assert that the title is what was searched for
        String title = main.getTitle();
        Assert.assertTrue(title.equals("Cats - YouTube"));

        //Close the browser
        main.closeBrowser();
    }


    /**********************
     *** helper methods ***
     **********************/

    //Initializes chromedriver from path
    public WebDriver chromeDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\burla\\Documents\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    //Sleeps the page for 2 seconds
    public void sleepPageTwoSeconds(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Opens any URL
    public void openURL(WebDriver driver, String url){
        driver.get(url);
    }
}
