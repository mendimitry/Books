package com.journaldev.jsf;

public class Chitateli {
    private int NumberChitatelya;
    private int NumberBileta;
    private String FamiliyaImyaOtchestvo;
    private String Address;
    private int TelephoneRab;
    private int TelephoneDom;



    public Chitateli()
    {

    }

    public Chitateli(int NumberChitatelya)
    {
        this.NumberChitatelya=NumberChitatelya;
    }
    public Chitateli(int NumberChitatelya, int NumberBileta, String FamiliyaImyaOtchestvo,String Address,int TelephoneRab, int TelephoneDom) {
        this.NumberChitatelya = NumberChitatelya;
        this.NumberBileta =NumberBileta;
        this.FamiliyaImyaOtchestvo = FamiliyaImyaOtchestvo;
        this.Address=Address;
        this.TelephoneRab=TelephoneRab;
        this.TelephoneDom=TelephoneDom;



    }

    public int getNumberChitatelya() {
        return NumberChitatelya;
    }
    public void setNumberChitatelya(int NumberChitatelya) {
        this.NumberChitatelya = NumberChitatelya;
    }
    public int getNumberBileta() {
        return NumberBileta;
    }
    public void setNumberBileta(int NumberBileta) {
        this.NumberBileta = NumberBileta;
    }
    public String getFamiliyaImyaOtchestvo() {
        return FamiliyaImyaOtchestvo;
    }
    public void setFamiliyaImyaOtchestvo(String FamiliyaImyaOtchestvo) {
        this.FamiliyaImyaOtchestvo = FamiliyaImyaOtchestvo;}
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public int getTelephoneRab() {
        return TelephoneRab;
    }
    public void setTelephoneRab(int TelephoneRab) {
        this.TelephoneRab = TelephoneRab;
    }
    public int getTelephoneDom() {
        return TelephoneDom;
    }
    public void setTelephoneDom(int TelephoneDom) {
        this.TelephoneDom = TelephoneDom;
    }



    @Override
    public String toString() {
        return "Book{" + "NumberKnigi=" + NumberChitatelya + ", Chif=" + NumberBileta + ", Nazvanie=" + FamiliyaImyaOtchestvo + '}';
    }
}
