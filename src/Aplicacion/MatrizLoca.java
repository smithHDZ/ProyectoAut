package Aplicacion;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class MatrizLoca {
    public static void main(String[] args) {
        int[][] matriz = new int[10][5];
        Scanner teclado = new Scanner(System.in);
        char caracter;
        int vocales, renglon, valor;
        boolean exito = false;
        String mensaje = "";

        Random aleatorio = new Random();
        for(int i = 0; i < matriz.length; i++)
        {
            for(int j = 0; j < matriz[0].length; j++)
            {
                matriz[i][j] = aleatorio.nextInt(0,11);
            }
        }

        for(int i = 0; i < matriz.length; i++)
        {
            for(int j = 0; j < matriz[0].length; j++)
            {
                mensaje += matriz[i][j] + "  ";
            }
            mensaje += "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);

        String cadena = JOptionPane.showInputDialog(null,
                "Dame la cadena del texto");
        renglon = 0;
        for(int i = 0; i < cadena.length(); i++)
        {
            caracter = cadena.charAt(i);
            switch (caracter) {
                case 'a':
                    vocales = 0;
                    break;
                case 'e':
                    vocales = 1;
                    break;
                case 'i':
                    vocales = 2;
                    break;
                case 'o':
                    vocales = 3;
                    break;
                case 'u':
                    vocales = 4;
                    break;
                default:
                    vocales = -1;
                    break;
            }

            if(vocales >= 0){
                valor = matriz[renglon][vocales];
                if(valor == 10){
                    JOptionPane.showMessageDialog(null,
                            "El valor 10 se encontro en el renglon "
                                    +   (renglon + 1));
                    exito = true;
                    break;
                } else{
                    JOptionPane.showMessageDialog(null,
                            "Valor:  " + valor +
                                    " Reglon:  " + (renglon + 1));
                    if(renglon < 10){
                        renglon++;
                    } else{
                        renglon = 0;
                    }
                }
            }
        }

        if (!exito) {
            JOptionPane.showMessageDialog(null,
                    "No fue hallado el valor 10");

        }
    }
}
