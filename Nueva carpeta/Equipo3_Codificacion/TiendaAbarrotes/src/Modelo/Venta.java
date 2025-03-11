package Modelo;

public class Venta {
    private int id;
    private String cli;
    private String ven;
    private double tol;

    public Venta() {
    }

    public Venta(int id, String cli, String ven, double tol) {
        this.id = id;
        this.cli = cli;
        this.ven = ven;
        this.tol = tol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCli() {
        return cli;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }

    public String getVen() {
        return ven;
    }

    public void setVen(String ven) {
        this.ven = ven;
    }

    public double getTol() {
        return tol;
    }

    public void setTol(double tol) {
        this.tol = tol;
    }
    
        
}
