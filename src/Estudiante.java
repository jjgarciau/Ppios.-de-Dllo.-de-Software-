public class Estudiante {
    private String nombres;
    private String apellidos;
    private String correo;
    private int idEpik;
    private String contraseña;
    private String tipoUsuario;
    
    public Estudiante(int idEpik, String nombres, String apellidos, String correo, String contraseña, String tipoUsuario) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.idEpik = idEpik;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }
    //Getters
    public int getIdEpik(){
        return idEpik;
    }
    public String getContraseña(){
        return contraseña;
    }
    public String getCorreo(){
        return correo;
    }
    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getTipoUsuario(){
        return tipoUsuario;
    }
    //Setters
    public void setIdEpik(int idEpik){
        this.idEpik = idEpik;
    }
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    public void setCorreoInstitucional(String correo){
        this.correo = correo;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public void setTipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    //Encriptar contraseña
    public void encriptarContraseña(){
        //Encriptar contraseña
    }
    public void inscribirReunion(Reunion reunion){
        //Inscribir a la reunión
    }
    public void salirReunion(Reunion reunion){
        //Salir de la reunión
    }
    //Actualizar la información del estudiante
    public void editarPerfil(){
        //Editar perfil del estudiante
    }
    //Actualizar información del estudiante
    public void actualizarInformacionEstudiante(){
        //Actualizar información del estudiante
    }
}
