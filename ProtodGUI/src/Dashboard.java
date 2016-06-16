
import java.io.File;
import java.io.IOException;
import java.util.ListIterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDev = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListNIC = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListCPU = new javax.swing.JList<>();
        debug1 = new javax.swing.JTextField();

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

        jScrollPane1.setViewportView(jListDev);

        jScrollPane2.setViewportView(jListNIC);

        jScrollPane3.setViewportView(jListCPU);

        debug1.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cpuChart, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ramChart, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(networkChart, javax.swing.GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dataChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(importData, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(dateLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(debug1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
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
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearData)
                            .addComponent(importData))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(debug1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(ramChart)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpuChart)
                            .addComponent(networkChart)
                            .addComponent(dataChart))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
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
            if (dataSet.header.dateStamp == 0) {
                Log.importLog(dataSet);
            } else {
                System.out.println("Log Already Imported, Clear First");
            }
            updateListDisplay();
            //Log.printCPUSet(dataSet.cpuCores);
            //Log.printDevName(dataSet);
            //Log.printNICName(dataSet);
            //Log.printCPUSet(dataSet.cpuCores);
            updateHeaderDisplay();
            //if (!Objects.equals(dataSet.cpuCores.get(0).sCPU.get(0), dataSet.cpuCores.get(1).sCPU.get(0))) debug1.setText("success");

        } catch (IOException | ParseException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_importDataActionPerformed

    private void cpuChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpuChartActionPerformed
        int index = jListCPU.getSelectedIndex();
        String label = jListCPU.getSelectedValue();
        debug1.setText(String.valueOf(index));
        DisplayData.cpuPlot(dataSet.cpuCores.get(index).uCPU, dataSet.timeStamp.timeStamp, "User Load %",label );
        DisplayData.cpuPlot(dataSet.cpuCores.get(index).sCPU, dataSet.timeStamp.timeStamp, "System Load %",label);

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
        int index = jListDev.getSelectedIndex();
        //System.out.println(index);
        String label = jListDev.getSelectedValue();
        DisplayData.dataPlot(dataSet.devList.get(index).rds, dataSet.timeStamp.timeStamp, "Sectors Read Succesfully",label);
        DisplayData.dataPlot(dataSet.devList.get(index).wrs, dataSet.timeStamp.timeStamp, "Sectors Written Succesfully",label);
        DisplayData.dataPlot(dataSet.devList.get(index).rdi, dataSet.timeStamp.timeStamp, "Read IOs Completed",label);
        DisplayData.dataPlot(dataSet.devList.get(index).rdm, dataSet.timeStamp.timeStamp, "Number of Reads Merged",label);
        DisplayData.dataPlot(dataSet.devList.get(index).rdt, dataSet.timeStamp.timeStamp, "Total Milliseconds Spent By Reads",label);
        DisplayData.dataPlot(dataSet.devList.get(index).wri, dataSet.timeStamp.timeStamp, "Write IOS Completed",label);
        DisplayData.dataPlot(dataSet.devList.get(index).wrm, dataSet.timeStamp.timeStamp, "Number of Writes Merged",label);
        DisplayData.dataPlot(dataSet.devList.get(index).wrt, dataSet.timeStamp.timeStamp, "Total Milliseconds Spent By Writes",label);
        DisplayData.dataPlot(dataSet.devList.get(index).iop, dataSet.timeStamp.timeStamp, "Total # of IOs in Progress",label);
        DisplayData.dataPlot(dataSet.devList.get(index).tot, dataSet.timeStamp.timeStamp, "Number of Milliseoncd spent on IO",label);
        DisplayData.dataPlot(dataSet.devList.get(index).rqt, dataSet.timeStamp.timeStamp, "Weighted # of Milliseconds Spent oo IO",label);
    }//GEN-LAST:event_dataChartActionPerformed

    private void networkChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkChartActionPerformed
        int index = jListNIC.getSelectedIndex();
        String label = jListNIC.getSelectedValue();
        DisplayData.networkPlot(dataSet.nicList.get(index).rx,dataSet.timeStamp.timeStamp, "Bytes Received", label);
        DisplayData.networkPlot(dataSet.nicList.get(index).tx,dataSet.timeStamp.timeStamp, "Bytes Sent", label);
        
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
        clearList();
        updateHeaderDisplay();
        
    }//GEN-LAST:event_clearDataActionPerformed

    public void updateHeaderDisplay() {
        dateDisplay.setText(String.valueOf(dataSet.header.dateStamp));
        idDisplay.setText(String.valueOf(dataSet.header.machineID));
        cpuDisplay.setText(String.valueOf(dataSet.header.totalCPU));
        ramDisplay.setText(String.valueOf((dataSet.header.totalRAM) / (1000)));
    }

    private void updateListDisplay() {
//        ListIterator itr = dataSet.nicNames.listIterator();
//        while(itr.hasNext()){
//            jListNIC.addE
//        }
        DefaultListModel nicList = new DefaultListModel();
        DefaultListModel devList = new DefaultListModel();
        DefaultListModel cpuList = new DefaultListModel();
        for(int i =0;i<dataSet.nicNames.size();i++){
            nicList.addElement(dataSet.nicNames.get(i));
        }
        for(int i=0;i<dataSet.devNames.size();i++){
            devList.addElement(dataSet.devNames.get(i));
        }
        for(int i=0;i<dataSet.cpuCount;i++){
            cpuList.addElement(dataSet.cpuNames.get(i));
        }
        jListNIC.setModel(nicList);
        jListDev.setModel(devList);
        jListCPU.setModel(cpuList);
    }
    private void clearList() {
        DefaultListModel listModel = (DefaultListModel) jListCPU.getModel();
        DefaultListModel listModel1 = (DefaultListModel) jListDev.getModel();
        DefaultListModel listModel2 = (DefaultListModel) jListNIC.getModel();
        listModel.removeAllElements();
        listModel1.removeAllElements();
        listModel2.removeAllElements();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearData;
    private javax.swing.JButton cpuChart;
    private javax.swing.JTextPane cpuDisplay;
    private javax.swing.JButton dataChart;
    private javax.swing.JTextPane dateDisplay;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLabel1;
    public javax.swing.JTextField debug1;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTextPane idDisplay;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idLabel1;
    private javax.swing.JButton importData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListCPU;
    private javax.swing.JList<String> jListDev;
    private javax.swing.JList<String> jListNIC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton networkChart;
    private javax.swing.JButton ramChart;
    private javax.swing.JTextPane ramDisplay;
    // End of variables declaration//GEN-END:variables

}
