/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import vista.Acercade;
import vista.Inicio;

/**
 *
 * @author Chris
 */
public class ControladorAcercaDe implements ActionListener{
    Acercade vista;

    public ControladorAcercaDe(Acercade vista) {
        this.vista = vista;
        this.vista.jButton1.addActionListener(this);
         String rut = System.getProperty("user.dir");
         rut = rut + "\\src\\main\\java\\imagenes";
         setearImagen((rut + "\\dpi.jpg"), vista.jLabel1);
         setearImagen((rut + "\\logo.jpg"), vista.jLabel4);
    }
    
     public void setearImagen(String rut, JLabel imagen){
        ImageIcon foto = new ImageIcon(rut);
        Icon iconoFoto = new ImageIcon(foto.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH));
        imagen.setIcon(iconoFoto);
    }
    
    public void mostrarVista(){
        vista.setTitle("Acerca de");
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.jButton1){
            Inicio view = new Inicio();
        
             ControladorInicio ctrl = new ControladorInicio(view);
             ctrl.mostrarVista();
             view.setVisible(true);
             vista.dispose();
        }
    }
}
