package Aplicacion;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*** @author  ***/

public class Tabla {
// frame
    JFrame f;
// Table
    JTable j;
    ArrayList<String> dato = new ArrayList<String>();
    ArrayList<String> variables = new ArrayList<String>();
    List<Integer> numeroVar = new ArrayList<>();
// Constructor
    Tabla() throws Exception
    {
        try{
// Open the file that is the first
// command line parameter
            FileInputStream fstream = new FileInputStream("C:/Users/oscar/OneDrive/Escritorio/TablaSimbolos.txt");
// Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
//Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                String[] delims = strLine.split(":");
                for(int i = 0; i < delims.length;);
                {
                    dato.add(delims[i]);
                    break;
                    String reverse = "";
                    for(int i = strLine.length() - 1; i >= 0; i--)
                    {
                        reverse = reverse + strLine.charAt(i);
                    }
                    String[] subdelims = reverse.split(" ");
                    String reverse2 = "";
                    for(int i = subdelims[0].length() - 1; i >= 0; i--)
                    {
                        reverse2 = reverse2 + subdelims[0].charAt(i);
                    }
                    String[] subdelims2 = reverse2.split(";");
                    System.out.print(subdelims2[0]);
                    for(int i = 0; i < subdelims2.length;);
                    {
                        ArrayList<String> variable = new ArrayList<>(Arrays.asList(subdelims2[i].split(",")));
                        numeroVar.add(variable.size());
                        for (int index = 0; index < variable.size(););
                        {
                            variables.add(variable.get(index));
                            index++;
                        }
                        break;
                    }
                }
//Close the input stream
                in.close();
            }catch (Exception e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
// Frame initialization
            f = new JFrame();
// Frame Title

            f.setTitle("JTable Example");

// Column Names

            String[] columnNames = {"# Consecutivo", "Identificador", "Tipo de dato", "Valor inicial"};

            Object[][] data = new Object [variables.size()][4];

            int contador = 0;

            for (int index = 0; index<dato.size(); index++)

            {

                for (int i=0; i<numeroVar.get(index); i++)

                {

                    data[contador][0] = contador+1;

                    data[contador][1] = variables.get(contador);

                    data[contador][2] = dato.get(index);

                    char a = dato.get(index).charAt(0);

                    if (a == 'E')

                    {

                        data[contador][3] = "0";

                    }

                    else

                    if (a == 'R')

                    {

                        data[contador][3] = "0.0";

                    }

                    else

                    if (a == 'L')

                    {

                        data[contador][3] = "false";

                    }

                    else

                    if (a == 'C')

                    {

                        data[contador][3] = "null";

                    }

                    contador++;

                }

            }

// Initializing the JTable

            j = new JTable(data, columnNames);

            j.setBounds(30, 40, 200, 300);

// adding it to JScrollPane

            JScrollPane sp = new JScrollPane(j);

            f.add(sp);

// Frame Size

            f.setSize(500, 200);

// Frame Visible = true

            f.setVisible(true);

        }

    }
}
