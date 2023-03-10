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
import modelo.Capacidad;
import modelo.Cedula;
import modelo.Consultas;
import modelo.ConsultasCapacidad;
import modelo.ConsultasCedula;
import modelo.ConsultasDepartamento;
import modelo.ConsultasDpi;
import modelo.ConsultasFeDeEdad;
import modelo.ConsultasLimitacion;
import modelo.ConsultasMunicipio;
import modelo.ConsultasPais;
import modelo.ConsultasProfesion;
import modelo.ConsultasVecindad;
import modelo.Departamento;
import modelo.Dpi;
import modelo.FeDeEdad;
import modelo.Limitacion;
import modelo.Municipio;
import modelo.Pais;
import modelo.Persona;
import modelo.Profesion;
import modelo.Vecindad;
import vista.Acercade;
import vista.Inicio;
import vista.Registro;

/**
 *
 * @author Chris
 */
public class ControladorInicio implements ActionListener{
    private Inicio vista1;

    public ControladorInicio(Inicio vista1) {
        this.vista1 = vista1;
        this.vista1.jMenuItem1.addActionListener(this);
        this.vista1.jMenuItem2.addActionListener(this);
        String ruta = System.getProperty("user.dir");
        ruta = ruta + "\\src\\main\\java\\imagenes";
        setearImagen((ruta + "\\logo.jpg"), vista1.jLabel1);
        setearImagen((ruta + "\\Huella.png"), vista1.jLabel3);
        setearImagen((ruta + "\\dpi.jpg"), vista1.jLabel5);
    }
    
    public void setearImagen(String rut, JLabel imagen){
        ImageIcon foto = new ImageIcon(rut);
        Icon iconoFoto = new ImageIcon(foto.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH));
        imagen.setIcon(iconoFoto);
    }
    
    public void mostrarVista(){
        vista1.setTitle("Ventana de Inicio");
        vista1.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == vista1.jMenuItem1){ desplegarOtraVentana(); }
       
       if(e.getSource() == vista1.jMenuItem2){ desplegarAppInfo(); }
       
    }
    
    public void desplegarOtraVentana(){
        Pais mod = new Pais();
        ConsultasPais modC = new ConsultasPais();
        Profesion mod1 = new Profesion();
        ConsultasProfesion modC1 = new ConsultasProfesion();
        Limitacion mod2 = new Limitacion();
        ConsultasLimitacion modC2 = new ConsultasLimitacion();
        Departamento mod3 = new Departamento();
        ConsultasDepartamento modC3 = new ConsultasDepartamento();
        Municipio mod4 = new Municipio();
        ConsultasMunicipio modC4 = new ConsultasMunicipio();
        Dpi mod5 = new Dpi();
        ConsultasDpi modC5 = new ConsultasDpi();
        Capacidad mod6 = new Capacidad();
        ConsultasCapacidad modC6 = new ConsultasCapacidad();
        Cedula mod7 = new Cedula();
        ConsultasCedula modC7 = new ConsultasCedula();
        Vecindad mod8 = new Vecindad();
        ConsultasVecindad modC8 = new ConsultasVecindad();
        FeDeEdad mod9 = new FeDeEdad();
        ConsultasFeDeEdad modC9 = new ConsultasFeDeEdad();
        Persona mod10 = new Persona();
        Consultas modC10 = new Consultas();
        
        Registro vista = new Registro();
        
        
       ControladorPersona ctrl = new ControladorPersona(mod, modC, vista, mod1, modC1, mod2, modC2, mod3, modC3, mod4, modC4, mod5, modC5, 
       mod6, modC6, mod7, modC7, mod8, modC8, mod9, modC9, mod10, modC10);
       ctrl.mostrarVista();
       ctrl.llenarComboPais();
       vista.setVisible(true);
       vista1.dispose();
    }
    public void desplegarAppInfo(){
        Acercade view = new Acercade();
        
        ControladorAcercaDe ctrl = new ControladorAcercaDe(view);
        ctrl.mostrarVista();
        view.setVisible(true);
        vista1.dispose();
        
    }
    
}
