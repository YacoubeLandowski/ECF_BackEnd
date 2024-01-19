package entity;

import javax.persistence.*;

@Entity
@Table(name = "ResponsableDepartement")
public class ResponsableDepartement {
    @Id
    @Column(name = "id_responsable")
    private int idResponsable;

    @OneToOne
    @JoinColumn(name = "id_enseignant", unique = true, nullable = false)
    private Enseignant enseignant;


    @Override
    public String toString() {
        return "ResponsableDepartement{" +
                "idResponsable=" + idResponsable +
                ", enseignant=" + enseignant +
                '}';
    }

    public ResponsableDepartement() {

    }

    public ResponsableDepartement(int idResponsable, Enseignant enseignant) {
        this.idResponsable = idResponsable;
        this.enseignant = enseignant;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

}