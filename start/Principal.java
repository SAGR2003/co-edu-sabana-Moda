import javax.swing.*;

public class Principal {
    //Comunicación Objeto
    ManageStudent mancito = new ManageStudent();

    //main
    public static void main(String[] args) {
        new Principal();
    }

    public Principal(){
        this.mancito=new ManageStudent(); //Creación del objeto
        System.out.println("Objeto creado");
        this.menu();
    }

    //Menú
    private void menu(){
        int opcion;
        String x;
        int v;
        do {
            x = JOptionPane.showInputDialog("======== Opciones ======== \n" +
                    "1. Agregar Estudiante \n" +
                    "2. Ver todos \n" +
                    "3. Ver Estudiante \n" +
                    "4. Ver ordenados\n" +
                    "5. Mejor \n" +
                    "0. SALIR \n");
            opcion = Integer.parseInt(x);
            switch (opcion) {
                case 1:
                    this.mancito.nuevoEstudiante();
                    break;
                case 2:
                    if(mancito.hayEstudiantes()== true){
                        JOptionPane.showMessageDialog(null, "No hay alumnos en el sistema, dirigase a la opción 1");
                    }
                    else{
                        this.mancito.muestraTodos();
                    }
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    JOptionPane.showMessageDialog(null,"No existe");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Hasta luego");
                    break;
            }
        }
        while (opcion!=0);
    }
}

