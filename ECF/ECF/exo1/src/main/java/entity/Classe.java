package entity;

import javax.persistence.*;

@Entity
@Table(name = "Classe")
public class Classe {
    @Id
    @Column(name = "id_classe")
    private int idClasse;

    @Column(name = "nom_classe", length = 50)
    private String nomClasse;

    @Column(name = "niveau_classe")
    private int niveauClasse;

    @Override
    public String toString() {
        return "Classe{" +
                "idClasse=" + idClasse +
                ", nomClasse='" + nomClasse + '\'' +
                ", niveauClasse=" + niveauClasse +
                ", departement=" + departement +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "id_departement", nullable = false)
    private Departement departement;

    public Classe() {

    }

    public Classe(int idClasse, String nomClasse, int niveauClasse, Departement departement) {
        this.idClasse = idClasse;
        this.nomClasse = nomClasse;
        this.niveauClasse = niveauClasse;
        this.departement = departement;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public int getNiveauClasse() {
        return niveauClasse;
    }

    public void setNiveauClasse(int niveauClasse) {
        this.niveauClasse = niveauClasse;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }


}