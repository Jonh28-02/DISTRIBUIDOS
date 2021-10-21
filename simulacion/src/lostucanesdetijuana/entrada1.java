
package lostucanesdetijuana;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class entrada1 extends Thread {
    
    public JLabel grupo;
    
    public ventaboletos taq;
    
    public int random;
    
    public int xinit;
    
    public int yinit;
    
    public entrada1(JLabel eti, int random, ventaboletos p, int x, int y) {
        
        this.grupo = eti;
        this.taq = p;
        this.random = 1;
        this.xinit = x;
        this.yinit = y;     
    }

    entrada1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        
        
        boolean camino_taquilla = false;
        boolean camino_puerta = false;
        int x, y;
        
        while (taq.contador != 1000) {
            
            try {
                sleep(20);
            } catch (InterruptedException ex) {

            }
            x = taq.getGrupo().getLocation().x;
            y = taq.getGrupo().getLocation().y;
            
            if (!camino_taquilla && x < taq.getVenta().getLocation().x) {
                taq.getGrupo().setLocation(taq.getGrupo().getLocation().x+10, taq.getGrupo().getLocation().y-5);
                taq.repaint();
                
                
            }else{
                camino_taquilla = true;
            }
            if(camino_taquilla && random == 0 && x > taq.getP1().getLocation().x){
                taq.getGrupo().setLocation(x-2, y-1);
                taq.repaint();
                camino_puerta = true;
            }
            else if (camino_taquilla && random == 1 && x < taq.getP2().getLocation().x){
                taq.getGrupo().setLocation(x+2, y-1);
                taq.repaint();
                camino_puerta = true;
               
               }
             else if (camino_puerta){
                taq.getGrupo().setLocation(0, yinit);
                camino_puerta = false;
                camino_taquilla = false;
                random = (int)(Math.random()*2);
                taq.contador += 20;
                taq.gerres().setText("Quedan: "+(1000-taq.contador)+" boletos");
                
                System.out.println(taq.contador);
               }
            
            
            
        


        }
        taq.gerres().setText("YA NO HAY MAS BOLETOS");
         
        }
    
    }
