Feature: Perform the Get Operation

@Sanity
  Scenario: To Get the most viewed product list
    Given The base URI will be "http://localhost:8009/medicare/json/data/mv/products"
    When perfroming the Get operation
    Then The Responsecode is shown to be
