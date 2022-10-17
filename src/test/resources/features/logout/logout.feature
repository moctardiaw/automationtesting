@test
Feature: Tester la fonctionnalité de logout
  @logout @TEST_TEAM4-47 @Team4TNR
  Scenario Outline: Vérifier que la déconnexion est réussie après être connecté
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    And  cliquer sur le menu My Account
    When saisir un  '<email>' et un '<motdepasse>'
    And  cliquer  sur le bouton LOGIN
    And  cliquer  sur le lien Logout
    Then Verifier que la page contient le message 'Hello'

    Examples:
      |navigator|email|motdepasse|
      |chrome|md.team4.success@yopmail.com     |Te$t@2022&*4        |
      |edge|md.team4.success@yopmail.com     |Te$t@2022&*4        |
      |firefox|md.team4.success@yopmail.com     |Te$t@2022&*4        |