package hu.uni.miskolc.recyclerviewozd.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Dolgozo implements Serializable {

    int id;

    String keresztNev;

    String vezetekNev;

    int fizetes;


    public Dolgozo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeresztNev() {
        return keresztNev;
    }

    public void setKeresztNev(String keresztNev) {
        this.keresztNev = keresztNev;
    }

    public String getVezetekNev() {
        return vezetekNev;
    }

    public void setVezetekNev(String vezetekNev) {
        this.vezetekNev = vezetekNev;
    }

    public int getFizetes() {
        return fizetes;
    }

    public void setFizetes(int fizetes) {
        this.fizetes = fizetes;
    }


    @Override
    public String toString() {
        return "Dolgozo{" +
                "id=" + id +
                ", keresztNev='" + keresztNev + '\'' +
                ", vezetekNev='" + vezetekNev + '\'' +
                ", fizetes=" + fizetes +
                '}';
    }
}