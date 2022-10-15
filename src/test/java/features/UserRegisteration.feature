Feature: User Registeration
    I want to check that the user can register in our e-commerce website
    
  Scenario Outline: User Registeration
  Given the user in the home page
  When I click on register link
  And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
  Then the registeration page displayed successfully
  
  Examples: 
  | firstname | lastname | email | password |
  | Ahmed | Mohamed | shdssdshd@gmail.com | 123456 |
  | Moatz| Ahmed | testsdsss@gmail.com | 12345678 |	