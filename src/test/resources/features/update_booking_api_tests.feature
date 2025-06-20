@update-booking
Feature: Update an existing booking

  Create and update booking in same scenario

  Scenario: Create a new booking and update the additional needs and price
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
    And we prepare a request for update booking API
      | firstName         | John          |
      | lastName          | Simpson       |
      | depositPaid       | true          |
      | additionalNeeds   | Mineral Water |
      | checkInPlusDays   | 20            |
      | checkOutPlusDays  | 25            |
      | totalPrice        | 1000          |
    And   we send request to update booking API
    Then  API Response should have HTTP Status code 200