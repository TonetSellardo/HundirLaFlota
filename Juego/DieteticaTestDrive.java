public class DieteticaTestDrive
{
    public static void main (String [] args)
    {
        Paciente nuevoPaciente = new Paciente();
        
        int pacientesTotales;
        float pesoMedioPacientes = 0;
        float estaturaMediaPacientes = 0;
        int edadMinima = 200; 
        int edadMaxima = 0;
        
        nuevoPaciente.preguntaPacientes();
        pacientesTotales = nuevoPaciente.obtenPacientes();
        Paciente [] miPaciente = new Paciente[pacientesTotales];
        
        for (int i = 0; i < pacientesTotales; i++)
        {
            miPaciente[i] = new Paciente();
            miPaciente[i].obtenDatos(i);
            miPaciente[i].muestraDatos();
        }
        
        for (int i = 0; i < pacientesTotales; i++)
        {
            pesoMedioPacientes = pesoMedioPacientes + miPaciente[i].getPeso();
            estaturaMediaPacientes = estaturaMediaPacientes + miPaciente[i].getEstatura();
            if (miPaciente[i].getEdad() < edadMinima)
            {
                edadMinima = miPaciente[i].getEdad();
            }
            else
            {
                edadMinima = edadMinima;
            }
            if (miPaciente[i].getEdad() > edadMaxima)
            {
                edadMaxima = miPaciente[i].getEdad();
            }
            else
            {
                edadMaxima = edadMaxima;
            }
        }
        pesoMedioPacientes = pesoMedioPacientes / pacientesTotales;
        estaturaMediaPacientes = estaturaMediaPacientes / pacientesTotales;
        
        System.out.println("La edad mínima de los pacientes es: " + edadMinima + " y la edad máxima es: " + edadMaxima);
        System.out.println("El peso medio de todos los pacientes es: " + pesoMedioPacientes);
        System.out.println("La estatura media de todos los pacientes es: " + estaturaMediaPacientes);
    }
}