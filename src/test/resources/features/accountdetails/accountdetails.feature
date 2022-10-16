
  Feature: Tester les informations du compte
    @accountdetails
    Scenario Outline: Vérifier les informations du compte sont tous valides et le mot de passe de confirmation est le même que du nouveau mot de passe
      Given le navigateur '<navigator>' est ouvert
      And  je suis sur la home page
      And  cliquer sur le menu My Account
      When saisir un  '<email>' et un '<motdepasse>'
      And  cliquer  sur le bouton LOGIN
      Then Verifier que la page contient le message 'Hello'
      And cliquer sur le lien account details
      When entrer un '<nom>' et un '<prenom>'
      And saisir un '<motdepasseactuel>' et un '<motdepassenouveau>'
      And saisir le '<motdepasseconfirme>'
      And cliquer sur le bouton SAVE CHANGE
      Then Verifier que la page ne contient pas le message 'Error'

      Examples:
        |navigator|email|motdepasse|nom|prenom|motdepasseactuel|motdepassenouveau|motdepasseconfirme|
        |chrome|md.team4.reg12.success@yopmail.com|Te$t@2022&*4|HADJ|Abir|Te$t@2022&*4|F$R9a4r|F$R9a4r|
        |edge|md.team4.reg13.success@yopmail.com|Te$t@2022&*4|HADJ|Abir|Te$t@2022&*4|F$R9a4r|F$R9a4r|
        |firefox|md.team4.reg14.success@yopmail.com|Te$t@2022&*4|HADJ|Abir|Te$t@2022&*4|F$R9a4r|F$R9a4r|

    @accountdetailsencoursdedev
    Scenario Outline: Vérifier que le mot de passe actuel n'est pas valide
      Given le navigateur '<navigator>' est ouvert
      And  je suis sur la home page
      And  cliquer sur le menu My Account
      When saisir un  '<email>' et un '<motdepasse>'
      And  cliquer  sur le bouton LOGIN
      Then Verifier que la page contient le message 'Hello'
      And cliquer sur le lien account details
      And saisir un '<nom>' et un '<prenom>'
      And saisir un '<motdepasseactuel>' et un '<motdepassenouveau>'
      And saisir le '<motdepasseconfirme>'
      And cliquer sur le bouton SAVE CHANGE
      Then Verifier que la page ne contient pas le message 'Error'

      Examples:
        |navigator|email|motdepasse|nom|prenom|motdepasseactuel|motdepassenouveau|motdepasseconfirme|
        |chrome|md.team4.reg9.success@yopmail.com|Te$t@2022&*4|HADJ|Abir|Te$t@2022&*4|F$R9a4r|F$R9a4r|
        |edge|md.team4.reg9.success@yopmail.com|Te$t@2022&*4  |HADJ|Abir|Te$t@2022&*4|F$R9a4r|F$R9a4r|
        |firefox|md.team4.reg9.success@yopmail.com|Te$t@2022&*4|HADJ|Abir|Te$t@2022&*4|F$R9a4r|F$R9a4r|

    @accountdetailsencoursdedev
    Scenario Outline: Vérifier que le mot de passe actuel et le nouveau mot de passe sont valides mais le mot de passe de confirmation est différent du nouveau mot de passe
      Given le navigateur '<navigator>' est ouvert
      And  je suis sur la home page
      And  cliquer sur le menu My Account
      When saisir un  '<email>' et un '<motdepasse>'
      And  cliquer  sur le bouton LOGIN
      Then Verifier que la page contient le message 'Hello'
      And cliquer sur le lien account details
      And saisir un '<nom>' et un '<prenom>'
      And saisir un '<motdepasseactuel>' et un '<motdepassenouveau>'
      And saisir le '<motdepasseconfirme>'
      And cliquer sur le bouton SAVE CHANGE
      Then Verifier que la page ne contient pas le message 'Error'

      Examples:
        |navigator|email|motdepasse|nom|prenom|motdepasseactuel|motdepassenouveau|motdepasseconfirme|
        |chrome|md.team4.reg5.success@yopmail.com|Te$t@2022&*4|HADJ|Abir|Te$t@2022&*4|F$R9a4r|F$R9a4r|
        |edge|md.team4.reg5.success@yopmail.com|Te$t@2022&*4  |HADJ|Abir|Te$t@2022&*4|F$R9a4r|F$R9a4r|
        |firefox|md.team4.reg5.success@yopmail.com|Te$t@2022&*4|HADJ|Abir|Te$t@2022&*4|F$R9a4r|F$R9a4r|