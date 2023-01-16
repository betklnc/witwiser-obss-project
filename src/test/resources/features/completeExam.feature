Feature: Complete exam in assigned session as succesfully

  Background:
    Given User logins to Witwiser system with witwises-admin and lLYVRayAHimpt9bJ
    When  User assigns session to user

  @assignsession
  Scenario: User completes assigning of test session
    Then  It's seen that user complete assigning session

  @completeexam
  Scenario: User completes assigning exam to her
    Given User navigate to Home page
    When  User starts and finish the exam answering the all questions
    Then  It's seen that user complete exam assigned


