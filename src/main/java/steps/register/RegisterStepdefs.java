package steps.register;

import cucumber.api.java.After;
import cucumber.api.java.en.*;
import pages.RegisterPage;
import setup.NavigateFactory;

public class RegisterStepdefs {
    NavigateFactory navigateFactory;
    RegisterPage registerPage;
    final String url="https://practice.automationtesting.in/";
    @Given("le navigateur choisi {string} est ouvert")
    public void leNavigateurChoisiNavigatorEstOuvert(String navigator) {
        navigateFactory =  new NavigateFactory();
        navigateFactory.navigate(navigator);
    }

    @And("etre sur la home page")
    public void etreSurLaHomePage() {
        registerPage = new RegisterPage(navigateFactory);
        registerPage.Navigate(url);
    }
    @And("cliquer sur le menu MyAccount")
    public void cliquerSurLeMenuMyAccount() {
        registerPage.ClickMyAccount();
    }

    @When("entrer un  {string} et un {string}")
    public void entrerUnEmailEtUnMotdepasse(String email, String motdepasse) throws InterruptedException {
        registerPage.EnterEmail(email);
        registerPage.EnterMotDePasse(motdepasse);
    }

    @And("cliquer sur message strong")
    public void cliquerSurMessageStrong() {
        registerPage.ClickStrong();
    }
    @And("cliquer  sur le bouton REGISTER")
    public void cliquerSurLeBoutonREGISTER() throws InterruptedException {
        registerPage.ClickRegister();
    }
    @Then("Verifier que la page actuelle contient le message {string}")
    public void verifierQueLaPageActuelleContientLeMessageH(String message) {
        registerPage.CheckContains(message);
    }

    @After
    public void tearDown(){
        registerPage.Close();
    }
}
