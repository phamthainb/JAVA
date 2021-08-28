/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.returning;

import dao.ReturningDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BorrowedBook;
import model.FineDetail;
import model.Returning;
import view.user.LibrarianHomeFrm;

/**
 *
 * @author admin
 */
public class ReturnSuccessFrm extends javax.swing.JFrame implements ActionListener{
    private Returning returning;
    /**
     * Creates new form ReturnSuccessFrm
     */
    
    public void setViewReturning()
    {
     String[] col = {"STT","ID","Tên sách","Tác giả", "Ngày mượn","Ngày trả"};
        int numRow = 0;
        
        if(this.returning.getListBorrowedBook() != null){
            for(BorrowedBook bb : this.returning.getListBorrowedBook()) {
                numRow++;
            }
        }
        String[][] val = new String[numRow][6];
        int index = 0;
        if(this.returning.getListBorrowedBook() != null)
        for(int i = this.returning.getListBorrowedBook().size()-1; i >= 0;i--)
        {
            BorrowedBook bb = this.returning.getListBorrowedBook().get(i);
            val[index][0]= (index+1) + "";
            val[index][1] = bb.getBook().getId() + "";
            val[index][2] = bb.getBook().getName();
            val[index][3] = bb.getBook().getAuthor();

            if(bb.getBorrowedDay() != null)
            val[index][4] = bb.getBorrowedDay().toString();
            else val[index][4] = "";
            if(bb.getReturnDay() != null)
            {
                SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
                String stringDate = dateFor.format(bb.getReturnDay());
                val[index][5] = stringDate;
            } else val[index][5] = "";
           
            index++;
        }

        DefaultTableModel tableModel = 
                       new DefaultTableModel(val, col){
                           public boolean isCellEditable(int row, int column) {
                   //unable to edit cells
                   return false;
                           }
                       };
        jTable1.setModel(tableModel);   
    }
    
    public double setViewFine()
    {
        double sum = 0;
        String[] col2 = {"STT","ID","Tên sách","Tác giả", "Ngày mượn","Loại lỗi", "Tiền phạt"};
        int numRow = 0;
        
        if(this.returning.getListBorrowedBook() != null)
        for(int i = this.returning.getListBorrowedBook().size()-1; i >= 0;i--)
        {
            BorrowedBook bb = this.returning.getListBorrowedBook().get(i);
            if(bb.getListFineDetail() != null)
            for(FineDetail fd : bb.getListFineDetail()){
                if(fd.getFine().getId() == 1) numRow++;
            }
        }
        String[][] val = new String[numRow][7];
        int index = 0;
        if(this.returning.getListBorrowedBook() != null)
        for(int i = this.returning.getListBorrowedBook().size()-1; i >= 0;i--)
        {
            BorrowedBook bb = this.returning.getListBorrowedBook().get(i);
            if(bb.getListFineDetail() != null)
            {
                for(FineDetail fd : bb.getListFineDetail()){
                    val[index][0]= (index+1) + "";
                    val[index][1] = bb.getBook().getId() + "";
                    val[index][2] = bb.getBook().getName();

                    val[index][3] = bb.getBook().getAuthor();

                    if(bb.getBorrowedDay() != null)
                        val[index][4] = bb.getBorrowedDay().toString();
                    else val[index][4] = "";
                    
                    val[index][5] = fd.getFine().getName();
                    val[index][6] = bb.getBook().getPrice()*fd.getPrice() + "";
                    sum += bb.getBook().getPrice()*fd.getPrice();
                    index++;
                }
                

            }
        }
        
        DefaultTableModel tableModel2 = 
                       new DefaultTableModel(val, col2){
                           public boolean isCellEditable(int row, int column) {
                   //unable to edit cells
                   return false;
                           }
                       };
        jTable2.setModel(tableModel2);
        return sum;
    }
    public ReturnSuccessFrm(Returning returning) {
        this.returning = returning;
        double sum = 0;
        initComponents();
        setViewReturning();
        sum = setViewFine();
        jLabel12.setText(sum + "");
        jLabel9.setText(this.returning.getReader().getName());
        jLabel10.setText(this.returning.getReader().getCardNumber());
        jLabel11.setText(this.returning.getReader().getDateOfBirth().toString());
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
//                    System.out.println(this.returning.getDayReturn().toString());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Xác nhận thông tin trả sách");

        jLabel2.setText("Danh sách sách trả");

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

        jLabel3.setText("Danh sách lỗi");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel4.setText("Tổng tiền phạt");

        jButton1.setText("OK");

        jButton2.setText("Cancel");

        jLabel6.setText("Tên độc giả");

        jLabel7.setText("Mã thẻ");

        jLabel8.setText("Ngày sinh");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jButton1)
                        .addGap(100, 100, 100)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ReturnSuccessFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnSuccessFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnSuccessFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnSuccessFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnSuccessFrm(new Returning()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource() instanceof JButton )
                &&(((JButton)e.getSource()).equals(jButton1))) {

            ReturningDAO rd = new ReturningDAO();
            if(rd.addReturning(this.returning))
            {
                JOptionPane.showMessageDialog(this, 
                          "Success!");
            }
            else {
                JOptionPane.showMessageDialog(this, 
                          "Something wrong!");
            }
            
        }
        
        (new LibrarianHomeFrm(this.returning.getUser())).setVisible(true);
        this.dispose();
    }
}
