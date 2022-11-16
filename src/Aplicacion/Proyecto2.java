package Aplicacion;
import java.io.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/*** @author ***/

public class Proyecto2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        String contador;
        File archivo = new File ("C:\\Users\\jaher\\IdeaProjects\\Automatas I\\src\\Aplicacion\\codigo.txt");
        FileReader flujoEntrada = new FileReader(archivo);
        BufferedReader entrada = new BufferedReader(flujoEntrada);
        int i=0;
        while ((contador = entrada.readLine()) != null){
            i++;
        }
    }

    }
