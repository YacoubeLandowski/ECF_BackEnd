package entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Enseigner")
public class Enseigner {

    @EmbeddedId
    private EnseignerId id;

    @ManyToOne
    @JoinColumn(name = "id_enseignant", insertable = false, updatable = false)
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "id_matiere", insertable = false, updatable = false)
    private Matiere matiere;


    public Enseigner() {
    }

    public Enseigner(EnseignerId id, Enseignant enseignant, Matiere matiere) {
        this.id = id;
        this.enseignant = enseignant;
        this.matiere = matiere;
    }

    public EnseignerId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Enseigner{" +
                "id=" + id +
                ", enseignant=" + enseignant +
                ", matiere=" + matiere +
                '}';
    }

    public void setId(EnseignerId id) {
        this.id = id;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }


    @Embeddable
    public static class EnseignerId implements Serializable {
        @Column(name = "id_enseignant")
        private int idEnseignant;

        @Column(name = "id_matiere")
        private int idMatiere;


        @Override
        public String toString() {
            return "EnseignerId{" +
                    "idEnseignant=" + idEnseignant +
                    ", idMatiere=" + idMatiere +
                    '}';
        }

        public EnseignerId() {

        }

        public int getIdEnseignant() {
            return idEnseignant;
        }

        public void setIdEnseignant(int idEnseignant) {
            this.idEnseignant = idEnseignant;
        }

        public int getIdMatiere() {
            return idMatiere;
        }

        public void setIdMatiere(int idMatiere) {
            this.idMatiere = idMatiere;
        }

        public EnseignerId(int idEnseignant, int idMatiere) {
            this.idEnseignant = idEnseignant;
            this.idMatiere = idMatiere;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EnseignerId that = (EnseignerId) o;
            return idEnseignant == that.idEnseignant &&
                    idMatiere == that.idMatiere;
        }

    }
}