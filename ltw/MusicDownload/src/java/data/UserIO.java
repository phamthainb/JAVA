package data;

import java.io.*;
import business.User;
import java.util.ArrayList;
import java.util.Scanner;

public class UserIO {

    ArrayList<User> list = new ArrayList<>();

    public static void add(User user, String filepath)
            throws IOException {
        File file = new File(filepath);
        PrintWriter out = new PrintWriter(
                new FileWriter(file, true));
        out.println(user.getEmailAddress() + "|"
                + user.getFirstName() + "|"
                + user.getLastName());
        out.close();
    }

    public static User getUser(String email, String path) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(path));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split("|");
                User user = new User();
                if (values.length > 0 && values[0].equals(email)) {
                    user.setEmailAddress(values[0]);
                    if (values.length > 1) {
                        user.setFirstName(values[1]);
                        if (values.length > 2) {
                            user.setLastName(values[2]);
                        }
                    }
                    return user;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
