/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phamthainb
 */
public class HandlerExp extends Exception {

    private String mess;

    public HandlerExp(String string) {
        this.mess = string;
    }

    public String getMess() {
        return mess;
    }

}
