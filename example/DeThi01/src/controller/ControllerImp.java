/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mode/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bus;
import model.Driver;
import model.Manager;
import model.Pair;

/**
 *
 * @author ADMIN
 */
public class ControllerImp implements Controller {

    @Override
    public <T> void writeToFile(List<T> list, String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> List<T> readDataFromFile(String fileName) {
        List<T> list = new ArrayList<>();
        File file = new File(fileName);
        if (file.length() > 0) {
            try {
                file.createNewFile();
                FileInputStream fos = new FileInputStream(file);
                ObjectInputStream oos = new ObjectInputStream(fos);
                Object o = oos.readObject();
                list = (List<T>) o;
                oos.close();
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public boolean isAccepted(List<Manager> managers, Driver driver, Pair<Bus, Integer> pair) {
        for (Manager manager : managers) {
            if (manager.getDriver().getId() == driver.getId()) {
                return (manager.getTongSoLuot() + pair.getSoLuot()) <= 15;
            }
        }
        return true;
    }

    public Manager getManager(List<Manager> managers, Driver driver) {
        for (Manager manager : managers) {
            if (manager.getDriver().getId() == driver.getId()) {
                return manager;
            }
        }
        return null;
    }

    public void addOrUpdate(List<Manager> managers, Driver driver, Pair<Bus, Integer> pair) {
        Manager m = this.getManager(managers, driver);
        if (m == null) { // chua lai luot nao
            Manager man = new Manager(driver, pair);
            managers.add(man);
        } else { // cap nhat
            // 1. tuyen xe hien thoi (pair) chua duoc lai
            // 2. da lai n luot tuyen xe trong pair
            boolean isExist = false;
            for (int i = 0; i < m.getPairs().size(); i++) {
                Pair<Bus, Integer> p = m.getPairs().get(i);
                if (p.getTuyen().getId() == pair.getTuyen().getId()) {
                    isExist = true;
                    p.setSoLuot(p.getSoLuot() + pair.getSoLuot());
                    break;
                }
            }
            if (!isExist) {
                m.getPairs().add(pair);
            }
        }
    }

    @Override
    public <T> void sortByName(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Manager) {
                    Manager m1 = (Manager) o1;
                    Manager m2 = (Manager) o2;
                    String fullName1 = m1.getDriver().getName().trim();
                    String fullName2 = m2.getDriver().getName().trim();
                    String name = fullName1.substring(fullName1.lastIndexOf(" "));
                    String name2 = fullName2.substring(fullName2.lastIndexOf(" "));
                    return name.compareTo(name2);
                }
                // tran van nam
                return 0;
            }
        });
    }

    @Override
    public <T> void sortByBuses(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Manager) {
                    Manager m1 = (Manager) o1;
                    Manager m2 = (Manager) o2;
                    return m2.getPairs().size() - m1.getPairs().size();
                }
                return 0;
            }
        });
    }

    public float getTotalDistance(Manager m) {
        float distance = 0;
        for (Pair<Bus, Integer> pair : m.getPairs()) {
            distance += pair.getTuyen().getDistance();
        }
        return distance;
    }

    @Override
    public <T> void sortByTotalDistance(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Manager) {
                    Manager m1 = (Manager) o1;
                    Manager m2 = (Manager) o2;
                    float d1 = getTotalDistance(m1);
                    float d2 = getTotalDistance(m2);
                    if(d1 > d2) {
                        return -1;
                    } else if(d1 < d2) {
                        return 1;
                    }
                }
                return 0;
            }
        });
    }

}
