public class Monitor extends Estudiante{
    private String materia;

    public Monitor(int idEpik, String nombres, String apellidos, String correoInstitucional, String contraseña, String tipoUsuario, String materia) {
        super(idEpik ,nombres, apellidos, correoInstitucional, contraseña, tipoUsuario);
        this.materia = materia;
    }

    public String getMateria(){
        return materia;
    }
    
    public void setMateria(String materia){
        this.materia = materia;
    }
}
