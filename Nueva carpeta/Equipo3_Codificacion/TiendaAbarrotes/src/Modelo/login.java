package Modelo;


public class login {
    private int id;
    private String dni;
    private String nom;
    private int tel;
    private String usu;
    private String dir;
    private String cor;
    private String pass;

    public login() {
    }

    public login(int id, String dni, String nom, int tel, String usu, String dir, String cor, String pass) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.tel = tel;
        this.usu = usu;
        this.dir = dir;
        this.cor = cor;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
