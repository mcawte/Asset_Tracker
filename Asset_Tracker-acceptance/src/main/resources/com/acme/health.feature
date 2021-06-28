Feature: Health
  As an api developer, I want a health endpoint, so my api can report its health

  Scenario: The Api is healthy
    Given I have a health endpoint
    When I request its health
    Then I should receive a 200 response
