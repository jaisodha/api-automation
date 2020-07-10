Feature: Verify if a user is able to book, reschedule and cancel a ride
  Description: The purpose of this feature is to test that if a user has coupon & bookable slot then he should able to book a ride
  @booking
  Scenario: verify if user is able to book a ride using coupon
    Given A user call "POST" https request for "/v3/booking/create" with
     |               couponId               |            fromId                    |                    toId                  |
     | b27aae6d-66ca-4d49-b6c5-31bbc1689d54 | 5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4 | c8894713-07a8-4bb0-bb49-219f545bc377     |
    Then User should get successful response with message "Your ride has been confirmed"

  Scenario: verify if booking card is visible to user on home screen
    Given A user call "GET" https request for "/api/v3/home_cards" to fetch all cards
    Then User should get booking card if he has active booking

  Scenario: verify if user is able to reschedule his ride
    Given Given user call "GET" https request for "/v4/routes/combinedSlots" with below payload for reschedulable
      | fromLat           | fromLng           | toLat             |  toLng           |                fromLocId            |             toLocId                 | routeId |
      | 28.58368506583371 | 77.21241725488308 | 28.56636061941184 | 77.20755711353199| 5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4| c8894713-07a8-4bb0-bb49-219f545bc377| 4a2a0e8d-ee20-4cf8-9827-94e8f52c4af3|
    And User should get a bookable slot
    And If user call "POST" https request for "/v3/booking/create" with reschedule create booking call
      |               couponId               |            fromId                    |                    toId                  |
      | b27aae6d-66ca-4d49-b6c5-31bbc1689d54 | 5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4 | c8894713-07a8-4bb0-bb49-219f545bc377     |
    Then User should get successful response with message "Your ride has been confirmed" and parent booking status should be "POSTPONED"

  Scenario: verify if user is able to cancel his ride
    Given A user call "POST" https request for "/v3/booking/cancel" to cancel his ride
    Then User should get his bookingStatus as "CANCELLED"

