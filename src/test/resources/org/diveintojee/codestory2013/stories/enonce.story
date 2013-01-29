Enonce stories

Meta:
@refs enonce
@progress done

Narrative:
When It's provided a subject
It should be able to read the subject

Scenario: the server should be able to read the subject
When the server is provided with subject "content", id "1" and media type "text/plain"
Then the response should be:
| code | body    |
| 200  | content |

Scenario: the server should be able to read the subject
When the server is provided with subject "content", id "1" and media type "text/*"
Then the response should be:
| code | body    |
| 200  | content |

Scenario: the server should be able to read the subject
When the server is provided with subject "content", id "1" and media type "text/x-markdown"
Then the response should be:
| code | body    |
| 200  | content |
