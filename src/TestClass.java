import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    @Test
    public void main(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\burla\\Documents\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.get("https://www.google.com");
    }
}
