import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * Esta clase analiza el archivo log donde se guarda la fecha en la que se han hecho 
 * accesos al servidor
 *
 * @author Fran Alvarez
 * @version 1.0
 * @since 2018-23-02
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> coleccionAccesos;
    /**
     * Constructor for objects of class AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor()
    {
        coleccionAccesos = new ArrayList<>();
    }

    /**
     * Lee y analiza un archivo.log
     *
     * @param  nombre Nombre del archivo que sera leido.
     */
    public void analizarArchivoDeLog(String nombre)
    {
        try {
            File archivo = new File(nombre);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(" ");
                Acceso nuevoAcceso = new Acceso(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]),
                        Integer.parseInt(partes[2]), Integer.parseInt(partes[3]), Integer.parseInt(partes[4]));
                coleccionAccesos.add(nuevoAcceso);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int obtenerHoraMasAccesos()
    {
        int numeroADevolver = -1;
        int contador2 = 0;
        for (int i = 0; coleccionAccesos.size() > i; i++)
        {
            int primerNum = coleccionAccesos.get(i).getHora();
            int contador = 0;
            for (int j = 0; coleccionAccesos.size() > j; j++)
            {
                int numAComparar = coleccionAccesos.get(j).getHora();
                if (numAComparar == primerNum)
                {
                    contador ++;
                    if (contador > contador2 )
                    {
                        numeroADevolver = primerNum;
                        contador2 = contador;
                    }
                }
                if (contador == contador2 && primerNum > numeroADevolver)
                {
                    numeroADevolver = numAComparar;
                    contador2 = contador;
                }
            }
        }
        if (coleccionAccesos.size()==0)
        {
            System.out.println("No hay ningun registro");
        }
        else
        {
            coleccionAccesos.clear();
        }
        return numeroADevolver;
    }
}