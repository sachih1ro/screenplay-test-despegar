Feature: Search the cheapest plane ticket on the Despegar webpage
  I as a traveller
  Want to search the cheapest plane ticket
  To save money

  Scenario: Search the cheapest ticket for tomorrow on the Medellín - Santa Marta route
    Given Ana wants to search a ticket
    When Ana chooses the cheapest ticket
    Then Ana should watch the ticket payment gateway