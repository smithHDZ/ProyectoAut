package Aplicacion;
import java.io.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


/*** @author ***/

public class Proyecto2 {
    public static void main (String args[]) {
        File codigo = new File ("C:\\Users\\jaher\\IdeaProjects" +
                "\\Automatas I\\src\\Aplicacion\\codigo.txt");
        //TblToken
        TT(codigo);
    }

    public static void TT(File codigo) {
        try{
            if (codigo.exists()){

                String tablaDeToken = "Cadena        Token      posicion       Linea \n";
                int linea = 1;
                String Linea;

                BufferedReader LectorDeArchivo = new BufferedReader(new FileReader(codigo));

                while((Linea = LectorDeArchivo.readLine()) != null){

                    StringTokenizer Token = new StringTokenizer(Linea);

                    while (Token.hasMoreTokens()) {
                        String caracterPorComparar = Token.nextToken();


                        //PALABRAS RESERVADAS
                        if (caracterPorComparar.equalsIgnoreCase("if")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                      -1,              -1,                    " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("else")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -2,              -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("for")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                      -3,              -1,                   " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("while")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                      -4,              -1,                   " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("do")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                      -5,              -1,                   " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("swich")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                      -6,              -1,                   " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("case")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                      -7,              -1,                   " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("break")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                      -8,              -1,                   " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("read")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                      -9,              -1,                   " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("readln")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -10,              -1,                    " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("then")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                -11,             -1,                      " + linea + "\n";
                        }

                        //Simbolos de Puntuacion
                        else if (caracterPorComparar.equalsIgnoreCase("(")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                     -71,             -1,                      " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase(")")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                     -72,             -1,                      " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("[")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -73,             -1,                      " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("]")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -74,             -1,                      " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("{")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -75,             -1,                   " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("}")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -76,             -1,                   " + linea + "\n";
                        }

                        //Operadores Aritmeticos
                        else if (caracterPorComparar.equalsIgnoreCase("+")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -51,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("-")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -52,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("*")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -53,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("/")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -54,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("%")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -55,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("=")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -56,             -1,                  " + linea + "\n";
                        }

                        //Operadores Relacionales
                        else if (caracterPorComparar.equalsIgnoreCase(">")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                     -61,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("<")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                     -62,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase(">=")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                     -63,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("<=")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                     -64,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("==")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                     -65,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("!=")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                     -66,             -1,                  " + linea + "\n";
                        }

                        //Operadores Logicos
                        else if (caracterPorComparar.equalsIgnoreCase("&&")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                   -81,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("||")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -82,             -1,                  " + linea + "\n";
                        } else if (caracterPorComparar.equalsIgnoreCase("!")) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -83,             -1,                  " + linea + "\n";
                        }else if (caracterPorComparar.charAt(0) >= 'a' && caracterPorComparar.charAt(0) <= 'z') {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",               -21,             -2,                    " + linea + "\n";
                        } else if (caracterPorComparar.length() < 10 ) {
                            tablaDeToken = tablaDeToken + caracterPorComparar + ",                    -41,             -2,                  " + linea + "\n";
                        }

                    }
                    linea++;
                    tablaDeToken = tablaDeToken +"\n";
                }
                JOptionPane.showMessageDialog(null, tablaDeToken);

                LectorDeArchivo.close();
            }
            else{
                JOptionPane.showInternalMessageDialog(null," NO existe o No encunetro el documento");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

