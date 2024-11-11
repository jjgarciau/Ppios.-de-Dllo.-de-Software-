public class Monitor extends Estudiante{
    private String Materia;
    public Monitor(int idEpik, String nombres, String apellidos, String correoInstitucional, String contraseña, String tipoUsuario, String Materia) {
        super(idEpik ,nombres, apellidos, correoInstitucional, contraseña, tipoUsuario);
        this.Materia = Materia;
    }

    public String getMateria(){
        return Materia;
    }
    
    public void setMateria(String Materia){
        this.Materia = Materia;
    }
    
    
}
