/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements.messaggi;

/**
 *
 * @author luca
 */
public interface MessaggioAstratto {
    public String getTesto();
    public String getTestoCifrato();
    public String getLingua();
    public String getTitolo();
    public boolean elimina();
}
