package com.journaldev.jsf;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQuery(name="findAllContacts", query = "select c from Books c")
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int NumberKnigi;
    private String Chif;
    private String Nazvanie;
    private String Avtor;
    private String MestoIzdaniya;
    private String Izadtelstvo;
    private Date YearIzdaniya;
    private int KolStranic;

    public Books()
    {

    }

    public Books(int NumberKnigi)
    {
    this.NumberKnigi=NumberKnigi;
    }
    public Books(int NumberKnigi, String Chif, String Nazvanie,String Avtor,String MestoIzdaniya, String Izadtelstvo, Date YearIzdaniya, int KolStranic) {
        this.NumberKnigi = NumberKnigi;
        this.Chif =Chif;
        this.Nazvanie = Nazvanie;
        this.Avtor=Avtor;
        this.MestoIzdaniya=MestoIzdaniya;
        this.Izadtelstvo=Izadtelstvo;
        this.YearIzdaniya=YearIzdaniya;
        this.KolStranic=KolStranic;

    }

    public int getNumberKnigi() {
        return NumberKnigi;
    }
    public void setNumberKnigi(int NumberKnigi) {
        this.NumberKnigi = NumberKnigi;
    }
    public String getChif() {
        return Chif;
    }
    public void setChif(String Chif) {
        this.Chif = Chif;
    }
    public String getNazvanie() {
        return Nazvanie;
    }
    public void setNazvanie(String Nazvanie) {
        this.Nazvanie = Nazvanie;
    }
    public String getAvtor() {
        return Avtor;
    }
    public void setAvtor(String Avtor) {
        this.Avtor = Avtor;
    }
    public String getMestoIzdaniya() {
        return MestoIzdaniya;
    }
    public void setMestoIzdaniya(String MestoIzdaniya) {
        this.MestoIzdaniya = MestoIzdaniya;
    }
    public String getIzadtelstvo() {
        return Izadtelstvo;
    }
    public void setIzatelstvo(String Izatelstvo) {
        this.Izadtelstvo = Izadtelstvo;
    }
    public Date setYearIzdaniya() {return YearIzdaniya;}
    public void setYearIzdaniya(Date YearIzdaniya) {
        this.YearIzdaniya = YearIzdaniya;
    }
    public int getKolStranic() {
        return KolStranic;
    }
    public void setKolStranic(int KolStranic) {
        this.KolStranic = KolStranic;
    }

    @Override
    public String toString() {
        return "Book{" + "NumberKnigi=" + NumberKnigi + ", Chif=" + Chif + ", Nazvanie=" + Nazvanie + '}';
    }
}
