Q1 stories

Meta:
@refs 1
@progress wip

Narrative:
Given my server is ready
When I'm asked the first question
Then I should be able to answer correctly to that question

Scenario: the server should answer to the new question
When the server is asked the question "Quelle est ton adresse email"
Then the response code should be:
| code | body                          | requiredType |
| 200  | louis.gueye@gmail.com         | text/plain   |

