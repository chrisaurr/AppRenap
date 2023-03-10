/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import modelo.Capacidad;
import modelo.Cedula;
import modelo.ConexionBd;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.Inicio;
import vista.Registro;

/**
 *
 * @author Chris
 */
public class ControladorPersona implements ActionListener {
    
    private Pais mod;
    private ConsultasPais modC;
    private Profesion mod1;
    private ConsultasProfesion modC1;
    private Limitacion mod2;
    private ConsultasLimitacion modC2;
    private Departamento mod3;
    private ConsultasDepartamento modC3;
    private Municipio mod4;
    private ConsultasMunicipio modC4;
    private Dpi mod5;
    private ConsultasDpi modC5;
    private Capacidad mod6;
    private ConsultasCapacidad modC6;
    private Cedula mod7;
    private ConsultasCedula modC7;
    private Vecindad mod8;
    private ConsultasVecindad modC8;
    private FeDeEdad mod9;
    private ConsultasFeDeEdad modC9;
    private Persona mod10;
    private Consultas modC10;
    private Registro vista;
    String mano = "";
    String dedo;
    int largoCamara = 250;
    int anchoCamara = 250;
         
    Dimension dimension = new Dimension(largoCamara, anchoCamara);
    Dimension dimension1 = WebcamResolution.VGA.getSize();
    Webcam webcam = Webcam.getDefault();
    WebcamPanel webcamPanel = new WebcamPanel(webcam, dimension, false);
         
    BufferedImage ruta;
   // int contador = 0;
    
    public ControladorPersona(Pais mod, ConsultasPais modC, Registro vista, Profesion mod1, ConsultasProfesion modC1,
    Limitacion mod2, ConsultasLimitacion modC2, Departamento mod3, ConsultasDepartamento modC3, 
    Municipio mod4, ConsultasMunicipio modC4,Dpi mod5, ConsultasDpi modC5, Capacidad mod6,
    ConsultasCapacidad modC6, Cedula mod7, ConsultasCedula modC7, Vecindad mod8, ConsultasVecindad modC8, 
    FeDeEdad mod9, ConsultasFeDeEdad modC9, Persona mod10, Consultas modC10){
        this.mod = mod;
        this.modC = modC;
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.mod2 = mod2;
        this.modC2 = modC2;
        this.mod3 = mod3;
        this.modC3 = modC3;
        this.mod4 = mod4;
        this.modC4 = modC4;
        this.mod5 = mod5;
        this.modC5 = modC5;
        this.mod6 = mod6;
        this.modC6 = modC6;
        this.mod7 = mod7;
        this.modC7 = modC7;
        this.mod8 = mod8;
        this.modC8 = modC8;
        this.mod9 = mod9;
        this.modC9 = modC9;
        this.mod10 = mod10;
        this.modC10 = modC10;
        this.vista = vista;
        //this.vista1 = vista1;
        //this.vista.comboCedulaDepartamento.addPropertyChangeListener(this);
         this.vista.comboCedulaDepartamento.addActionListener(this);
         this.vista.comboVecindadDepa.addActionListener(this);
         this.vista.comboPaisNac.addActionListener(this);
         this.vista.comboDepartamentoNac.addActionListener(this);
         this.vista.checkPulgarIzq.addActionListener(this);
         this.vista.checkIndiceIzq.addActionListener(this);
         this.vista.checkMedioIzq.addActionListener(this);
         this.vista.checkAnularIzq.addActionListener(this);
         this.vista.checkMeniqueIzq.addActionListener(this);
         this.vista.checkPulgarDer.addActionListener(this);
         this.vista.checkIndiceDer.addActionListener(this);
         this.vista.checkMedioDer.addActionListener(this);
         this.vista.checkAnularDer.addActionListener(this);
         this.vista.checkMeniqueDer.addActionListener(this);
         //this.vista1.btnGuardarHuella.addActionListener(this);
         this.vista.btnIniciarCamara.addActionListener(this);
         this.vista.btnApagar.addActionListener(this);
         this.vista.btnTomar.addActionListener(this);
         this.vista.btnGuardar.addActionListener(this);
         this.vista.btnGenerarReporte.addActionListener(this);
         this.vista.btnRegresar.addActionListener(this);
         
         webcam.setViewSize(dimension1);
         webcamPanel.setFillArea(true);
         this.vista.pnlCamara.setLayout(new FlowLayout());
         this.vista.pnlCamara.add(webcamPanel);
         
         //this.vista.lblFoto.setText(webcam.toString());
         String rut = System.getProperty("user.dir");
         rut = rut + "\\src\\main\\java\\imagenes";
         setearImagen((rut + "\\logo.jpg"), vista.jLabel34);
         setearImagen((rut + "\\logo.jpg"), vista.jLabel36);
         setearImagen((rut + "\\logo.jpg"), vista.jLabel39);
         
    }
    
    public void setearImagen(String rut, JLabel imagen){
        ImageIcon foto = new ImageIcon(rut);
        Icon iconoFoto = new ImageIcon(foto.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH));
        imagen.setIcon(iconoFoto);
    }
    
    public void mostrarVista(){
        vista.setTitle("Registros");
        vista.setLocationRelativeTo(null);
    }
    
    public void llenarComboPais(){
       /* if(modC.MostrarPacientes(mod)){
            
            vista.jComboBox1.addItem(mod.getDescripcion());
        }*/
        ArrayList<Pais> listaPaises = modC.obtenerPais();
        vista.comboNacionalidad.removeAllItems();
        for(int i=0; i < listaPaises.size(); i++){
            vista.comboNacionalidad.addItem(new Pais(listaPaises.get(i).getIdPais(), listaPaises.get(i).getDescripcion()));
        }
        
        ArrayList<Profesion> listaProfesion = modC1.obtenerProfesion();
        vista.comboProfesion.removeAllItems();
        for(int i=0; i < listaProfesion.size(); i++){
            vista.comboProfesion.addItem(new Profesion(listaProfesion.get(i).getIdProfesion(), listaProfesion.get(i).getDescripcion()));
        }
        
        ArrayList<Limitacion> listaLimitacion = modC2.obtenerLimitacion();
        vista.comboLimitacion.removeAllItems();
        for(int i=0; i < listaLimitacion.size(); i++){
            vista.comboLimitacion.addItem(new Limitacion(listaLimitacion.get(i).getIdLimitacion(), listaLimitacion.get(i).getDescripcion()));
        }
        
         ArrayList<Departamento> listaDepartamento = modC3.obtenerDepartamento();
        vista.comboCedulaDepartamento.removeAllItems();
        for(int i=0; i < listaDepartamento.size(); i++){
            vista.comboCedulaDepartamento.addItem(new Departamento(listaDepartamento.get(i).getIdDepartamento(), listaDepartamento.get(i).getDescripcion(), listaDepartamento.get(i).getIdPais()));
        }
        
        ArrayList<Departamento> listaDepartamento1 = modC3.obtenerDepartamento();
        vista.comboVecindadDepa.removeAllItems();
        for(int i=0; i < listaDepartamento1.size(); i++){
            vista.comboVecindadDepa.addItem(new Departamento(listaDepartamento1.get(i).getIdDepartamento(), listaDepartamento1.get(i).getDescripcion(), listaDepartamento1.get(i).getIdPais()));
        }
        
        ArrayList<Pais> listaPaises1 = modC.obtenerPais();
        vista.comboPaisNac.removeAllItems();
        for(int i=0; i < listaPaises1.size(); i++){
            vista.comboPaisNac.addItem(new Pais(listaPaises1.get(i).getIdPais(), listaPaises1.get(i).getDescripcion()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.comboCedulaDepartamento){
           // System.out.println("Cambio");
            Object ob = vista.comboCedulaDepartamento.getSelectedItem();
            if(ob instanceof Departamento){
                Departamento d = (Departamento)ob;
                System.out.println(d.getIdDepartamento());
               // int n = d.getIdDepartamento();
                
            ArrayList<Municipio> listaMunicipio = modC4.obtenerMuniDeDepa(d.getIdDepartamento());
                vista.comboCedulaMuni.removeAllItems();
                for(int i=0; i < listaMunicipio.size(); i++){
                    vista.comboCedulaMuni.addItem(new Municipio(listaMunicipio.get(i).getIdMunicipio(), listaMunicipio.get(i).getDescripcion(), listaMunicipio.get(i).getIdDepartamento()));
                }
                
            }
        }
        
        
        if(e.getSource() == vista.comboVecindadDepa){
           // System.out.println("Cambio");
            Object ob = vista.comboVecindadDepa.getSelectedItem();
            if(ob instanceof Departamento){
                Departamento d = (Departamento)ob;
                System.out.println(d.getIdDepartamento());
               // int n = d.getIdDepartamento();
                
            ArrayList<Municipio> listaMunicipio = modC4.obtenerMuniDeDepa(d.getIdDepartamento());
                vista.comboVecindadMuni.removeAllItems();
                for(int i=0; i < listaMunicipio.size(); i++){
                    vista.comboVecindadMuni.addItem(new Municipio(listaMunicipio.get(i).getIdMunicipio(), listaMunicipio.get(i).getDescripcion(), listaMunicipio.get(i).getIdDepartamento()));
                }
                
            }
        }
        
        if(e.getSource() == vista.comboPaisNac){
           // System.out.println("Cambio");
            Object ob = vista.comboPaisNac.getSelectedItem();
            if(ob instanceof Pais){
                Pais p = (Pais)ob;
                System.out.println(p.getIdPais());
               // int n = d.getIdDepartamento();
                
            ArrayList<Departamento> listaDepartamento = modC3.obtenerDepaDePais(p.getIdPais());
                vista.comboDepartamentoNac.removeAllItems();
                vista.comboMunicipioNac.removeAllItems();
                for(int i=0; i < listaDepartamento.size(); i++){
                    vista.comboDepartamentoNac.addItem(new Departamento(listaDepartamento.get(i).getIdDepartamento(), listaDepartamento.get(i).getDescripcion(), listaDepartamento.get(i).getIdPais()));
                }
                
            }
        }
        
         if(e.getSource() == vista.comboDepartamentoNac){
           // System.out.println("Cambio");
            Object ob = vista.comboDepartamentoNac.getSelectedItem();
            if(ob instanceof Departamento){
                Departamento d = (Departamento)ob;
                System.out.println(d.getIdDepartamento());
               // int n = d.getIdDepartamento();
                
            ArrayList<Municipio> listaMunicipio = modC4.obtenerMuniDeDepa(d.getIdDepartamento());
                vista.comboMunicipioNac.removeAllItems();
                for(int i=0; i < listaMunicipio.size(); i++){
                    vista.comboMunicipioNac.addItem(new Municipio(listaMunicipio.get(i).getIdMunicipio(), listaMunicipio.get(i).getDescripcion(), listaMunicipio.get(i).getIdDepartamento()));
                }
                
            }
        }
         
         if(e.getSource() == vista.checkPulgarIzq || e.getSource() == vista.checkIndiceIzq || 
         e.getSource() == vista.checkMedioIzq || e.getSource() == vista.checkAnularIzq ||
         e.getSource() == vista.checkMeniqueIzq){
            mano = "izq";
            if(vista.checkPulgarIzq.isSelected()){
                dedo = vista.checkPulgarIzq.getText();
            }
            
             if(vista.checkIndiceIzq.isSelected()){
                dedo = vista.checkIndiceIzq.getText();
            }
             
              if(vista.checkMedioIzq.isSelected()){
                dedo = vista.checkMedioIzq.getText();
            }
              
               if(vista.checkAnularIzq.isSelected()){
                dedo = vista.checkAnularIzq.getText();
            }
               
                if(vista.checkMeniqueIzq.isSelected()){
                dedo = vista.checkMeniqueIzq.getText();
            }
            
            
         }
         
         if(e.getSource() == vista.checkPulgarDer || e.getSource() == vista.checkIndiceDer || 
         e.getSource() == vista.checkMedioDer || e.getSource() == vista.checkAnularDer ||
         e.getSource() == vista.checkMeniqueDer){

            mano = "der";
            if(vista.checkPulgarDer.isSelected()){
                dedo = vista.checkPulgarDer.getText();
            }
            
             if(vista.checkIndiceDer.isSelected()){
                dedo = vista.checkIndiceDer.getText();
            }
             
              if(vista.checkMedioDer.isSelected()){
                dedo = vista.checkMedioDer.getText();
            }
              
               if(vista.checkAnularDer.isSelected()){
                dedo = vista.checkAnularDer.getText();
            }
               
                if(vista.checkMeniqueDer.isSelected()){
                dedo = vista.checkMeniqueDer.getText();
            }
            
            
         }
         
         if(e.getSource() == vista.btnIniciarCamara){
             Thread hilo = new Thread(){
                 
                 @Override
                 public void run(){
                     webcamPanel.start();
                 }
             };
             
             hilo.setDaemon(true);
             hilo.start();
             
         }
         
         if(e.getSource() == vista.btnApagar){
             webcamPanel.stop();
         }
         
         if(e.getSource() == vista.btnTomar){
             vista.lblFoto.setText("");
             ImageIcon foto;
             foto = new ImageIcon(webcam.getImage());
             Icon iconoFoto = new ImageIcon(foto.getImage().getScaledInstance(vista.lblFoto.getWidth(), vista.lblFoto.getHeight(), Image.SCALE_SMOOTH));
             vista.lblFoto.setIcon(iconoFoto);
             
             ruta = webcam.getImage();
         }
         
         if(e.getSource() == vista.btnGuardar){
             try {
                 mod5.setIdDpi(vista.txtCui.getText());
                 java.util.Date utilDate = vista.txtEmision.getDate();
                  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    mod5.setEmision(sqlDate);
                    
                    java.util.Date utilDate1 = vista.txtVencimiento.getDate();
                  java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
                    mod5.setVencimiento(sqlDate1);
                    mod5.setMrz2(vista.txtMrz1.getText() + vista.txtMrz2.getText());

                    String directorio = System.getProperty("user.dir");
                    directorio = directorio + "\\Foto.jpg";
                    File salidaImagen = new File(directorio);
                    System.out.println(directorio);

                   try {
                        ImageIO.write(ruta, "jpg", salidaImagen);
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    //System.out.println(ruta);
                    FileInputStream foto = null;
                   try {
                       foto = new FileInputStream(directorio);
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
                   }

                   try {
                       mod5.setLongitudBytes((int) foto.getChannel().size());
                   } catch (IOException ex) {
                       Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
                   }

                    mod5.setFotografia(foto);

                   mod5.setNoSerie(vista.txtNoSerie.getText());

                   modC5.registrar(new Dpi(mod5.getIdDpi(),mod5.getEmision(), mod5.getVencimiento(), mod5.getMrz2(), mod5.getNoSerie(), mod5.getFotografia(), mod5.getLongitudBytes()));

                    mod6.setIdCapacidad(vista.txtCui.getText());
                mod6.setOfcialActivo(vista.checkOficial.isSelected());
                mod6.setSabeLeer(vista.checkLeer.isSelected());
                mod6.setSabeEscribir(vista.checkEscribir.isSelected());
                modC6.registrar(mod6);

                mod7.setIdCedula(vista.txtCui.getText());
                mod7.setNoCedula(vista.txtNoCedula.getText());
                Object ob = vista.comboCedulaMuni.getSelectedItem();
                if(ob instanceof Municipio){
                    Municipio m = (Municipio)ob;
                    mod7.setMunicipio(m.getDescripcion());
                }

                Object ob1 = vista.comboCedulaDepartamento.getSelectedItem();
                if(ob1 instanceof Departamento){
                    Departamento d = (Departamento)ob1;
                    mod7.setDepartamento(d.getDescripcion());
                }
                modC7.registrar(mod7);


                mod8.setIdVecindad(vista.txtCui.getText());
                Object ob2 = vista.comboVecindadMuni.getSelectedItem();
                if(ob2 instanceof Municipio){
                    Municipio m = (Municipio)ob2;
                    mod8.setMunicipio(m.getDescripcion());
                }

                Object ob3 = vista.comboVecindadDepa.getSelectedItem();
                if(ob3 instanceof Departamento){
                    Departamento d = (Departamento)ob3;
                    mod8.setDepartamento(d.getDescripcion());
                }
                modC8.registrar(mod8);

                  mod9.setIdFeDeEdad(vista.txtCui.getText());
                  java.util.Date utilDate2 = vista.txtFecha.getDate();
                  java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
                  mod9.setFecha(sqlDate2);

                Object ob4 = vista.comboMunicipioNac.getSelectedItem();
                if(ob4 instanceof Municipio){
                    Municipio m = (Municipio)ob4;
                    mod9.setMunicipio(m.getDescripcion());
                }

                Object ob5 = vista.comboDepartamentoNac.getSelectedItem();
                if(ob5 instanceof Departamento){
                    Departamento d = (Departamento)ob5;
                    mod9.setDepartamento(d.getDescripcion());
                }
               // mod9.setMunicipio(dedo);
               // mod9.setDepartamento(dedo);

                Object ob6 = vista.comboPaisNac.getSelectedItem();
                if(ob6 instanceof Pais){
                    Pais p = (Pais)ob6;
                    mod9.setPais(p.getDescripcion());
                }

               // mod9.setPais(dedo);
                mod9.setLibro(vista.txtLibroNac.getText());
                mod9.setFolio(vista.txtFolioNac.getText());
                mod9.setPartida(vista.txtPartidaNac.getText());
                modC9.registrar(mod9);

                mod10.setIdDpi(vista.txtCui.getText());
                mod10.setPrimerNom(vista.txtPrimernombre.getText());
                mod10.setSegundoNom(vista.txtSegundonombre.getText());
                mod10.setOtroNom(vista.txtOtronombre.getText());
                mod10.setPrimerApe(vista.txtPrimerApellido.getText());
                mod10.setSegundoApe(vista.txtSegundoApellido.getText());
                mod10.setCasadaApe(vista.txtApellidoCasada.getText());
                mod10.setGenero(vista.comboGenero.getSelectedItem().toString());
                mod10.setEstadoCivil(vista.txtEstadoCivil.getText());

                Object ob7 = vista.comboNacionalidad.getSelectedItem();
                if(ob7 instanceof Pais){
                    Pais p = (Pais)ob7;
                    int noPais = p.getIdPais();
                    mod10.setIdPais(noPais);
                }

                Object ob8 = vista.comboProfesion.getSelectedItem();
                if(ob8 instanceof Profesion){
                    Profesion pr = (Profesion)ob8;
                    int noProfesion = pr.getIdProfesion();
                    mod10.setIdProfesion(noProfesion);
                }

                Object ob9 = vista.comboLimitacion.getSelectedItem();
                if(ob9 instanceof Limitacion){
                    Limitacion l = (Limitacion)ob9;
                    int noLimitacion = l.getIdLimitacion();
                    mod10.setIdLimitaciones(noLimitacion);
                }

                mod10.setIdCapacidad(vista.txtCui.getText());
                mod10.setIdCedula(vista.txtCui.getText());
                mod10.setIdVecindad(vista.txtCui.getText());
                mod10.setIdFeDeEdad(vista.txtCui.getText());
                mod10.setNombreUsual(vista.txtNombreUsual.getText());
                mod10.setIdentificacion(vista.txtIdentificacion.getText());
                modC10.registrar(mod10);
                
                limpiarCampos();
             } catch (Exception ex) {
                 System.out.println("No se puede realizar el registro debido al siguiente error "+ex);
             }
         
   }
         
         if(e.getSource() == vista.btnGenerarReporte){
            
             try {
                ConexionBd con = new ConexionBd();
                Connection conn = con.obtenerConexion();

                JasperReport reporte = null;
                String path = System.getProperty("user.dir");
                path = path + "\\Reporte.jasper";

                Map parametro = new HashMap();
                parametro.put("parametro", vista.txtCuiReporte.getText());
                
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                
                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);
                
                JasperViewer view = new JasperViewer(jprint, false);
                
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
                view.setVisible(true);
                
             } catch (JRException ex) {
                 Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
                 
             }
             
             
             
         }
         
         if(e.getSource() == vista.btnRegresar){
             Inicio view = new Inicio();
        
             ControladorInicio ctrl = new ControladorInicio(view);
             ctrl.mostrarVista();
             view.setVisible(true);
             vista.dispose();
             
         }
    }
    
    public void limpiarCampos(){
        vista.txtCui.setText("");
        vista.txtEmision.setDate(null);
        vista.txtVencimiento.setDate(null);
        vista.txtPrimernombre.setText("");
        vista.txtSegundonombre.setText("");
        vista.txtOtronombre.setText("");
        vista.txtPrimerApellido.setText("");
        vista.txtSegundoApellido.setText("");
        vista.txtApellidoCasada.setText("");
        vista.txtMrz1.setText("");
        vista.txtMrz2.setText("");
        vista.lblFoto.setIcon(null);
        vista.comboGenero.setSelectedIndex(0);
        vista.txtEstadoCivil.setText("");
        vista.comboNacionalidad.setSelectedIndex(0);
        vista.txtNoSerie.setText("");
        vista.comboProfesion.setSelectedIndex(0);
        vista.comboLimitacion.setSelectedIndex(0);
        vista.checkOficial.setSelected(false);
        vista.checkLeer.setSelected(false);
        vista.checkEscribir.setSelected(false);
        vista.txtNoCedula.setText("");
        vista.comboCedulaMuni.setSelectedIndex(0);
        vista.comboCedulaDepartamento.setSelectedIndex(0);
        vista.comboVecindadMuni.setSelectedIndex(0);
        vista.comboVecindadDepa.setSelectedIndex(0);
        vista.txtFecha.setDate(null);
        vista.comboMunicipioNac.setSelectedIndex(0);
        vista.comboDepartamentoNac.setSelectedIndex(0);
        vista.comboPaisNac.setSelectedIndex(0);
        vista.txtLibroNac.setText("");
        vista.txtFolioNac.setText("");
        vista.txtPartidaNac.setText("");
        vista.checkPulgarIzq.setSelected(false);
        vista.checkIndiceIzq.setSelected(false);
        vista.checkMedioIzq.setSelected(false);
        vista.checkAnularIzq.setSelected(false);
        vista.checkMeniqueIzq.setSelected(false);
        vista.checkPulgarDer.setSelected(false);
        vista.checkIndiceDer.setSelected(false);
        vista.checkMedioDer.setSelected(false);
        vista.checkAnularDer.setSelected(false);
        vista.checkMeniqueDer.setSelected(false);
    }
   
}
