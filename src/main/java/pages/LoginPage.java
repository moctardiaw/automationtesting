package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.NavigateFactory;
import java.time.Duration;
import java.util.List;

public class LoginPage {
    WebDriver navigate;
    NavigateFactory navigateFactory;
    private final int TIMEOUT = 10;
    private final int TIMEOUTLOGOUT = 60000;
    private final int TIMEOUTLINK = 2000;
    private By ButtonMyAccountLocator = By.cssSelector("#menu-item-50 > a");
    private By InputEmailLocator = By.id("username");
    private By InputMotDePassLocator = By.id("password");
    private By ButtonLoginLocator = By.cssSelector("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > input.woocommerce-Button.button");
    private By ButtonFilterLocator = By.cssSelector("button[type='submit']");
    private By LinkLogoutLocator = By.linkText("Sign out");
    private By LinkAccountdetailsLocator = By.linkText("Account Details");
    private By BasketLocator = By.cssSelector(".cartcontents");

    private By InputNomLocator = By.name("account_first_name");
    private By InputPrenomLocator = By.name("account_last_name");
    private By InputCourantMotdePasseLocator = By.id("password_current");
    private By InputNouveauMotdePasseLocator = By.id("password_1");
    private By InputConfirmeMotdepasseLocator = By.id("password_2");
    private By ButtonSaveChangesLocator = By.cssSelector("#menu-item-50 > a");

    private By LinkDashboardLocator = By.linkText("Dashboard");

    private By LinkOrderLocator = By.linkText("Orders");

    private By LinkDownloadsLocator = By.linkText("Downloads");

    private By LinkAddressesLocator = By.linkText("Addresses");

    private By LinkAccountDetailsLocator = By.linkText("Account Details");
    private By SearchResultsLocator = By.cssSelector("img.attachment-shop_catalog");
    private By SliderPriceLocator = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > aside:nth-child(2) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)");
    private By SliderPriceMaxLocator = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > aside:nth-child(2) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(3)");


    /**
     *
     * @param navigateFactory
     */
    public LoginPage(NavigateFactory navigateFactory){
        this.navigateFactory = navigateFactory;
    }

    /**
     *
     * @param url
     * @return LoginPage
     */
    public WebDriver Navigate(String url){
        this.navigate = navigateFactory.Get(url);
        return navigate ;
    }

    /**
     *
     * @return LoginPage
     */
    public LoginPage ClickMyAccount(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement ButtonMyAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonMyAccountLocator));
        ButtonMyAccount.click();
        return this;
    }

    /**
     *
     * @param email
     * @return LoginPage
     */
    public LoginPage EnterEmail(String email){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(InputEmailLocator));
        InputEmail.sendKeys(email);
        return this;
    }

    /**
     *
     * @param motdepasse
     * @return LoginPage
     */
    public LoginPage EnterMotDePasse(String motdepasse){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputMotDePasse = wait.until(ExpectedConditions.visibilityOfElementLocated(InputMotDePassLocator));
        InputMotDePasse.sendKeys(motdepasse);
        return this;
    }

    /**
     *
     * @return LoginPage
     */
    public LoginPage ClickLogin(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement ButtonLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonLoginLocator));
        ButtonLogin.click();
        return this;
    }

    /**
     *
     * @param message
     * @return LoginPage
     */
    public LoginPage CheckContains(String message){
        navigate.getPageSource().contains(message);
        return this;
    }

    /**
     *
     * @param text
     * @return LoginPage
     */
    public LoginPage CheckPresent(String text){

        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLOGOUT));
        WebElement LinkLogout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));

        String ExpectedText = text;
        Assert.assertEquals(ExpectedText,LinkLogout.getText());
        return this;
    }

    /**
     *
     * @return LoginPage
     */
    public LoginPage Close(){

        navigate.quit();
        return this;
    }

//----------------------------------------------------Log out---------------------------------------------------------------//

    /**
     *
     * @return LoginPage
     */
    public LoginPage ClickLogoutLinkText(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLOGOUT));
        WebElement LinkLogout = wait.until(ExpectedConditions.visibilityOfElementLocated(LinkLogoutLocator));
        LinkLogout.click();

        return this;
    }

    //----------------------------------------------------accountdetails-----------------------------------------------------//

    /**
     *
     * @return LoginPage
     */
    public LoginPage ClickAccountdetailsLinkText(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLOGOUT));
        WebElement LinkAccountdetails = wait.until(ExpectedConditions.visibilityOfElementLocated(LinkAccountdetailsLocator));
        LinkAccountdetails.click();

        return this;
    }

    /**
     *
     * @param nom
     * @return LoginPage
     */
    public LoginPage EnterNom(String nom){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputNom = wait.until(ExpectedConditions.visibilityOfElementLocated(InputNomLocator));
        InputNom.clear();
        InputNom.sendKeys(nom);
        return this;
    }

    /**
     *
     * @param prenom
     * @return LoginPage
     */
    public LoginPage EnterPrenom(String prenom){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputPrenom = wait.until(ExpectedConditions.visibilityOfElementLocated(InputPrenomLocator));
        InputPrenom.clear();
        InputPrenom.sendKeys(prenom);
        return this;
    }

    /**
     *
     * @param currentpassword
     * @return LoginPage
     */
    public LoginPage EnterCourantMotdepasse(String currentpassword) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputCourantMotdePasse = wait.until(ExpectedConditions.visibilityOfElementLocated(InputCourantMotdePasseLocator));
        InputCourantMotdePasse.clear();

        char[] charArray = currentpassword.toCharArray();
        for(int i=0; i<charArray.length;i++){
            InputCourantMotdePasse.sendKeys(""+charArray[i]);
            System.out.println(charArray[i]+toString());
            Thread.sleep(1000);
        }
        return this;
    }

    /**
     *
     * @param newpassword
     * @return LoginPage
     */
    public LoginPage EnterNouveauMotdepasse(String newpassword) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputNouveauMotdePasse = wait.until(ExpectedConditions.visibilityOfElementLocated(InputNouveauMotdePasseLocator));
        InputNouveauMotdePasse.clear();


        char[] charArray = newpassword.toCharArray();
        for(int i=0; i<charArray.length;i++){
            InputNouveauMotdePasse.sendKeys(""+charArray[i]);
            System.out.println(charArray[i]+toString());
            Thread.sleep(1000);
        }

        return this;
    }

    /**
     *
     * @param confirmpass
     * @return LoginPage
     */
    public LoginPage EnterConfirmeMotdepasse(String confirmpass) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement InputConfirmeMotdepasse = wait.until(ExpectedConditions.visibilityOfElementLocated(InputConfirmeMotdepasseLocator));
        InputConfirmeMotdepasse.clear();

        char[] charArray = confirmpass.toCharArray();
        for(int i=0; i<charArray.length;i++){
            InputConfirmeMotdepasse.sendKeys(""+charArray[i]);
            System.out.println(charArray[i]+toString());
            Thread.sleep(1000);
        }

        return this;
    }

    /**
     *
     * @return LoginPage
     */
    public LoginPage ClickSaveChanges(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement ButtonSaveChanges = wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonSaveChangesLocator));
        ButtonSaveChanges.click();
        return this;
    }

    /**
     *
     * @param text
     * @return
     */
    public LoginPage ClickMenu(String text){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement ButtonLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
        ButtonLogin.click();
        return this;
    }

    /**
     *
     * @return
     */
    public List<WebElement> GetAllProducts(){
        List<WebElement> resultatList = navigate.findElements(SearchResultsLocator);
        return resultatList;
    }

    /**
     *
     * @param categorie
     * @return
     */
    public List<WebElement> GetAllProductsByCategorie(String categorie){
        List<WebElement> resultatList = navigate.findElements(SearchResultsLocator);
        return resultatList;
    }

    /**
     *
     * @param text
     * @return
     */
    public LoginPage ClickLink(String text){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLINK));
        WebElement LinkText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
        if(LinkText.isDisplayed()){
            System.out.println(text+" is displayed");
            LinkText.click();
        }
        return this;
    }

    /**
     *
     * @param id
     * @return
     */
    public LoginPage ClickLinkByDataProductId(String id){
        String text="[data-product_id$='";
        text=text+id+"']";
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLINK));
        WebElement LinkText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(text)));
        if(LinkText.isDisplayed()){
            System.out.println(text+" is displayed");
            LinkText.click();
        }

        return this;
    }
    /**
     *
     * @param title
     * @return
     */
    public LoginPage ClickLinkByTitle(String title){
        String text="[title$='";
        text=text+title+"']";
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLINK));
        WebElement LinkText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(text)));
        if(LinkText.isDisplayed()){
            System.out.println(text+" is displayed");
            LinkText.click();
        }

        return this;
    }

    /**
     *
     * @param text
     * @return
     */
    public LoginPage CheckIncrement(String text){

        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLOGOUT));
        WebElement Basket = wait.until(ExpectedConditions.visibilityOfElementLocated(BasketLocator));

        System.out.println(Basket.getText());
        String ExpectedText = text;
        Assert.assertEquals(ExpectedText,Basket.getText());
        return this;
    }

    /**
     *
     * @param min
     * @return
     */
    public LoginPage DragAndDropMin(String min){

        int minimum = Integer.parseInt(min);
        minimum=minimum-37;
        minimum=minimum+10;

        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLOGOUT));
        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(SliderPriceLocator));
        Actions action = new Actions(navigate);
        action.dragAndDropBy(slider,minimum,0).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    /**
     *
     * @param max
     * @return
     */
    public LoginPage DragAndDropMax(String max){

        int maximum = Integer.parseInt(max);
        maximum=maximum+37;
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUTLOGOUT));
        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(SliderPriceMaxLocator));
        Actions action = new Actions(navigate);
        action.dragAndDropBy(slider,maximum,0).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    /**
     *
     * @return
     */
    public LoginPage ClickFilter(){
        WebDriverWait wait = new WebDriverWait((WebDriver) navigate, Duration.ofSeconds(TIMEOUT));
        WebElement ButtonFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonFilterLocator));
        ButtonFilter.click();
        return this;
    }

    /**
     *
     * @param filter
     * @return
     */
    public LoginPage GetCurrentUrl(String filter){

        String requestUri = null;

        String path=navigate.getCurrentUrl();
        System.out.println(path);

        if(path.startsWith("https://")){

            requestUri = path.substring(8).split("/shop/")[1];
        }else{
            requestUri = path.split("/shop/")[1];
        }
        System.out.println(requestUri);
        String ExpectedText = filter;
        Assert.assertEquals(ExpectedText,requestUri);
        return this;
    }

    /**
     *
     * @param filter
     * @return
     */
    public LoginPage GetNotCurrentUrl(String filter){

        String requestUri = null;
        String path=navigate.getCurrentUrl();
        System.out.println(path);

        if(path.startsWith("https://")){

            requestUri = path.substring(8).split("/shop/")[1];
        }else{
            requestUri = path.split("/shop/")[1];
        }
        System.out.println(requestUri);
        String ExpectedText = filter;
        Assert.assertNotEquals(ExpectedText,requestUri);
        return this;
    }


}
