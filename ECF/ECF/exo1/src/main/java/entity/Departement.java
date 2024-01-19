package entity;

import javax.persistence.*;

@Entity
@Table(name = "Departement")
public class Departement {
    @Id
    @Column(name = "id_departement")
    private int idDepartement;

    @Column(name = "nom_departement")
    private String nomDepartement;

    @ManyToOne
    @JoinColumn(name = "id_etablissement", nullable = false)
    private Etablissement etablissement;



    public Departement() {

    }

    public Departement(int idDepartement, String nomDepartement, Etablissement etablissement) {
        this.idDepartement = idDepartement;
        this.nomDepartement = nomDepartement;
        this.etablissement = etablissement;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "idDepartement=" + idDepartement +
                ", nomDepartement='" + nomDepartement + '\'' +
                ", etablissement=" + etablissement +
                '}';
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

}