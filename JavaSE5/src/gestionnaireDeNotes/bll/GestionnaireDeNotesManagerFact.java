package gestionnaireDeNotes.bll;

public class GestionnaireDeNotesManagerFact {
    public static GestionnaireDeNotesManager getInstance(boolean b) {
        if (b)
            return new GestionnaireDeNotesManagerClassique();
        else
            return new GestionnaireDeNotesManagerGentil();

    }
}
