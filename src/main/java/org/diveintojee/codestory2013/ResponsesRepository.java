package org.diveintojee.codestory2013;

import com.google.common.collect.ImmutableMap;

import org.springframework.stereotype.Component;

/**
 * User: lgueye Date: 18/01/13 Time: 18:47
 */
@Component
public class ResponsesRepository {

  private static ImmutableMap<String, String> repository;

  static {
    repository = new ImmutableMap.Builder<String, String>()
        .put("Quelle est ton adresse email", "louis.gueye@gmail.com")
        .put("Es tu heureux de participer(OUI/NON)", "OUI")
        .put("Es tu abonne a la mailing list(OUI/NON)", "OUI")
        .put("Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)", "OUI")
        .build();
  }

  public String getResponse(String question) {
    return repository.get(question);
  }
}
