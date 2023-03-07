package Aplicacion;
import java.io.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LectorLexico {
    public static void main (String args []) {
        File codigo = new File("C:\\Users\\jaher\\IdeaProjects" +
                "\\Automatas I\\src\\Aplicacion\\codigo.txt");
        //TblToken
        TT(codigo);
    }
    }
}
