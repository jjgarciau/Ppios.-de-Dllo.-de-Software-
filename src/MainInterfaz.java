import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
//import javax.swing.event.*;

public class MainInterfaz extends JFrame {
    private JButton btnSalirReunion;
    private JButton btnPerfil;
    private JButton btnBuscarReunion;
    private JLabel txtInfoPersonal;
    private JList<String> listReunionInscritas;
    private JLabel txtReunionInscritas;
    private JLabel txtReunionDisponible;
    private JList<String> JListReunionDisponible;
    private JTextField cuadroTxtBuscarReunion;
    private JButton btnInscribirReunion;
    private JButton btnCrearReunion;
    private JTextField cuadroTxtFechaReunion;
    private JTextField cuadroTxtLugarReunion;
    private JLabel txtFechaReunion;
    private JLabel txtNuevaReunion;
    private JLabel txtLugarReunion;
    private JList<String> JListMisReunion;
    private JButton btnEditarReunion;
    private JTextField cuadroTxtMaxEstudiantes;
    private JLabel txtMaxEstudiantes;
    private JButton btnGuardarReunion;
    private JButton btnEliminarReunion;

    public MainInterfaz(Estudiante usuarioActual) {
        //construct preComponents
        List<Reunion> reunionesDisponibles = BaseDeDatos.obtenerReuniones();
        DefaultListModel<String> listReunionesInscritasItems = new DefaultListModel<>();
        DefaultListModel<String> ItemsReunionesDisponibles = new DefaultListModel<>();
        DefaultListModel<String> MisReunionItems = new DefaultListModel<>();

        for(Reunion r: reunionesDisponibles){
            ItemsReunionesDisponibles.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
        }

        for(Reunion r: reunionesDisponibles){
            if(r.getPersonasInscritas().contains(usuarioActual.getIdEpik())){
                listReunionesInscritasItems.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
            }
        }



        //construct components
        btnSalirReunion = new JButton ("Salirse de la reunión");
        btnPerfil = new JButton ("P");
        btnBuscarReunion = new JButton ("Buscar");
        txtInfoPersonal = new JLabel ("Informacion Personal");
        listReunionInscritas = new JList<> (listReunionesInscritasItems);
        txtReunionInscritas = new JLabel ("Reuniones inscritas");
        txtReunionDisponible = new JLabel ("Reuniones Disponibles");
        JListReunionDisponible = new JList<> (ItemsReunionesDisponibles);
        cuadroTxtBuscarReunion = new JTextField (5);
        btnInscribirReunion = new JButton ("Inscribirse a reunión");
        btnCrearReunion = new JButton ("Crear reunión");
        cuadroTxtFechaReunion = new JTextField (5);
        cuadroTxtLugarReunion = new JTextField (5);
        txtFechaReunion = new JLabel ("Fecha de la reunión");
        txtNuevaReunion = new JLabel ("Nueva Reunión");
        txtLugarReunion = new JLabel ("Lugar de la reunión");
        btnEditarReunion = new JButton ("Editar reunión");
        cuadroTxtMaxEstudiantes = new JTextField (5);
        txtMaxEstudiantes = new JLabel ("Max Estudiantes");
        btnGuardarReunion = new JButton ("Guardar reunión");
        btnEliminarReunion = new JButton ("Eliminar reunión");

        //set components properties
        cuadroTxtBuscarReunion.setToolTipText ("Buscar reunión");

        //adjust size and set layout
        setSize(1080, 720);
        setLayout (null);


        //Verificar si el usuario es un monitor para mostrar las opciones de crear reunión
        if(usuarioActual.getTipoUsuario().equals("Monitor")){


            List<Reunion> reunionesDisponiblesMonitor = BaseDeDatos.obtenerReunionesPorMonitor(usuarioActual.getIdEpik());
            

            for(Reunion r: reunionesDisponiblesMonitor){
                MisReunionItems.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
            }

            JListMisReunion = new JList<> (MisReunionItems);

            

            add (btnCrearReunion);
            add (cuadroTxtFechaReunion);
            add (cuadroTxtLugarReunion);
            add (txtFechaReunion);
            add (txtNuevaReunion);
            add (txtLugarReunion);
            add (JListMisReunion);
            add (btnEditarReunion);
            add (cuadroTxtMaxEstudiantes);
            add (txtMaxEstudiantes);
            add (btnGuardarReunion);
            add (btnEliminarReunion);


            btnCrearReunion.setBounds (740, 295, 115, 25);
            cuadroTxtFechaReunion.setBounds (585, 255, 130, 30);
            cuadroTxtLugarReunion.setBounds (725, 255, 130, 30);
            txtFechaReunion.setBounds (590, 230, 115, 25);
            txtNuevaReunion.setBounds (590, 195, 90, 30);
            txtLugarReunion.setBounds (725, 230, 115, 25);
            JListMisReunion.setBounds (585, 335, 270, 65);
            btnEditarReunion.setBounds (585, 415, 270, 25);
            cuadroTxtMaxEstudiantes.setBounds (690, 295, 45, 25);
            txtMaxEstudiantes.setBounds (585, 295, 100, 25);
            btnGuardarReunion.setBounds (585, 475, 270, 25);
            btnEliminarReunion.setBounds (585, 445, 270, 25);

            btnCrearReunion.addActionListener(e -> {
                String fechaHoraNuevoReunion = cuadroTxtFechaReunion.getText();
                String lugarNuevoReunion = cuadroTxtLugarReunion.getText();
                String maxEstudiantesNuevoReunion = cuadroTxtMaxEstudiantes.getText();
                if(!maxEstudiantesNuevoReunion.isEmpty()&&!fechaHoraNuevoReunion.isEmpty()&&!lugarNuevoReunion.isEmpty()){
                    // Convertir maxEstudiantesNuevoReunion de String a int
                    int maxEstudiantesNuevoReunionInt = Integer.parseInt(maxEstudiantesNuevoReunion.trim());
    
                    // Convertir fechaHoraNuevoReunion de String a Date
                    // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    // Date fechaHoraNuevoReunionDate = dateFormat.parse(fechaHoraNuevoReunion);

                    //lista de estudiantes inscritos vacia
                    List<Integer> listaEstudiantesInscritos = new ArrayList<>();
                    
                    // Creamos la reunión
                    Reunion nuevaReunion = new Reunion(0, lugarNuevoReunion, fechaHoraNuevoReunion, usuarioActual.getIdEpik(), maxEstudiantesNuevoReunionInt, listaEstudiantesInscritos);
                    BaseDeDatos.añadirReunion(nuevaReunion);

                    //Actualizar las reuniones disponibles
                    List<Reunion> nuevasReunionesDisponibles = BaseDeDatos.obtenerReuniones();
                    Reunion reuAgregada = nuevasReunionesDisponibles.get(nuevasReunionesDisponibles.size()-1);
                    ItemsReunionesDisponibles.addElement("[" + reuAgregada.getIdReunion() + "]" + "Materia: " + reuAgregada.getMateriaDeMonitor() + "| Lugar: " + reuAgregada.getLugar() + "| Fecha: " + reuAgregada.getFechaHora() + "| Personas:  " + reuAgregada.getPersonasInscritas().size() + "/" + reuAgregada.getMaxEstudiantes());
                    MisReunionItems.addElement("[" + reuAgregada.getIdReunion() + "]" + "Materia: " + reuAgregada.getMateriaDeMonitor() + "| Lugar: " + reuAgregada.getLugar() + "| Fecha: " + reuAgregada.getFechaHora() + "| Personas:  " + reuAgregada.getPersonasInscritas().size() + "/" + reuAgregada.getMaxEstudiantes());

                    JOptionPane.showMessageDialog(null, "Reunión creada exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Información faltante o errónea");
                }

            });//Fin Evento btnCrearReunion

            btnEditarReunion.addActionListener(e -> {
                //Editar reunión
                if(JListMisReunion.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "Selecciona una reunión para editar");
                    return;
                }

                String fechaHoraNuevoReunion = cuadroTxtFechaReunion.getText();
                String lugarNuevoReunion = cuadroTxtLugarReunion.getText();
                String maxEstudiantesNuevoReunion = cuadroTxtMaxEstudiantes.getText();
                if(!maxEstudiantesNuevoReunion.equals("")&&!fechaHoraNuevoReunion.equals("")){

                    //Obtener información de la reunión seleccionada en un String
                    String reunionSeleccionada = JListMisReunion.getSelectedValue();

                    //Obtenemos el id de la reunión seleccionada
                    StringBuilder sbIdReunion = new StringBuilder();
                    Boolean bandera = false;
                    for(char c: reunionSeleccionada.toCharArray()){
                        if(c == '['){
                            bandera = true;
                        } else if(c == ']'){
                            break;
                        }
                        
                        if(bandera && c != '['){
                            sbIdReunion.append(c);
                        }
                    }

                    String idReunionString = sbIdReunion.toString();
                    int idReunion = Integer.parseInt(idReunionString);
                    
                    //Obtener la información de la reunión seleccionada
                    Reunion reunionEditar = BaseDeDatos.obtenerReunionPorId(idReunion);

                    try {
                        // Convertir maxEstudiantesNuevoReunion de String a int
                        int maxEstudiantesNuevoReunionInt = Integer.parseInt(maxEstudiantesNuevoReunion.trim());
            
                        // Convertir fechaHoraNuevoReunion de String a Date

                        // Crear la reunión con los datos convertidos
                        Reunion nuevaReunion = new Reunion(reunionEditar.getIdReunion(), lugarNuevoReunion, fechaHoraNuevoReunion, usuarioActual.getIdEpik(), maxEstudiantesNuevoReunionInt, reunionEditar.getPersonasInscritas());
                        
                        //Editar la reunión
                        BaseDeDatos.modificarReunion(nuevaReunion);

                        //Actualizar las reuniones disponibles
                        List<Reunion> nuevasReunionesDisponibles = BaseDeDatos.obtenerReuniones();
                        List<Reunion> nuevasReunionesMonitor = BaseDeDatos.obtenerReunionesPorMonitor(usuarioActual.getIdEpik());
                        ItemsReunionesDisponibles.clear();
                        MisReunionItems.clear();
                        for(Reunion r: nuevasReunionesDisponibles){
                            ItemsReunionesDisponibles.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                        }
                        for(Reunion r: nuevasReunionesMonitor){
                            MisReunionItems.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                        }

                        JOptionPane.showMessageDialog(null, "Reunión editada exitosamente");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El número máximo de estudiantes debe ser un número entero");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Información faltante o errónea");
                }           
                
                
            });

            btnEliminarReunion.addActionListener(e -> {
                //Eliminar reunión
                if(JListMisReunion.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "Selecciona una reunión para eliminar");
                    return;
                }

                    
                // Mostrar ventana emergente con eleccion
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres borrar la reunión?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
                // Lógica para eliminar la reunión si se presiona "Aceptar"
                if (respuesta == JOptionPane.YES_OPTION) {
                    
                    String reunionSeleccionada = JListMisReunion.getSelectedValue();

                    //Obtenemos el id de la reunión seleccionada
                    StringBuilder sbIdReunion = new StringBuilder();
                    Boolean bandera = false;
                    for(char c: reunionSeleccionada.toCharArray()){
                        if(c == '['){
                            bandera = true;
                        } else if(c == ']'){
                            break;
                        }
                        
                        if(bandera && c != '['){
                            sbIdReunion.append(c);
                        }
                    }

                    String idReunionString = sbIdReunion.toString();
                    int idReunion = Integer.parseInt(idReunionString);
                    BaseDeDatos.borrarReunion(idReunion);

                    //Actualizar las reuniones disponibles
                    List<Reunion> nuevasReunionesDisponibles = BaseDeDatos.obtenerReuniones();
                    List<Reunion> nuevasReunionesMonitor = BaseDeDatos.obtenerReunionesPorMonitor(usuarioActual.getIdEpik());
                    ItemsReunionesDisponibles.clear();
                    MisReunionItems.clear();
                    for(Reunion r: nuevasReunionesDisponibles){
                        ItemsReunionesDisponibles.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                    }
                    for(Reunion r: nuevasReunionesMonitor){
                        MisReunionItems.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                    }


                    JOptionPane.showMessageDialog(null, "Reunión eliminada exitosamente");
                }          
            });
              
        }//Fin if

        //add components
        add (btnSalirReunion);
        add (btnPerfil);
        add (txtInfoPersonal);
        add (listReunionInscritas);
        add (txtReunionInscritas);
        add (txtReunionDisponible);
        add (JListReunionDisponible);
        add (cuadroTxtBuscarReunion);
        add (btnInscribirReunion);
        add (btnBuscarReunion);
        

        //set component bounds (only needed by Absolute Positioning)
        btnSalirReunion.setBounds (590, 170, 235, 25);
        btnPerfil.setBounds (860, 30, 47, 40);
        txtInfoPersonal.setBounds (720, 30, 130, 34);
        listReunionInscritas.setBounds (590, 85, 235, 80);
        txtReunionInscritas.setBounds (590, 55, 115, 25);
        txtReunionDisponible.setBounds (90, 95, 136, 25);
        JListReunionDisponible.setBounds (90, 180, 470, 250);
        cuadroTxtBuscarReunion.setBounds (90, 135, 350, 30);
        btnBuscarReunion.setBounds (450, 135, 110, 25);
        btnInscribirReunion.setBounds (207, 445, 235, 25);
        

        //Evento salirse de la reunión
        btnSalirReunion.addActionListener(e -> {
            if(listReunionInscritas.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Selecciona una reunión de la lista de reuniones inscritas");
                return;
            }
            // Mostrar ventana emergente con eleccion
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir de la reunión?", "Confirmar", JOptionPane.YES_NO_OPTION);
            
            // Lógica para salirse de la reunión si se presiona "Aceptar"
            if (respuesta == JOptionPane.YES_OPTION) {

                //Obtener la reunión seleccionada
                String reunionSeleccionada = listReunionInscritas.getSelectedValue();

                //Obtenemos el id de la reunión seleccionada
                StringBuilder sbIdReunion = new StringBuilder();
                Boolean bandera = false;
                for(char c: reunionSeleccionada.toCharArray()){
                    if(c == '['){
                        bandera = true;
                    } else if(c == ']'){
                        break;
                    }
                    
                    if(bandera && c != '['){
                        sbIdReunion.append(c);
                    }
                }

                String idReunionString = sbIdReunion.toString();
                int idReunion = Integer.parseInt(idReunionString);

                String mensaje = BaseDeDatos.eliminarPersonaReunion(usuarioActual, idReunion);

                //Actualizar las reuniones disponibles
                List<Reunion> nuevasReunionesDisponibles = BaseDeDatos.obtenerReuniones();
                ItemsReunionesDisponibles.clear();
                for(Reunion r: nuevasReunionesDisponibles){
                    ItemsReunionesDisponibles.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                }
                
                //Actualizar las reuniones inscritas
                listReunionesInscritasItems.clear();
                for(Reunion r: nuevasReunionesDisponibles){
                    if(r.getPersonasInscritas().contains(usuarioActual.getIdEpik())){
                        listReunionesInscritasItems.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                    }
                }

                if(usuarioActual.getTipoUsuario().equals("Monitor")){
                    List<Reunion> nuevasReunionesMonitor = BaseDeDatos.obtenerReunionesPorMonitor(usuarioActual.getIdEpik());
                    MisReunionItems.clear();
                    for(Reunion r: nuevasReunionesMonitor){
                        MisReunionItems.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                    }
                }

                JOptionPane.showMessageDialog(null, mensaje);
            }
        });

        btnInscribirReunion.addActionListener( e -> {
            if(JListReunionDisponible.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Selecciona una reunión de la lista de reuniones disponibles");
                return;
            }

            // Mostrar ventana emergente con eleccion
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que te quieres inscribir la reunión?", "Confirmar", JOptionPane.YES_NO_OPTION);
            
            // Lógica para inscribirse   la reunión si se presiona "Aceptar"
            if (respuesta == JOptionPane.YES_OPTION) {

                //Obtener la reunión seleccionada
                String reunionSeleccionada = JListReunionDisponible.getSelectedValue();
                
                //Obtenemos el id de la reunión seleccionada
                StringBuilder sbIdReunion = new StringBuilder();
                Boolean bandera = false;
                for(char c: reunionSeleccionada.toCharArray()){
                    if(c == '['){
                        bandera = true;
                    } else if(c == ']'){
                        break;
                    }
                    
                    if(bandera && c != '['){
                        sbIdReunion.append(c);
                    }
                }

                String idReunionString = sbIdReunion.toString();
                int idReunion = Integer.parseInt(idReunionString);
                
                String mensaje = BaseDeDatos.inscribirPersonaReunion(usuarioActual, idReunion);

                //Actualizar las reuniones disponibles
                List<Reunion> nuevasReunionesDisponibles = BaseDeDatos.obtenerReuniones();
                ItemsReunionesDisponibles.clear();
                for(Reunion r: nuevasReunionesDisponibles){
                    ItemsReunionesDisponibles.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                }

                //Actualizar las reuniones inscritas
                listReunionesInscritasItems.clear();
                for(Reunion r: nuevasReunionesDisponibles){
                    if(r.getPersonasInscritas().contains(usuarioActual.getIdEpik())){
                        listReunionesInscritasItems.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                    }
                }


                if(usuarioActual.getTipoUsuario().equals("Monitor")){
                    List<Reunion> nuevasReunionesMonitor = BaseDeDatos.obtenerReunionesPorMonitor(usuarioActual.getIdEpik());
                    MisReunionItems.clear();
                    for(Reunion r: nuevasReunionesMonitor){
                        MisReunionItems.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                    }
                }

                JOptionPane.showMessageDialog(null, mensaje);
            }
        });
        //Evento buscar reunión por materia
        btnBuscarReunion.addActionListener(e -> {
            if(cuadroTxtBuscarReunion.getText().isEmpty()){
                
                List<Reunion> nuevasReunionesDisponibles = BaseDeDatos.obtenerReuniones();
                ItemsReunionesDisponibles.clear();
                
                for(Reunion r: nuevasReunionesDisponibles){
                    ItemsReunionesDisponibles.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                }

            } else {

                String materiaBuscar = cuadroTxtBuscarReunion.getText();
                List<Reunion> nuevasReunionesDisponibles = BaseDeDatos.obtenerReuniones();
                ItemsReunionesDisponibles.clear();
                
                for(Reunion r: nuevasReunionesDisponibles){
                    if(r.getMateriaDeMonitor().equals(materiaBuscar)){
                        ItemsReunionesDisponibles.addElement("[" + r.getIdReunion() + "]" + "Materia: " + r.getMateriaDeMonitor() + "| Lugar: " + r.getLugar() + "| Fecha: " + r.getFechaHora() + "| Personas:  " + r.getPersonasInscritas().size() + "/" + r.getMaxEstudiantes());
                    }
                }
            }
                

        });
        btnPerfil.addActionListener(e -> {
            JFrame frame = new InterfazActualizarInformacion(usuarioActual);
            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            frame.setVisible (true);
            dispose();
        });



    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazInicioSesion().setVisible(true);
        });
    }
}
