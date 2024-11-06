public class Estudiante {
    private String nombres;
    private String apellidos;
    private String correoInstitucional;
    private int idEpik;
    private String contraseña;
    private String tipoUsuario;
    
    public Estudiante(String nombres, String apellidos, String correoInstitucional, int idEpik, String contraseña, String tipoUsuario) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoInstitucional = correoInstitucional;
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
    public String getCorreoInstitucional(){
        return correoInstitucional;
    }
    public String getNombres(){
        return nombres;
    }
    public String getApellidos(){
        return apellidos;
    }
    //Setters
    public void setIdEpik(int idEpik){
        this.idEpik = idEpik;
    }
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    public void setCorreoInstitucional(String correoInstitucional){
        this.correoInstitucional = correoInstitucional;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
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
