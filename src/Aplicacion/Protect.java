package Aplicacion;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//El proyeto tiene como entrada un archivo llamado readme y da como salida la cantidad
//de parrafos que contiene
public class Protect {
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        String contador;
        File archivo = new File ("C:\\Users\\jaher\\IdeaProjects\\Automatas I\\src\\Aplicacion\\readme.txt");
        FileReader flujoEntrada = new FileReader(archivo);
        BufferedReader entrada = new BufferedReader(flujoEntrada);
        int i=0;
        while ((contador = entrada.readLine()) != null){
            i++;
        }
        System.out.println("Numero de lineas  \n" +
                          "en el arcivo es de : "+ i);

    }
}
