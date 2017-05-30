/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytwitter;

import javax.swing.JOptionPane;
import twitter4j.*;

/**
 * Clase principal.
 * @author Diego
 */
public class MyTwitter {

    /**
     * Método main con un menú para escoger que hacer.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autentificar obj = new Autentificar();
        int select;
        do{
        select = Integer.parseInt(JOptionPane.showInputDialog("1: Enviar tweet.\n2: Ver tweets.\n3: Enviar mensaje directo.\n4: Buscar tweets.\n5:Salir."));
        switch(select){
            case 1: obj.postATweet(JOptionPane.showInputDialog("Nuevo tweet (140 caracteres):"));
                    break;
            case 2: obj.getTimeline("done");
                    break;
            case 3: obj.directMessages(JOptionPane.showInputDialog("Usuario al que enviar el mensaje directo."), JOptionPane.showInputDialog("Mensaje."));
                    break;
            case 4: obj.searchTweet(JOptionPane.showInputDialog("¿Qué quieres buscar?"));
                    break;
        }
        }while(select!=5);
    }
    
}
