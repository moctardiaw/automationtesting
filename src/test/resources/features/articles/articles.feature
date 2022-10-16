@articles
Feature: Consultation de la liste des articles
  @nombretotal @passant
  Scenario Outline: Verifier que le nombre de produits affiches est coherent
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    When cliquer le menu shop
    Then le nombre de produits affiches doit etre doit etre egale au '<nombretotal>' attendu

    Examples:
      |navigator|nombretotal|
      |chrome   | 8         |
      |edge     | 8         |
      |firefox  | 8         |

  @nombretotalparcategorie @passant
  Scenario Outline: Verifier que le nombre de produits affiches par categorie est coherent
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    When cliquer le menu shop
    And cliquer sur lien '<categorie>'
    Then le nombre de produits affiches doit etre doit etre egale au '<nombretotal>' attendu

    Examples:
      |navigator|categorie |nombretotal|
      |chrome   |Android   |1          |
      |chrome   |HTML      |3          |
      |chrome   |JavaScript|3          |
      |chrome   |selenium  |1          |
      |edge     |Android   |1          |
      |edge     |HTML      |3          |
      |edge     |JavaScript|3          |
      |edge     |selenium  |1          |
      |firefox  |Android   |1          |
      |firefox  |HTML      |3          |
      |firefox  |JavaScript|3          |
      |firefox  |selenium  |1          |

  @nombretotalfiltre @passant
  Scenario Outline: Verifier que le prix des  produits affiches entre bien dans l'intervalle définit par le filtre
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    When cliquer le menu shop
    And filtrer par prix '<minimumoffset>' et '<maximunoffset>'
    And cliquer sur le bouton FILTER
    Then url contient les valeurs de filtres '<filter>'

    Examples:
      |navigator|minimumoffset|maximunoffset|filter                      |
      |firefox  |100          |-100         |?min_price=278&max_price=390|
      |edge     |100          |-100         |?min_price=278&max_price=390|
      |chrome   |100          |-100         |?min_price=278&max_price=390|

  @nombretotalfiltre @nonpassant
  Scenario Outline: Verifier que le prix des  produits affiches ne sont pas dans l'intervalle définit par le filtre
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    When cliquer le menu shop
    And filtrer par prix '<minimumoffset>' et '<maximunoffset>'
    And cliquer sur le bouton FILTER
    Then url ne contient pas les valeurs de filtres '<filter>'

    Examples:
      |navigator|minimumoffset|maximunoffset|filter                      |
      |firefox  |100          |-100         |?min_price=150&max_price=500|
      |edge     |100          |-100         |?min_price=150&max_price=500|
      |chrome   |100          |-100         |?min_price=150&max_price=500|

  @nombretotal @nonpassant
  Scenario Outline: Verifier que le nombre de produits affiches n'est pas coherent
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    When cliquer le menu shop
    Then le nombre de produits affiches ne doit pas etre egale au '<nombretotal>' attendu

    Examples:
      |navigator|nombretotal|
      |chrome   | 6         |
      |edge     | 4         |
      |firefox  | 2         |

  @nombretotalparcategorie @nonpassant
  Scenario Outline: Verifier que le nombre de produits affiches par categorie n'est pas coherent
    Given le navigateur '<navigator>' est ouvert
    And  je suis sur la home page
    When cliquer le menu shop
    And cliquer sur lien '<categorie>'
    Then le nombre de produits affiches ne doit pas etre egale au '<nombretotal>' attendu

    Examples:
      |navigator|categorie |nombretotal|
      |chrome   |Android   |8          |
      |chrome   |HTML      |4          |
      |chrome   |JavaScript|7          |
      |chrome   |selenium  |10         |
      |edge     |Android   |8          |
      |edge     |HTML      |4          |
      |edge     |JavaScript|0          |
      |edge     |selenium  |4          |
      |firefox  |Android   |5          |
      |firefox  |HTML      |9          |
      |firefox  |JavaScript|4          |
      |firefox  |selenium  |0          |
