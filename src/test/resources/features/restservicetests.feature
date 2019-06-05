Feature: REST Testing

  Scenario: As a user I would like to post various queries to test a HTTP/HTTPS web service

    Given I use the api "posts/1"
    When I Get the response
    Then The response is equal to json response

    Scenario: As A user I would like to test that I can create and store data using the api
      Given I use the end point "posts"
      When I post the data
      Then I can retrieve the object just created

      Scenario: As A user I would like to Negative test a post with malformed JSON
        Given I use the endpoint "posts"
        When I use malformed JSON
        Then I should receive an error