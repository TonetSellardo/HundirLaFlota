public class Clinica
{
    public Clinica() {}
    
    private float IMC;
    private String estadoPaciente;
    
    public void calculaIMC(float peso, float altura)
    {
        this.IMC = peso / (altura * altura);
    }
    
    public String calculaEstado(String nombre)
    {
        if (IMC < 16) {estadoPaciente = "El estado nutricional del paciente " + nombre + " es : Desnutrición grado 3";}
        if (IMC >= 16 && IMC < 17) {estadoPaciente = "El estado nutricional del paciente " + nombre + " es : Desnutrición grado 2";}
        if (IMC >= 17 && IMC < 18.5) {estadoPaciente = "El estado nutricional del paciente " + nombre + " es : Desnutrición grado 1";}
        if (IMC >= 18.5 && IMC < 25) {estadoPaciente = "El estado nutricional del paciente " + nombre + " es : Normal";}
        if (IMC >= 25 && IMC < 30) {estadoPaciente = "El estado nutricional del paciente " + nombre + " es : Sobrepeso grado 1";}
        if (IMC >= 30 && IMC < 40) {estadoPaciente = "El estado nutricional del paciente " + nombre + " es : Sobrepeso grado 2";}
        if (IMC > 40) {estadoPaciente = "El estado nutricional del paciente " + nombre + " es : Sobrepeso grado 3";}
        return estadoPaciente;
    }
}