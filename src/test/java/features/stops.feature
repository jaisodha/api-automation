Feature: Validating the stop search results
  Description: The purpose of this feature is to test the stop results and place preferences
  @stop
  Scenario: Verify if the place preference values for bing & google
    Given User call "GET" https request for "/shuttl/places_preference" call
    Then If search provider name is "GOOGLE" then triggered value should be "10"

  Scenario: Verify if user is able to see the desired stops
    Given User call "GET" https request for "/v2/routes/search" with String "sfai" and type as "FROM"
    Then Results should contain "SFHospital" and "SF Airport"