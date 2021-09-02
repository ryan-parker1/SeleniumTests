package Tests;

import PageObjects.NewEgg;
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
        openURL(driver, "https://www.youtube.com/");

        //Search for cats
        main main = new main(driver);
        main.youtubeSearchFor("Cats");
        main.clickSearch();

        //We sleepin
        sleepPageTwoSeconds();

        //Assert that the title is what was searched for
        String title = main.getTitle();
        Assert.assertTrue(title.equals("Cats - YouTube"));

        //Close the browser
        main.closeBrowser();
    }

    @Test
    public void searchAmazon(){
        //Initialize chromedriver
        WebDriver driver = chromeDriver();

        //Go to youtube
        openURL(driver, "https://www.amazon.com/");

        main Amazon = new main(driver);
        Amazon.enterAmazonSearch("Hard Drive");
        Amazon.clickAmazonSearch();

        sleepPageTwoSeconds();
        String title = Amazon.getTitle();
        Assert.assertTrue(title.contains("Amazon.com : Hard Drive"));

        Amazon.clickHardDriveIWant();

        sleepPageTwoSeconds();
        String allTextOnPage = Amazon.getAllTextOnPage();
        Assert.assertTrue(allTextOnPage.contains("Seagate BarraCuda 2TB Internal Hard Drive HDD – 3.5 Inch SATA 6Gb/s 7200 RPM 256MB Cache 3.5-Inch – Frustration Free Packaging (ST2000DM008)"));

        Amazon.closeBrowser();
    }

    @Test
    public void searchTwitch(){
        //Initialize chromedriver
        WebDriver driver = chromeDriver();

        //Go to twitch
        openURL(driver, "https://www.twitch.tv/");

        main Twitch = new main(driver);
        Twitch.clickBrowseTwitch();
        sleepPageTwoSeconds();

        Twitch.clickFirstTileTwitch();
        sleepPageTwoSeconds();

        Twitch.clickFirstTileTwitchResults();
        sleepPageTwoSeconds();

        Boolean isDisplayed = Twitch.isVideoPresent();
        Assert.assertTrue(isDisplayed.equals(true));

        Twitch.closeBrowser();
    }

    @Test
    public void searchNewEgg(){
        //Initialize chromedriver
        WebDriver driver = chromeDriver();

        //Set string
        String searchTerms = "phones";

        //Go to NewEgg
        openURL(driver, "https://www.newegg.com/");
        sleepPageTwoSeconds();

        //Enter into search field
        NewEgg newEgg = new NewEgg(driver);
        newEgg.enterSearchText(searchTerms);
        sleepPageTwoSeconds();

        //Click Search
        newEgg.clickSearch();
        sleepPageTwoSeconds();

        String textOnPage = newEgg.getAllTextOnPage();
        Assert.assertTrue(textOnPage.contains("Search Results: \"phones\""));
        driver.close();
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
