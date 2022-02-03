import java.util.Scanner;
import java.lang.Integer;

public class Paciente
{
    public Paciente() {}
    
    Scanner sc = new Scanner(System.in);
    Clinica consulta = new Clinica();
    
    private int numeroPacientes = 0; 
    private String nombrePaciente;
    private int edadPaciente;
    private float pesoPaciente;
    private float estaturaPaciente;
    
    public void preguntaPacientes()
    {
        System.out.println("¿Cuantos pacientes desea introducir en la consulta?");
        this.numeroPacientes = sc.nextInt();
    }
    
    public int obtenPacientes()
    {
        this.numeroPacientes = numeroPacientes;
        return numeroPacientes;
    }
    
    public void obtenDatos(int contador)
    {
        contador = contador + 1;
        System.out.println("¿Como se llama el paciente nº " + contador + "?");
        this.nombrePaciente = sc.nextLine();
        System.out.println("¿Cual es la edad del paciente " + nombrePaciente + "?");
        this.edadPaciente = sc.nextInt();
        System.out.println("¿Cual es el peso del paciente " + nombrePaciente + "?");
        this.pesoPaciente = sc.nextFloat();
        System.out.println("¿Cual es la estatura del paciente " + nombrePaciente + "?");
        this.estaturaPaciente = sc.nextFloat();
    }
    
    public void muestraDatos()
    {
        consulta.calculaIMC(pesoPaciente, estaturaPaciente);
        System.out.println(consulta.calculaEstado(nombrePaciente));
    }
    
    public String getNombre()
    {
        return nombrePaciente;
    }
    
    public int getEdad()
    {
        return edadPaciente;
    }
    
    public float getPeso()
    {
        return pesoPaciente;
    }
    
    public float getEstatura()
    {
        return estaturaPaciente;
    }
}