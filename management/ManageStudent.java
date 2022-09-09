import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
*
* @author Sergio
*/
public class GestionEstudiantes{
    ///Variable de clase
    private String ruta;

    public GestionEstudiantes()
    {
        this.ruta="./Archivos/misEstudiantes.txt";
        this.verificArchivo ();
    }

    private void verificArchivo(){
        try{
            File filex=new File (this.ruta);
            if(!filex.exists()){       //si no existe el archivo 
                filex.createNewFile(); //lo crea
            }
        }
        catch (IOException ex){
            System.out.println("Problemas con la ruta...!!");
        }
    }

    public void nuevoEstudiante(){
        String cod;
        String nom;
        char gen;
        float note;
        boolean esta;

        do{
            cod=JOptionPane.showInputDialog("Digite código:");
            esta=this.existeCodigo(cod);
            if(esta){
                JOptionPane.showMessageDialog(null, "El código ya existe!!! por favor digite otro código");
            }
        }while (esta);

        nom=JOptionPane.showInputDialog("Digite nombre:");
        gen=Character.toUpperCase(JOptionPane.showInputDialog("Digite genero:").charAt(0));
        switch(gen){
            case 'M':
                JOptionPane.showMessageDialog(null, "El genero se guardo como: masculino");
            break;
            case 'F':
                JOptionPane.showMessageDialog(null, "El genero se guardo como: femenino");
            break;
            case 'O':
                JOptionPane.showMessageDialog(null, "El genero se guardo como: otro");
            break;
            default:
                while(gen!='M'|| gen!='F'|| gen!='O'){
                    JOptionPane.showMessageDialog(null, "Genero no valido!! recuerde: Masculino, Femenino, Otro");
                    gen=Character.toUpperCase(JOptionPane.showInputDialog("Digite genero:").charAt(0));
                    if(gen=='M'|| gen=='F'|| gen=='O') break;
                }
            break;
        }
        note=Float.parseFloat(JOptionPane.showInputDialog("Digite nota:"));
        while(note<0 || note>5){
            JOptionPane.showMessageDialog(null, "Nota no valida!! recuerde: NO valores negativos ni mayores de 5");
            note=Float.parseFloat(JOptionPane.showInputDialog("Digite la nota nuevamente:"));
        }
        Estudiante student=new Estudiante(cod,nom,gen,note);
        this.guardaEstudiante(student);
    }

    private void guardaEstudiante(Estudiante student){
        try{
            File file=new File(this.ruta);
            FileWriter fr=new FileWriter(file, true);
            PrintWriter pw=new PrintWriter(fr);
                pw.println(student);
            pw.close();
            JOptionPane.showMessageDialog(null, "La operacion ha sido exitosa!!!");
        }
        catch(IOException xxx){
            JOptionPane.showMessageDialog(null, "No se pudo guardar el estudiante!!!");
        }
    }

    public void verEstudiante (){
        String code;
        code=JOptionPane.showInputDialog("Digite el código que desea buscar:");
        Estudiante stud=this.buscaEstudiante(code);

        if(stud!=null){
            System.out.println(stud);
            System.out.println("=================================");
        }else{
            JOptionPane.showMessageDialog(null, "El código no existe!!");
        }
    }
    
    private Estudiante buscaEstudiante(String code){
        FileReader file;
        BufferedReader br;
        String registro;
        Estudiante stud=null;

        try{
            file=new FileReader(this.ruta);
            br=new BufferedReader(file);
            while((registro=br.readLine())!=null){
                String[] campos=registro.split(",");
                if(campos[0].equals(code)){
                    stud=new Estudiante(campos[0], campos[1],campos[2].charAt(0),Float.parseFloat(campos[3]));
                    break;
                }
            }
        }catch(IOException ex){
            System.out.println("Fallo buscando estudiante!!!");
        }
        return stud;
    }
    
    public ArrayList<Estudiante> getEstudiantes(){
        FileReader file;
        BufferedReader br;
        String registro;
        Estudiante stud=null;
        ArrayList<Estudiante> students=new ArrayList<>();

        try{
            file=new FileReader(this.ruta);
            br=new BufferedReader(file);
            while((registro=br.readLine())!=null){
                String[] campos=registro.split(",");
                stud=new Estudiante(campos[0], campos[1],campos[2].charAt(0),Float.parseFloat(campos[3]));
                students.add(stud);
            }
        }catch(IOException ex){
            System.out.println("Fallo buscando estudiante!!!");
        }
        return students;
    }

    public void verTodos() {
        
        ArrayList<Estudiante> students=this.getEstudiantes();

        for (Estudiante stud : students){
            System.out.println(stud);
        }
        System.out.println("=================================");
    }

    public void modifyCodigo() {
        String code,newDato;
        boolean existe=false;
        ArrayList<Estudiante> studes=this.getEstudiantes();

        code=JOptionPane.showInputDialog("Digite el código que desea modificar:");
        for (Estudiante stud : studes){
            if(stud.getCodigo().equals(code)){
                do{
                    newDato=JOptionPane.showInputDialog("Digite el nuevo dato");
                    existe=this.existeCodigo(newDato);
                    if(existe)
                        JOptionPane.showMessageDialog(null, "El código ya existe!!! por favor digite otro código");
                }while(existe);
                
                stud.setCodigo(newDato);
                this.reemplazArchivo(studes);          
                JOptionPane.showMessageDialog(null, "El código se modifico correctamente!!!");
                existe=true;
                break;
            }
        }
        if (!existe)
            JOptionPane.showMessageDialog(null, "El código no existe");
    }

    public void modifyNombre() {
       
        String code,newDato;
        boolean existe=false;
        ArrayList<Estudiante> students=this.getEstudiantes();

        code=JOptionPane.showInputDialog("Digite el código del estudiante que desea modificarle el nombre:");
        for (Estudiante stud : students){
            if(stud.getCodigo().equals(code)){
                newDato=JOptionPane.showInputDialog("Digite el nuevo nombre");
                stud.setNombre(newDato);
                this.reemplazArchivo(students);
                JOptionPane.showMessageDialog(null, "El nombre se modifico correctamente!!!");
                existe=true;
                break;
            }
        }
        if (!existe)
            JOptionPane.showMessageDialog(null, "El código no existe");
    }
    
    public void modifyGenero() {
        String code;
        char newDato;
        boolean existe=false;
        ArrayList<Estudiante> students=this.getEstudiantes();

        code=JOptionPane.showInputDialog("Digite el código del estudiante que desea modificarle el genero:");
        for (Estudiante stud : students){
            if(stud.getCodigo().equals(code)){
                newDato=Character.toUpperCase(JOptionPane.showInputDialog("Digite el nuevo genero").charAt(0));
                switch(newDato){
                    case 'M':
                        JOptionPane.showMessageDialog(null, "El genero se guardo como: masculino");
                    break;
                    case 'F':
                        JOptionPane.showMessageDialog(null, "El genero se guardo como: femenino");
                    break;
                    case 'O':
                        JOptionPane.showMessageDialog(null, "El genero se guardo como: otro");
                    break;
                    default:
                        while(newDato!='M'|| newDato!='F'|| newDato!='O'){
                            JOptionPane.showMessageDialog(null, "Genero no valido!! recuerde: Masculino, Femenino, Otro");
                            newDato=Character.toUpperCase(JOptionPane.showInputDialog("Digite el nuevo genero:").charAt(0));
                            if(newDato=='M'|| newDato=='F'|| newDato=='O') break;
                        }
                    break;
                }
                stud.setGenero(newDato);
                this.reemplazArchivo(students);
                JOptionPane.showMessageDialog(null, "El genero se modifico correctamente!!!");
                existe=true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "El código no existe");
        
    }

    public void modifyNota() {
        String code;
        float newDato;
        boolean existe=false;
        ArrayList<Estudiante> students=this.getEstudiantes();

        code=JOptionPane.showInputDialog("Digite el código del estudiante que desea modificarle la nota:");
        for (Estudiante stud : students){
            if(stud.getCodigo().equals(code)){
                newDato=Float.parseFloat(JOptionPane.showInputDialog("Digite la nueva nota"));
                while(newDato<0 || newDato>5){
                    JOptionPane.showMessageDialog(null, "Nota no valida!! recuerde: NO valores negativos ni mayores de 5");
                    newDato=Float.parseFloat(JOptionPane.showInputDialog("Digite la nota nuevamente:"));
                }
                stud.setNota(newDato);
                this.reemplazArchivo(students);
                existe=true;
                break;
            }
        }
        if (!existe) 
            JOptionPane.showMessageDialog(null, "El código no existe");
    }

    public void eliminarEstudiante() {
        String code;
        boolean existe=false;
        ArrayList<Estudiante> students=this.getEstudiantes();

        code=JOptionPane.showInputDialog("Digite el código del estudiante que desea eliminar:");
        for (Estudiante stud : students){
            if(stud.getCodigo().equals(code)){
                students.remove(stud);
                this.reemplazArchivo(students);
                JOptionPane.showMessageDialog(null, "Se ha eliminado del registro el estudiante de código: "+code);
                existe=true;
                break;
            }
        }
        if (!existe)
            JOptionPane.showMessageDialog(null, "El código no existe");       
    }

    private void reemplazArchivo(ArrayList<Estudiante> students){
        try{
            File file=new File(ruta);
            FileWriter fr=new FileWriter(file, false);
            PrintWriter ps=new PrintWriter(fr);
            for(Estudiante elstudent:students)
                ps.println(elstudent);
            ps.close();
        }catch (IOException cosito){
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el estudiante...!!!");
        }
    }

    private boolean existeCodigo(String code){
        boolean existe=false;
        ArrayList<Estudiante> students=this.getEstudiantes();

        for (Estudiante stud : students){
            if(stud.getCodigo().equals(code)){                
                existe=true;
                break;
            }
        }
        return existe;
    }

    public boolean hayEstudiantes(){
        
        FileReader file;
        BufferedReader br;
        String registro;
        boolean hay=false;

        try{
            file=new FileReader(this.ruta);
            br=new BufferedReader(file);
            while((registro=br.readLine())!=null){
                hay=true;
                break;
            }
        }catch(IOException ex){
            System.out.println("Fallo buscando estudiante!!!");
        }
        return hay;
    }
}