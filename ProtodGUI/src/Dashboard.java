
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

    DataSet set1 = new DataSet();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cpuChart, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ramChart, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dataChart, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(networkChart))
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
                                    .addComponent(clearData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpuChart)
                    .addComponent(ramChart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkChart)
                    .addComponent(dataChart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                set1.filePath = file.getAbsolutePath();
            } else {
                System.out.println("File access cancelled by user.");
            }
            Log.importLog(set1);
            updateHeaderDisplay();

        } catch (IOException | ParseException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_importDataActionPerformed

    private void cpuChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpuChartActionPerformed
        //plot the chart (cpuLoad and time) 
        //DisplayData.cpuPlot(set1.cpuLoad, set1.timeStamp);   
    }//GEN-LAST:event_cpuChartActionPerformed

    private void ramChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramChartActionPerformed
        //DisplayData.ramPlot(set1.memLoad, set1.timeStamp);
    }//GEN-LAST:event_ramChartActionPerformed

    private void dataChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataChartActionPerformed
        //DisplayData.dataPlot(set1.dataBus, set1.timeStamp);
    }//GEN-LAST:event_dataChartActionPerformed

    private void networkChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkChartActionPerformed
        //DisplayData.networkPlot(set1.networkBus, set1.timeStamp);
    }//GEN-LAST:event_networkChartActionPerformed

    private void clearDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDataActionPerformed
//    set1.dateStamp = 0;
//    set1.machineID = "This Is The Default Meassage";
//    set1.totalCPU = 0;
//    set1.totalRAM = 0;
//    set1.iniTimeStamp = 0;
//    set1.thresholdcpu = 0;
//    set1.thresholdram = 0;
//    set1.thresholdDataBus = 0;
//    set1.thresholdNetwork = 0;
//    set1.cpuLoad.clear();
//    set1.memLoad.clear();
//    set1.dataBus.clear();
//    set1.networkBus.clear();
//    set1.timeStamp.clear();
//    updateHeaderDisplay();
    }//GEN-LAST:event_clearDataActionPerformed

    public void updateHeaderDisplay() {
        dateDisplay.setText(String.valueOf(set1.header.dateStamp));
        idDisplay.setText(String.valueOf(set1.header.machineID));
        cpuDisplay.setText(String.valueOf(set1.header.totalCPU));
        ramDisplay.setText(String.valueOf((set1.header.totalRAM) / (1000)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearData;
    private javax.swing.JButton cpuChart;
    private javax.swing.JTextPane cpuDisplay;
    private javax.swing.JButton dataChart;
    private javax.swing.JTextPane dateDisplay;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLabel1;
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
