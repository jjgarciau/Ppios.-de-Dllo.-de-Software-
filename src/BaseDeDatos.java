import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    public static List<Estudiante> obtenerUsuarios() {
        List<Estudiante> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Estudiante.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                Estudiante usuario = new Estudiante(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4], partes[5]);
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

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("Estudiante.txt", true)))) {
            if(usuarios.isEmpty()){
                pw.println(usuario.getIdEpik() + ", " + usuario.getNombres() + ", " + usuario.getApellidos() + ", " + usuario.getCorreoInstitucional() + ", " + usuario.getContraseña() + ", " + usuario.getTipoUsuario());
            } else {
                for (Estudiante u : usuarios) {

                    if(u.getIdEpik() == usuario.getIdEpik() || u.getCorreoInstitucional().equals(usuario.getCorreoInstitucional())){
                        System.out.println("El usuario ya existe.");
                        existe = true;
                        break;
                    }
                }
                if(!existe){
                    pw.println(usuario.getIdEpik() + ", " + usuario.getNombres() + ", " + usuario.getApellidos() + ", " + usuario.getCorreoInstitucional() + ", " + usuario.getContraseña() + ", " + usuario.getTipoUsuario());
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

            if(CorreoId.equals(usuario.getCorreoInstitucional())){
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Estudiante.txt"))) {
            for (Estudiante usuario : usuarios) {
                if (usuario.getIdEpik() == estudianteActualizado.getIdEpik()) {
                    // Si encontramos el usuario que estamos actualizando, escribimos sus nuevos datos
                    bw.write(estudianteActualizado.getIdEpik() + ", " + estudianteActualizado.getNombres() + ", " + estudianteActualizado.getApellidos() + ", " + estudianteActualizado.getCorreoInstitucional() + ", " + estudianteActualizado.getContraseña() + ", " + estudianteActualizado.getTipoUsuario());
                } else {
                    // Si no es el usuario que estamos actualizando, escribimos sus datos originales
                    bw.write(usuario.getIdEpik() + ", " + usuario.getNombres() + ", " + usuario.getApellidos() + ", " + usuario.getCorreoInstitucional() + ", " + usuario.getContraseña() + ", " + usuario.getTipoUsuario());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
        }
    }


}
