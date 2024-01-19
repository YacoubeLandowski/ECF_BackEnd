package entity;

import javax.persistence.*;

@Entity
@Table(name = "Enseignant")
public class Enseignant {
    @Id
    @Column(name = "id_enseignant")
    private int idEnseignant;

    @Column(name = "matricule_prof", unique = true)
    private int matriculeProf;

    @Override
    public String toString() {
        return "Enseignant{" +
                "idEnseignant=" + idEnseignant +
                ", matriculeProf=" + matriculeProf +
                ", prenomProf='" + prenomProf + '\'' +
                ", ageProf=" + ageProf +
                ", gradeProf='" + gradeProf + '\'' +
                ", profPrincipal=" + profPrincipal +
                ", nomProf='" + nomProf + '\'' +
                ", departement=" + departement +
                '}';
    }

    @Column(name = "prenom_prof")
    private String prenomProf;

    @Column(name = "age_prof")
    private int ageProf;

    @Column(name = "grade_prof")
    private String gradeProf;

    @Column(name = "prof_principal")
    private boolean profPrincipal;

    @Column(name = "nom_prof")
    private String nomProf;

    @ManyToOne
    @JoinColumn(name = "id_departement", nullable = false)
    private Departement departement;



    public Enseignant() {
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public int getMatriculeProf() {
        return matriculeProf;
    }

    public void setMatriculeProf(int matriculeProf) {
        this.matriculeProf = matriculeProf;
    }

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
    }

    public int getAgeProf() {
        return ageProf;
    }

    public void setAgeProf(int ageProf) {
        this.ageProf = ageProf;
    }

    public String getGradeProf() {
        return gradeProf;
    }

    public void setGradeProf(String gradeProf) {
        this.gradeProf = gradeProf;
    }

    public boolean isProfPrincipal() {
        return profPrincipal;
    }

    public void setProfPrincipal(boolean profPrincipal) {
        this.profPrincipal = profPrincipal;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Enseignant(int idEnseignant, int matriculeProf, String prenomProf, int ageProf,
                      String gradeProf, boolean profPrincipal, String nomProf, Departement departement) {
        this.idEnseignant = idEnseignant;
        this.matriculeProf = matriculeProf;
        this.prenomProf = prenomProf;
        this.ageProf = ageProf;
        this.gradeProf = gradeProf;
        this.profPrincipal = profPrincipal;
        this.nomProf = nomProf;
        this.departement = departement;
    }




}