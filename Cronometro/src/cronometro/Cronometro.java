/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author andre
 */
public class Cronometro extends javax.swing.JFrame {

    /**
     * Creates new form Cronometro
     */

    public Cronometro() {
        initComponents();
    }

    /**
     * int Quan This method is called from within the constructor to initialize
     * the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // End of variables declaration     

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Voltar = new javax.swing.JButton();
        Iniciar = new javax.swing.JButton();
        resultado = new javax.swing.JLabel();
        resultadoEsquerda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Voltar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Voltar.setText("Zerar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        Iniciar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        resultado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        resultado.setText("00");

        resultadoEsquerda.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        resultadoEsquerda.setText("00");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Iniciar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(resultadoEsquerda)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(resultado)
                        .addGap(0, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultado)
                    .addComponent(resultadoEsquerda)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Voltar)
                    .addComponent(Iniciar))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int Quanridade_de_clicks = 0;
    boolean pediuParada = false;
    
    int segundos = 0;
    int minutos = 0;

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
    	Thread cronometro = new Thread(new Runnable() {
            public void run(){
                //Parte criada para o quando o botao "Zerar" for acionado
                pediuParada = false;
                segundos = 0;
                minutos = 0;
                //FIM
                for(; segundos <= 60; segundos++) {
                	if(pediuParada) {
                		pediuParada = false;
                		break;
                	}
                	
                    if(segundos < 10) {
                        resultado.setText( String.valueOf("0"+segundos) );
                        
                    } else {
                        resultado.setText( String.valueOf(segundos) );
  
                    }
                    //Aumentando os minutos
                    //parte para adicionar os minutos
                    if(segundos == 60 && minutos < 10){
                        segundos = 0;
                        minutos++;
                        
                        if(segundos < 10) {
                            resultado.setText( String.valueOf("0"+segundos) );
                        } else {
                            resultado.setText( String.valueOf(segundos) );
                        }
                        
                        if(minutos < 10) {
                        	resultadoEsquerda.setText(String.valueOf("0" + minutos));
                        } else {
                        	resultadoEsquerda.setText(String.valueOf(minutos));
                        }
                    }
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                
            }    
        });
 
        //Variavel
        if(Quanridade_de_clicks == 0){
        	
        	cronometro.start();
	        
	        Iniciar.setText("Parar");
	        Quanridade_de_clicks = 1;
	        
        } else if (Quanridade_de_clicks == 1) {
        	Quanridade_de_clicks = 0;
        	pediuParada = true;
        	Iniciar.setText("Retomar");
        }
            
        
   
    }//GEN-LAST:event_IniciarActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        resultadoEsquerda.setText(String.valueOf("0"+0));
        resultado.setText(String.valueOf("0"+0));
        pediuParada = true;
        Quanridade_de_clicks = 0;
        
        
        
    }//GEN-LAST:event_VoltarActionPerformed

    public static void time() {
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {

        }

    }

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cronometro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cronometro().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iniciar;
    private javax.swing.JButton Voltar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel resultado;
    private javax.swing.JLabel resultadoEsquerda;
    // End of variables declaration//GEN-END:variables

}
