Feature: Search the cheapest plane ticket and accommodation on the Despegar webpage
  I as a traveller
  Want to search the cheapest plane ticket and accommodation
  To save money

  Scenario: Search the cheapest ticket for tomorrow on the Medellín - Santa Marta route
    Given Ana wants to search a ticket from Medellin to Cartagena
    When Ana chooses the cheapest ticket
    Then Ana should watch the ticket payment gateway

  Scenario: Find the cheapest accommodation for tomorrow and the day after in Santa Marta
    Given Ana wants to search accommodation in Cartagena
    When Ana chooses the cheapest accommodation
    Then Ana should watch the accommodation payment gateway