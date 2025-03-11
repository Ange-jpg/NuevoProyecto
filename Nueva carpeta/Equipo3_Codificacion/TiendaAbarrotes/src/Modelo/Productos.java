
package Modelo;


public class Productos {
    private int id;
    private String cod;
    private String des;
    private String pro;
    private int sto;
    private double pre;
    private int cont;

    public Productos() {
    }

    public Productos(int id, String cod, String des, String pro, int sto, double pre, int cont) {
        this.id = id;
        this.cod = cod;
        this.des = des;
        this.pro = pro;
        this.sto = sto;
        this.pre = pre;
        this.cont = cont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public int getSto() {
        return sto;
    }

    public void setSto(int sto) {
        this.sto = sto;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
}
