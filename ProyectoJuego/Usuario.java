import java.util.Scanner;

public class Usuario {
    //Atributos de la clase
    private int usuarioInt = 0;
    private String usuarioSt;
    Scanner sc = new Scanner(System.in);

	//Constructor de la clase
	public Usuario() {}
	

    //Métodos de la clase
    public boolean compruebaUsuario() //Este método sirve para comprar si existe un usuario ya creado, usuarioInt = 1, o si no existe ninguno, usuarioInt = 0
    {
        if (usuarioInt == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void creaUsuarioNuevo() //Este método crea un nuevo usuario en la variable usuarioSt (String)
    {
        System.out.println("Introduzca el nombre deseado para su usuario a continuación");
        usuarioSt = sc.nextLine();
        usuarioInt = 1;
    }

    public String modificaUsuario (string usuario) //Este método no se si me sirve para algo xD
    {
        this.usuarioSt = usuario;
    }

    public String obtenDatosUsuario() //Este método devuelve el nombre del usuario cuando se le consulta por el
    {
        return usuarioSt;
    }

    public void creaOtroUsuario() //Este método sirve para crear otro usuario distinto al primero
    {
        System.out.println("Introduzca a continuación el nombre de su nuevo usuario.");
        usuarioSt = sc.nextLine();
        usuarioInt = 1;
    }

    public String obtenOtroUsuario() //Este método devuelve el nombre del nuevo usuario cuando se le consulta por el
    {
        return usuarioSt;
    }
}
