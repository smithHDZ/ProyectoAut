package Aplicacion;
import java.io.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static Aplicacion.Proyecto2.TT;

public class LectorLexico {
    public static void main(String args[]) {
        File codigo = new File("C:\\Users\\jaher\\IdeaProjects" +
                "\\Automatas I\\src\\Aplicacion\\codigo.txt");
        //TblToken
        TT(codigo);
    }
    public static void TabladeTokens(File archivo){
        try{
            if (archivo.exists()){

                String tabla = "Token   Valor en Tabla  k   Linea \n";
                int linea = 1;
                String Line;
                BufferedReader leerarch = new BufferedReader(new FileReader(archivo));

                while((Line = leerarch.readLine()) != null){

                    StringTokenizer st = new StringTokenizer(Line);

                    while (st.hasMoreTokens()){
                        String st1 = st.nextToken();

                        try{
                            Float.parseFloat(st1);
                            if(st1.contains(".") && (st1.charAt(0) != '.')  && (st1.charAt(st1.length()-1) != '.')) {
                                tabla = tabla + st1 + ", -42, -1, " + linea + "\n";//ctn real
                            }else {
                                if(!st1.contains(".")) {
                                    tabla = tabla + st1 + ", -41, -1, " + linea + "\n";//ctn entera
                                }
                            }
                        }catch (Exception e){
                            switch (st1){
                                //Palabras Reservadas
                                case "if":
                                    tabla = tabla + st1 + ", -1, -1, " + linea + "\n";
                                    break;
                                case "else":
                                    tabla = tabla + st1 + ", -2, -1, " + linea + "\n";
                                    break;
                                case "read":
                                    tabla = tabla + st1 + ", -3, -1, " + linea + "\n";
                                    break;
                                case "readln":
                                    tabla = tabla + st1 + ", -4, -1, " + linea + "\n";
                                    break;
                                case "for":
                                    tabla = tabla + st1 + ", -5, -1, " + linea + "\n";
                                    break;
                                case "then":
                                    tabla = tabla + st1 + ", -6, -1, " + linea + "\n";
                                    break;

                                //Operadores Aritmeticos
                                case "+":
                                    tabla = tabla + st1 + ", -51, -1, " + linea + "\n";
                                    break;
                                case "-":
                                    tabla = tabla + st1 + ", -52, -1, " + linea + "\n";
                                    break;
                                case "*":
                                    tabla = tabla + st1 + ", -53, -1, " + linea + "\n";
                                    break;
                                case "/":
                                    tabla = tabla + st1 + ", -54, -1, " + linea + "\n";
                                    break;
                                case "++":
                                    tabla = tabla + st1 + ", -55, -1, " + linea + "\n";
                                    break;
                                case "--":
                                    tabla = tabla + st1 + ", -56, -1, " + linea + "\n";
                                    break;
                                case "%":
                                    tabla = tabla + st1 + ", -57, -1, " + linea + "\n";
                                    break;



                                //Operadores Relacionales
                                case ">":
                                    tabla = tabla + st1 + ", -61, -1, " + linea + "\n";
                                    break;
                                case "<":
                                    tabla = tabla + st1 + ", -62, -1, " + linea + "\n";
                                    break;
                                case ">=":
                                    tabla = tabla + st1 + ", -63, -1, " + linea + "\n";
                                    break;
                                case "<=":
                                    tabla = tabla + st1 + ", -64, -1, " + linea + "\n";
                                    break;
                                case "==":
                                    tabla = tabla + st1 + ", -65, -1, " + linea + "\n";
                                    break;
                                case "!=":
                                    tabla = tabla + st1 + ", -66, -1, " + linea + "\n";
                                    break;

                                //Simbolos de agrupacion
                                case "(":
                                    tabla = tabla + st1 + ", -71, -1, " + linea + "\n";
                                    break;
                                case ")":
                                    tabla = tabla + st1 + ", -72, -1, " + linea + "\n";
                                    break;
                                case "[":
                                    tabla = tabla + st1 + ", -73, -1, " + linea + "\n";
                                    break;
                                case "]":
                                    tabla = tabla + st1 + ", -74, -1, " + linea + "\n";
                                    break;
                                case "{":
                                    tabla = tabla + st1 + ", -75, -1, " + linea + "\n";
                                    break;
                                case "}":
                                    tabla = tabla + st1 + ", -76, -1, " + linea + "\n";
                                    break;

                                //Operadores Logicos
                                case "&&": //and
                                    tabla = tabla + st1 + ", -81, -1, " + linea + "\n";
                                    break;
                                case "||": //or
                                    tabla = tabla + st1 + ", -82, -1, " + linea + "\n";
                                    break;
                                case "!": //not
                                    tabla = tabla + st1 + ", -83, -1, " + linea + "\n";
                                    break;

                                case ";":
                                    break;

                                default:
                                    if(st1.charAt(0) != '"') {
                                        String palabra;
                                        if(st1.length() == 1){
                                            tabla = tabla + st1 + ", 24, -2, " + linea + "\n";
                                            break;
                                        } else {
                                            if(st1.length() == 2) {
                                                palabra = st1.substring(0,1);
                                            }else {
                                                palabra = st1.substring(0, st1.length()-2);
                                            }
                                        }
                                        if(palabra.matches("[a-zA-Z]{1,999}") && palabra.length() != 1){//ientificador
                                            char ultimo = st1.charAt(st1.length()-1);
                                            switch (ultimo){
                                                case '&'://enteros
                                                    tabla = tabla + st1 + ", -21, -2, " + linea + "\n";
                                                    break;
                                                case '%'://reales
                                                    tabla = tabla + st1 + ", -22, -2, " + linea + "\n";
                                                    break;
                                                case '$'://string
                                                    tabla = tabla + st1 + ", -23, -2, " + linea + "\n";
                                                    break;
                                                default:
                                                    tabla = tabla + st1 + ", -99, -1, " + linea + "\n";
                                                    break;
                                            }
                                        }else{//error
                                            tabla = tabla + st1 + ", -99, -1, " + linea + "\n";
                                        }
                                    }else {//constantes
                                        if(st1.charAt(0) == '"' && st1.charAt(st1.length()-1) == '"') {
                                            tabla = tabla + st1 + ", -43, -1, " + linea + "\n";//string
                                        }else {
                                            tabla = tabla + st1 + ", -99, -1, " + linea + "\n";
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                    linea++;
                    tabla = tabla +"\n";
                }
                System.out.println( "Tabla de tokens \n " + tabla);
                leerarch.close();
            }
            else{
                System.out.println("No existe el archivo");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}