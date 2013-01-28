Scalaskel stories

Meta:
@refs jajascript
@progress wip

Narrative:
Given my server is ready
When It's provided a payload
It should be able to provide the most optimized solution

Scenario: the server should be able to provide the most optimized solution
When the server is asked the provided the payload:
| vol      | depart | duree | prix |
| MONAD42  | 0      | 5     | 10   |
| META18   | 3      | 7     | 14   |
| LEGACY01 | 5      | 9     | 8    |
| YAGNI17  | 5      | 9     | 7    |

Then the response should be:
| code | body                                           |
| 200  | {"gain" : 18, "path" : ["MONAD42","LEGACY01"]} |

