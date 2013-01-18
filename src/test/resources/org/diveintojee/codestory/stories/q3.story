Q3 stories

Meta:
@refs q3
@progress done

Narrative:
Given my server is ready
When I'm asked the second question
Then I should be able to answer correctly to that question

Scenario: the server should answer to the new question
When the server is asked the question "Es tu abonne a la mailing list(OUI/NON)"
Then the response code should be:
| code | body                          | requiredType |
| 200  | OUI                           | text/plain   |

