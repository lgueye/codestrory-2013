Scalaskel stories

Meta:
@refs skalaskel
@progress done

Narrative:
When the server is asked a scalaskel change
It should provide the correct change

Scenario: the server should provide the correct change for value "1"
When the server is asked the scalaskel change for value "1"
Then the response should be:
| code | body        |
| 200  | [{"foo":1}] |

