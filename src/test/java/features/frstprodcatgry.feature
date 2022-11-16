Feature: performed the get operations

  @Sanity
  Scenario: To Get the frist product category list
    Given The base URI is shown as "http://localhost:8009/medicare/json/data/category"
    When I perfromed the Get Operation
    Then The ResponseCode will be shown as
