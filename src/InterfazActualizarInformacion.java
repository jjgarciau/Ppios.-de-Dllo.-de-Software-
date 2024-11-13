//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import javax.swing.*;

public class InterfazActualizarInformacion extends JFrame {
    private final  JButton btnAtrasAC;
    private final JButton btnActualizarInformacion;
    private final JTextField nombreMostrar;
    private final JTextField apellidosMostrar;
    private final JTextField contraseñaMostrar;
    private final JTextField correoInstitucionalMostrar;
    private final JLabel txtNombres;
    private final JLabel txtApellidos;
    private final JLabel txtContraseña;
    private final JLabel txtCorreoInstitucional;
    private final JLabel txtNombresNuevo;
    private final JLabel txtApellidosNuevo;
    private final JLabel txtContraseñaNuevo;
    private final JLabel txtCorreoInstitucionalNuevo;
    private final JLabel txtInformacionPersonal;
    private final JLabel txtRol;
    private JComboBox<String> selectorRol;
    private final JButton btnBuscar;
    private JTextField cuadroTxtbuscarIdEpik;
    private final JLabel txtNombresBusquedad;
    private JLabel txtNombresEncontrado;
    private final JLabel txtApellidosBusquedad;
    private JLabel txtApellidosEncontrado;
    private final JLabel txtCorreoBusquedad;
    private JLabel txtCorreoEncontrado;
    private final JLabel txtIdEpikBusquedad;
    private JLabel txtIdEpikEncontrado;
    private final JButton btnActualizarRol;
    private final JLabel txtBuscarUsuario;


    public InterfazActualizarInformacion(Estudiante usuarioActual) {
        
        //construct preComponents
        String[] selectorRolItems = {"Estudiante", "Monitor", "Administrador"};
        //construct components
        btnAtrasAC = new JButton ("Atras");
        btnActualizarInformacion = new JButton ("Actualizar información");
        nombreMostrar = new JTextField (5);
        apellidosMostrar = new JTextField (5);
        contraseñaMostrar = new JTextField (5);
        correoInstitucionalMostrar = new JTextField (5);
        txtNombres = new JLabel ("Nombres: " + usuarioActual.getNombres());
        txtApellidos = new JLabel ("Apellidos: " + usuarioActual.getApellidos());
        txtContraseña = new JLabel ("Contraseña: **********");
        txtCorreoInstitucional = new JLabel ("Correo: " + usuarioActual.getCorreo());
        txtNombresNuevo = new JLabel ("Cambiar nombres: ");
        txtApellidosNuevo = new JLabel ("Cambiar apellidos: ");
        txtContraseñaNuevo = new JLabel ("Cambiar contraseña: ");
        txtCorreoInstitucionalNuevo = new JLabel ("Cambiar correo: ");
        txtInformacionPersonal = new JLabel ("Información personal: Id de Epik: " + usuarioActual.getIdEpik());
        txtRol = new JLabel ("Rol");
        selectorRol = new JComboBox<> (selectorRolItems);

        btnBuscar = new JButton ("Buscar");
        cuadroTxtbuscarIdEpik = new JTextField (5);

        txtNombresBusquedad = new JLabel ("Nombres");
        txtNombresEncontrado = new JLabel ("");
        txtApellidosBusquedad = new JLabel ("Apellidos");
        txtApellidosEncontrado = new JLabel ("");
        txtCorreoBusquedad = new JLabel ("Correo institucional");
        txtCorreoEncontrado = new JLabel ("");
        txtIdEpikBusquedad = new JLabel ("Id de Epik");
        txtIdEpikEncontrado = new JLabel ("");
        btnActualizarRol = new JButton ("Actualizar rol");
        txtBuscarUsuario = new JLabel ("Buscar usuario por Id de Epik");

        //adjust size and set layout
        setSize(1080, 720);
        setLayout (null);

        //add components
        add(btnAtrasAC);
        add (btnActualizarInformacion);
        add (nombreMostrar);
        add (apellidosMostrar);
        add (contraseñaMostrar);
        add (correoInstitucionalMostrar);
        add (txtNombres);
        add (txtApellidos);
        add (txtContraseña);
        add (txtCorreoInstitucional);
        add (txtNombresNuevo);
        add (txtApellidosNuevo);
        add (txtContraseñaNuevo);
        add (txtCorreoInstitucionalNuevo);
        add (txtInformacionPersonal);
        
        
        

        //set component bounds (only needed by Absolute Positioning)
        btnAtrasAC.setBounds (10, 10, 75, 25);
        btnActualizarInformacion.setBounds (45, 270, 240, 30);
        nombreMostrar.setBounds (390, 85, 200, 30);
        apellidosMostrar.setBounds (390, 130, 200, 30);
        contraseñaMostrar.setBounds (390, 175, 200, 30);
        correoInstitucionalMostrar.setBounds (390, 220, 200, 30);
        txtNombres.setBounds (45, 90, 200, 25);
        txtApellidos.setBounds (45, 130, 200, 25);
        txtContraseña.setBounds (45, 175, 200, 25);
        txtCorreoInstitucional.setBounds (45, 220, 220, 25);
        txtNombresNuevo.setBounds (260, 85, 140, 25);
        txtApellidosNuevo.setBounds (260, 130, 140, 25);
        txtContraseñaNuevo.setBounds (260, 175, 140, 25);
        txtCorreoInstitucionalNuevo.setBounds (260, 220, 140, 25);
        txtInformacionPersonal.setBounds (45, 50, 250, 25);
        txtRol.setBounds (635, 300, 100, 25);
        selectorRol.setBounds (870, 300, 100, 25);

        btnBuscar.setBounds (870, 105, 140, 30);
        cuadroTxtbuscarIdEpik.setBounds (635, 105, 195, 30);
        txtNombresBusquedad.setBounds (635, 155, 100, 25);
        txtNombresEncontrado.setBounds (870, 155, 100, 25);
        txtApellidosBusquedad.setBounds (635, 190, 100, 25);
        txtApellidosEncontrado.setBounds (870, 190, 100, 25);
        txtCorreoBusquedad.setBounds (635, 225, 120, 25);
        txtCorreoEncontrado.setBounds (870, 225, 250, 25);
        txtIdEpikBusquedad.setBounds (635, 260, 100, 25);
        txtIdEpikEncontrado.setBounds (870, 260, 100, 25);
        btnActualizarRol.setBounds (870, 340, 140, 30);
        txtBuscarUsuario.setBounds (635, 60, 200, 25);

        //Boton para retroceder a la interfaz principal
        btnAtrasAC.addActionListener(e -> {
            JFrame interfazMI = new MainInterfaz (usuarioActual);
            interfazMI.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            interfazMI.setVisible (true);
            dispose();
        });
        
        btnActualizarInformacion.addActionListener(e ->{
            // Lógica para actualizar información
            String nombres = nombreMostrar.getText();
            String apellidos = apellidosMostrar.getText();
            String correo = correoInstitucionalMostrar.getText();
            String contraseña = contraseñaMostrar.getText();
            Boolean cambio = false;
            if(!nombres.trim().isEmpty()){
                usuarioActual.setNombres(nombres);
                nombreMostrar.setText("");
                txtNombres.setText("Nombres: " + usuarioActual.getNombres());
                cambio = true;
            }
            if(!apellidos.trim().isEmpty()){
                usuarioActual.setApellidos(apellidos);
                apellidosMostrar.setText("");
                txtApellidos.setText("Apellidos: " + usuarioActual.getApellidos());
                cambio = true;
            }
            if(!correo.trim().isEmpty()){
                usuarioActual.setCorreoInstitucional(correo);
                correoInstitucionalMostrar.setText("");
                txtCorreoInstitucional.setText("Correo: " + usuarioActual.getCorreo());
                cambio = true;
            }
            if(!contraseña.trim().isEmpty()){
                usuarioActual.setContraseña(contraseña);
                contraseñaMostrar.setText("");
                txtContraseña.setText("Contraseña: " + usuarioActual.getContraseña());
                cambio = true;
            }
            if(cambio) {
                BaseDeDatos.actualizarUsuario(usuarioActual);
                JOptionPane.showMessageDialog(null, "Información actualizada");
            } else {
                JOptionPane.showMessageDialog(null, "Si quiere actualizar la información, debe llenar al menos un campo");
            }
        });

        if(usuarioActual.getTipoUsuario().equals("Administrador")){
            add (btnBuscar);
            add (cuadroTxtbuscarIdEpik);
            add (txtNombresBusquedad);     
            add (txtApellidosBusquedad);
            add (txtCorreoBusquedad);            
            add (txtIdEpikBusquedad);            
            add(btnActualizarRol);
            add(txtBuscarUsuario);
            add (selectorRol);
            add (txtRol);
        }
        //Evento para buscar un usuario siendo administrador
        btnBuscar.addActionListener(e -> {
            add (selectorRol);
            add (txtNombresEncontrado);
            add (txtApellidosEncontrado);
            add (txtCorreoEncontrado);
            add (txtIdEpikEncontrado);
            boolean found = false;
            for (Estudiante estudiante : BaseDeDatos.obtenerUsuarios()) {
            if (estudiante.getIdEpik() == Integer.parseInt(cuadroTxtbuscarIdEpik.getText())) {
                txtNombresEncontrado.setText(estudiante.getNombres());
                txtApellidosEncontrado.setText(estudiante.getApellidos());
                txtCorreoEncontrado.setText(estudiante.getCorreo());
                txtIdEpikEncontrado.setText(String.valueOf(estudiante.getIdEpik()));
                found = true;
                break;
            }
            }
            if (!found) {
            JOptionPane.showMessageDialog(null, "No se encontró el estudiante");
            }
        });

        btnActualizarRol.addActionListener(e -> {
            String rolSeleccionado = (String) selectorRol.getSelectedItem();
            int idEpik = Integer.parseInt(cuadroTxtbuscarIdEpik.getText());
            for (Estudiante estudiante : BaseDeDatos.obtenerUsuarios()) {
                if (estudiante.getIdEpik() == idEpik) {
                    estudiante.setTipoUsuario(rolSeleccionado);
                    BaseDeDatos.actualizarUsuario(estudiante);
                    JOptionPane.showMessageDialog(null, "Rol actualizado");
                    break;
                }
            }
        });
    }


    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazInicioSesion().setVisible(true);
        });
    }
}
