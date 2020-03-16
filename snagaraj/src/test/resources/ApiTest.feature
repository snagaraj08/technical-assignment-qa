Feature:

  @apitest
  Scenario: Get random user and print the emailId
    Given I have a random user
    Given I perform a GET request "/users?id=" for endpoint
    Then I display the emailId

  @apitest
  Scenario: Get all the posts for the earlier random user
    Given I perform a GET request "/posts?userId=" to list all posts
    Then validate the post Ids

  @apitest
  Scenario: Perform a POST request for the earlier random user
    Given I perform a POST request with title and body
    Then I verify the responseCode