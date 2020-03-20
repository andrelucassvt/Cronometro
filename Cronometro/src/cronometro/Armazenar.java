/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro;

/**
 *
 * @author andre
 */
public class Armazenar{ 
    private int minutos;
    private int segundos;   
    private int armazenar_minutos;
    private String armazenar_segundos;

    
    
    
    
    //Gett e Sett
    public int getArmazenar_minutos() {
        return armazenar_minutos;
    }

    public void setArmazenar_minutos(int armazenar_minutos) {
        this.armazenar_minutos = armazenar_minutos;
    }

    public String getArmazenar_segundos() {
        return armazenar_segundos;
    }

    public void setArmazenar_segundos(String armazenar_segundos) {
        this.armazenar_segundos = armazenar_segundos;
    }
    
    
    
    
    
}
