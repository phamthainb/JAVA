/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Book;
import model.Returning;
import model.BorrowedBook;
import model.FineDetail;
import model.Reader;

/**
 *
 * @author admin
 */
public class ReturningDAO extends DAO{

    public ReturningDAO() {
    }
    
    public ArrayList<Returning> getReturning(int idUser){
        ArrayList<Returning> result = new ArrayList<Returning>();
        String sql="SELECT bt.createDate, re.*, r.ID, r.name, r.type, r.dateOfBirth as DOB,"
                + "r.cardNumber, bb.*, b.ID, b.name, b.author, b.price "
                + "FROM tblBorrowTicket as bt, tblReturning as re, tblReader as r, tblBorrowedBook as bb,"
                + "tblBook as b "
                + "WHERE re.ID = bb.ReturningID "
                + "AND re.ReaderID = r.ID "
                + "AND bb.BookID = b.ID "
                + "AND bt.ID = bb.BorrowTicketID "
                + "AND r.ID = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            int currentID = 0;
            Returning rm  = new Returning();
            while(rs.next()){
                if(currentID == 0 || rs.getInt("re.ID") != currentID)
                {
                    if(currentID != 0)
                        result.add(rm);
                    rm = new Returning();
                    rm.setId(rs.getInt("re.ID"));
                    rm.setDayReturn(rs.getDate("re.dayReturn"));

                    //set reader
                    Reader rd = new Reader();
                    rd.setId(rs.getInt("r.ID"));
                    rd.setName(rs.getString("r.name"));
                    rd.setType(rs.getString("r.type"));
                    rd.setDateOfBirth(rs.getDate("DOB"));
                    rd.setCardNumber(rs.getString("r.cardNumber"));
                    rm.setReader(rd);
                    
                    //set BorrowedBook
                    BorrowedBook bb = new BorrowedBook();
                    bb.setId(rs.getInt("bb.ID"));
                    bb.setNote(rs.getString("bb.note"));
                    bb.setBorrowedDay(rs.getDate("bt.createDate"));
                    bb.setReturnDay(rs.getDate("re.dayReturn"));
                    bb.setReturned(true);
                    
                    //set Book
                    Book b = new Book();
                    b.setId(rs.getInt("b.ID"));
                    b.setName(rs.getString("b.name"));
                    b.setAuthor(rs.getString("b.author"));
                    b.setPrice(rs.getDouble("b.price"));
                    bb.setBook(b);
                    ArrayList<BorrowedBook> tmp = new ArrayList<>();
                    tmp.add(bb);
                    rm.setListBorrowedBook(tmp);
                    currentID = rs.getInt("re.ID");
                }
                else {
                //set BorrowedBook
                    BorrowedBook bb = new BorrowedBook();
                    bb.setId(rs.getInt("bb.ID"));
                    bb.setNote(rs.getString("bb.note"));

                    //set Book
                    Book b = new Book();
                    b.setId(rs.getInt("b.ID"));
                    b.setName(rs.getString("b.name"));
                    b.setAuthor(rs.getString("b.author"));
                    b.setPrice(rs.getDouble("b.price"));
                    bb.setBook(b);

                    ArrayList<BorrowedBook> tmp = rm.getListBorrowedBook();
                    tmp.add(bb);
                    rm.setListBorrowedBook(tmp);
                }
                
            }
            result.add(rm);
        }catch(Exception e){
            e.printStackTrace();
        }   
        return result;
    }
    
    public boolean addReturning(Returning b) {
        if(b.getListBorrowedBook() == null) return false;
        String sqlAddReturning = "INSERT INTO tblReturning(UserID, ReaderID, dayReturn, note) "
                + "VALUES(?,?,?,?)";
        String sqlEditBorrowedBook = "UPDATE tblborrowedbook "
                + "SET ReturningID = ?"
                + " WHERE ID = ?";
        String sqlAddFineDetail = "INSERT INTO "
                + "tblFineDetail(price, numberFault, note, BorrowedBookID,FineID) VALUES(?,?,?,?,?)";
        
        String sqlCheckBorrowedBook = "SELECT ReturningID FROM tblBorrowedBook WHERE ID = ?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean result = true;
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlAddReturning,
                       Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, b.getUser().getId());
            ps.setInt(2, b.getReader().getId());

            ps.setDate(3, new java.sql.Date(b.getDayReturn().getTime()));
            if(b.getNote() == null) b.setNote("");
            ps.setString(4, b.getNote());
            ps.executeUpdate();         
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                b.setId(generatedKeys.getInt(1));
                System.out.println(b.getId()+ "id");
                for(BorrowedBook br: b.getListBorrowedBook()) {
                    
                    ps = con.prepareStatement(sqlCheckBorrowedBook);
                    ps.setInt(1, br.getId());
//                    
                    ResultSet rs = ps.executeQuery();
                    if(rs.next() && rs.getInt(1) != 0) {//unavailable
                            result = false;
                        try {
                            con.rollback();
                            con.setAutoCommit(true);
                        }catch(Exception ex) {
                            result = false;
                            ex.printStackTrace();
                        }
                        return result;
                    }
                    
                    
                    
                    
                    ps = con.prepareStatement(sqlEditBorrowedBook);
                    ps.setInt(1, b.getId());
                    ps.setInt(2, br.getId());
                    ps.executeUpdate();
                    
                    if(br.getListFineDetail() != null)
                    for(FineDetail fd : br.getListFineDetail()){
                        ps = con.prepareStatement(sqlAddFineDetail,
                                   Statement.RETURN_GENERATED_KEYS);
                        ps.setDouble(1, fd.getPrice());
                        ps.setInt(2, fd.getNumberFault());
                        ps.setString(3, fd.getNote());
                        ps.setInt(4, br.getId());
                        ps.setInt(5,fd.getFine().getId());
                    
                        ps.executeUpdate();         
                        
                    }
                }
            }
             
        }catch(Exception e) {
            result = false;         
            try {               
                con.rollback();
            }catch(Exception ex) {
                result = false;
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {               
                con.setAutoCommit(true);//set this line into comment in JUnit test mode
            }catch(Exception ex) {
                result = false;
                ex.printStackTrace();
            }
        }
        System.out.println(result);
        return result;
    }   
}
