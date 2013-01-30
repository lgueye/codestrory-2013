Jajascript stories

Meta:
@refs jajascript
@progress done

Narrative:
When the server is provided a payload
It should be able to provide the most optimized solution

Scenario: the server should be able to provide the most optimize
When the server is asked the provided the payload:
| vol      | depart | duree | prix |
| MONAD42  | 0      | 5     | 10   |
| META18   | 3      | 7     | 14   |
| LEGACY01 | 5      | 9     | 8    |
| YAGNI17  | 5      | 9     | 7    |
Then the response should be:
| code | body                                      |
| 200  | {"path":["MONAD42","LEGACY01"],"gain":18} |

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
| 200  | {"gain":145,"path":["dark-playwright-49","long-alcohol-70","modern-lava-64","harsh-sword-34","puny-judo-34","stupid-reformer-69","blue-eyed-fishnet-70","hushed-fencer-85","homeless-warship-63"]} |

Scenario: the server should be able to provide the most optimized solution
When the server is asked the provided the payload:
| vol                          | depart | duree | prix |
| funny-bandana-20             | 3      | 3     | 25   |
| super-bumblebee-89           | 0      | 7     | 21   |
| poor-azimuth-8               | 4      | 4     | 3    |
| resonant-gallbladder-57      | 1      | 3     | 12   |
| moaning-theater-63           | 2      | 8     | 6    |
| uninterested-sedation-26     | 8      | 10    | 2    |
| jolly-terrapin-3             | 7      | 2     | 6    |
| clumsy-wardroom-99           | 5      | 1     | 6    |
| kind-condo-18                | 6      | 1     | 10   |
| deep-quintuple-37            | 9      | 13    | 7    |
| tiny-yearbook-36             | 11     | 9     | 13   |
| thoughtless-milkshake-86     | 12     | 9     | 12   |
| spotless-weather-79          | 12     | 8     | 1    |
| wicked-leader-97             | 13     | 10    | 7    |
| hilarious-electrician-26     | 12     | 5     | 5    |
| dead-chimp-63                | 18     | 2     | 23   |
| short-cockatoo-52            | 15     | 9     | 6    |
| cloudy-turf-17               | 17     | 3     | 10   |
| helpless-warhead-25          | 15     | 4     | 13   |
| plain-bum-43                 | 18     | 9     | 7    |
| motionless-maggot-34         | 22     | 4     | 10   |
| old-fashioned-spoon-38       | 24     | 3     | 5    |
| clumsy-kidnapper-79          | 21     | 5     | 1    |
| terrible-frisbee-62          | 24     | 10    | 12   |
| odd-sheepskin-2              | 24     | 6     | 7    |
| important-confetti-64        | 25     | 2     | 2    |
| homely-salamander-19         | 26     | 5     | 16   |
| short-copperhead-18          | 27     | 10    | 2    |
| silly-gynecologist-70        | 29     | 1     | 6    |
| miniature-metropolis-42      | 29     | 9     | 2    |
| elated-appliance-11          | 32     | 7     | 12   |
| quaint-opulence-56           | 30     | 1     | 11   |
| glorious-sport-63            | 31     | 6     | 7    |
| screeching-ibex-1            | 34     | 8     | 12   |
| nutty-strapless-98           | 31     | 20    | 5    |
| distinct-number-79           | 39     | 8     | 8    |
| good-insignia-26             | 39     | 8     | 20   |
| blue-viewer-87               | 38     | 10    | 3    |
| busy-mall-67                 | 35     | 2     | 15   |
| combative-hazel-40           | 39     | 20    | 1    |
| calm-mirror-59               | 44     | 3     | 17   |
| healthy-femur-56             | 40     | 4     | 7    |
| good-simulator-71            | 42     | 6     | 1    |
| enthusiastic-bowler-26       | 44     | 9     | 6    |
| impossible-bread-50          | 44     | 3     | 2    |
| stormy-transition-74         | 46     | 9     | 9    |
| thundering-transportation-98 | 47     | 3     | 21   |
| breakable-magnet-62          | 45     | 9     | 1    |
| adventurous-zombie-82        | 48     | 9     | 11   |
| worried-sax-17               | 45     | 17    | 7    |
| scary-gel-67                 | 50     | 5     | 14   |
| innocent-greyhound-61        | 52     | 7     | 15   |
| late-chip-34                 | 53     | 9     | 6    |
| pleasant-simplicity-11       | 54     | 6     | 10   |
| dull-scarf-90                | 51     | 1     | 3    |
| elated-cat-2                 | 58     | 10    | 8    |
| weary-oboist-34              | 55     | 6     | 22   |
| homely-vat-60                | 58     | 1     | 9    |
| tense-pail-67                | 56     | 10    | 13   |
| dull-welt-22                 | 55     | 13    | 1    |
| long-pest-22                 | 61     | 10    | 27   |
| mute-newsprint-61            | 63     | 4     | 21   |
| dull-violinist-93            | 61     | 10    | 10   |
| tall-battalion-96            | 64     | 4     | 7    |
| moaning-motorcyclist-63      | 61     | 13    | 7    |
| brainy-panda-95              | 68     | 7     | 28   |
| rich-desert-39               | 69     | 1     | 6    |
| beautiful-turbojet-1         | 66     | 3     | 7    |
| high-canoe-56                | 67     | 8     | 9    |
| graceful-dove-99             | 68     | 8     | 7    |
Then the response should be:
| code | body                                                                                                                                                                                                                                                                                                                                                |
| 200  | {"gain":241,"path":["funny-bandana-20","kind-condo-18","jolly-terrapin-3","hilarious-electrician-26","dead-chimp-63","motionless-maggot-34","silly-gynecologist-70","quaint-opulence-56","busy-mall-67","healthy-femur-56","calm-mirror-59","thundering-transportation-98","scary-gel-67","weary-oboist-34","mute-newsprint-61","brainy-panda-95"]} |



