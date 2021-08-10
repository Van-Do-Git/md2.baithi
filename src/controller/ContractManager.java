package controller;

import model.Contract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractManager {
    private List<Contract> list = new ArrayList<>();

    public ContractManager() {
    }

    public ContractManager(List<Contract> list) {
        this.list = list;
    }

    public List<Contract> getList() {
        return list;
    }

    public void setList(List<Contract> list) {
        this.list = list;
    }

    public void addContract(Contract contract) {
        list.add(contract);
    }

    public void editContract(String phoneNumber, Contract newContract) {
        int index = findContract(phoneNumber);
        if (index == -1) {
            System.out.println("Not found phone number");
        } else {
            list.remove(index);
            list.add(index, newContract);
        }
    }

    public void deleteContract(String phoneNumber) {
        int index = findContract(phoneNumber);
        if (index == -1) {
            System.out.println("Not found phone number");
        } else {
            list.remove(index);
        }
    }
    public void showAllContract(){
        System.out.println(list);
    }

    public int findContract(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber().equals(phoneNumber)) {
                index = i;
            }
        }
        return index;
    }

    public void readInFile() {
        try {
            File file = new File("src/data/contacts.csv");
            if (file.length() > 0) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (List<Contract>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void writeOnFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("src/data/contacts.csv");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
