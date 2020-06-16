Feature: Validating the app login flows
  Description: The purpose of this feature is to test the just login flow in the app
  @login
  Scenario Outline: verify if user is successfully able to generate the OTP
    Given Given user call "POST" https request for "/v3/auth/user/otp" with "<newDevice>" and "<phoneNumber>" and "<policyPerused>" body
    Then  I should see the success key value as "true" in the API response
    Examples:
      | newDevice | phoneNumber | policyPerused |
      |  true     | 9555814581  | true         |
      |  false    | 9999954851  | true          |

  Scenario Outline: verify if user is successfully login into the app with json validations
    Given Given user call "POST" https request for "/v3/auth/user" with '<loginType>' and '<newDevice>' and '<newUser>' and '<otp>' and '<phoneNumber>' and '<policyPerused>' body
    Then I should see the session token in response with json validations
    Examples:
     | loginType | newDevice | newUser| otp | phoneNumber | policyPerused |
     | SHUTTL    |  true     | true   | 1337| 9555814581  | true          |
     | SHUTTL    |  false    | true   | 1337| 9999954851  | true          |