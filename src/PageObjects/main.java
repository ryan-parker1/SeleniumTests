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
    WebElement textField;

    @FindBy(id = "guide-icon")
    WebElement btnHamburgerMenu;

    @FindBy(xpath = "//*[@id=\"search-icon-legacy\"]/yt-icon")
    WebElement searchButton;

    public void clickHamburgerMenu(){
        btnHamburgerMenu.click();
    }

    public void searchFor(String text){
        textField.sendKeys(text);
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

}
