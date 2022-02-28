Feature: Asset Location Creation Endpoint
    As an asset owner, I want an asset location creation endpoint, so that I can track the location of my endpoints.

    Scenario: A new asset gets added fine
        Given I have some valid asset location JSON
        When I post the JSON to the asset location creation endpoint
        Then I should receive a 200 status code response
        And the returned JSON should include a generated asset location id