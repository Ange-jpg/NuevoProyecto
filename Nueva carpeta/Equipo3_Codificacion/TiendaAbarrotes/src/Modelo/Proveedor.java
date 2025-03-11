package Modelo;


public class Proveedor {
    private int id;
    private int rfc;
    private String nom;
    private int tel;
    private String dir;
    private String cor;

    public Proveedor() {
    }

    public Proveedor(int id, int rfc, String nom, int tel, String dir, String cor) {
        this.id = id;
        this.rfc = rfc;
        this.nom = nom;
        this.tel = tel;
        this.dir = dir;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRfc() {
        return rfc;
    }

    public void setRfc(int rfc) {
        this.rfc = rfc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    
}
