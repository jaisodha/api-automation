Feature: Validate the user profile details & profile update scenarios

  @profile
  Scenario: verify if user is able to view his profile
    Given User call "GET" https request for "/v3/user/metadata" to get is profile details
    Then  User should see the success key value as "true" in the API response along with below details
    |                     Home address               |                     Work address                   |         email           |    name          |     referId   |
    |Dwarka Sector 21 metro station, New Delhi, Delhi|CD Chowk, Sector 48, Gurugram, Haryana 122004, India|jaisinghsodha27@gmail.com| jai singh sodha  |+919555814581  |

  Scenario: verify if user is able to update his profile
    Given User call "POST" https request for "/v3/user/info" to update his profile with below details
    |  gender  |       name        |
    |   MALE   | jai singh sodha   |
    Then  User should see the success key value as "true" in the API response

