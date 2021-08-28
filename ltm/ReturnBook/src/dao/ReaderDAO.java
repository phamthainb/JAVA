    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Reader;
/**
 *
 * @author admin
 */
public class ReaderDAO extends DAO{
    public ReaderDAO(){
        super();
    }
    public Reader scanReader(String cardNumber)
    {
//        Reader result = new Reader();
        String sql = "SELECT ID, name, cardNumber, dateOfBirth FROM tblReader WHERE cardNumber = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cardNumber);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Reader result = new Reader();
                result.setId(rs.getInt("ID"));
                result.setName(rs.getString("name"));
                result.setCardNumber(rs.getString("cardNumber"));
                result.setDateOfBirth(rs.getDate("dateOfBirth"));
                //continue..
                return result;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
