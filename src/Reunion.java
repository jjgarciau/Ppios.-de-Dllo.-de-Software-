import java.util.List;
public class Reunion {
    public String lugar;
    public String fechaHora;
    public int maxEstudiantes;
    public int idReunion;
    public int monitor;
    public List<Integer> personasInscritas;

    public Reunion(int idReunion, String lugar, String fechaHora, int monitor,int maxEstudiantes, List<Integer> personasinscritas){
        this.idReunion = idReunion;
        this.lugar = lugar;
        this.fechaHora = fechaHora;
        this.maxEstudiantes = maxEstudiantes;
        this.monitor = monitor;
        this.personasInscritas = personasinscritas;

    }
     //Getters
    public String getMateriaDeMonitor(){
        return BaseDeDatos.getMateriaMonitor(monitor);
    }

    // public 

    public int getIdReunion(){
        return idReunion;
    }

    public String getLugar(){
        return lugar;
    }

    public String getFechaHora(){
        return fechaHora;
    }
    public int getMaxEstudiantes(){
        return maxEstudiantes;
    }
    public int getMonitor(){
        return monitor;
    }
    public List<Integer> getPersonasInscritas(){
        return personasInscritas;
    }

    //Setters
    public void setMaxEstudiantes(int maxEstudiantes){
        this.maxEstudiantes = maxEstudiantes;
    }

    public void setLugar(String lugar){
        this.lugar = lugar;
    }

    public void setFechaHora(String fechaHora){
        this.fechaHora = fechaHora;
    }

    public void setPersonasInscritas(List<Integer> personasInscritas){
        this.personasInscritas = personasInscritas;
    }

    public void editarReunion(String lugar, String fechaHora){
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
