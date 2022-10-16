package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.NavigateFactory;
import java.time.Duration;
public class RegisterPage {

    WebDriver navigate;
    NavigateFactory navigateFactory;
    private final int TIMEOUT = 20;

    private By ButtonMyAccountLocator = By.cssSelector("#menu-item-50 > a");
    private By InputEmailLocator = By.id("reg_email");
    private By InputMotDePassLocator = By.id("reg_password");
    private By ButtonRegisterLocator = By.name("register");

    private By LabelMotDePasseLocator = By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[2]/label/text()");

    private By FlashMessageStrongLocator = By.className("strong");//add Click and wait to click REGISTER
    /**
     *
     * @param navigateFactory
     */
    public RegisterPage(NavigateFactory navigateFactory){
        this.navigateFactory = navigateFactory;
    }

    /**
     *
     * @param url
     * @return
     */
    public WebDriver Navigate(String url){
        this.navigate = navigateFactory.Get(url);
        return navigate ;
    }

    /**
     *
     * @return RegisterPage
     */
    public RegisterPage ClickMyAccount(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement ButtonMyAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonMyAccountLocator));
        ButtonMyAccount.click();
        return this;
    }

    /**
     *
     * @param email
     * @return
     */
    public RegisterPage EnterEmail(String email){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(InputEmailLocator));
        InputEmail.sendKeys(email);
        return this;
    }

    /**
     *
     * @param motdepasse
     * @return RegisterPage
     */
    public RegisterPage EnterMotDePasse(String motdepasse) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputMotDePasse = wait.until(ExpectedConditions.visibilityOfElementLocated(InputMotDePassLocator));

        char[] charArray = motdepasse.toCharArray();
        for(int i=0; i<charArray.length;i++){
            InputMotDePasse.sendKeys(""+charArray[i]);
            System.out.println(charArray[i]+toString());
            Thread.sleep(1000);
        }

        return this;
    }

    public RegisterPage ClickStrong(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement FlashMessageStrong = wait.until(ExpectedConditions.visibilityOfElementLocated(LabelMotDePasseLocator));
        FlashMessageStrong.click();
        return this;
    }

    /**
     *
     * @return RegisterPage
     */
    public RegisterPage ClickRegister(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement ButtonRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonRegisterLocator));
        ButtonRegister.click();
        return this;
    }

    /**
     *
     * @param message
     * @return RegisterPage
     */
    public RegisterPage CheckContains(String message){
        navigate.getPageSource().contains(message);
        return this;
    }

    /**
     *
     * @return RegisterPage
     */
    public RegisterPage Close(){
        navigate.quit();
        return this;
    }
}