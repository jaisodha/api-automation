Feature: Validating the app login flows
  Description: The purpose of this feature is to test the just login flow in the app
  @login
  Scenario Outline: verify if user is successfully able to generate the OTP
    Given Given user call "POST" https request for "/v3/auth/user/otp" with "<newDevice>" and "<phoneNumber>" and "<policyPerused>" body
    Then  I should see the success key value as "true" in the API response
    Examples:
      | newDevice | phoneNumber | policyPerused |
      |  true     | 9555814581  | true         |
      |  false    | 9555814581  | true          |

  Scenario Outline: verify if user is successfully login into the app with json validations
    Given Given user call "POST" https request for "/v3/auth/user" with '<loginType>' and '<newDevice>' and '<newUser>' and '<otp>' and '<phoneNumber>' and '<policyPerused>' body
    Examples:
     | loginType | newDevice | newUser| otp | phoneNumber | policyPerused |
     | SHUTTL    |  true     | true   | 1337| 9555814581  | true          |
     | SHUTTL    |  false    | true   | 1337| 9555814581  | true          |

 @signup
 Scenario Outline: verify if user is successfully registered himself in the shuttl app
   Given user call "POST" https request for "/v3/auth/confirmRegister" with '<email>' and '<gender>' and '<homeLat>' and '<homeLng>' and '<homeLocation>' and '<name>' and '<workLat>' and '<workLng>' and '<workLocation>'
   Then I should see the success key value as "true" in the API response
   Examples:
     | email | gender | homeLat| homeLng | homeLocation | name | workLat | workLng| workLocation |
     | jaisinghsodha27@gmail.com|MALE|28.630950927734375|77.21727752685547|Dwarka+Sector+21+metro+station%2C+New+Delhi%2C+Delhi|jai singh sodha|28.4118006|77.0419318|CD+Chowk%2C+Sector+48%2C+Gurugram%2C+Haryana+122004%2C+India|
