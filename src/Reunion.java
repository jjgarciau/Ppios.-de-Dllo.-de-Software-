import java.util.Date;
public class Reunion {
    public String lugar;
    public Date fechaHora;
    public int maxEstudiantes;
    public int idReunion;
    public int personasInscritas;
    public Reunion(String lugar, Date fechaHora, Estudiante monitor,int maxEstudiantes) {
        this.lugar = lugar;
        this.fechaHora = fechaHora;
    }
     //Getters
    public String getLugar(){
        return lugar;
    }

    public Date getFechaHora(){
        return fechaHora;
    }
    public int getMaxEstudiantes(){
        return maxEstudiantes;
    }
    //Setters
    public void setLugar(String lugar){
        this.lugar = lugar;
    }

    public void setFechaHora(Date fechaHora){
        this.fechaHora = fechaHora;
    }

    public void crearReunion(String lugar, Date fechaHora, Monitor monitor){
        Reunion reunion = new Reunion(lugar, fechaHora, monitor, maxEstudiantes);
    }

    public void editarReunion(String lugar, Date fechaHora){
        this.lugar = lugar;
        this.fechaHora = fechaHora;
    }
    public void actualizarInformacionReunion(){
        //Actualizar información de la reunión
    }

    public void eliminarReunion(){
        this.lugar = null;
        this.fechaHora = null;
        //Eliminar reunion de la base de datos
    }

    public void guardarReunion(){
        //Guardar reunion en la base de datos
    }
    //Verificar disponibilidad de la reunion
    public void verificarDisponibilidad(){
        //Verificar disponibilidad de la reunion
    }
    
    //Enviar correo de confirmación de la reunión
    public void enviarCorreoConfirmacion(){
        //Enviar correo de confirmación de la reunión
    }
    //Verificar cuantos estudiantes hay en la reunion
    public void verificarCantidadEstudiantes(){

    }
    
}
