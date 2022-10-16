package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.NavigateFactory;
import java.time.Duration;

public class PanierPage {
    WebDriver navigate;
    NavigateFactory navigateFactory;
    private final int TIMEOUT = 10;
    private final int TIMEOUTLOGOUT = 60000;

    private By MenuShopLocator = By.linkText("Shop");

    private By ButtonMyAccountLocator = By.cssSelector("#menu-item-50 > a");
    private By InputEmailLocator = By.id("username");
    private By InputMotDePassLocator = By.id("password");


    /**
     *
     * @param navigateFactory
     */
    public PanierPage(NavigateFactory navigateFactory){
        this.navigateFactory = navigateFactory;
    }

    /**
     *
     * @param url
     * @return WebDriver
     */
    public WebDriver Navigate(String url){
        this.navigate = navigateFactory.Get(url);
        return navigate ;
    }

    /**
     *
     * @return PanierPage
     */
    public PanierPage ClickMyAccount(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement ButtonMyAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonMyAccountLocator));
        ButtonMyAccount.click();
        return this;
    }

    /**
     *
     * @param email
     * @return PanierPage
     */
    public PanierPage EnterEmail(String email){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(InputEmailLocator));
        InputEmail.sendKeys(email);
        return this;
    }

    /**
     *
     * @param motdepasse
     * @return PanierPage
     */
    public PanierPage EnterMotDePasse(String motdepasse){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputMotDePasse = wait.until(ExpectedConditions.visibilityOfElementLocated(InputMotDePassLocator));
        InputMotDePasse.sendKeys(motdepasse);
        return this;
    }

    /**
     *
     * @return PanierPage
     */
    public PanierPage ClickMenu(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement MenuShop = wait.until(ExpectedConditions.visibilityOfElementLocated(MenuShopLocator));
        MenuShop.click();
        return this;
    }

    /**
     *
     * @param message
     * @return PanierPage
     */
    public PanierPage CheckContains(String message){
        navigate.getPageSource().contains(message);
        return this;
    }

    /**
     *
     * @param text
     * @return PanierPage
     */
    public PanierPage CheckPresent(String text){

        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLOGOUT));
        WebElement LinkLogout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));

        String ExpectedText = text;
        Assert.assertEquals(ExpectedText,LinkLogout.getText());
        return this;
    }

    /**
     *
     * @return PanierPage
     */
    public PanierPage Close(){

        navigate.quit();
        return this;
    }






}
