package entity;


import javax.persistence.*;

@Entity
@Table(name = "Etablissement")
public class Etablissement {
    @Id
    @Column(name = "id_etablissement")
    private int idEtablissement;

    @Column(name = "nom_etablissement")
    private String nomEtablissement;


    public Etablissement() {

    }

    public Etablissement(int idEtablissement, String nomEtablissement) {
        this.idEtablissement = idEtablissement;
        this.nomEtablissement = nomEtablissement;
    }

    public int getIdEtablissement() {
        return idEtablissement;
    }

    public void setIdEtablissement(int idEtablissement) {
        this.idEtablissement = idEtablissement;
    }

    public String getNomEtablissement() {
        return nomEtablissement;
    }

    @Override
    public String toString() {
        return "Etablissement{" +
                "idEtablissement=" + idEtablissement +
                ", nomEtablissement='" + nomEtablissement + '\'' +
                '}';
    }

    public void setNomEtablissement(String nomEtablissement) {
        this.nomEtablissement = nomEtablissement;
    }
}


