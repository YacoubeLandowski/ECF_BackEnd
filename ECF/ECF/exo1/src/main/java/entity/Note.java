package entity;

import javax.persistence.*;

@Entity
@Table(name = "Note")
public class Note {
    @Id
    @Column(name = "id_note")
    private int idNote;

    @Column(name = "valeur_note")
    private int valeurNote;

    @Column(name = "commentaire_note", length = 300)
    private String commentaireNote;

    @ManyToOne
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "id_etudiant", nullable = false)
    private Etudiant etudiant;


    public Note() {
    }

    public Note(int idNote, int valeurNote, String commentaireNote, Matiere matiere, Etudiant etudiant) {
        this.idNote = idNote;
        this.valeurNote = valeurNote;
        this.commentaireNote = commentaireNote;
        this.matiere = matiere;
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "Note{" +
                "idNote=" + idNote +
                ", valeurNote=" + valeurNote +
                ", commentaireNote='" + commentaireNote + '\'' +
                ", matiere=" + matiere +
                ", etudiant=" + etudiant +
                '}';
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public int getValeurNote() {
        return valeurNote;
    }

    public void setValeurNote(int valeurNote) {
        this.valeurNote = valeurNote;
    }

    public String getCommentaireNote() {
        return commentaireNote;
    }

    public void setCommentaireNote(String commentaireNote) {
        this.commentaireNote = commentaireNote;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }


}
