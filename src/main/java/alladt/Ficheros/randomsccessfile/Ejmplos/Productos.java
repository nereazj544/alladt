package alladt.Ficheros.randomsccessfile.Ejmplos;

public class Productos {
    private int id; //4
    private String nombre; //20
    private double precio; //8
    //20 + 4 + 8 = 32

    public Productos(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
