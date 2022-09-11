package management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Clothe;

public class ManageClothes {
    //Variable de clase
    private String route;
    
    public ManageClothes(){
        this.route="./Archivos/misPrendas.txt";
        this.verifyFile();
    }

    private void verifyFile(){
        try{
            File filex=new File (this.route);
            if(!filex.exists()){       //si no existe el archivo 
                filex.createNewFile(); //lo crea
            }
        }
        
        catch (IOException ex){
            System.out.println("Problemas con la ruta...!!");
        }
    }
    
    public void newClothe(){
        String code;
        String name;
        float manufactoringCost;
        float salePrice;
        String collection;
        boolean exist;
        
        do{
            code = JOptionPane.showInputDialog("Digite código:");
        
            exist = this.codeExist(code);
            
            if (exist){
                JOptionPane.showMessageDialog(null, "El código ya existe!!! por favor digite otro código");
            }
        }while (exist);
        
        name = JOptionPane.showInputDialog("Digite nombre de la prenda: ");
        
        manufactoringCost = Float.parseFloat(JOptionPane.showInputDialog("Digite costo de fabricación:"));
        
        salePrice = Float.parseFloat(JOptionPane.showInputDialog("Digite costo de venta:"));

        while(salePrice < manufactoringCost){
            JOptionPane.showMessageDialog(null, "Costo no válido!! Recuerde: El costo de venta no puede ser mayor al costo de producción");
            
            salePrice = Float.parseFloat(JOptionPane.showInputDialog("Digite costo de venta nuevamente:"));
        }
        
        collection = JOptionPane.showInputDialog("Digite colección:");
        
        Clothe cloth = new Clothe(code, name, manufactoringCost, salePrice, collection);
        this.saveClothe (cloth);
    }
    
    private void saveClothe (Clothe cloth){
        try{
            File file=new File(this.route);
            
            FileWriter fr=new FileWriter(file, true);
            
            PrintWriter pw=new PrintWriter(fr);
            
            pw.println(cloth);
            
            pw.close();
            
            JOptionPane.showMessageDialog(null, "La operación ha sido exitosa!!!");
        }catch (IOException xxx){
            JOptionPane.showMessageDialog(null, "No se pudo guardar la prenda!!!");
        }
    }
    
    public void seeClothe (){
        String code;
        
        code = JOptionPane.showInputDialog("Digite el código que desea buscar:");
        
        Clothe cloth = this.searchClothe(code);
        
        if (cloth != null){
            System.out.println(cloth);
            System.out.println("================================================");
        }else {
            JOptionPane.showMessageDialog(null, "El código no existe!!");
        }
    }
    
    private Clothe searchClothe (String code){
        FileReader file;
        BufferedReader br;
        String register;
        Clothe cloth = null;

        try{
            file = new FileReader(this.route);
            
            br = new BufferedReader(file);
            
            while((register = br.readLine()) != null){
                String[] fields = register.split(",");
                if(fields[0].equals(code)){
                    cloth = new Clothe (fields [0], fields [1], Float.parseFloat(fields [2]), Float.parseFloat(fields[3]), fields [4]);
                    
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println("Fallo buscando prenda!!!");
        }
        
        return cloth;
    }
    
    public ArrayList <Clothe> getClothes(){ 
        FileReader file;
        BufferedReader br;
        String register;
        Clothe cloth = null;
        ArrayList<Clothe> clothes = new ArrayList<>();

        try{
            file = new FileReader (this.route);
            
            br = new BufferedReader(file);
            
            while((register = br.readLine()) != null){
                String[] fields = register.split(",");
                
                cloth = new Clothe (fields [0], fields [1], Float.parseFloat(fields [2]), Float.parseFloat(fields[3]), fields [4]);
                
                clothes.add(cloth);
            }
            
        }catch (IOException ex){
            System.out.println("Fallo!!!");
        }
        return clothes;
    }
    
    public void seeAll() {
        ArrayList <Clothe> clothes = this.getClothes();
        
        for (Clothe cloth : clothes){
            System.out.println(cloth);
        }

        System.out.println("====================================================");
    }
    
    public void modifyCode (){
        String code;
        String newCode;
        boolean exist = false;
        ArrayList <Clothe> clothes = this.getClothes();
        
        code=JOptionPane.showInputDialog("Digite el código que desea modificar:");
        
        for (Clothe cloth : clothes){
            if(cloth.getCode().equals(code)){
                do{
                    newCode = JOptionPane.showInputDialog("Digite el nuevo código");
                    exist = this.codeExist(newCode);
                    if(exist)
                        JOptionPane.showMessageDialog(null, "El código ya existe!!! por favor digite otro código");
                }while(exist);
                
                cloth.setCode(newCode);
                this.replaceFile(clothes);          
                JOptionPane.showMessageDialog(null, "El código se modifico correctamente!!!");
                exist = true;
                
                break;
            }
        }
        if (!exist)
            JOptionPane.showMessageDialog(null, "El código no existe");
    }
    
    public void modifyName (){
        String code;
        String newName;
        boolean exist = false;
        ArrayList <Clothe> clothes = this.getClothes();
        
        code = JOptionPane.showInputDialog("Digite el código de la prenda que desea modificarle el nombre:");
        
        for (Clothe cloth : clothes){
            if (cloth.getCode().equals(code)){
                newName = JOptionPane.showInputDialog("Digite el nuevo nombre");
                cloth.setName(newName);
                
                this.replaceFile(clothes);
                JOptionPane.showMessageDialog(null, "El nombre se modifico correctamente!!!");
                exist = true;
                
                break;
            }
        }
        if (!exist)
            JOptionPane.showMessageDialog(null, "El código no existe");
    }
    
    public void modifyManufactoringCost (){
        String code;
        float newMfC;
        boolean exist = false;
        ArrayList <Clothe> clothes = this.getClothes();
        
        code = JOptionPane.showInputDialog("Digite el código de la prenda que desea modificarle el costo de fabricación:");

        for (Clothe cloth : clothes){
            if (cloth.getCode().equals(code)){
                newMfC = Float.parseFloat(JOptionPane.showInputDialog("Digite el nuevo costo de fabricación:"));
                cloth.setManufactoringCost(newMfC);
                
                this.replaceFile(clothes);
                JOptionPane.showMessageDialog(null, "El costo de fabricación se modifico correctamente!!!");
                exist = true;
                
                break;
            }
        }
        if (!exist)
            JOptionPane.showMessageDialog(null, "El código no existe");
    } 
    
    public void modifySalePrice (){
        String code;
        float newSalePrice;
        boolean exist = false;
        ArrayList <Clothe> clothes = this.getClothes();
        
        code = JOptionPane.showInputDialog("Digite el código de la prenda que desea modificarle el precio de venta:");

        for (Clothe cloth : clothes){
            if (cloth.getCode().equals(code)){
                newSalePrice = Float.parseFloat(JOptionPane.showInputDialog("Digite el nuevo costo de venta:"));
                
                while (newSalePrice < cloth.getManufactoringCost()){
                    JOptionPane.showMessageDialog(null, "Costo de venta no válido!! Recuerde: El costo de venta no puede ser mayor al costo de producción");
                    newSalePrice = Float.parseFloat(JOptionPane.showInputDialog("Digite el costo de venta nuevamente:"));
                }
                
                cloth.setSalePrice(newSalePrice);
                
                this.replaceFile(clothes);
                JOptionPane.showMessageDialog(null, "El costo de venta se modifico correctamente!!!");
                exist = true;
                
                break;
            }
        }
        if (!exist)
            JOptionPane.showMessageDialog(null, "El código no existe");
    } 
    
    public void modifyCollection (){
        String code;
        String newCollection;
        boolean exist = false;
        ArrayList <Clothe> clothes = this.getClothes();
        
        code = JOptionPane.showInputDialog("Digite el código de la prenda que desea modificarle la colección:");
        
        for (Clothe cloth : clothes){
            if (cloth.getCode().equals(code)){
                newCollection = JOptionPane.showInputDialog("Digite la nueva colección para la prenda:");
                cloth.setCollection(newCollection);
                
                this.replaceFile(clothes);
                JOptionPane.showMessageDialog(null, "La colección se modifico correctamente!!!");
                exist = true;
                
                break;
            }
        }
        if (!exist)
            JOptionPane.showMessageDialog(null, "El código no existe");
    }
    
    public void deleteClothe (){
        String code;
        boolean exist = false;
        ArrayList <Clothe> clothes = this.getClothes();
        
        code = JOptionPane.showInputDialog("Digite el código de la prenda que desea eliminar:");
        for (Clothe cloth : clothes){
            if(cloth.getCode().equals(code)){
                clothes.remove (cloth);
                
                this.replaceFile (clothes);
                
                JOptionPane.showMessageDialog(null, "Se ha eliminado del registro la prenda de código: "+code);
                
                exist = true;
                break;
            }
        }
        if (!exist)
            JOptionPane.showMessageDialog(null, "El código no existe");
    }
            
    private void replaceFile (ArrayList <Clothe> clothes){
        try{
            File file=new File(route);
            
            FileWriter fr=new FileWriter(file, false);
            
            PrintWriter ps=new PrintWriter(fr);
            
            for(Clothe newCloth : clothes)
                ps.println(newCloth);
            ps.close();
        }catch (IOException cosito){
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el estudiante...!!!");
        }
    }
    
    public boolean atLeastOne (){
        FileReader file;
        BufferedReader br;
        String register;
        boolean exist = false;

        try{
            file=new FileReader(this.route);
            
            br=new BufferedReader(file);
            
            while((register = br.readLine()) != null){
                exist = true;
                break;
            }
        }catch(IOException ex){
            System.out.println("Fallo!!!");
        }
        return exist;
    }
    
    private boolean codeExist(String code){
        boolean exist=false;
        ArrayList<Clothe> clothes = this.getClothes();

        for (Clothe i : clothes){
            if(i.getCode().equals(code)){                
                exist=true;
                break;
            }
        }
        return exist;
    }
}
