package com.mycompany.java_project;

public class ProgramManagerPanel extends javax.swing.JFrame {  
    private String chosenDate;
    private java.util.Map<String, Boolean> bookedAppointments = new java.util.HashMap<>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ProgramManagerPanel.class.getName());
    
    //CONSTRUCTOR
    public ProgramManagerPanel() {
        initComponents();
        
        // Branş seçimi değiştiğinde tabloyu güncelleyecek listener
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTrainerTable();
            }
        });
        
        // Ekran ilk açıldığında tabloyu mevcut seçime göre doldur
        updateTrainerTable();
    }
  
    //TABLO GÜNCELLEME METOTLARI
    private void updateTrainerTable() {
        String selectedExercise = (String) jComboBox1.getSelectedItem();
        javax.swing.table.DefaultTableModel tableModel = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        
        tableModel.setRowCount(0);
        String[] trainerList = getTrainersForExercise(selectedExercise);
        
        for (String trainerName : trainerList) {
            tableModel.addRow(new Object[]{trainerName, false, false, false, false});
        }
        System.out.println("Tablo güncellendi. Seçilen branş: " + selectedExercise);
    }
    
    private String[] getTrainersForExercise(String exerciseType) {
        if ("Fitness".equals(exerciseType)) {
            return new String[]{"Ahmet Hoca", "Merve Hoca"};
        } else if ("Swim".equals(exerciseType)) {
            return new String[]{"Ayşe Hoca", "Kenan Hoca"};
        } else if ("Pilates".equals(exerciseType)) {
            return new String[]{"Zeynep Hoca", "Hakan Hoca"};
        }
        return new String[]{};
    }

    // arayüzün kendi oluşturduğu kod
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        textField1 = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textField1.setBackground(new java.awt.Color(153, 0, 255));
        textField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textField1.setForeground(new java.awt.Color(255, 255, 255));
        textField1.setText("Schedule Panel");

        jLabel1.setText("Exercise Type:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fitness", "Swim", "Pilates" }));

        jButton1.setText("Tarih seç");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Trainer", "08.00-10.00", "10.00-12.00", "13.00-15.00", "15.00-17.00"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField2.setText("Burayı seçemezsiniz. DOLU!");
        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jButton2.setText("Save");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>                        

    //BUTON OLAYLARI (ACTION LİSTENER'LAR)
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        chosenDate = javax.swing.JOptionPane.showInputDialog(this, 
            "Lütfen randevu tarihini giriniz (Örn: 10.05.2026):", 
            "Tarih Seçimi", 
            javax.swing.JOptionPane.QUESTION_MESSAGE);
            
        if (chosenDate != null && !chosenDate.trim().isEmpty()) {
            jButton1.setText("Tarih: " + chosenDate);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Geçerli bir tarih girmediniz!");
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {  
        if (chosenDate == null || chosenDate.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen önce bir tarih seçiniz!", "Eksik Bilgi", javax.swing.JOptionPane.WARNING_MESSAGE);
            System.out.println("Hata: Tarih seçimi yapılmadan randevu kaydedilmeye çalışıldı.");
            return; 
        }

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        
        boolean isSelected = false;
        String selectedTrainer = "";
        String selectedTimeSlot = "";
        int selectedRow = -1;
        int selectedCol = -1;

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 1; j < model.getColumnCount(); j++) { 
                Object hucre = model.getValueAt(i, j);
                
                if (hucre != null && (Boolean) hucre) {
                    selectedTrainer = (String) model.getValueAt(i, 0); 
                    selectedTimeSlot = model.getColumnName(j); 
                    isSelected = true;
                    selectedRow = i;
                    selectedCol = j;
                    break; 
                }
            }
        }

        if (!isSelected) {
            jTextField2.setText("Lütfen tablodan bir saat seçiniz!");
            jTextField2.setForeground(java.awt.Color.RED);
            System.out.println("Uyarı: Herhangi bir eğitmen ve saat seçilmedi.");
        } else {
            // Randevu çakışmasını kontrol eden asıl mantık
            String appointmentKey = chosenDate + "-" + selectedTrainer + "-" + selectedTimeSlot;
            boolean isDolu = bookedAppointments.getOrDefault(appointmentKey, false);
            
            if (isDolu) {
                model.setValueAt(false, selectedRow, selectedCol);
                jTextField2.setText("Burayı seçemezsiniz. DOLU!");
                jTextField2.setForeground(java.awt.Color.RED);
                System.out.println("Başarısız kayıt denemesi: " + appointmentKey + " zaten dolu.");
            } else {
                bookedAppointments.put(appointmentKey, true); 
                
                String brans = (String) jComboBox1.getSelectedItem();
                jTextField2.setText("Randevu Uygun. Kaydedildi.");
                jTextField2.setForeground(java.awt.Color.GREEN);
                
                System.out.println("Yeni randevu başarıyla eklendi: " + appointmentKey);
                
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Randevunuz başarıyla oluşturuldu!\n" +
                    "Branş: " + brans + "\n" +
                    "Eğitmen: " + selectedTrainer + "\n" +
                    "Tarih: " + chosenDate + "\n" +
                    "Saat: " + selectedTimeSlot, 
                    "Randevu Onayı", 
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
                
                // this.setVisible(false); // Paneli kapatmak istersen bu satırın başındaki yorum çizgilerini kaldır
            }
        }
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

   //main
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new ProgramManagerPanel().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private java.awt.TextField textField1;
    // End of variables declaration                   
}