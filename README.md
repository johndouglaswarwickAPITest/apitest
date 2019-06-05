Test Instructions
-----------------

To run the test (all scenarios) use the following command

-Dtest=Runner test


Test Explained
--------------

I use the cucumber framework with 3 scenarios

Scenario 1 - retrieves an object from the rest call (GET) api = posts/1

Scenario 2 - POSTs and inspects the resulting result

Scenraio 3 - Negatively tests the API with malformed JSON


Observed Results
----------------
Scenario 1 passes

Scenario 2 fails - This is because the resulting result only contains "id" in the JSON response

Scenario 3 fails - This is because the error reported does not reflect the error expected ( there should be a invalid JSON error )


Notes
-----
I could of continued for x amount of time to test all of the endpoints/apis - with negative and positive testing.

As instructed I have taken 1 hour to create the framework project and the tests in it.


Cucumber Report
---------------
The HTML cucumber report sits in build/report/html folder in the project. Simply launch the file index.html in chrome (or any other browser).


