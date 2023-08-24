Feature: Data Persistence
  Scenario: Add new Character to DataBase
    Given a new character
    When the character is persisted to the database
    Then the list of character grows