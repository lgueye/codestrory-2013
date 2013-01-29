Jajascript stories

Meta:
@refs jajascript
@progress done

Narrative:
When the server is provided a payload
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

Scenario: the server should be able to provide the most optimized solution 2
When the server is asked the provided the payload:
| vol                       | depart | duree | prix |
| dark-playwright-49        | 0      | 5     | 17   |
| swift-whirlwind-45        | 2      | 2     | 15   |
| curious-toupee-34         | 0      | 4     | 2    |
| wide-eyed-workaholic-58   | 3      | 1     | 8    |
| shy-vengeance-31          | 3      | 14    | 4    |
| long-alcohol-70           | 6      | 8     | 24   |
| sleepy-squabble-79        | 6      | 2     | 5    |
| chubby-madwoman-24        | 7      | 5     | 1    |
| eager-arsonist-2          | 7      | 9     | 6    |
| tender-knitter-21         | 7      | 15    | 5    |
| Early-hailstorm-74        | 10     | 10    | 21   |
| modern-lava-64            | 14     | 9     | 21   |
| great-bather-46           | 14     | 6     | 6    |
| hollow-slumlord-84        | 11     | 4     | 12   |
| round-tombstone-50        | 14     | 3     | 4    |
| silent-shotgun-20         | 17     | 9     | 2    |
| obedient-squirrel-22      | 19     | 3     | 6    |
| bad-developer-97          | 19     | 2     | 5    |
| dead-bead-29              | 19     | 10    | 7    |
| repulsive-saltwater-80    | 16     | 11    | 3    |
| quick-blackjack-8         | 22     | 8     | 23   |
| harsh-sword-34            | 23     | 1     | 23   |
| joyous-yodeler-88         | 21     | 3     | 8    |
| clever-weakling-38        | 20     | 7     | 7    |
| condemned-minion-8        | 20     | 12    | 1    |
| big-grail-71              | 28     | 10    | 4    |
| stupid-reformer-69        | 29     | 3     | 12   |
| tender-quagmire-69        | 29     | 8     | 4    |
| modern-corn-95            | 29     | 3     | 6    |
| puny-judo-34              | 27     | 1     | 2    |
| blue-eyed-fishnet-70      | 32     | 4     | 22   |
| breakable-switchhitter-68 | 30     | 10    | 15   |
| young-revolutionary-2     | 30     | 7     | 10   |
| open-fowl-8               | 31     | 5     | 10   |
| important-temper-21       | 31     | 3     | 7    |
| homeless-warship-63       | 39     | 8     | 16   |
| bad-instep-1              | 36     | 8     | 21   |
| hushed-fencer-85          | 37     | 1     | 8    |
| brainy-stereo-9           | 35     | 1     | 11   |
| modern-oak-72             | 38     | 11    | 2    |
| defeated-plaster-4        | 41     | 3     | 14   |
| jittery-letter-36         | 43     | 3     | 5    |
| weary-bonbon-33           | 40     | 9     | 1    |
| doubtful-jawbone-8        | 43     | 6     | 10   |
| repulsive-teacup-84       | 43     | 2     | 1    |
Then the response should be:
| code | body |
| 200  | {"path":["dark-playwright-49","long-alcohol-70","modern-lava-64","harsh-sword-34","stupid-reformer-69","puny-judo-34","blue-eyed-fishnet-70","homeless-warship-63","hushed-fencer-85"],"gain":145} |
