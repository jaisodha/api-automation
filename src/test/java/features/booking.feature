Feature: Verify if a user is able to book a ride
  Description: The purpose of this feature is to test that if a user has coupon & bookable slot then he should able to book a ride
  @booking
  Scenario: verify if user is able to book a ride using coupon
    Given A user call "POST" https request for "/v3/booking/create" with
     |               couponId               |            fromId                    |                    toId                  |
     | b27aae6d-66ca-4d49-b6c5-31bbc1689d54 | 5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4 | c8894713-07a8-4bb0-bb49-219f545bc377     |
    Then User should get successful response with message "Your ride has been confirmed"
