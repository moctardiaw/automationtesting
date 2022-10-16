package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 */
public class NavigateFactory{
    WebDriver driver;

    /**
     *
     * @param navigator
     * @return WebDriver
     */
    public WebDriver navigate ( String navigator ){

        switch (navigator){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    /**
     *
     * @param url
     * @return WebDriver
     */
    public WebDriver Get(String url){
        driver.get(url);
        return  driver;
    }
}