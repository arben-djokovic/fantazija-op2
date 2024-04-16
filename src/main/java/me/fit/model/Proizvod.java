package me.fit.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({ 
    @NamedQuery(name = Proizvod.GET_ALL_PROIZVODI, query = "SELECT p FROM Proizvod p"),
    @NamedQuery(name = Proizvod.GET_PROIZVODI_BY_IME, query = "SELECT p FROM Proizvod p WHERE p.ime = :ime") 
})
public class Proizvod {

    public static final String GET_ALL_PROIZVODI = "getAllProizvodi";
    public static final String GET_PROIZVODI_BY_IME = "getProizvodiByIme";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proizvod_seq")
    private Long id;

    private String ime;

    private double cijena;

    private String smjesa;

    // Možete dodati dodatne atribute ili promijeniti postojeće prema potrebi

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getSmjesa() {
        return smjesa;
    }

    public void setSmjesa(String smjesa) {
        this.smjesa = smjesa;
    }

    // Možete dodati gettere i settere za dodatne atribute ili promijeniti postojeće prema potrebi

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ime == null) ? 0 : ime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Proizvod other = (Proizvod) obj;
        if (ime == null) {
            if (other.ime != null)
                return false;
        } else if (!ime.equals(other.ime))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Proizvod [id=" + id + ", ime=" + ime + ", cijena=" + cijena + ", smjesa=" + smjesa + "]";
    }
}
