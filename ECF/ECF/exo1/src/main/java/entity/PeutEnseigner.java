package entity;

import javax.persistence.*;

@Entity
@Table(name = "peut_enseigner")
@IdClass(PeutEnseignerId.class)
public class PeutEnseigner {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_enseignant")
    private Enseignant enseignant;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_classe")
    private Classe classe;


    public PeutEnseigner() {
    }

    public PeutEnseigner(Enseignant enseignant, Classe classe) {
        this.enseignant = enseignant;
        this.classe = classe;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }


}