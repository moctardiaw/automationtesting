@REQ_TEAM4-2
Feature: Authentification d’un client
  @TEST_TEAM4-21 @Team4
  #Scenario: Connexion : Login valide et MDP valide
  Scenario Outline: Vérifier que la connexion est réussie avec un email valide et un mot de passe valide
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    And  cliquer sur le menu My Account
    When saisir un  '<email>' et un '<motdepasse>'
    And  cliquer  sur le bouton LOGIN
    Then Verifier que la page contient le message 'Hello'

    Examples:
      |navigator|email|motdepasse|
      |chrome|md.team4.success@yopmail.com     |Te$t@2022&*4        |
      |edge|md.team4.success@yopmail.com     |Te$t@2022&*4        |
      |firefox|md.team4.success@yopmail.com     |Te$t@2022&*4        |

  @recette
  Scenario Outline: Vérifier que la connexion échoue avec un email invalide et un mot de passe invalide
      Given le navigateur '<navigator>' est ouvert
      And  je suis sur la home page
      And  cliquer sur le menu My Account
      When saisir un  '<email>' et un '<motdepasse>'
      And  cliquer  sur le bouton LOGIN
      Then Verifier que la page contient  le message 'Error: the password you entered for the username'

    Examples:
      |navigator|email|motdepasse|
      |chrome|md.team4.failed@yopmail.com     |Te$t@2022        |
      |edge|md.team4.failed@yopmail.com     |Te$t@2022        |
      |firefox|md.team4.failed@yopmail.com     |Te$t@2022        |
  @recette
  Scenario Outline: Vérifier que la connexion est échoue avec un email valide et un mot de passe vide
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    And  cliquer sur le menu My Account
    When saisir un  '<email>' et un '<motdepasse>'
    And  cliquer  sur le bouton LOGIN
    Then Verifier que la page contient le message 'Error: Password is required.'

    Examples:
      |navigator|email|motdepasse|
      |chrome|md.team4.success@yopmail.com     |        |
      |edge|md.team4.success@yopmail.com     |       |
      |firefox|md.team4.success@yopmail.com     |        |

  @recette
  Scenario Outline: Vérifier que la connexion est échoue avec un email vide et un mot de passe valide
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    And  cliquer sur le menu My Account
    When saisir un  '<email>' et un '<motdepasse>'
    And  cliquer  sur le bouton LOGIN
    Then Verifier que la page contient le message 'Error: Username is required.'

    Examples:
      |navigator|email|motdepasse|
      |chrome|     |Te$t@2022        |
      |edge|     |Te$t@2022       |
      |firefox|     |Te$t@2022        |

  @recette
  Scenario Outline: Vérifier que la connexion est échoue avec un email vide et un mot de passe vide
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    And  cliquer sur le menu My Account
    When saisir un  '<email>' et un '<motdepasse>'
    And  cliquer  sur le bouton LOGIN
    Then Verifier que la page contient le message 'Username is required.'

    Examples:
      |navigator|email|motdepasse|
      |chrome|    |        |
      |edge|     |       |
      |firefox|    |        |

    @totest
  Scenario Outline: Vérifier que la connexion est réussie avec un email valide et un mot de passe valide avec la présence des liens Dashboard, Orders, Downloads, Addresses, Account Details
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    And  cliquer sur le menu My Account
    When saisir un  '<email>' et un '<motdepasse>'
    And  cliquer  sur le bouton LOGIN
    Then Verifier que la page contient le message 'Hello'
      And Verifier la presence des liens

    Examples:
      |navigator|email|motdepasse|
      |chrome|md.team4.success@yopmail.com     |Te$t@2022&*4        |
      |edge|md.team4.success@yopmail.com     |Te$t@2022&*4        |
      |firefox|md.team4.success@yopmail.com     |Te$t@2022&*4        |