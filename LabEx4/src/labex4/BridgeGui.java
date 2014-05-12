package labex4;

import java.util.Stack;
import javax.swing.JOptionPane;
/**
 *
 * @author Kyle Jolicoeur
 */
public class BridgeGui extends javax.swing.JFrame 
{
    Deck d1 = new Deck();
    Deck d2;
    
    Stack stackDeck;
    
    Card cNorth;
    Card cEast;
    Card cSouth;
    Card cWest;
    
    public String sWhoLeads = "North";
    public Card cWhoLeads;
    
    String sLead;
    
    public BridgeGui() 
    {
        d1.getCardID(0).setFaceValue("13");
        d1.getCardID(13).setFaceValue("13");
        d1.getCardID(26).setFaceValue("13");
        d1.getCardID(39).setFaceValue("13");
        
        stackDeck = (Stack) d1.shuffleDeck();
        
        cNorth = (Card)stackDeck.pop();
        cEast = (Card)stackDeck.pop();
        cSouth = (Card)stackDeck.pop();
        cWest = (Card)stackDeck.pop();
        cWhoLeads = cNorth;
        
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        laNorth = new javax.swing.JLabel();
        laEast = new javax.swing.JLabel();
        laSouth = new javax.swing.JLabel();
        laWest = new javax.swing.JLabel();
        laOutput = new javax.swing.JLabel();
        tfNorth = new javax.swing.JTextField();
        tfEast = new javax.swing.JTextField();
        tfSouth = new javax.swing.JTextField();
        tfWest = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taOutput = new javax.swing.JTextArea();
        bExit = new javax.swing.JButton();
        bDraw = new javax.swing.JButton();
        bClear = new javax.swing.JButton();
        bClearOutput = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        laNorth.setText("North");

        laEast.setText("East");

        laSouth.setText("South");

        laWest.setText("West");

        laOutput.setText("Output:");

        taOutput.setColumns(20);
        taOutput.setLineWrap(true);
        taOutput.setRows(5);
        taOutput.setWrapStyleWord(true);
        taOutput.setFocusable(false);
        jScrollPane1.setViewportView(taOutput);

        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        bDraw.setText("Draw Cards");
        bDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDrawActionPerformed(evt);
            }
        });

        bClear.setText("Clear Board");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        bClearOutput.setText("Clear Output");
        bClearOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(bDraw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bClearOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addComponent(bExit)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfWest, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(laWest)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(laEast))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfEast, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(laSouth)
                            .addComponent(laNorth)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(tfSouth, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(tfNorth, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(laOutput))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(laNorth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNorth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(laEast)
                            .addComponent(laWest))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfWest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(laSouth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSouth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(laOutput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(bClearOutput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExit)
                    .addComponent(bDraw)
                    .addComponent(bClear))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Card getcNorth() {
        return cNorth;
    }

    public void setcNorth(Card cNorth) {
        this.cNorth = cNorth;
    }

    public Card getcEast() {
        return cEast;
    }

    public void setcEast(Card cEast) {
        this.cEast = cEast;
    }

    public Card getcSouth() {
        return cSouth;
    }

    public void setcSouth(Card cSouth) {
        this.cSouth = cSouth;
    }

    public Card getcWest() {
        return cWest;
    }

    public void setcWest(Card cWest) {
        this.cWest = cWest;
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        tfEast.setText("");
        tfNorth.setText("");
        tfSouth.setText("");
        tfWest.setText("");
        taOutput.append("*Game board cleared*\n");
 
        d2 = new Deck();
        d2.getCardID(0).setFaceValue("13");
        d2.getCardID(13).setFaceValue("13");
        d2.getCardID(26).setFaceValue("13");
        d2.getCardID(39).setFaceValue("13");
        Stack newDeck = (Stack) d2.shuffleDeck();
        cNorth = (Card)newDeck.pop();
        cEast = (Card)newDeck.pop();
        cSouth = (Card)newDeck.pop();
        cWest = (Card)newDeck.pop();
        
        switch (sWhoLeads) 
        {
            case "North":
                cWhoLeads=cEast;
                sWhoLeads="East";
                break;
            case "East":
                cWhoLeads=cSouth;
                sWhoLeads="South";
                break;
            case "South":
                cWhoLeads=cWest;
                sWhoLeads="West";
                break;
            case "West":
                cWhoLeads=cNorth;
                sWhoLeads="North";
                break;
        }
        
    }//GEN-LAST:event_bClearActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExitActionPerformed

    private void bDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDrawActionPerformed
        if(!"".equals(tfNorth.getText()))
        {
            JOptionPane.showMessageDialog(null, "Please clear the game board "
                    + "first ","Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String sHigherValue = sWhoLeads;
            int iHigherValue = Integer.parseInt(cWhoLeads.getFaceValue());
            
            int iNorthFaceValue = Integer.parseInt(cNorth.getFaceValue());
            int iEastFaceValue = Integer.parseInt(cEast.getFaceValue());
            int iSouthFaceValue = Integer.parseInt(cSouth.getFaceValue());
            int iWestFaceValue = Integer.parseInt(cWest.getFaceValue());
            
            taOutput.append(sWhoLeads + " leads\n*Drawing Cards*\n");
            tfNorth.setText(cNorth.checkFaceValue() + " of " + cNorth.getSuit());                              
            tfEast.setText(cEast.checkFaceValue() + " of " + cEast.getSuit());                              
            tfSouth.setText(cSouth.checkFaceValue() + " of " + cSouth.getSuit());                              
            tfWest.setText(cWest.checkFaceValue() + " of " + cWest.getSuit());
            
            sLead= cWhoLeads.getSuit();
            switch(sWhoLeads)
            {
            case "North":
                if(sLead.equals(cEast.getSuit()) && (iEastFaceValue >= iHigherValue))
                {
                    sHigherValue = "East";
                }
                if(sLead.equals(cSouth.getSuit()) && (iSouthFaceValue >= iHigherValue))
                {
                    sHigherValue ="South";
                }
                if(sLead.equals(cWest.getSuit()) && (iWestFaceValue >= iHigherValue))
                {
                    sHigherValue="West";
                }
                break;
            case "East":
                if(sLead.equals(cNorth.getSuit()) && (iNorthFaceValue >= iHigherValue))
                {
                    sHigherValue = "North";
                }
                if(sLead.equals(cSouth.getSuit()) && (iSouthFaceValue >= iHigherValue))
                {
                    sHigherValue ="South";
                }
                if(sLead.equals(cWest.getSuit()) && (iWestFaceValue >= iHigherValue))
                {
                    sHigherValue="West";
                }
                break;
            case "South":
                if(sLead.equals(cNorth.getSuit()) && (iNorthFaceValue >= iHigherValue))
                {
                    sHigherValue = "North";
                }
                if(sLead.equals(cEast.getSuit()) && (iEastFaceValue >= iHigherValue))
                {
                    sHigherValue = "East";
                }
                if(sLead.equals(cWest.getSuit()) && (iWestFaceValue >= iHigherValue))
                {
                    sHigherValue="West";
                }  
                break;
            case "West":
                if(sLead.equals(cNorth.getSuit()) && (iNorthFaceValue >= iHigherValue))
                {
                    sHigherValue = "North";
                }
                if(sLead.equals(cEast.getSuit()) && (iEastFaceValue >= iHigherValue))
                {
                    sHigherValue = "East";
                }
                if(sLead.equals(cSouth.getSuit()) && (iSouthFaceValue >= iHigherValue))
                {
                    sHigherValue ="South";
                }
                break;
            default:
                System.err.println("error");
                break;
            }
            switch(sHigherValue)
            {
                case "North":
                    taOutput.append("North won with a " + cNorth.checkFaceValue()
                            + " of " + cNorth.getSuit() + "\n");
                    break;
                case "East":
                    taOutput.append("East won with a " + cEast.checkFaceValue()
                            + " of " + cEast.getSuit() + "\n");
                    break;
                case "South":
                    taOutput.append("South won with a " + cSouth.checkFaceValue()
                            + " of " + cSouth.getSuit() + "\n");
                    break;
                case "West":
                    taOutput.append("West won with a " + cWest.checkFaceValue()
                            + " of " + cWest.getSuit() + "\n");
                    break;
                default:
                    System.err.println("error");
                    break;
            }
        }
    }//GEN-LAST:event_bDrawActionPerformed

    private void bClearOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearOutputActionPerformed
        taOutput.setText("");
    }//GEN-LAST:event_bClearOutputActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClear;
    private javax.swing.JButton bClearOutput;
    private javax.swing.JButton bDraw;
    private javax.swing.JButton bExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel laEast;
    private javax.swing.JLabel laNorth;
    private javax.swing.JLabel laOutput;
    private javax.swing.JLabel laSouth;
    private javax.swing.JLabel laWest;
    private javax.swing.JTextArea taOutput;
    private javax.swing.JTextField tfEast;
    private javax.swing.JTextField tfNorth;
    private javax.swing.JTextField tfSouth;
    private javax.swing.JTextField tfWest;
    // End of variables declaration//GEN-END:variables

}
