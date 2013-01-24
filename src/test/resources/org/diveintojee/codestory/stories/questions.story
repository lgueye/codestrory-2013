Questions stories

Meta:
@refs q1
@refs q2
@refs q3
@refs q4
@refs q5
@refs q6
@progress done

Narrative:
Given my server is ready
When I'm asked the first question
Then I should be able to answer correctly to that question

Scenario: the server should answer to the new question
When the server is asked the question "Quelle est ton adresse email"
Then the response should be:
| code | body                          | requiredType |
| 200  | louis.gueye@gmail.com         | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "Es tu heureux de participer(OUI/NON)"
Then the response should be:
| code | body                          | requiredType |
| 200  | OUI                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "Es tu abonne a la mailing list(OUI/NON)"
Then the response should be:
| code | body                          | requiredType |
| 200  | OUI                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)"
Then the response should be:
| code | body                          | requiredType |
| 200  | OUI                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "Est ce que tu reponds toujours oui(OUI/NON)"
Then the response should be:
| code | body                          | requiredType |
| 200  | NON                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "As tu bien recu le premier enonce(OUI/NON)"
Then the response should be:
| code | body                          | requiredType |
| 200  | OUI                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "1 1"
Then the response should be:
| code | body                          | requiredType |
| 200  | 2,0                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "3*2"
Then the response should be:
| code | body                          | requiredType |
| 200  | 6,0                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "6/2"
Then the response should be:
| code | body                          | requiredType |
| 200  | 3,0                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "5-4"
Then the response should be:
| code | body                          | requiredType |
| 200  | 1,0                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "(1 2)*2"
Then the response should be:
| code | body                          | requiredType |
| 200  | 6,0                           | text/plain   |

Scenario: the server should answer to the new question
When the server is asked the question "(1 2)/2"
Then the response should be:
| code | body                          | requiredType |
| 200  | 1,5                           | text/plain   |
