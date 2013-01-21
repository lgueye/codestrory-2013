Scalaskel stories

Meta:
@refs skalaskel1
@progress wip

Narrative:
Given my server is ready
When It's asked a skalaskel change
It should be able to provide the correct change

Scenario: the server should be able to read the subject
When the server is asked the skalaskel change for value "1"
Then the response should be:
| code | body        |
| 200  | [{"foo":1}] |

