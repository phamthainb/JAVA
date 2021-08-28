/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.returning;

import dao.BorrowTicketDAO;
import dao.ReaderDAO;
import dao.ReturningDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.BorrowTicket;
import model.BorrowedBook;
import model.Fine;
import model.FineDetail;
import model.Returning;

/**
 *
 * @author admin
 */
public class ReturnBookFrm extends javax.swing.JFrame implements ActionListener{
    private ArrayList<BorrowTicket> listBorrowTiket;
    private ArrayList<Returning> listReturning;
    private Returning returning;
    private String IDBookScan = "";
    /**
     * Creates new form ReturnBookFrm
     */
    
    public void setViewBorrowBook()
    {
        if(listBorrowTiket.size() == 0) return;
        String[] col = {"STT","ID","Tên sách","Tác giả", "Ngày mượn","Hạn trả"};
        int numRow = 0;
        for(BorrowTicket i : listBorrowTiket)
        {
            for(BorrowedBook bb : i.getListBorrowedBook())
            {
                if(!bb.isReturned())
                {
                    numRow++;
                }
            }
                
        }
        String[][] val = new String[numRow][6];
        if(numRow < 5)
        {
            jButton5.setEnabled(false);
            if(numRow < 4)
            {
                jButton4.setEnabled(false);
                if(numRow < 3)
                {
                    jButton3.setEnabled(false);
                    if(numRow < 2)
                    {
                        jButton2.setEnabled(false);
                        if(numRow < 1)
                        {
                            jButton1.setEnabled(false);
                        }
                    }
                }
            }
            
            
        }
        int index = 0;
        for(BorrowTicket i : listBorrowTiket)
        {
            for(BorrowedBook bb : i.getListBorrowedBook()){
                if(!bb.isReturned()){
                    val[index][0]= (index+1) + "";
                    val[index][1] = bb.getBook().getId() + "";
                    val[index][2] = bb.getBook().getName();
                    val[index][3] = bb.getBook().getAuthor();
                    val[index][4] = i.getCreateDate().toString();
                    //tinh toan han tra
                    Calendar tmp = Calendar.getInstance();
                    tmp.setTime(i.getCreateDate());
                    tmp.add(Calendar.DAY_OF_YEAR, 30);
                    Date date = tmp.getTime();
                    SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
                    String stringDate = dateFor.format(date);
                    val[index][5] = stringDate;
                    index++;
                }
                
            }
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
    
    public void setViewFinedBook()
    {
        String[] col = {"STT","ID","Tên sách","Tác giả", "Ngày mượn","Hạn trả", "Ngày trả", "Tiền phạt"};
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
        
        String[][] val = new String[numRow][8];
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
                    Calendar tmp = Calendar.getInstance();
                    tmp.setTime(bb.getBorrowedDay());
                    tmp.add(Calendar.DAY_OF_YEAR, 30);
                    Date date = tmp.getTime();
                    SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
                    String stringDate = dateFor.format(date);
                    val[index][5] = stringDate;

                    if(bb.getReturnDay() != null)
                    {
                        stringDate = dateFor.format(bb.getReturnDay());
                    val[index][6] = stringDate;
                    } else val[index][6] = "";
                    val[index][7] = bb.getBook().getPrice()*fd.getPrice() + "";
                }
                index++;

            }
        }

        
        DefaultTableModel tableModel = 
                       new DefaultTableModel(val, col){
                           public boolean isCellEditable(int row, int column) {
                   //unable to edit cells
                   return false;
                           }
                       };
        jTable2.setModel(tableModel);
    }
    
    public void setViewReturnedBook()
    {
        String[] col = {"STT","ID","Tên sách","Tác giả", "Ngày mượn","Ngày trả"};
        int numRow = 0;
        
        for(Returning i : listReturning)
        {
            if(i.getListBorrowedBook() == null) break;
            for(BorrowedBook bb : i.getListBorrowedBook())
            {
                numRow++;
            }
                
        }
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

        for(Returning i : listReturning)
        {
            if(i.getListBorrowedBook() != null)
            for(BorrowedBook bb : i.getListBorrowedBook()){
                
                val[index][0]= (index+1) + "";
                val[index][1] = bb.getBook().getId() + "";
                
                val[index][2] = bb.getBook().getName();
//                System.out.println(bb.getBook().getName());
                val[index][3] = bb.getBook().getAuthor();
                
                if(bb.getBorrowedDay() != null)
                    val[index][4] = bb.getBorrowedDay().toString();
                else val[index][4] = "";
                if(bb.getReturnDay()!= null)
                    val[index][5] = bb.getReturnDay().toString();
                else val[index][5] = "";
                index++;
            }
        }
        DefaultTableModel tableModel = 
                       new DefaultTableModel(val, col){
                           public boolean isCellEditable(int row, int column) {
                   //unable to edit cells
                   return false;
                           }
                       };
        jTable3.setModel(tableModel);
    }
    
    public ReturnBookFrm(Returning returning) {
        this.returning = returning;
        BorrowTicketDAO bd = new BorrowTicketDAO();
        ReturningDAO rd = new ReturningDAO();
//        
        listBorrowTiket = bd.getBorrowTicket(this.returning.getReader().getId());
        listReturning = rd.getReturning(this.returning.getReader().getId());
        
        initComponents();
        this.setFocusable(true);
        
        jLabel1.setText(this.returning.getUser().getName());
        jLabel2.setText(this.returning.getReader().getName());
        jButton6.addActionListener(this);
        setViewBorrowBook();
        setViewReturnedBook();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jLabel3.setText("Danh sách sách mượn chưa trả");

        jLabel4.setText("Danh sách sách trả quá hạn ");

        jLabel5.setText("Danh sách sách mượn đã trả");

        jButton1.setText("X");

        jButton2.setText("X");

        jButton3.setText("X");

        jButton4.setText("X");

        jButton5.setText("X");

        jButton6.setText("Submit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setText("Trả sách");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(jButton6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            boolean flag = false;
            BorrowedBook newBorrowedBook = new BorrowedBook();
            for(BorrowTicket b : listBorrowTiket)
            {
                for(BorrowedBook bb : b.getListBorrowedBook() )
                {
                    if(bb.getBook().getId() == Integer.parseInt(this.IDBookScan) && !bb.isReturned())
                    {
                        newBorrowedBook = bb;
                        newBorrowedBook.setReturned(true);
                        flag = true;
                    }
                }
            }
            this.IDBookScan= "";
            if(!flag) return;
            newBorrowedBook.setReturnDay(new Date());
            this.returning.setDayReturn(new Date());
            ArrayList<BorrowedBook> brb;
            if(this.returning.getListBorrowedBook() == null)
            {
                brb = new ArrayList<BorrowedBook>();
            }
            else brb = this.returning.getListBorrowedBook();
            Calendar tmp = Calendar.getInstance();
            tmp.setTime(newBorrowedBook.getBorrowedDay());
            tmp.add(Calendar.DAY_OF_MONTH, 30);
            Date date = tmp.getTime();
            if(date.before(new Date()))
            {
                Fine fine = new Fine();
                FineDetail fd = new FineDetail();
                fd.setFine(fine);
                fd.setPrice(fine.getPrice());
                ArrayList<FineDetail> lfd = new ArrayList<>();
                lfd.add(fd);
                newBorrowedBook.setListFineDetail(lfd);
            }
            brb.add(newBorrowedBook);
            this.returning.setListBorrowedBook(brb);
            setViewBorrowBook();
            setViewFinedBook();
            setViewReturnedBook();
            
            

        }
        else {
            this.IDBookScan += Character.toString(evt.getKeyChar());
            System.out.println(this.IDBookScan);
        }
    }//GEN-LAST:event_formKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBookFrm(new Returning()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource() instanceof JButton)
                &&(((JButton)e.getSource()).equals(jButton6))) {
            (new ReturnSuccessFrm(this.returning)).setVisible(true);
                    this.dispose();
        }
    }
}
