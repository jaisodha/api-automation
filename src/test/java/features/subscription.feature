Feature: Validating the subscription related flows
  Description: The purpose of this feature is to test the pass listings and pass purchase/renew/cancel flow
  @pass
  Scenario: Verify if user is able to see all the available offerings on the app
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
      |  10 Rides    |

  Scenario: Verify if user is able to see all the details related to particular offering
    Given Given user call "GET" https request for "/api/v2/subscriptions/4694105b-e0f8-476c-a6ea-4d6e5414331c" with origin and destination stop
      | origin_stop_id                       | destination_stop_id                  |
      | c8894713-07a8-4bb0-bb49-219f545bc377 | 5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4 |

    Then  I should see the subscription details in the API response as below
      |             cta       | amount | rides_count | validity_days |               from_stop              |               to_stop               |
      | CONTINUE TO PAY ₹1180 | 1180.0 |  10         |   30          | c8894713-07a8-4bb0-bb49-219f545bc377 |5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4 |


  Scenario: Verify if user is able to purchase a shuttl pass
    Given Given user call "POST" https request for "/v4/subPlan/buySubscriptionPaymentMethods" for selected subscription
      | fromId                               |           subscriptionId             | toId                                 | twoWay |
      | c8894713-07a8-4bb0-bb49-219f545bc377 | 4694105b-e0f8-476c-a6ea-4d6e5414331c | 5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4 | false  |

    When User call "GET" https request for "/v3/wallet/balance" for shuttl wallet
      |         wallet        |
      |     SHUTTL_WALLET     |

    And  User call "POST" https request for "/v4/subPlan/buy" with body
      |bookType |deductShuttlCashback|email                    |              fromId                |onlyAddOn|paymentViaShuttlWallet|selectTimeEnabled|          subscriptionId            |                toId                |twoWay|userFromLat|userFromLng|userFromName|userToLat|userToLng|          userToName                |    wallet    |
      |SELF_BOOK|      true          |jaisinghsodha27@gmail.com|c8894713-07a8-4bb0-bb49-219f545bc377|  false  |     1180.0           |     false       |4694105b-e0f8-476c-a6ea-4d6e5414331c|5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4| true |   0.0     |    0.0    | SF Airport |   0.0   |  0.0    |5752b57f-fd85-4c3a-9f67-6b1f30e2e7d4| SHUTTL_WALLET|

    Then I should see the message "Successfully Purchased Shuttl Pass" in response

  Scenario: Verify if user is able to see his purchased offering on the app
    Given User call "GET" https request for "/api/v2/user_subscriptions"
    Given User call "GET" https request for "/api/v2/user_subscriptions/" with userSubscription

    Then  I should see the userSubscription details as below in API response
      |     cta    | from_stop  | to_stop    |             sub_cta                 | applicability | renewable | state  |             subscription_id        | RIDES REMAINING |
      | RENEW PASS | SFHospital | SF Airport | Carry forward your remaining rides  |   TWO_WAY     |   true    | ACTIVE |4694105b-e0f8-476c-a6ea-4d6e5414331c|  <h> 10</h>/10  |

  Scenario: Verify if user is able to cancel his purchased pass
    Given User call "GET" https request for "/v3/sub/getRefundCategories" with query params as userSubscription
    Given User call "Post" https request for "/v3/sub/refundSubscription" with userSubscription & reasonid
    Then I should see the refund success message "The refund amount has been transferred to your wallet/account that was used for the transaction." in response