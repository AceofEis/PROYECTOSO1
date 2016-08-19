/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author eisne
 */
public class Reloj extends Thread{
    
    private JLabel lbl;
    public Reloj (JLabel lbl)
            {
                this.lbl = lbl;
            }

    Reloj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void run()
    {
        while(true)
        {
            Date hoy = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            lbl.setText(sdf.format(hoy));
            
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
