//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!
import javax.swing.*;

public class InterfazInicioSesion extends JFrame {
    private Estudiante usuarioActual;
    private final JButton btnCrearCuenta;
    private final JButton btnIniciarSesion;
    private JTextField ingresoUsuario;
    private JPasswordField ingresoContraseña;

    public InterfazInicioSesion() {
        //construct components
        btnCrearCuenta = new JButton ("Crear cuenta");
        btnIniciarSesion = new JButton ("Inicio sesión");
        ingresoUsuario = new JTextField (5);
        ingresoContraseña = new JPasswordField (5);

        //Prueba Usuario
        //Estudiante estudiante = new Estudiante("Juan", "Perez", "prueba", 1000, "admin", "Estudiante");
        // Estudiante estudiante = new Monitor( 1001, "Pedro", "Ramirez", "pruebaM", "admin", "Monitor", "Matematicas");
        //Fin prueba usuario

        //adjust size and set layout
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout (null);

        //add components
        add (btnCrearCuenta);
        add (btnIniciarSesion);
        add (ingresoUsuario);
        add (ingresoContraseña);

        //set component bounds (only needed by Absolute Positioning)
        btnCrearCuenta.setBounds (380, 465, 340, 40);//315
        btnIniciarSesion.setBounds (380, 410, 340, 40);//260
        ingresoUsuario.setBounds (380, 295, 340, 40);//145
        ingresoContraseña.setBounds (380, 350, 340, 40);//200


        //Evento iniciar sesion
        btnIniciarSesion.addActionListener(e -> {

                String usuario = ingresoUsuario.getText();
                String contraseña = new String(ingresoContraseña.getPassword());

                // Lógica para iniciar sesión
                
                usuarioActual = BaseDeDatos.iniciarSesion(usuario, contraseña);
                if (usuarioActual != null) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    JFrame frame = new MainInterfaz(usuarioActual);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
                
                // if ((usuario.equals(estudiante.getCorreoInstitucional())||usuario.equals(String.valueOf(estudiante.getIdEpik())))&& contraseña.equals(estudiante.getContraseña())) {
                //     usuarioActual = estudiante;
                //     JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                //     JFrame frame = new MainInterfaz(usuarioActual);
                //     frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                //     frame.setVisible (true);
                //     dispose();
                // } else {
                //     JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                // }
            });

        //Evento pulsar boton de crear cuenta
        btnCrearCuenta.addActionListener(e -> {
                JFrame interfazCC = new InterfazCrearCuenta();
                interfazCC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                interfazCC.setVisible (true);
                dispose();
        });

        setVisible(true);
    }
    public void setUsuarioActual(Estudiante usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public Estudiante getUsuarioActual() {
        return usuarioActual;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazInicioSesion().setVisible(true);
        });
    }
}
