Feature: Verify Product Category

  @Sanity
  Scenario Outline: Get category details
    Given The base url "localhost:8009"
    When I hit the endpoint "http://localhost:8009/medicare/json/data/category/1/products"
    Then I get 2 products
    And validate the count
    Then I validate the "<name>" "<brand>" <id> following

    Examples: 
      | name        |  | brand |  | id |
      | Combiflame  |  | Cipla |  |  1 |
      | Paracetamol |  | Cipla |  |  2 |

 