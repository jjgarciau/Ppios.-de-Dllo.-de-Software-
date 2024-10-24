public class Monitor extends Estudiante{
    public String Materia;
    public Monitor(String nombres, String apellidos, String correoInstitucional, int idEpik, String contraseña, String Materia) {
        super(nombres, apellidos, correoInstitucional, idEpik, contraseña);
        this.Materia = Materia;
    }

    public String getMateria(){
        return Materia;
    }
    
    public void setMateria(String Materia){
        this.Materia = Materia;
    }
    
    
}
