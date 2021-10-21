package lostucanesdetijuana;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;

public class entrada2 extends Thread {
    public JLabel grupo;
    public ventaboletos taq;
    public int random;
    public int xinit;
    public int yinit;
    public entrada2(JLabel eti, int random, ventaboletos p, int x, int y) {
        this.grupo = eti;
        this.taq = p;
        this.random = 1;
        this.xinit = x;
        this.yinit = y;     
    }

    @Override
    
    //TIENE UN BUG QUE INTENTE DE TODO PERO SE BUGEA LOS PRIMEROS 3 GRUPOS AL ENTRAR AL CONCIERTO:CC AAAAAAAAAAAAAAAAAAAAA
    
    public void run() {
        
        int coordenadas_grupo_x, coordenadas_grupo_y;
        boolean camino_taquilla = false;
        boolean camino_puerta = false;
        while (taq.contador != 1000) {
            
            try {
                sleep(20);
            } catch (InterruptedException ex) {

            }
            coordenadas_grupo_x = taq.getGrupo2().getLocation().x;
            coordenadas_grupo_y = taq.getGrupo2().getLocation().y;
            
            if (!camino_taquilla && coordenadas_grupo_x > taq.getVenta().getLocation().x) {
                taq.getGrupo2().setLocation(taq.getGrupo2().getLocation().x-10, taq.getGrupo2().getLocation().y-5);
                taq.repaint();
                
                
            }else{
                camino_taquilla = true;
            }
            if(camino_taquilla && random == 0 && coordenadas_grupo_x > taq.getP1().getLocation().x){
                taq.getGrupo2().setLocation(coordenadas_grupo_x-2, coordenadas_grupo_y-1);
                taq.repaint();
                camino_puerta = true;
            }
            else if (camino_taquilla && random == 1 && coordenadas_grupo_x < taq.getP2().getLocation().x){
                taq.getGrupo2().setLocation(coordenadas_grupo_x+2, coordenadas_grupo_y-1);
                taq.repaint();
                camino_puerta = true;
               
               }
             else if (camino_puerta){
                taq.getGrupo2().setLocation(xinit, yinit);
                camino_puerta = false;
                camino_taquilla = false;
                random = (int)(Math.random()*2);
                taq.contador += 20;
                
                System.out.println(taq.contador);
               }
            

        }
        taq.gerres().setText("YA NO HAY MAS BOLETOS");
         
        }
}
