package steps.login;

import common.ImportResultsToXray;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import setup.NavigateFactory;
import steps.logout.LogoutStepdefs;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 *
 */
public class LoginStepdefs  {
    NavigateFactory navigateFactory;
    LoginPage loginPage;
    final String url="https://practice.automationtesting.in/";
    //--------------------------------login------------------------------------------//

    /**
     *
     * @param navigator
     */
    @Given("le navigateur {string} est ouvert")
    public void leNavigateurNavigatorEstOuvert(String navigator) {
        navigateFactory =  new NavigateFactory();
        navigateFactory.navigate(navigator);
    }
    @And("je suis sur la home page")
    public void jeSuisSurLaHomePage() {
        loginPage = new LoginPage(navigateFactory);
        loginPage.Navigate(url);
    }

    /**
     *
     * @param email
     * @param motdepasse
     */
    @When("saisir un  {string} et un {string}")
    public void saisirUnEmailEtUnMotdepasse(String email, String motdepasse) {
        loginPage.EnterEmail(email);
        loginPage.EnterMotDePasse(motdepasse);
    }
    @And("cliquer  sur le bouton LOGIN")
    public void cliquerSurLeBoutonLOGIN() {
        loginPage.ClickLogin();
    }

    /**
     *
     * @param message
     */
    @Then("Verifier que la page contient le message {string}")
    public void verifierQueLaPageContientLeMessageHello(String message) {
         loginPage.CheckContains(message);
    }

    /**
     *
     * @param message
     */
    @Then("Verifier que la page contient  le message {string}")
    public void verifierQueLaPageContientLeMessageErrorThePasswordYouEnteredForTheUsername(String message) {
         loginPage.CheckContains(message);
    }
    @And("cliquer sur le menu My Account")
    public void cliquerSurLeMenuMyAccount() {
        loginPage.ClickMyAccount();
    }
    @After
    public void tearDown() throws NoSuchAlgorithmException, KeyStoreException, IOException, InterruptedException, KeyManagementException {
        loginPage.Close();
    }
    //--------------------------------logout------------------------------------------//
    @And("cliquer  sur le lien Logout")
    public void cliquerSurLeLienLogout() {
        loginPage.ClickLogoutLinkText();
    }
    //-----------------------------accountdetails-------------------------------------//
    @And("cliquer sur le lien account details")
    public void cliquerSurLeLienAccountDetails() {
        loginPage.ClickAccountdetailsLinkText();
    }

    /**
     *
     * @param nom
     * @param prenom
     */
    @When("entrer un {string} et un {string}")
    public void entrerUnNomEtUnPrenom(String nom, String prenom) {
        loginPage.EnterNom(nom);
        loginPage.EnterPrenom(prenom);
    }

    /**
     *
     * @param newpassword
     */
    @And("saisir  le nouveau {string}")
    public void saisirLeNouveauMotdepassenouveau(String newpassword) throws InterruptedException {

        loginPage.EnterNouveauMotdepasse(newpassword);
    }

    /**
     *
     * @param confirmpass
     */
    @And("saisir le {string}")
    public void saisirLeMotdepasseconfirme(String confirmpass) throws InterruptedException {

        loginPage.EnterConfirmeMotdepasse(confirmpass);
    }

    @And("saisir un {string} et un {string}")
    public void saisirUnMotdepasseactuelEtUnMotdepassenouveau(String currentpass,String nouveaupass) throws InterruptedException {

        loginPage.EnterCourantMotdepasse(currentpass);
        loginPage.EnterNouveauMotdepasse(nouveaupass);
    }

    @And("cliquer sur le bouton SAVE CHANGE")
    public void cliquerSurLeBoutonSAVECHANGE() {

        loginPage.ClickSaveChanges();
    }

    /**
     *
     * @param message
     */
    @Then("Verifier que la page ne contient pas le message {string}")
    public void verifierQueLaPageNeContientPasLeMessageError(String message) {
        loginPage.CheckContains(message);
    }
    //----------------Presence des liens----------------------------------------------------//
    @And("Verifier la presence des liens")
    public void verifierLaPresenceDesLiens() {
        loginPage.CheckPresent("Dashboard");
        loginPage.CheckPresent("Orders");
        loginPage.CheckPresent("Downloads");
        loginPage.CheckPresent("Addresses");
        loginPage.CheckPresent("Account Details");
    }
    //-------------------------------Panier---------------------------------------------------//
    @When("cliquer le menu shop")
    public void cliquerLeMenuShop() {
        loginPage.ClickMenu("Shop");
    }

    @Then("la page shop s'ouvre avec des produits affichés")
    public void laPageShopSOuvreAvecDesProduitsAffichés() {
        Assert.assertEquals(8,loginPage.GetAllProducts().size());
    }
     //------------------------------Articles--------------------------------------------------//
    /**
     *
     * @param val
     */
    @Then("le nombre de produits affiches doit etre doit etre egale au {string} attendu")
    public void leNombreDeProduitsAffichesDoitEtreDoitEtreEgaleAuNombretotalAttendu(String val) {
        int nombre = Integer.parseInt(val);
        try {
            Thread.sleep(1000);
            System.out.println(loginPage.GetAllProducts().size());
            Assert.assertEquals(nombre,loginPage.GetAllProducts().size());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param link
     */
    @And("cliquer sur lien {string}")
    public void cliquerSurLienCategorie(String link) {
        loginPage.ClickLink(link);
    }

    /**
     *
     * @param val
     */
    @Then("le nombre de produits affiches ne doit pas etre egale au {string} attendu")
    public void leNombreDeProduitsAffichesNeDoitPasEtreEgaleAuNombretotalAttendu(String val) {

        int nombre = Integer.parseInt(val);
        try {
            Thread.sleep(1000);
            System.out.println(loginPage.GetAllProducts().size());
            Assert.assertNotEquals(nombre,loginPage.GetAllProducts().size());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @And("cliquer sur View Basket")
    public void cliquerSurViewBasket() {
        loginPage.ClickLink("View Basket");
    }

    /**
     *
     * @param product
     */
    @And("choisir un produit {string} en  cliquant sur ADD TO BASKET")
    public void choisirUnProduitProductidEnCliquantSurADDTOBASKET(String product) {

        try {
            Thread.sleep(1000);
            loginPage.ClickLinkByDataProductId(product);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("cliquer sur l'icone du panier")
    public void cliquerSurLIconeDuPanier() {
        loginPage.ClickLinkByTitle("View your shopping cart");
    }

    /**
     *
     * @param increment
     */
    @Then("le nombre de produits presents dans le panier doit etre doit etre egale au nombre {string} attendu")
    public void leNombreDeProduitsPresentsDansLePanierDoitEtreDoitEtreEgaleAuNombreIncrementAttendu(String increment) {
        loginPage.CheckIncrement(increment);
    }

    @And("cliquer sur la croix pour supprimer l'article")
    public void cliquerSurLaCroixPourSupprimerLArticle() {
        loginPage.ClickLinkByTitle("Remove this item");
    }

    /**
     *
     * @param min
     * @param max
     */
    @And("filtrer par prix {string} et {string}")
    public void filtrerParPrixMinimumEtMaximun(String min, String max) {
        loginPage.DragAndDropMin(min);
        loginPage.DragAndDropMax(max);
    }

    @And("cliquer sur le bouton FILTER")
    public void cliquerSurLeBoutonFILTER() {
        loginPage.ClickFilter();
    }

    /**
     *
     * @param filter
     */
    @Then("url contient les valeurs de filtres {string}")
    public void urlContientLesValeursDeFiltresFilter(String filter) {
        loginPage.GetCurrentUrl(filter);
    }

    /**
     *
     * @param filter
     */
    @Then("url ne contient pas les valeurs de filtres {string}")
    public void urlNeContientPasLesValeursDeFiltresFilter(String filter) {
        loginPage.GetNotCurrentUrl(filter);
    }





}