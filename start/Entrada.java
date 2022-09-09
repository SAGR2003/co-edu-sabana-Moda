package sagrModa;

import javax.swing.*;

public class principal {
    ///Variable de clase
    private managePrend gestor;
    public static void main(String[] x) {
        new principal();
    }
    public principal()
    {
        this.gestor=new managePrend();
        this.menu(); 
    }
    private void menu() 
    {
        char opcion;
        String inicio;
        do {
            inicio=JOptionPane.showInputDialog("=====OPCIONES===== \n" + 
                                    "1. Agregar prenda \n" +
                                    "2. Buscar prenda \n" +
                                    "3. Ver todos los estudiantes \n" +
                                    "4. Modificar prenda \n" +
                                    "5. Eliminar estudiante\n" +
                                    "0. SALIDA \n");
            opcion=(char)Integer.parseInt(inicio);
            switch (opcion) {
                case 1:
                    this.gestor.nuevaPrenda();
                break;
                case 2:
                    if (this.gestor.hayEstudiantes())
                    {
                        this.gestor.verEstudiante(); 
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Aún no hay estudiantes");
                    }
                break;
                case 3:
                    if (this.gestor.hayEstudiantes())
                    {
                        this.gestor.verTodos();
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Aún no hay estudiantes");
                    }
                break;
                case 4:
                    if (this.gestor.hayPrenda())
                    {
                        this.menuModificadores();
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Aún no hay prendas");
                    }
                break;
                case 5:
                    if (this.gestor.hayEstudiantes())
                    {
                        this.gestor.eliminarEstudiante();
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Aún no hay estudiantes");
                    }
                break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Nos veremos luego, gracias por participar");
                break;
                default:
                    JOptionPane.showMessageDialog(null,"Intenta otra vez esa opcion no existe."); 
                break;
            }
        }
        while(opcion!=0);
    }
    private void menuModificadores() {
        char opcion;
        String inicio;
        do {
            inicio=JOptionPane.showInputDialog("=====OPCIONES===== \n" + 
                                      "1. Modificar código \n" +
                                      "2. Modificar nombre \n" +
                                      "3. Modificar costo de fabrica \n" +
                                      "4. Modificar pecio de venta \n" +
                                      "5. Modificar categoria \n" +
                                      "0. ATRAS \n");
            opcion=(char) Integer.parseInt(inicio);
            switch (opcion) {
                case 1:
                    this.gestor.modifyCodigo();
                break;
                case 2:
                    this.gestor.modifyNombre();
                break;
                case 3:
                    this.gestor.modifyCostoFabrica();
                break;
                case 4:
                    this.gestor.modifyPrecioVenta();
                break;
                case 5:
                    this.gestor.modifyCategoria();
                break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Lo devolveremos al menú principal...");
                break;
                default:
                    JOptionPane.showMessageDialog(null,"Intenta otra vez esa opcion no existe."); 
                break;
            }
        }
        while(opcion!=0);
    }
}