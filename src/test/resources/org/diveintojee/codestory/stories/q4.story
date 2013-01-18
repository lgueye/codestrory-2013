Q4 stories

Meta:
@refs q4
@progress done

Narrative:
Given my server is ready
When I'm asked the second question
Then I should be able to answer correctly to that question

Scenario: the server should answer to the new question
When the server is asked the question "Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)"
Then the response code should be:
| code | body                          | requiredType |
| 200  | OUI                           | text/plain   |

