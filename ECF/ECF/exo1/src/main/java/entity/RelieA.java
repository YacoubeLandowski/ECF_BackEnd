package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "relie_a")
public class RelieA {
    @Override
    public String toString() {
        return "RelieA{" +
                "id=" + id +
                ", matiere=" + matiere +
                ", emploiDuTemps=" + emploiDuTemps +
                '}';
    }

    @EmbeddedId
    private RelieAId id;

    @ManyToOne
    @JoinColumn(name = "id_matiere", insertable = false, updatable = false)
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "id_emploi_temps", insertable = false, updatable = false)
    private EmploiDuTemps emploiDuTemps;

    public RelieA() {
    }

    public RelieA(RelieAId id, Matiere matiere, EmploiDuTemps emploiDuTemps) {
        this.id = id;
        this.matiere = matiere;
        this.emploiDuTemps = emploiDuTemps;
    }

    public RelieAId getId() {
        return id;
    }

    public void setId(RelieAId id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public EmploiDuTemps getEmploiDuTemps() {
        return emploiDuTemps;
    }

    public void setEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        this.emploiDuTemps = emploiDuTemps;
    }


    @Embeddable
    public static class RelieAId implements Serializable {
        @Column(name = "id_matiere")
        private int idMatiere;

        @Column(name = "id_emploi_temps")
        private int idEmploiTemps;



        public RelieAId() {
        }

        public RelieAId(int idMatiere, int idEmploiTemps) {
            this.idMatiere = idMatiere;
            this.idEmploiTemps = idEmploiTemps;
        }

        public int getIdMatiere() {
            return idMatiere;
        }

        public void setIdMatiere(int idMatiere) {
            this.idMatiere = idMatiere;
        }

        @Override
        public String toString() {
            return "RelieAId{" +
                    "idMatiere=" + idMatiere +
                    ", idEmploiTemps=" + idEmploiTemps +
                    '}';
        }

        public int getIdEmploiTemps() {
            return idEmploiTemps;
        }

        public void setIdEmploiTemps(int idEmploiTemps) {
            this.idEmploiTemps = idEmploiTemps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RelieAId that = (RelieAId) o;
            return idMatiere == that.idMatiere &&
                    idEmploiTemps == that.idEmploiTemps;
        }


    }
}