package entity;

import java.io.Serializable;

public class PeutEnseignerId implements Serializable {
    private int enseignant;
    private int classe;

    public PeutEnseignerId() {
    }

    @Override
    public String toString() {
        return "PeutEnseignerId{" +
                "enseignant=" + enseignant +
                ", classe=" + classe +
                '}';
    }

    public PeutEnseignerId(int enseignant, int classe) {
        this.enseignant = enseignant;
        this.classe = classe;
    }

}