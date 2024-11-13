import java.util.List;
public class Main{
    public static void main(String[] args) {
        // add a reunion
        // List<Integer> personasInscritas = new ArrayList<>();
        // personasInscritas.add(111);
        // personasInscritas.add(222);
        // personasInscritas.add(333);
        // Reunion reunion = new Reunion(1, "Casa de Juan", "18/09/2023 19:00", 1, 10, personasInscritas);

        // List<Integer> personasInscritas2 = new ArrayList<>();
        // personasInscritas2.add(444);
        // personasInscritas2.add(555);
        // personasInscritas2.add(666);
        // Reunion reunion2 = new Reunion(0, "Casa de Pedro", "18/11/2023 19:00", 45, 5, personasInscritas2);

        // BaseDeDatos.agregarReunion(reunion);
        // BaseDeDatos.agregarReunion(reunion2);

        // get all reunions
        // List<Reunion> reuniones = BaseDeDatos.obtenerReuniones();
        // for(Reunion r: reuniones){
        //     System.out.println(r.getIdReunion() + ", " + r.getLugar() + ", " + r.getFechaHora() + ", " + r.getMonitor() + ", " + r.getMaxEstudiantes() + ", " + r.getPersonasInscritas());
        // }

        List<Estudiante> usuarios = BaseDeDatos.obtenerUsuarios();
        for(Estudiante u: usuarios){
            if( u instanceof Monitor m){
                System.out.println(m.getIdEpik() + ", " + m.getNombres() + ", " + m.getApellidos() + ", " + m.getCorreo() + ", " + m.getContraseña() + ", " + m.getTipoUsuario() + ", " + m.getMateria());
            } else {
                if (u != null) {
                    System.out.println(u.getIdEpik() + ", " + u.getNombres() + ", " + u.getApellidos() + ", " + u.getCorreo() + ", " + u.getContraseña() + ", " + u.getTipoUsuario());
                }
            }
        }

    }
}