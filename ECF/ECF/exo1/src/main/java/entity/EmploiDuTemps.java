package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmploiDuTemps")
public class EmploiDuTemps {
    @Id
    @Column(name = "id_emploi_temps")
    private int idEmploiTemps;

    @Column(name = "jour_emploi_temps")
    @Temporal(TemporalType.DATE)
    private Date jourEmploiTemps;

    @Column(name = "heure_emploi_temps")
    @Temporal(TemporalType.TIME)
    private Date heureEmploiTemps;



    public EmploiDuTemps() {
    }

    public EmploiDuTemps(int idEmploiTemps, Date jourEmploiTemps, Date heureEmploiTemps) {
        this.idEmploiTemps = idEmploiTemps;
        this.jourEmploiTemps = jourEmploiTemps;
        this.heureEmploiTemps = heureEmploiTemps;
    }

    public int getIdEmploiTemps() {
        return idEmploiTemps;
    }

    public void setIdEmploiTemps(int idEmploiTemps) {
        this.idEmploiTemps = idEmploiTemps;
    }

    public Date getJourEmploiTemps() {
        return jourEmploiTemps;
    }

    public void setJourEmploiTemps(Date jourEmploiTemps) {
        this.jourEmploiTemps = jourEmploiTemps;
    }

    @Override
    public String toString() {
        return "EmploiDuTemps{" +
                "idEmploiTemps=" + idEmploiTemps +
                ", jourEmploiTemps=" + jourEmploiTemps +
                ", heureEmploiTemps=" + heureEmploiTemps +
                '}';
    }

    public Date getHeureEmploiTemps() {
        return heureEmploiTemps;
    }

    public void setHeureEmploiTemps(Date heureEmploiTemps) {
        this.heureEmploiTemps = heureEmploiTemps;
    }

}