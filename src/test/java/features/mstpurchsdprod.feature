Feature: Perform the get operation

  @Regression
  Scenario: To Get the most purchased product list
    Given The base URI added as "http://localhost:8009/medicare/json/data/mp/products"
    When I Perfrom The Get Operation
    Then The Responsecode Should be
