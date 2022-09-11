package start;

import management.ManageClothes;
import javax.swing.JOptionPane;

public class Principal {
    //Variables de clase
    private ManageClothes manager;
    
    public static void main(String[] x){
        new Principal();
    }
    public Principal(){
        this.manager = new ManageClothes();
        this.menu();
    }
    
    private void menu(){
        String menuOptions;
        char option;
        
        do{
            menuOptions = JOptionPane.showInputDialog("=====OPCIONES===== \n" + 
                                    "1. Agregar prenda \n" +
                                    "2. Buscar prenda \n" +
                                    "3. Ver todas las prendas \n" +
                                    "4. Modificar atributos de una prenda\n" +
                                    "5. Eliminar prenda\n" +
                                    "0. SALIDA \n");
            option = (char) Integer.parseInt(menuOptions);
            switch (option){
                case 1 -> {
                    //agrega prenda
                    this.manager.newClothe();
                }
                case 2 -> {
                    //busca prenda
                    if (this.manager.atLeastOne()){
                        this.manager.seeClothe();
                    }else {
                        JOptionPane.showMessageDialog(null, "Aún no hay prendas");
                    }
                }
                case 3 -> {
                    //muestra todas las prendas
                    if (this.manager.atLeastOne()){
                        this.manager.seeAll();
                    }else {
                        JOptionPane.showMessageDialog(null, "Aún no hay prendas");
                    }
                }
                case 4 -> {
                    //modifica prenda
                    if (this.manager.atLeastOne()){
                        this.modifiersMenu();
                    }else {
                        JOptionPane.showMessageDialog(null, "Aún no hay prendas");
                    }
                }
                case 5 -> {
                    //elimina prenda
                    if (this.manager.atLeastOne()){
                        this.manager.deleteClothe();
                    }else {
                        JOptionPane.showMessageDialog(null, "Aún no hay prendas");
                    }
                }
                case 0 -> {
                    //salida
                    JOptionPane.showMessageDialog(null,"Nos veremos luego, gracias por participar");
                }
                default -> {
                    //opcion no existe
                    JOptionPane.showMessageDialog(null,"Intenta otra vez esa opcion no existe."); 
                }
            }
        }while(option != 0);
    }
    
    private void modifiersMenu(){
        String menuOptions;
        char option;
        
        do{
            menuOptions = JOptionPane.showInputDialog("=====OPCIONES===== \n" + 
                                    "1. Modificar código \n" +
                                    "2. Modificar nombre \n" +
                                    "3. Modificar costo de fabrica \n" +
                                    "4. Modificar precio de venta \n" +
                                    "5. Modificar coleccion \n" +
                                    "0. ATRAS \n");
            option = (char) Integer.parseInt(menuOptions);
            switch (option){
                case 1 -> {
                    //modifica codigo
                    this.manager.modifyCode();
                }
                case 2 -> {
                    //modifica nombre
                    this.manager.modifyName();
                }
                case 3 -> {
                    //modifica costo de fabrica
                    this.manager.modifyManufactoringCost();
                }
                case 4 -> {
                    //modifica precio de venta
                    this.manager.modifySalePrice();
                }
                case 5 -> {
                    //modifica coleccion
                    this.manager.modifyCollection();
                }
                case 0 -> {
                    //vuelve a menu principal
                    JOptionPane.showMessageDialog(null,"Lo devolveremos al menú principal...");
                }
                default -> {
                    //opcion no existe
                    JOptionPane.showMessageDialog(null,"Intenta otra vez esa opcion no existe"); 
                }
            }
        }while (option != 0);
    }
}
