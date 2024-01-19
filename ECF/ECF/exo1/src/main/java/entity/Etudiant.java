package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Etudiant")
public class Etudiant {
    @Id
    @Column(name = "id_etudiant")
    private int idEtudiant;

    @Column(name = "nom_etudiant", length = 50)
    private String nomEtudiant;

    @Column(name = "prenom_etudiant", length = 50)
    private String prenomEtudiant;

    @Column(name = "date_naissance_etudiant")
    @Temporal(TemporalType.DATE)
    private Date dateNaissanceEtudiant;

    @Column(name = "email_etudiant", length = 100)
    private String emailEtudiant;

    @Column(name = "matricule_etudiant", unique = true)
    private int matriculeEtudiant;

    @ManyToOne
    @JoinColumn(name = "id_emploi_temps", nullable = false)
    private EmploiDuTemps emploiDuTemps;

    @ManyToOne
    @JoinColumn(name = "id_classe", nullable = false)
    private Classe classe;


    public Etudiant() {

    }

    public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, Date dateNaissanceEtudiant,
                    String emailEtudiant, int matriculeEtudiant, EmploiDuTemps emploiDuTemps, Classe classe) {
        this.idEtudiant = idEtudiant;
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.dateNaissanceEtudiant = dateNaissanceEtudiant;
        this.emailEtudiant = emailEtudiant;
        this.matriculeEtudiant = matriculeEtudiant;
        this.emploiDuTemps = emploiDuTemps;
        this.classe = classe;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public Date getDateNaissanceEtudiant() {
        return dateNaissanceEtudiant;
    }

    public void setDateNaissanceEtudiant(Date dateNaissanceEtudiant) {
        this.dateNaissanceEtudiant = dateNaissanceEtudiant;
    }

    public String getEmailEtudiant() {
        return emailEtudiant;
    }

    public void setEmailEtudiant(String emailEtudiant) {
        this.emailEtudiant = emailEtudiant;
    }

    public int getMatriculeEtudiant() {
        return matriculeEtudiant;
    }

    public void setMatriculeEtudiant(int matriculeEtudiant) {
        this.matriculeEtudiant = matriculeEtudiant;
    }

    public EmploiDuTemps getEmploiDuTemps() {
        return emploiDuTemps;
    }

    public void setEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        this.emploiDuTemps = emploiDuTemps;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "idEtudiant=" + idEtudiant +
                ", nomEtudiant='" + nomEtudiant + '\'' +
                ", prenomEtudiant='" + prenomEtudiant + '\'' +
                ", dateNaissanceEtudiant=" + dateNaissanceEtudiant +
                ", emailEtudiant='" + emailEtudiant + '\'' +
                ", matriculeEtudiant=" + matriculeEtudiant +
                ", emploiDuTemps=" + emploiDuTemps +
                ", classe=" + classe +
                '}';
    }
}