package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class main {

    WebDriver driver;

    public main(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#search")
    WebElement tbYoutubeSearchField;

    @FindBy(id = "guide-icon")
    WebElement btnHamburgerMenu;

    @FindBy(xpath = "//*[@id=\"search-icon-legacy\"]/yt-icon")
    WebElement searchButton;

    @FindBy(id = "twotabsearchtextbox")
    WebElement amazonSearchField;

    @FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
    WebElement amazonSearchButton;

    @FindBy(linkText = "Seagate BarraCuda 2TB Internal Hard Drive HDD – 3.5 Inch SATA 6Gb/s 7200 RPM 256MB Cache 3.5-Inch – Frustration Free Packaging (ST2000DM008)")
    WebElement linkHardDriveIWant;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/nav/div/div[1]/div[1]/div/div/div[1]/a/div/div[1]/div[2]/p")
    WebElement linkBrowseTwitch;

    @FindBy(css = "#root > div > div.sc-AxjAm.tlQbp > div > main > div.root-scrollable.scrollable-area > div.simplebar-scroll-content > div > div > div > div > div.sc-AxjAm.gBRyDo > div > div.ScTower-sc-1dei8tr-0.fhpaoU.tw-tower > div:nth-child(2) > div > div > div > div > div.sc-AxjAm.hBZJQK.tw-card > div > a > div > div.ScTransformWrapper-uo2e2v-1.eiQqOY > div > div > div > div")
    WebElement btnFirstTileTwitch;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/main/div[2]/div[3]/div/div/div/div/div/div[4]/div[2]/div[1]/div[1]/div[2]/div/div/div/article/div[2]/div/div[5]/a/div/div/div[1]")
    WebElement btnFirstTileTwitchResults;

    @FindBy(css = "#root > div > div.sc-AxjAm.tlQbp > div > main > div.root-scrollable.scrollable-area.scrollable-area--suppress-scroll-x > div.simplebar-scroll-content > div > div > div.InjectLayout-sc-588ddc-0.iTtXFV.persistent-player > div > div.sc-AxjAm.StDqN.video-player > div > video")
    WebElement videoScreen;

    /*******************************************************************************************************************
     ******************************************* Methods ***************************************************************
     *******************************************************************************************************************/

    public Boolean isVideoPresent(){
        Boolean isDisplayed = videoScreen.isDisplayed();
        return isDisplayed;
    }

    public void clickFirstTileTwitchResults(){
        btnFirstTileTwitchResults.click();
    }

    public void clickFirstTileTwitch(){
        btnFirstTileTwitch.click();
    }

    public void clickBrowseTwitch(){
        linkBrowseTwitch.click();
    }

    public void clickHardDriveIWant(){
        linkHardDriveIWant.click();
    }

    public void enterAmazonSearch(String text){
        amazonSearchField.sendKeys(text);
    }

    public void clickAmazonSearch(){
        amazonSearchButton.click();
    }

    public void clickHamburgerMenu(){
        btnHamburgerMenu.click();
    }

    public void youtubeSearchFor(String text){
        tbYoutubeSearchField.sendKeys(text);
    }

    public void clickSearch(){
        searchButton.click();
    }

    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

    public void closeBrowser(){
        driver.quit();
    }

    public String getAllTextOnPage(){
        String textOnPage = driver.getPageSource();
        return textOnPage;
    }

}
