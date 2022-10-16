@panier
Feature: Ajout d'articles au panier
  @increment @passant
  Scenario Outline: Verifier l'incrementation du nombre d'articles dans le panier
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    When cliquer le menu shop
    And cliquer sur lien '<categorie>'
    And choisir un produit '<productid>' en  cliquant sur ADD TO BASKET
    And cliquer sur View Basket
    And cliquer sur l'icone du panier
    Then le nombre de produits presents dans le panier doit etre doit etre egale au nombre '<increment>' attendu


    Examples:
      |navigator|increment|productid|categorie |
      |chrome   |1 Item   |182      |HTML      |
      |edge     |1 Item   |182      |HTML      |
      |firefox  |1 Item   |182      |HTML      |
      |chrome   |1 Item   |180      |JavaScript|
      |edge     |1 Item   |180      |JavaScript|
      |firefox  |1 Item   |180      |JavaScript|
      |chrome   |1 Item   |165      |JavaScript|
      |edge     |1 Item   |165      |JavaScript|
      |firefox  |1 Item   |165      |JavaScript|
      |chrome   |1 Item   |160      |selenium  |
      |edge     |1 Item   |160      |selenium  |
      |firefox  |1 Item   |160      |selenium  |


  @decrement @passant
  Scenario Outline: Verifier la décrementation du nombre d'articles dans le panier
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    When cliquer le menu shop
    And cliquer sur lien '<categorie>'
    And choisir un produit '<productid>' en  cliquant sur ADD TO BASKET
    And cliquer sur View Basket
    And cliquer sur l'icone du panier
    And cliquer sur la croix pour supprimer l'article
    Then Verifier que la page contient le message 'removed'
    And cliquer sur l'icone du panier
    And le nombre de produits presents dans le panier doit etre doit etre egale au nombre '<increment>' attendu


    Examples:
      |navigator|increment|productid|categorie |
      |chrome   |0 Items   |182      |HTML      |
      |edge     |0 Items   |182      |HTML      |
      |firefox  |0 Items   |182      |HTML      |
      |chrome   |0 Items   |180      |JavaScript|
      |edge     |0 Items   |180      |JavaScript|
      |firefox  |0 Items   |180      |JavaScript|
      |chrome   |0 Items   |165      |JavaScript|
      |edge     |0 Items   |165      |JavaScript|
      |firefox  |0 Items   |165      |JavaScript|
      |chrome   |0 Items   |160      |selenium  |
      |edge     |0 Items   |160      |selenium  |
      |firefox  |0 Items   |160      |selenium  |