package labex4;

import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class TarotGui extends javax.swing.JFrame 
{
    TarotLinkedList tll;
    TarotDeck tD;
    
    public TarotGui() 
    {
        tll = new TarotLinkedList();
        tll.populateList();
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taCircle = new javax.swing.JTable();
        New = new javax.swing.JButton();
        laRandomCardPick = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpRandomNumber = new javax.swing.JTextPane();
        laCardSwitching = new javax.swing.JLabel();
        tfCardSwitching = new javax.swing.JTextField();
        Draw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taCircle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Card 1", "Card 2", "Card 3", "Card 4", "Card 5", "Card 6", "Card 7", "Card 8", "Card 9"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        taCircle.setAutoscrolls(false);
        taCircle.setEditingColumn(0);
        taCircle.setEditingRow(0);
        taCircle.setFocusable(false);
        taCircle.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(taCircle);
        if (taCircle.getColumnModel().getColumnCount() > 0) {
            taCircle.getColumnModel().getColumn(0).setResizable(false);
            taCircle.getColumnModel().getColumn(1).setResizable(false);
            taCircle.getColumnModel().getColumn(2).setResizable(false);
            taCircle.getColumnModel().getColumn(3).setResizable(false);
            taCircle.getColumnModel().getColumn(4).setResizable(false);
            taCircle.getColumnModel().getColumn(5).setResizable(false);
            taCircle.getColumnModel().getColumn(6).setResizable(false);
            taCircle.getColumnModel().getColumn(7).setResizable(false);
            taCircle.getColumnModel().getColumn(8).setResizable(false);
        }

        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });

        laRandomCardPick.setText("Random Card Pick #:");

        jScrollPane2.setViewportView(tpRandomNumber);

        laCardSwitching.setText("Card Switching:");

        Draw.setText("Draw");
        Draw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(New)
                        .addGap(50, 50, 50)
                        .addComponent(Draw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(laRandomCardPick)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(laCardSwitching)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCardSwitching, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laCardSwitching, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(New)
                        .addComponent(laRandomCardPick)
                        .addComponent(tfCardSwitching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Draw)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        for(int i = 0; i<9; i++)
        {
            taCircle.setValueAt(null, 0, i);
        }
        tpRandomNumber.setText(null);
        tfCardSwitching.setText(null);
        tll = null;
        tll = new TarotLinkedList();
        tll.populateList();
    }//GEN-LAST:event_NewActionPerformed

    private void DrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrawActionPerformed
        if(taCircle.getValueAt(0, 0) == null)
        {
            for(int i=0; i<9; i++)
            {
                taCircle.setValueAt(tll.getNode(i).getData().getAll(), 0, i);
            }

//        taCircle.setValueAt("Queen of Knights",0,0);
//        tpRandomNumber.setText("9");
//        tfCardSwitching.setText("Queen of Knights (card 1) switched with Queen of Knights");
        }
        else if(!tll.td.getStack().empty())
        {
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please restart the game", "Restart Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DrawActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Draw;
    private javax.swing.JButton New;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel laCardSwitching;
    private javax.swing.JLabel laRandomCardPick;
    private javax.swing.JTable taCircle;
    private javax.swing.JTextField tfCardSwitching;
    private javax.swing.JTextPane tpRandomNumber;
    // End of variables declaration//GEN-END:variables
}
