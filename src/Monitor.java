public class Monitor extends Estudiante{
    private String Materia;
    public Monitor(String nombres, String apellidos, String correoInstitucional, int idEpik, String contraseña, String tipoUsuario, String Materia) {
        super(nombres, apellidos, correoInstitucional, idEpik, contraseña, tipoUsuario);
        this.Materia = Materia;
    }

    public String getMateria(){
        return Materia;
    }
    
    public void setMateria(String Materia){
        this.Materia = Materia;
    }
    
    
}
