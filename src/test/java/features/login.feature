Feature: Validating the app login flows

Scenario Outline: verify if user is successfully login into the app with json validations
Given Given user call "POST" https request for "/v3/auth/user" with '<loginType>' and '<newDevice>' and '<newUser>' and '<otp>' and '<phoneNumber>' and '<policyPerused>' body
Then I should see the session token in response with json validations
  Examples:
    | loginType | newDevice | newUser| otp | phoneNumber | policyPerused |
    | SHUTTL    |  true     | true   | 1337| 9555814581  | true          |
    | SHUTTL    |  false    | true   | 1237| 7406634660  | true          |