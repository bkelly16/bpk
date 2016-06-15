
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Brett Kelly
 */
public class Dashboard extends javax.swing.JFrame {

    DataSet dataSet = new DataSet();

    public Dashboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fileChooser = new javax.swing.JFileChooser();
        importData = new javax.swing.JButton();
        cpuChart = new javax.swing.JButton();
        ramChart = new javax.swing.JButton();
        dataChart = new javax.swing.JButton();
        networkChart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idLabel1 = new javax.swing.JLabel();
        dateLabel1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        dateDisplay = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        idDisplay = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        cpuDisplay = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        ramDisplay = new javax.swing.JTextPane();
        clearData = new javax.swing.JButton();
        displayChart = new javax.swing.JButton();

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

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        importData.setText("Import Data");
        importData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importDataActionPerformed(evt);
            }
        });

        cpuChart.setText("CPU Load");
        cpuChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpuChartActionPerformed(evt);
            }
        });

        ramChart.setText("RAM Usage");
        ramChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramChartActionPerformed(evt);
            }
        });

        dataChart.setText("Data Bus");
        dataChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataChartActionPerformed(evt);
            }
        });

        networkChart.setText("Network Bus");
        networkChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkChartActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/misc/Pod-Storinator.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/misc/45drives.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        dateLabel.setText("Date:");

        idLabel.setText("SystemID:");

        idLabel1.setText("TotalRAM(MB):");

        dateLabel1.setText("TotalCPU:");

        jScrollPane6.setViewportView(dateDisplay);

        jScrollPane7.setViewportView(idDisplay);

        jScrollPane8.setViewportView(cpuDisplay);

        jScrollPane9.setViewportView(ramDisplay);

        clearData.setText("Clear Data");
        clearData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDataActionPerformed(evt);
            }
        });

        displayChart.setText("Display Data");
        displayChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayChartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(idLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateLabel1)
                                    .addComponent(idLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane7)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(importData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clearData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addComponent(displayChart)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cpuChart, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ramChart, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dataChart, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(networkChart))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpuChart)
                            .addComponent(ramChart))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(networkChart)
                            .addComponent(dataChart)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(displayChart)))
                .addGap(18, 18, 18)
                .addComponent(importData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearData)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void importDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importDataActionPerformed
        try {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                dataSet.filePath = file.getAbsolutePath();
            } else {
                System.out.println("File access cancelled by user.");
            }
            if( dataSet.header.dateStamp == 0){
                    Log.importLog(dataSet);
            }else{
                System.out.println("Log Already Imported, Clear First");
            }
            //Log.printCPUSet(dataSet.cpuCores);
            //Log.printDevName(dataSet);
            //Log.printNICName(dataSet);
            //Log.printNicStats(dataSet.nicList);
            updateHeaderDisplay();

        } catch (IOException | ParseException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_importDataActionPerformed

    private void cpuChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpuChartActionPerformed
        DisplayData.cpuPlot(dataSet.cpu.uCPU, dataSet.timeStamp.timeStamp, "User Load %");
        DisplayData.cpuPlot(dataSet.cpu.sCPU, dataSet.timeStamp.timeStamp, "System Load %");
    }//GEN-LAST:event_cpuChartActionPerformed

    private void ramChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramChartActionPerformed
        DisplayData.ramPlot(dataSet.ram.usedMem, dataSet.timeStamp.timeStamp, "Used Memory");
        DisplayData.ramPlot(dataSet.ram.sharedMem, dataSet.timeStamp.timeStamp, "Shared Memory");
        DisplayData.ramPlot(dataSet.ram.buffMem, dataSet.timeStamp.timeStamp, "Buffer Space");
        DisplayData.ramPlot(dataSet.ram.cacheMem, dataSet.timeStamp.timeStamp, "Cache");
        DisplayData.ramPlot(dataSet.ram.totalSwapMem, dataSet.timeStamp.timeStamp, "Total Swap Space");
        DisplayData.ramPlot(dataSet.ram.usedSwapMem, dataSet.timeStamp.timeStamp, "Used Swap Space");
    }//GEN-LAST:event_ramChartActionPerformed

    private void dataChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataChartActionPerformed
        DisplayData.dataPlot(dataSet.dev.rds, dataSet.timeStamp.timeStamp, "Sectors Read Succesfully");
        DisplayData.dataPlot(dataSet.dev.wrs, dataSet.timeStamp.timeStamp, "Sectors Written Succesfully");
        DisplayData.dataPlot(dataSet.dev.rdi, dataSet.timeStamp.timeStamp, "Read IOs Completed");
        DisplayData.dataPlot(dataSet.dev.rdm, dataSet.timeStamp.timeStamp, "Number of Reads Merged");
        DisplayData.dataPlot(dataSet.dev.rdt, dataSet.timeStamp.timeStamp, "Total Milliseconds Spent By Reads");
        DisplayData.dataPlot(dataSet.dev.wri, dataSet.timeStamp.timeStamp, "Write IOS Completed");
        DisplayData.dataPlot(dataSet.dev.wrm, dataSet.timeStamp.timeStamp, "Number of Writes Merged");
        DisplayData.dataPlot(dataSet.dev.wrt, dataSet.timeStamp.timeStamp, "Total Milliseconds Spent By Writes");
        DisplayData.dataPlot(dataSet.dev.iop, dataSet.timeStamp.timeStamp, "Total # of IOs in Progress");
        DisplayData.dataPlot(dataSet.dev.tot, dataSet.timeStamp.timeStamp, "Number of Milliseoncd spent on IO");
        DisplayData.dataPlot(dataSet.dev.rqt, dataSet.timeStamp.timeStamp, "Weighted # of Milliseconds Spent oo IO");
    }//GEN-LAST:event_dataChartActionPerformed

    private void networkChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkChartActionPerformed
        //DisplayData.networkPlot(set1.networkBus, set1.timeStamp);
    }//GEN-LAST:event_networkChartActionPerformed

    private void clearDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDataActionPerformed
        dataSet.header.dateStamp = 0;
        dataSet.header.machineID = "";
        dataSet.header.totalCPU = 0;
        dataSet.header.totalRAM = 0;
        dataSet.threshold.iniTimeStamp = 0;
        dataSet.threshold.thresholdcpu = 0;
        dataSet.threshold.thresholdram = 0;
        dataSet.threshold.thresholdDataBus = 0;
        dataSet.threshold.thresholdNetwork = 0;
        dataSet.cpu.sCPU.clear();
        dataSet.cpu.uCPU.clear();
        dataSet.cpuCores.clear();
        dataSet.ram.sharedMem.clear();
        dataSet.ram.buffMem.clear();
        dataSet.ram.cacheMem.clear();
        dataSet.ram.usedMem.clear();
        dataSet.ram.usedSwapMem.clear();
        dataSet.devList.clear();
        dataSet.devNames.clear();
        dataSet.dev.iop.clear();
        dataSet.dev.rdi.clear();
        dataSet.dev.rdm.clear();
        dataSet.dev.rds.clear();
        dataSet.dev.rdt.clear();
        dataSet.dev.rqt.clear();
        dataSet.dev.tot.clear();
        dataSet.dev.wri.clear();
        dataSet.dev.wrm.clear();
        dataSet.dev.wrs.clear();
        dataSet.dev.wrt.clear();
        dataSet.nic.rx.clear();
        dataSet.nic.tx.clear();
        dataSet.nicList.clear();
        dataSet.nicNames.clear();
        dataSet.timeStamp.timeStamp.clear();
        updateHeaderDisplay();
    }//GEN-LAST:event_clearDataActionPerformed

    private void displayChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayChartActionPerformed
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        ChartDisplay subForm = new ChartDisplay();
        System.out.println(subForm.getSize());
        //subForm.updateHeaderDisplay();
        subForm.setVisible(true);
    }//GEN-LAST:event_displayChartActionPerformed

    public void updateHeaderDisplay() {
        dateDisplay.setText(String.valueOf(dataSet.header.dateStamp));
        idDisplay.setText(String.valueOf(dataSet.header.machineID));
        cpuDisplay.setText(String.valueOf(dataSet.header.totalCPU));
        ramDisplay.setText(String.valueOf((dataSet.header.totalRAM) / (1000)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearData;
    private javax.swing.JButton cpuChart;
    private javax.swing.JTextPane cpuDisplay;
    private javax.swing.JButton dataChart;
    private javax.swing.JTextPane dateDisplay;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLabel1;
    private javax.swing.JButton displayChart;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTextPane idDisplay;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idLabel1;
    private javax.swing.JButton importData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton networkChart;
    private javax.swing.JButton ramChart;
    private javax.swing.JTextPane ramDisplay;
    // End of variables declaration//GEN-END:variables
}
