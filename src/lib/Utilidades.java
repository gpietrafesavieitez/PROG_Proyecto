package lib;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Utilidades {
    
    public static boolean validar(String texto) throws FileNotFoundException, IOException{
        // Primero comprueba si no esta vacio ni tiene numeros
        if(texto.matches("^[a-zA-Z]+$") && !(texto.isBlank() && texto.isEmpty())){
            // Segundo comprueba si el index esta creado y sino lo crea
            File f = new File("save/index");
            if(!f.exists()){
                f.createNewFile();
            }
            Scanner sc = new Scanner(f);
            // Tercero comprueba si existe un pj con el mismo nombre
            while(sc.hasNextLine()){
                String[] personaje = sc.nextLine().split(":");
                for(int i = 0; i < personaje.length; i ++){
                    if(texto.equalsIgnoreCase(personaje[i])){
                        JOptionPane.showMessageDialog(null, "Ya existe ese nombre, elige otro.", "RPGame", 2);
                        return false;
                    }
                }
            }
            return true; // Si todo esta ok da luz verde
        }else{
            JOptionPane.showMessageDialog(null, "Introduce un nick válido.", "RPGame", 2);
            return false;
        }
    }
}