public class Administrador extends Estudiante{
    public Administrador(String nombres, String apellidos, String correoInstitucional, int idEpik, String contraseña, String tipoUsuario) {
        super(nombres, apellidos, correoInstitucional, idEpik, contraseña, tipoUsuario);
    }
    public void cambiarTipoUsuario(Estudiante estudiante){
        //Cambiar el rol del estudiante
    }
    
}
