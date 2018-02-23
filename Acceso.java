
/**
 * Esta clase representa un unico acceso al servidor
 *
 * @author Fran Alvarez
 * @version 1.0
 * @since 2018-23-02
 */
public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    /**
     * Constructor for objects of class Acceso
     */
    public Acceso(int ano, int mes, int dia, int hora, int minutos)
    {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }
    
    /**
     * Metodo getter del campo hora
     * @return int hora
     */
    public int getHora()
    {
        return hora;
    }
}
