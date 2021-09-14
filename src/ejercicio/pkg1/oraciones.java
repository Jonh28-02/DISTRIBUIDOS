/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg1;

import java.io.Serializable;

/**
 *
 * @author river
 */
public class oraciones implements Serializable{
    
    private String Oracion;

    public oraciones(String Oracion) {
        this.Oracion = Oracion;
    }

    public String getOracion() {
        return Oracion;
    }

    public void setOracion(String Oracion) {
        this.Oracion = Oracion;
    }
    
    
}
