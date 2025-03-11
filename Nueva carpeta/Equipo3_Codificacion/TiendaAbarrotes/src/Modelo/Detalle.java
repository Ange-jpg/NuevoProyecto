package Modelo;

public class Detalle {
    private int idd;
    private int idv;
    private int idp;
    private int cant;
    private double pre;
    private String codp;

    public Detalle() {
    }

    public Detalle(int idd, int idv, int idp, int cant, double pre, String codp) {
        this.idd = idd;
        this.idv = idv;
        this.idp = idp;
        this.cant = cant;
        this.pre = pre;
        this.codp = codp;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public int getIdv() {
        return idv;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    public String getCodp() {
        return codp;
    }

    public void setCodp(String codp) {
        this.codp = codp;
    }
    
    
}
