Feature: Validating the route search results
  Description: The purpose of this feature is to test the route and timeSlots
  @route
  Scenario: verify if user is able to get the timeslots
    Given Given user call "GET" https request for "/v4/routes/combinedSlots" with
      | fromLat           | fromLng           | toLat             |  toLng   |
      | 28.58368506583371 | 77.21241725488308 | 28.56636061941184 | 77.20755711353199 |
      | 28.58368506583371 | 77.21241725488308 | 28.56636061941184 | 77.20755711353199 |

    Then  I should see the success key value as "true" in the API response
    And I should see my pickup point as "SF Airport" and drop point as "SFHospital"
    And If I have any slot operational "true" then I should see slotType "BOOKABLE".
    And user should be having "SUBSCRIPTION" with coupon code as "EIIYKCQUZN".