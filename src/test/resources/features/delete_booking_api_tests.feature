Feature: Delete an existing booking
  Create and delete booking in same scenario

  Scenario: Create and delete booking
    Given we have a valid request for create booking with following params as a Map and total price 999
      | firstName         | John    |
      | lastName          | Simpson |
      | depositPaid       | false   |
      | additionalNeeds   | Soda    |
      | checkInPlusDays   | 20      |
      | checkOutPlusDays  | 25      |

    When we send request to create booking API
    Then API Response should have HTTP Status code 200
    And create booking API response has valid booking ID

    When booking id has been saved in shared context
    And we send request to delete booking API

    Then API Response should have HTTP Status code 201