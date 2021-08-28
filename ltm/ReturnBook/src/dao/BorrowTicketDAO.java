/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Book;
import model.BorrowTicket;
import model.BorrowedBook;
import model.Reader;

/**
 *
 * @author admin
 */
public class BorrowTicketDAO extends DAO{

    public BorrowTicketDAO() {
    }
    
    public ArrayList<BorrowTicket> getBorrowTicket(int idUser){
        ArrayList<BorrowTicket> result = new ArrayList<BorrowTicket>();
        String sql="SELECT bt.*, r.ID, r.name, r.type, r.dateOfBirth as DOB,"
                + "r.cardNumber, bb.*, b.ID, b.name, b.author, b.price "
                + "FROM tblBorrowTicket as bt, tblReader as r, tblBorrowedBook as bb,"
                + "tblBook as b "
                + "WHERE bt.ID = bb.BorrowTicketID "
                + "AND bt.ReaderID = r.ID "
                + "AND bb.BookID = b.ID "
                + "AND r.ID = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            int currentID = 0;
            BorrowTicket rm  = new BorrowTicket();
            while(rs.next()){
                if(currentID == 0 || rs.getInt("bt.ID") != currentID)
                {
                    if(currentID != 0)
                        result.add(rm);
                    rm = new BorrowTicket();
                    rm.setId(rs.getInt("bt.ID"));
                    rm.setCreateDate(rs.getDate("bt.createDate"));
                    
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
                    if(rs.getInt("bb.ReturningID") != 0) {
                        bb.setReturned(true);
                    }
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
                    currentID = rs.getInt("bt.ID");
                }
                else {
                //set BorrowedBook
                    BorrowedBook bb = new BorrowedBook();
                    bb.setId(rs.getInt("bb.ID"));
                    bb.setBorrowedDay(rs.getDate("bt.createDate"));
                    if(rs.getInt("bb.ReturningID") != 0) {
                        bb.setReturned(true);
                    }

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
    
}
