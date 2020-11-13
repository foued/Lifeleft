package com.lifeleft;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.Year;

@WebService(serviceName = "LifeLeft")
public class LifeleftService {

    private static final Integer ESPERANCE_VIE_HOMMES = 79;
    private static final Integer ESPERANCE_VIE_FEMMES = 85;

    String homme = "homme";
    String femme = "femme";

    Integer evDeReference = 0;

    @WebMethod
    public String  anneeRestantesAVivre (String prenom, String sexe, Integer anneeNaissance) {

        if(sexe.equals(homme)) evDeReference = ESPERANCE_VIE_HOMMES;
        else evDeReference = ESPERANCE_VIE_FEMMES;

        //Remarque, en cas de problème, vous pouvez changer Year.now().getValue() par Calendar.getInstance().get(Calendar.YEAR)
        Integer anneeRestantes = evDeReference -(Year.now().getValue() - anneeNaissance );

        return "Bonjour " + prenom + ", il vous reste " + anneeRestantes + " ans à vivre, profitez-en au maximum !";
    }

}

