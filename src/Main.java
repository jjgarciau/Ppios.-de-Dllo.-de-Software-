import javax.swing.JFrame;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame ("InterfazInicioSesion");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new InterfazInicioSesion());
        frame.pack();
        frame.setVisible (true);
    }
}