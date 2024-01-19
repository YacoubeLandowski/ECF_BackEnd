package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Matiere")
public class Matiere {
    @Id
    @Column(name = "id_matiere")
    private int idMatiere;

    @Column(name = "description_matiere", length = 500)
    private String descriptionMatiere;

    @Column(name = "coef_matiere")
    private int coefMatiere;

    @Column(name = "duree_matiere")
    private int dureeMatiere;

    @Column(name = "intitule", length = 100)
    private String intitule;

    @Override
    public String toString() {
        return "Matiere{" +
                "idMatiere=" + idMatiere +
                ", descriptionMatiere='" + descriptionMatiere + '\'' +
                ", coefMatiere=" + coefMatiere +
                ", dureeMatiere=" + dureeMatiere +
                ", intitule='" + intitule + '\'' +
                '}';
    }

    public Matiere() {
    }

    public Matiere(int idMatiere, String descriptionMatiere, int coefMatiere, int dureeMatiere, String intitule) {
        this.idMatiere = idMatiere;
        this.descriptionMatiere = descriptionMatiere;
        this.coefMatiere = coefMatiere;
        this.dureeMatiere = dureeMatiere;
        this.intitule = intitule;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getDescriptionMatiere() {
        return descriptionMatiere;
    }

    public void setDescriptionMatiere(String descriptionMatiere) {
        this.descriptionMatiere = descriptionMatiere;
    }

    public int getCoefMatiere() {
        return coefMatiere;
    }

    public void setCoefMatiere(int coefMatiere) {
        this.coefMatiere = coefMatiere;
    }

    public int getDureeMatiere() {
        return dureeMatiere;
    }

    public void setDureeMatiere(int dureeMatiere) {
        this.dureeMatiere = dureeMatiere;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

}