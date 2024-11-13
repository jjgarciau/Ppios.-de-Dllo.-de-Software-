import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    public static void modificarReunion(Reunion reunion){
        List<Reunion> reuniones = obtenerReuniones();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Tablas/Reunion.txt"))) {
            for (Reunion r : reuniones) {
                if (r.getIdReunion() == reunion.getIdReunion()) {
                    r.setLugar(reunion.getLugar());
                    r.setFechaHora(reunion.getFechaHora());
                    r.setMaxEstudiantes(reunion.getMaxEstudiantes());
                    r.setPersonasInscritas(reunion.getPersonasInscritas());
                }
                bw.write(r.getIdReunion() + ", " + r.getLugar() + ", " + r.getFechaHora() + ", " + r.getMonitor() + ", " + r.getMaxEstudiantes() + ", " + r.getPersonasInscritas());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }
    }

    public static void borrarReunion(int idReunion){
        List<Reunion> reuniones = obtenerReuniones();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Tablas/Reunion.txt"))) {
            for (Reunion r : reuniones) {
                if (r.getIdReunion() != idReunion) {
                    bw.write(r.getIdReunion() + ", " + r.getLugar() + ", " + r.getFechaHora() + ", " + r.getMonitor() + ", " + r.getMaxEstudiantes() + ", " + r.getPersonasInscritas());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }
    }

    public static Reunion obtenerReunionPorId(int idReunion){
        List<Reunion> reuniones = obtenerReuniones();
        for(Reunion reunion: reuniones){
            if(reunion.getIdReunion() == idReunion){
                return reunion;
            }
        }
        return null;
    }

    public static List<Reunion> obtenerReunionesPorMonitor(int idMonitor){
        List<Reunion> reuniones = obtenerReuniones();
        List<Reunion> reunionesMonitor = new ArrayList<>();
        for(Reunion reunion: reuniones){
            if(reunion.getMonitor() == idMonitor){
                reunionesMonitor.add(reunion);
            }
        }
        return reunionesMonitor;
    }


    public static List<Reunion> obtenerReuniones(){

        List<Reunion> reuniones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Tablas/Reunion.txt"))) {

        
            String linea;
            while ((linea = br.readLine()) != null) {

                List<Integer> personasInscritas = new ArrayList<>();
                StringBuilder infoPersonas = new StringBuilder();
                StringBuilder infoGeneral = new StringBuilder();
                Boolean dentro = false;
                
                for(char c: linea.toCharArray()){
                    if(c == '['){
                        dentro = true;
                    } else if(c == ']'){
                        dentro = false;
                    }
                    
                    
                    if(dentro && c != '['){
                        infoPersonas.append(c);
                    }else if(c != ']'){ 
                        infoGeneral.append(c);
                    }
                }    
                
                
                String[] partes = infoGeneral.toString().split(", ");
                if(infoPersonas.length() > 1){

                    String[] estudiantes = infoPersonas.toString().split(", ");
                    
                    for(String estudiante: estudiantes){
                        personasInscritas.add(Integer.valueOf(estudiante));
                    }

                }
                
                
                
                
                Reunion reunion = new Reunion(Integer.parseInt(partes[0]), partes[1], partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]), personasInscritas);
                reuniones.add(reunion);
                
            } 
            
            
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }
        
        return reuniones;
    }

    public static String getMateriaMonitor(int idEpik){
        List<Estudiante> usuarios = obtenerUsuarios();
        for(Estudiante usuario: usuarios){
            if(usuario.getIdEpik() == idEpik && usuario.getTipoUsuario().equals("Monitor")){
                if(usuario instanceof Monitor monitor){
                    return monitor.getMateria();
                }
            }
        }
        return null;
    }

    public static void añadirReunion(Reunion reunion){
        List<Reunion> reuniones = obtenerReuniones();

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Tablas/Reunion.txt", true))) ){

            if(reuniones.isEmpty()){
                pw.println(1 + ", " + reunion.getLugar() + ", " + reunion.getFechaHora() + ", " + reunion.getMonitor() + ", " + reunion.getMaxEstudiantes() + ", " + reunion.getPersonasInscritas());
            } else {
                int maxId = 0;
                for (Reunion r : reuniones) {
                    if(r.getIdReunion() >= maxId){
                        maxId = r.getIdReunion() + 1;
                    }
                }
                pw.println( maxId + ", " + reunion.getLugar() + ", " + reunion.getFechaHora() + ", " + reunion.getMonitor() + ", " + reunion.getMaxEstudiantes() + ", " + reunion.getPersonasInscritas());
            }


        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }
    }



    public static List<Estudiante> obtenerUsuarios() {
        List<Estudiante> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Tablas/Estudiante.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                Estudiante usuario;
                if(partes[5].equals("Monitor")) {
                    usuario = new Monitor(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4], partes[5], partes[6]);
                } else {
                    usuario = new Estudiante(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4], partes[5]);
                }
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }
        return usuarios;
    }
    
    public static Boolean agregarUsuario(Estudiante usuario) {
        
        List<Estudiante> usuarios = obtenerUsuarios();
        Boolean existe = false;

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Tablas/Estudiante.txt", true)))) {
            if(usuarios.isEmpty()){
                pw.println(usuario.getIdEpik() + ", " + usuario.getNombres() + ", " + usuario.getApellidos() + ", " + usuario.getCorreo() + ", " + usuario.getContraseña() + ", " + usuario.getTipoUsuario());
            } else {
                for (Estudiante u : usuarios) {

                    if(u.getIdEpik() == usuario.getIdEpik() || u.getCorreo().equals(usuario.getCorreo())){
                        System.out.println("El usuario ya existe.");
                        existe = true;
                        break;
                    }
                }
                if(!existe){
                    pw.println(usuario.getIdEpik() + ", " + usuario.getNombres() + ", " + usuario.getApellidos() + ", " + usuario.getCorreo() + ", " + usuario.getContraseña() + ", " + usuario.getTipoUsuario());
                }
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }
        return existe;
    }

    public static Estudiante iniciarSesion(String CorreoId, String contraseña) {
        List<Estudiante> usuarios = obtenerUsuarios();
        for (Estudiante usuario : usuarios) {

            if(CorreoId.equals(usuario.getCorreo())){
                if(contraseña.equals(usuario.getContraseña())){
                    return usuario;
                }
            } else if(CorreoId.equals(String.valueOf(usuario.getIdEpik()))){
                if(contraseña.equals(usuario.getContraseña())){
                    return usuario;
                }
            }
        }

        return null;

    }

    public static void actualizarUsuario(Estudiante estudianteActualizado) {
        List<Estudiante> usuarios = obtenerUsuarios();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Tablas/Estudiante.txt"))) {
            for (Estudiante usuario : usuarios) {
                
                if(usuario.getIdEpik() == estudianteActualizado.getIdEpik()){
                    // Si el usuario es monitor, escribimos sus datos con la materia
                    if(usuario instanceof Monitor monitor){
                        bw.write(estudianteActualizado.getIdEpik() + ", " + estudianteActualizado.getNombres() + ", " + estudianteActualizado.getApellidos() + ", " + estudianteActualizado.getCorreo() + ", " + estudianteActualizado.getContraseña() + ", " + estudianteActualizado.getTipoUsuario() + ", " + monitor.getMateria());
                    } else {
                        bw.write(estudianteActualizado.getIdEpik() + ", " + estudianteActualizado.getNombres() + ", " + estudianteActualizado.getApellidos() + ", " + estudianteActualizado.getCorreo() + ", " + estudianteActualizado.getContraseña() + ", " + estudianteActualizado.getTipoUsuario());
                    }
                } else {
                    // Si el usuario es monitor, escribimos sus datos con la materia
                    if(usuario instanceof Monitor monitor){
                        bw.write(usuario.getIdEpik() + ", " + usuario.getNombres() + ", " + usuario.getApellidos() + ", " + usuario.getCorreo() + ", " + usuario.getContraseña() + ", " + usuario.getTipoUsuario() + ", " + monitor.getMateria());
                    } else {
                        bw.write(usuario.getIdEpik() + ", " + usuario.getNombres() + ", " + usuario.getApellidos() + ", " + usuario.getCorreo() + ", " + usuario.getContraseña() + ", " + usuario.getTipoUsuario());
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }
    }

    public static String inscribirPersonaReunion(Estudiante estudiante, int idReunion){
        Reunion reunion = obtenerReunionPorId(idReunion);
        String mensaje; 
        if(reunion.getPersonasInscritas().size() < reunion.getMaxEstudiantes()){
            List<Integer> personasInscritas = reunion.getPersonasInscritas();
            if(personasInscritas.contains(estudiante.getIdEpik())){
                mensaje = "Ya te inscribiste a esta reunión.";
                return mensaje;
            }
            personasInscritas.add(estudiante.getIdEpik());
            reunion.setPersonasInscritas(personasInscritas);
            modificarReunion(reunion);
            mensaje = "Te has inscrito correctamente.";
            return mensaje;

        } else {
            mensaje = "La reunión ya tiene el máximo de estudiantes inscritos.";
            return mensaje;
        }
    }

    public static String eliminarPersonaReunion(Estudiante estudiante, int idReunion){
        Reunion reunion = obtenerReunionPorId(idReunion);
        String mensaje; 
        List<Integer> personasInscritas = reunion.getPersonasInscritas();
        if(personasInscritas.contains(estudiante.getIdEpik())){
            personasInscritas.remove(Integer.valueOf(estudiante.getIdEpik()));
            reunion.setPersonasInscritas(personasInscritas);
            modificarReunion(reunion);
            mensaje = "Saliste de la reunión.";
            return mensaje;
        } else {
            mensaje = "El estudiante no está inscrito en la reunión.";
            return mensaje;
        }
    }


}
