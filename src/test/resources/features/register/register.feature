@register
Feature: Création de compte client
  @integration
  Scenario Outline: Vérifier que l'enregistrement est réussie avec un email valide et un mot de passe valide
    Given le navigateur choisi '<navigator>' est ouvert
    And  etre sur la home page
    And  cliquer sur le menu MyAccount
    When entrer un  '<email>' et un '<motdepasse>'
    And  cliquer  sur le bouton REGISTER
    Then Verifier que la page actuelle contient le message 'Hello'

    Examples:
      |navigator|email|motdepasse|
      |chrome|md.team4.reg29.success@yopmail.com|Te$t@2022&*4b|
      |edge|md.team4.reg30.success@yopmail.com|Te$t@2022&*4b|
      |firefox|md.team4.reg31.success@yopmail.com|Te$t@2022&*4b|

  @integration
  Scenario Outline: Vérifier que l'enregistrement echoue avec un email valide et un mot de passe non valide
    Given le navigateur choisi '<navigator>' est ouvert
    And  etre sur la home page
    And  cliquer sur le menu MyAccount
    When entrer un  '<email>' et un '<motdepasse>'
    And  cliquer  sur le bouton REGISTER
    Then Verifier que la page actuelle contient le message 'Error'

    Examples:
      |navigator|email|motdepasse|
      |chrome|md.team4.reg32.success@yopmail.com|Te$t@|
      |edge|md.team4.reg33.success@yopmail.com|Te$t@|
      |firefox|md.team4.reg34.success@yopmail.com|Te$t@|