/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.apprenap;

import controlador.ControladorInicio;
import vista.Inicio;

/**
 *
 * @author Chris
 */
public class AppRenap {

    public static void main(String[] args) {
        Inicio view = new Inicio();
        
        ControladorInicio ctrl = new ControladorInicio(view);
        ctrl.mostrarVista();
        view.setVisible(true);
       
    }
}
