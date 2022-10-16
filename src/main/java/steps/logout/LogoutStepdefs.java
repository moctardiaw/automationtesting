package steps.logout;

import cucumber.api.java.en.And;
import pages.LoginPage;
public class LogoutStepdefs {

    LoginPage loginPage;
    @And("cliquer  sur le lien Logout")
    public void cliquerSurLeLienLogout() {
        loginPage.ClickLogoutLinkText();
    }
}
