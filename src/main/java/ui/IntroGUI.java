/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import DataClasses.Location;
import bl.LLM;
import bl.WTM;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class IntroGUI extends javax.swing.JFrame
{

  private WTM wtm = new WTM();
  private LLM lm = new LLM();

  public IntroGUI()
  {
    initComponents();
    jtTable.setModel(wtm);
    ltList.setModel(lm);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jPopupMenu1 = new javax.swing.JPopupMenu();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenuItem5 = new javax.swing.JMenuItem();
    jPanel6 = new javax.swing.JPanel();
    jPanel4 = new javax.swing.JPanel();
    jSplitPane1 = new javax.swing.JSplitPane();
    jScrollPane3 = new javax.swing.JScrollPane();
    ltList = new javax.swing.JList();
    jScrollPane2 = new javax.swing.JScrollPane();
    jtTable = new javax.swing.JTable();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();

    jMenuItem3.setText("Apply");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        onShow(evt);
      }
    });
    jPopupMenu1.add(jMenuItem3);

    jMenuItem4.setText("delete");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        onDelete(evt);
      }
    });
    jPopupMenu1.add(jMenuItem4);

    jMenuItem5.setText("edit");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jMenuItem5ActionPerformed(evt);
      }
    });
    jPopupMenu1.add(jMenuItem5);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel6.setLayout(new java.awt.GridLayout(1, 0));
    getContentPane().add(jPanel6, java.awt.BorderLayout.PAGE_END);

    jPanel4.setLayout(new java.awt.GridLayout(1, 0));

    jScrollPane3.setComponentPopupMenu(jPopupMenu1);

    ltList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    ltList.setComponentPopupMenu(jPopupMenu1);
    jScrollPane3.setViewportView(ltList);

    jSplitPane1.setLeftComponent(jScrollPane3);

    jtTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String []
      {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane2.setViewportView(jtTable);

    jSplitPane1.setRightComponent(jScrollPane2);

    jPanel4.add(jSplitPane1);

    getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

    jMenu1.setText("Data");

    jMenuItem1.setText("Add Destination");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jMenuItem1ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem1);

    jMenuItem2.setText("Day");
    jMenu1.add(jMenuItem2);

    jMenuBar1.add(jMenu1);

    setJMenuBar(jMenuBar1);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem1ActionPerformed
  {//GEN-HEADEREND:event_jMenuItem1ActionPerformed
    DestinationDlg dlg = new DestinationDlg(this, true);
    dlg.setVisible(true);
    lm.add(dlg.getLoc());
  }//GEN-LAST:event_jMenuItem1ActionPerformed

  private void onShow(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onShow
  {//GEN-HEADEREND:event_onShow
    int index = ltList.getSelectedIndex();
    try
    {
      wtm.addToList(lm.getName(index));
    } catch (IOException ex)
    {
      Logger.getLogger(IntroGUI.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_onShow

  private void onDelete(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onDelete
  {//GEN-HEADEREND:event_onDelete
    int index = ltList.getSelectedIndex();
    lm.remove(index);
  }//GEN-LAST:event_onDelete

  private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem5ActionPerformed
  {//GEN-HEADEREND:event_jMenuItem5ActionPerformed
    ReplaceDlg dlg = new ReplaceDlg(this, true);
    dlg.setVisible(true);
    int index = ltList.getSelectedIndex();
    dlg.get(lm.get(index));
    lm.replace(index, dlg.getLoc());
    
  }//GEN-LAST:event_jMenuItem5ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(IntroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(IntroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(IntroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(IntroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new IntroGUI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPopupMenu jPopupMenu1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JSplitPane jSplitPane1;
  private javax.swing.JTable jtTable;
  private javax.swing.JList ltList;
  // End of variables declaration//GEN-END:variables
}
