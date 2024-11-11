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
    private final JLabel rolActualizar;
    private final JComboBox selectorRol;

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
        txtContraseña = new JLabel ("Contraseña: " + usuarioActual.getContraseña());
        txtCorreoInstitucional = new JLabel ("Correo: " + usuarioActual.getCorreoInstitucional());
        txtNombresNuevo = new JLabel ("Cambiar nombres: ");
        txtApellidosNuevo = new JLabel ("Cambiar apellidos: ");
        txtContraseñaNuevo = new JLabel ("Cambiar contraseña: ");
        txtCorreoInstitucionalNuevo = new JLabel ("Cambiar correo: ");
        txtInformacionPersonal = new JLabel ("Información personal, id de Epik: " + usuarioActual.getIdEpik());
        rolActualizar = new JLabel ("Rol");
        selectorRol = new JComboBox (selectorRolItems);

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
        add (rolActualizar);
        add (selectorRol);

        //set component bounds (only needed by Absolute Positioning)
        btnAtrasAC.setBounds (10, 10, 75, 25);
        btnActualizarInformacion.setBounds (275, 445, 340, 40);
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
        rolActualizar.setBounds (655, 40, 100, 25);
        selectorRol.setBounds (655, 65, 100, 25);

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
                txtCorreoInstitucional.setText("Correo: " + usuarioActual.getCorreoInstitucional());
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

    }


    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazInicioSesion();
        });
    }
}
