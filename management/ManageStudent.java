import javax.swing.*;

public class ManageStudent {
    //Variables de clase

    private String codigos;
    private  String nombres;
    private float notas;
    private int posicion;

    //Constructor
    public ManageStudent(){
        this.codigos="";
        this.nombres="";
        this.notas=0;
        this.posicion=0;

    }

    //Métodos de servicio
    public boolean hayEstudiantes(){
        boolean hay = false;
        if ( this.codigos != null){
            hay = true;
        }
        return hay;
    }

    public void muestraTodos(){

    }

    public void muestraEstudiante(String codigos){

    }

    public void nuevoEstudiante(){
        this.codigos= JOptionPane.showInputDialog(null,"Ingrese el código del alumno");
        this.nombres= JOptionPane.showInputDialog(null,"Ingrese el nombre del alumno");
        this.notas= Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese la nota del alumno"));


    }

    /*private float capturaNota(){
        return cap;
    }


    public String mejor(){
        return best;
    }
         */

    public void ordenador(){

    }

    private void muestraOrdenados(String copiaCodigos, String copiaNombres, Float copiaNotas){

    }



}
