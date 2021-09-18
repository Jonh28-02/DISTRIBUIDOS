/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subneteo;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class EJERCICIOS_SUBNETEO extends javax.swing.JFrame {
   
    String IP;
    String []IPS;
    int digito, PO,SO,TO,CO,n,ROB;
    String binario1,binario2,binario3,binario4;

   //UwU
   
   public static String binarear(int n, int l ) throws Exception {
       double pow =  Math.pow(2, l);
       StringBuilder binary = new StringBuilder();
        if ( pow < n ) {
            throw new Exception("Ingresa un numero correcto");
        }
       int shift = l- 1;
       for (; shift >= 0 ; shift--) {
           int bit = (n >> shift) & 1;
           if (bit == 1) {
               binary.append("1");
           } else {
               binary.append("0");
           }
       }
       return binary.toString();
   }
   

   public static String mascaraBin(int ROB,String mascara_robada){

      StringBuilder Nueva_Mascara=new StringBuilder(mascara_robada);
      for(int i=mascara_robada.indexOf('0');ROB!=0;i++){
          Nueva_Mascara.setCharAt(i,'1');
          mascara_robada=Nueva_Mascara.toString();
          ROB=ROB-1;
      }
       return mascara_robada;
   }
   
   
   
   public static String MascaraDec(String masBin){
      
       String[] arrayMR = masBin.split("\\.");
       String oc1,oc2,oc3,oc4;
       oc1=String.valueOf(BIDE(arrayMR[0]));
       oc2=String.valueOf(BIDE(arrayMR[1]));
       oc3=String.valueOf(BIDE(arrayMR[2]));
       oc4=String.valueOf(BIDE(arrayMR[3]));
       
        String mascara = oc1+"."+oc2+"."+oc3+"."+oc4;
       return mascara;
   }
   
   public static long BIDE(String binario){
		
        long decimal = 0;
        int posicion = 0;
        
        for (int x = binario.length() - 1; x >= 0; x--) {
                
                short digito = 1;
                if (binario.charAt(x) == '0') {
                        digito = 0;
                }

               
                double multiplicador = Math.pow(2, posicion);
                decimal += digito * multiplicador;
                posicion++;
        }
        return decimal;
   }

   public static int Ceros(String mascara){
               int ceros = 0;
               System.out.println("LA MASCARA ES "+mascara);
        char temp;
        for (int i = 0; i < mascara.length(); i++) {

            temp = mascara.charAt(i);
            if (temp == '0')
                ceros++;
        }
        return ceros;
   }
   

   public static int salto(String clase, String mascara){
        int salto=0;
       
            if("A".equals(clase)){ 
                String[] arrayMA = mascara.split("\\.");
                int nu1 = Integer.parseInt(arrayMA[1]);
                salto=256-nu1;

            }
             
            if("B".equals(clase)){ 
                String[] arrayMA = mascara.split("\\.");
                int nu1 = Integer.parseInt(arrayMA[2]);
                salto=256-nu1;

            }

            if("C".equals(clase)){ 
                String[] arrayMA = mascara.split("\\.");
                int nu1 = Integer.parseInt(arrayMA[3]);
                salto=256-nu1;

            }            
        
        return salto;
       
   }
   

    static String[][] returnArrayTabla(String IP,int P,String hostxD, int Salto) throws Exception {
        int salto1=0;

        String[] arrayIP = IP.split("\\.");
        String data[][]=new String [P][6];
        for(int i=0;i<P;i++){
            data[i][0]=String. valueOf(i+1);
            data[i][1]=arrayIP[0]+"."+salto1+"."+0+"."+0;
            salto1=salto1+Salto; 
            data[i][2]=arrayIP[0]+"."+(salto1-1)+"."+255+"."+255;
            data[i][3]=hostxD;
            String subr = data[i][1];
             String subr2 = data[i][2];
            String[] arraySubRed=subr.split("\\.");
            String[] arraySubRed2=subr2.split("\\.");
            data[i][4]=binarear(Integer.parseInt(arraySubRed[0]),8)+"."+binarear(Integer.parseInt(arraySubRed[1]),8)+"."+binarear(Integer.parseInt(arraySubRed[2]),8)+"."+binarear(Integer.parseInt(arraySubRed[3]),8);
            data[i][5]=binarear(Integer.parseInt(arraySubRed2[0]),8)+"."+binarear(Integer.parseInt(arraySubRed2[1]),8)+"."+binarear(Integer.parseInt(arraySubRed2[2]),8)+"."+binarear(Integer.parseInt(arraySubRed2[3]),8);
            
            
        }
        return data;
    }
    
    
    

    static String[][] returnArrayTablaB(String IP,int P,String hostxD,int Salto) throws Exception {
        int salto1=0;

        String[] arrayIP = IP.split("\\.");
        String data[][]=new String [P][6];
        for(int i=0;i<P;i++){
            data[i][0]=String. valueOf(i+1);
            data[i][1]=arrayIP[0]+"."+arrayIP[1]+"."+salto1+"."+0;
            salto1=salto1+Salto; 
            data[i][2]=arrayIP[0]+"."+arrayIP[1]+"."+(salto1-1)+"."+255;
            data[i][3]=hostxD;
            String subr = data[i][1];
             String subr2 = data[i][2];
            String[] arraySubRed=subr.split("\\.");
            String[] arraySubRed2=subr2.split("\\.");
            data[i][4]=binarear(Integer.parseInt(arraySubRed[0]),8)+"."+binarear(Integer.parseInt(arraySubRed[1]),8)+"."+binarear(Integer.parseInt(arraySubRed[2]),8)+"."+binarear(Integer.parseInt(arraySubRed[3]),8);
            data[i][5]=binarear(Integer.parseInt(arraySubRed2[0]),8)+"."+binarear(Integer.parseInt(arraySubRed2[1]),8)+"."+binarear(Integer.parseInt(arraySubRed2[2]),8)+"."+binarear(Integer.parseInt(arraySubRed2[3]),8);
        }
        return data;
    }
    
    

    static String[][] returnArrayTablaC(String IP,int P,String hostxD,int Salto) throws Exception {
        int salto1=0;

        String[] arrayIP = IP.split("\\.");
        String data[][]=new String [P][6];
        for(int i=0;i<P;i++){
            data[i][0]=String. valueOf(i+1);
            data[i][1]=arrayIP[0]+"."+arrayIP[1]+"."+arrayIP[2]+"."+salto1;
            salto1=salto1+Salto; 
            data[i][2]=arrayIP[0]+"."+arrayIP[1]+"."+arrayIP[2]+"."+(salto1-1);
            data[i][3]=hostxD;
            String subr = data[i][1];
             String subr2 = data[i][2];
            String[] arraySubRed=subr.split("\\.");
            String[] arraySubRed2=subr2.split("\\.");
            data[i][4]=binarear(Integer.parseInt(arraySubRed[0]),8)+"."+binarear(Integer.parseInt(arraySubRed[1]),8)+"."+binarear(Integer.parseInt(arraySubRed[2]),8)+"."+binarear(Integer.parseInt(arraySubRed[3]),8);
            data[i][5]=binarear(Integer.parseInt(arraySubRed2[0]),8)+"."+binarear(Integer.parseInt(arraySubRed2[1]),8)+"."+binarear(Integer.parseInt(arraySubRed2[2]),8)+"."+binarear(Integer.parseInt(arraySubRed2[3]),8);
        }
        return data;
    }
   
   
   
   

    /**
     * Creates new form VentanaSubne
     */
    public EJERCICIOS_SUBNETEO() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DIP = new javax.swing.JTextField();
        NR = new javax.swing.JTextField();
        ACEP = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaOctetos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mascarita = new javax.swing.JLabel();
        clase = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mascro = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        salto = new javax.swing.JLabel();
        host = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        direcciones = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(java.awt.Color.black);
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setText("SUBNETEO");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("Numero de Subredes");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("Numero de Direccion IP:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        DIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DIPActionPerformed(evt);
            }
        });
        jPanel3.add(DIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 190, -1));

        NR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NRActionPerformed(evt);
            }
        });
        jPanel3.add(NR, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 140, 20));

        ACEP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/subneteo/Imagenes/acep_norm.png"))); // NOI18N
        ACEP.setBorder(null);
        ACEP.setBorderPainted(false);
        ACEP.setContentAreaFilled(false);
        ACEP.setFocusPainted(false);
        ACEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACEPActionPerformed(evt);
            }
        });
        jPanel3.add(ACEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, 20));

        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/subneteo/Imagenes/eliminar_norm.png"))); // NOI18N
        borrar.setBorder(null);
        borrar.setBorderPainted(false);
        borrar.setContentAreaFilled(false);
        borrar.setFocusPainted(false);
        borrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/subneteo/Imagenes/eliminar_press.png"))); // NOI18N
        borrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/subneteo/Imagenes/eliminar_roll.png"))); // NOI18N
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jPanel3.add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, 20));

        tablaOctetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Primer Octeto", "Segundo Octeto", "Tercer Octeto", "Cuarto Octeto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaOctetos);
        if (tablaOctetos.getColumnModel().getColumnCount() > 0) {
            tablaOctetos.getColumnModel().getColumn(0).setResizable(false);
            tablaOctetos.getColumnModel().getColumn(1).setResizable(false);
            tablaOctetos.getColumnModel().getColumn(2).setResizable(false);
            tablaOctetos.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, 50));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel5.setText("Clase de Red:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel6.setText("Mascara Actual:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        mascarita.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        mascarita.setForeground(new java.awt.Color(255, 0, 102));
        jPanel3.add(mascarita, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        clase.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        clase.setForeground(new java.awt.Color(255, 51, 102));
        jPanel3.add(clase, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel7.setText("Mascara de Red:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        mascro.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        mascro.setForeground(new java.awt.Color(255, 51, 102));
        jPanel3.add(mascro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel8.setText("Rango de salto:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 170, 30));

        salto.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        salto.setForeground(new java.awt.Color(255, 51, 102));
        jPanel3.add(salto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        host.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        host.setForeground(new java.awt.Color(255, 51, 102));
        jPanel3.add(host, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 200, 40));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel11.setText("Host/SubRed:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 150, 30));

        direcciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nº", "ID Red", "Rango IP", "Host/Subred", "ID Red (bin)", "Rango IP(bin)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(direcciones);
        if (direcciones.getColumnModel().getColumnCount() > 0) {
            direcciones.getColumnModel().getColumn(0).setResizable(false);
            direcciones.getColumnModel().getColumn(1).setResizable(false);
            direcciones.getColumnModel().getColumn(2).setResizable(false);
            direcciones.getColumnModel().getColumn(3).setResizable(false);
            direcciones.getColumnModel().getColumn(4).setResizable(false);
            direcciones.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 690, 120));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel9.setText("DIRECCIONES");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 280, -1));

        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, -70, 870, 830));

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DIPActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_DIPActionPerformed

    private void ACEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACEPActionPerformed
        // TODO add your handling code here:

        IP=DIP.getText();
        //EXPRESION REGULAR PARA SABER SI ES UNA IP
        String pattern = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";
        int exp=0;
        int P;

        if(IP.matches(pattern)){
            try {
                String[] arrayIP = IP.split("\\.");
                
             
                binario1=binarear(Integer.parseInt(arrayIP[0]),8);
                                
              
                binario2=binarear(Integer.parseInt(arrayIP[1]),8);
                
               
                binario3=binarear(Integer.parseInt(arrayIP[2]),8);
                
              
                binario4=binarear(Integer.parseInt(arrayIP[3]),8);
                
            
                        if(Integer.parseInt(arrayIP[0])<127){
                            clase.setText("A");
                        }
                        if(Integer.parseInt(arrayIP[0])>127&&Integer.parseInt(arrayIP[0])<191){
                            clase.setText("B");
                        }
                        if(Integer.parseInt(arrayIP[0])>191 && Integer.parseInt(arrayIP[0])<223){
                            clase.setText("C");
                        }
                        
               
                        if("A".equals(clase.getText())){
                            mascarita.setText("255.0.0.0");
                        }
                        if("B".equals(clase.getText())){
                            mascarita.setText("255.255.0.0");
                        }
                        if("C".equals(clase.getText())){
                            mascarita.setText("255.255.255.0");
                        }     
                        

                        
                        

                
              
                
                String nombreColumnas[]={"Primer Octeto","Segundo Octeto","Tercer Octeto","Cuarto Octeto"};
                String data[][]=new String[1][4];
                
                data[0][0]=binario1;
                data[0][1]=binario2;
                data[0][2]=binario3;
                data[0][3]=binario4;
                
                tablaOctetos.setModel(new DefaultTableModel(data,nombreColumnas));
                
                
              
                int redes = Integer.parseInt(NR.getText());
                int num=0;
                int residuo=0;

                    for(int i=0;i<100;i++){
                        residuo=(int) (Math.pow(2,i)-redes);
                        if(residuo>=0){
                            num=(int) Math.pow(2, i);
                            break;
                        }
                    }
                   System.out.println("EL NUMERO EEEEEEES"+num);
                
                ROB=(int) (Math.log10(num)/Math.log10(2));
                
                    
               
                        if("A".equals(clase.getText())){ 
                        
                         String bin = mascaraBin(ROB,"11111111.00000000.00000000.00000000");
                           
                         mascro.setText(MascaraDec(bin));
                          
                         salto.setText(String. valueOf(salto("A",MascaraDec(bin))));
                          
                         int ceros=Ceros(bin);
                         int HSR=(int) ((Math.pow(2,ceros))-2);
                         host.setText(String.valueOf(HSR));
                          
                         String columnas[]={"Nº","ID Red","Rango IP","Host/Subred","ID Red (Binario)","Rango IP(Binario)"};
                         direcciones.setModel(new DefaultTableModel(returnArrayTabla(IP, (int) Math.pow(2,ROB),String.valueOf(HSR),salto("A",MascaraDec(bin))),columnas));
                         
                         
                            
                        }
                        if("B".equals(clase.getText())){
                            String bin=(mascaraBin(ROB,"11111111.11111111.00000000.00000000"));
                            mascro.setText(MascaraDec(bin));
                            salto.setText(String. valueOf(salto("B",MascaraDec(bin))));
                           
                            int ceros=Ceros(bin);
                            int HSR=(int) ((Math.pow(2,ceros))-2);
                            host.setText(String.valueOf(HSR));
                              
                            String columnas[]={"Nº","ID Red","Rango IP","Host/Subred","ID Red (Binario)","Rango IP(Binario)"};
                            direcciones.setModel(new DefaultTableModel(returnArrayTablaB(IP, (int) Math.pow(2,ROB),String.valueOf(HSR),salto("B",MascaraDec(bin))),columnas));                   
                            
                            
                            
                            
                            
                            
                        }
                        if("C".equals(clase.getText())){
                            String bin=(mascaraBin(ROB,"11111111.11111111.11111111.00000000"));
                            mascro.setText(MascaraDec(bin));
                            salto.setText(String. valueOf(salto("C",MascaraDec(bin))));
                          
                            int ceros=Ceros(bin);
                            int HSR=(int) ((Math.pow(2,ceros))-2);
                            host.setText(String.valueOf(HSR));
                           
                            String columnas[]={"Nº","ID Red","Rango IP","Host/Subred","ID Red (Binario)","Rango IP(Binario)"};
                            direcciones.setModel(new DefaultTableModel(returnArrayTablaC(IP, (int) Math.pow(2,ROB),String.valueOf(HSR),salto("C",MascaraDec(bin))),columnas));                                  
                            
                        }                     
                
 
            } catch (Exception ex) {
                Logger.getLogger(EJERCICIOS_SUBNETEO.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
        }else{
            JOptionPane.showMessageDialog(null,"Ingresa un numero corecto","",JOptionPane.INFORMATION_MESSAGE);}
       
        
    }//GEN-LAST:event_ACEPActionPerformed



    
    
    
    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        DIP.setText("");
        NR.setText("");
        String nombreColumnas[]={"Primer Octeto","Segundo Octeto","Tercer Octeto","Cuarto Octeto"};          
        Double data[][]=new Double[1][4];
          data[0][0]=0.0;
          data[0][1]=0.0;
          data[0][2]=0.0;
          data[0][3]=0.0;
      tablaOctetos.setModel(new DefaultTableModel(data,nombreColumnas)); 
      mascarita.setText("");
      clase.setText("");
      mascro.setText("");
    }//GEN-LAST:event_borrarActionPerformed

    private void NRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NRActionPerformed

    /**
     * @param args thes command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EJERCICIOS_SUBNETEO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EJERCICIOS_SUBNETEO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EJERCICIOS_SUBNETEO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EJERCICIOS_SUBNETEO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EJERCICIOS_SUBNETEO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACEP;
    private javax.swing.JTextField DIP;
    private javax.swing.JTextField NR;
    private javax.swing.JButton borrar;
    private javax.swing.JLabel clase;
    private javax.swing.JTable direcciones;
    private javax.swing.JLabel host;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mascarita;
    private javax.swing.JLabel mascro;
    private javax.swing.JLabel salto;
    private javax.swing.JTable tablaOctetos;
    // End of variables declaration//GEN-END:variables
}
