package org.diveintojee.codestory2013.questions;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

/**
 * @author louis.gueye@gmail.com
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
                .put("Est ce que tu reponds toujours oui(OUI/NON)", "NON")
                .put("As tu bien recu le premier enonce(OUI/NON)", "OUI")
                .put("As tu passe une bonne nuit malgre les bugs de l etape precedente(PAS_TOP/BOF/QUELS_BUGS)", "QUELS_BUGS")
                .put("As tu bien recu le second enonce(OUI/NON)", "OUI")
                .put("As tu copie le code de ndeloof(OUI/NON/JE_SUIS_NICOLAS)", "NON")
                .build();
    }

    public String getAnswer(String question) {
        return repository.get(question);
    }
}
