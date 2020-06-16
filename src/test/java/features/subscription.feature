Feature: Validating the subscription related flows
  Description: The purpose of this feature is to test the pass listings and pass purchase/renew/cancel flow

  @pass
  Scenario: verify if user is able to see the offerings in the app
    Given Given user call "GET" https request for "/api/v2/subscriptions" with origin and destination stop
      | origin_stop_id                       | destination_stop_id                  |
      | c8894713-07a8-4bb0-bb49-219f545bc377 | 5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4 |

    Then  I should see the all given subscription in the API response
      |   title      |
      | Monthly Pass |
      |  90 Rides    |
      |  30 Rides    |
      |  45 Rides    |
      |  15 Rides    |
      |  1 Rides    |