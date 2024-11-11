public class Administrador extends Estudiante{
    public Administrador(int idEpik ,String nombres, String apellidos, String correoInstitucional, String contraseña, String tipoUsuario) {
        super(idEpik, nombres, apellidos, correoInstitucional, contraseña, tipoUsuario);
    }
    public void cambiarTipoUsuario(Estudiante estudiante){
        //Cambiar el rol del estudiante
    }
    
}
