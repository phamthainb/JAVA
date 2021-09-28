package control;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.IPAddress;
import view.SimpleClientMainFrm;

public class SimpleClientCtr {

    private Socket mySocket;
    private SimpleClientMainFrm view;
    private IPAddress serverAddress = new IPAddress("localhost", 8888);  // default server host and port

    public SimpleClientCtr(SimpleClientMainFrm view) {
        super();
        this.view = view;
    }

    public SimpleClientCtr(SimpleClientMainFrm view, IPAddress serverAddr) {
        super();
        this.view = view;
        this.serverAddress = serverAddr;
    }

    public boolean openConnection() {
        try {
            mySocket = new Socket(serverAddress.getHost(), serverAddress.getPort());
            view.showMessage("Connected to the server at host: " + serverAddress.getHost() + ", port: " + serverAddress.getPort());
        } catch (Exception e) {
            e.printStackTrace();
            view.showMessage("Error when connecting to the server!");
            return false;
        }
        return true;
    }

    public boolean sendData(Object obj) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(obj);

        } catch (Exception e) {
            //e.printStackTrace();
            view.showMessage("Error when sending data to the server!");
            return false;
        }
        return true;
    }

    public Object receiveData() {
        Object result = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            result = ois.readObject();
        } catch (Exception e) {
            //e.printStackTrace();
            view.showMessage("Error when receiving data from the server!");
            return null;
        }
        return result;
    }

    public boolean closeConnection() {
        try {
            if (mySocket != null) {
                mySocket.close();
                view.showMessage("Disconnected from the server!");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            view.showMessage("Error when disconnecting from the server!");
            return false;
        }
        return true;
    }
}
