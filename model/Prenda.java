package sagrModa;
public class Prenda {
    ///ATRIBUTOS
    private String codigo;
    private String nombre;
    private char genero;
    private float nota;
    
    ////Constructores.
    public Prenda() {
        this.codigo="";
        this.nombre="";
        this.genero='*';
        this.nota=0;
    }
    public Prenda(String codigo,String nombre,char genero,float f) {
        this.codigo=codigo;
        this.nombre=nombre;
        this.genero=genero;
        this.nota=f;
    }
    ///MODIFICADORES
    ///UNO POR CADA ATRIBUTO

    public Prenda(String cod, String nom, String gen, float note) {
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    ///ANALIZADORES

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public char getGenero() {
        return genero;
    }

    public float getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return this.codigo +"," +this.nombre+","+this.genero+","+this.nota;
    }
}

