package view;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import controller.ContractManager;
import model.Contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContractManagerView {

    public static void main(String[] args) {
        Validate validate = Validate.getInstance();
        ContractManager contractManager = new ContractManager();
        contractManager.readInFile();
        String chose;
        String regexChose = "^[1-8]+";
        boolean checkOut;
        Scanner inputNumber = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        do {

            System.out.println("---CHUONG TRINH QUAN LY DANH BA");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng:");
            chose = inputNumber.nextLine();
            checkOut = validate.validate(chose, regexChose) & chose.equals("8");
            switch (chose) {
                case "1":
                    showAllList(contractManager);
                    break;
                case "2":
                    addContract(contractManager);
                    break;
                case "3":
                    updateContract(contractManager);
                    break;
                case "4":
                    deleteContract(contractManager);
                    break;
                case "5":
                    searchComtractByPhoneNumber(contractManager);
                    break;
                case "6":
                    readFile(contractManager);
                    break;
                case "7":
                    writeFile(contractManager);
                    break;
                case "8":
                    break;
                default:
                    System.out.println("Nhập sai chức năng, hãy nhập lại");
                    break;
            }
        } while (!checkOut);
    }

    public static void showAllList(ContractManager contractManager) {
        contractManager.showAllContract();
        showContract(contractManager);
    }

    public static void showContract(ContractManager contractManager) {
        Scanner inputNumber = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        System.out.println("Nhập số điện thoại bạn muốn xem thông tin");
        String phoneNumber = inputString.nextLine();
        int index = contractManager.findContract(phoneNumber);
        if (index != -1) {
            Contract contract = contractManager.getList().get(index);
            String number = contract.getPhoneNumber();
            String part = contract.getPartContract();
            String name = contract.getName();
            String sex = contract.getSex();
            String adress = contract.getAddress();
            List<String> listInfo = new ArrayList<>();
            listInfo.add(number);
            listInfo.add(part);
            listInfo.add(name);
            listInfo.add(sex);
            listInfo.add(adress);
            for (int i = 0; i < listInfo.size(); i++) {
                System.out.println(listInfo.get(i));
                inputString.nextLine();
            }
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    public static Contract creatContract() {

        Scanner inputString = new Scanner(System.in);
        System.out.println("Nhập số điện thoại");
        String phoneNumber = inputString.nextLine();
        System.out.println("Nhập tên");
        String name = inputString.nextLine();
        System.out.println("Nhập giới tính");
        String sex = inputString.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = inputString.nextLine();
        System.out.println("Nhập nhóm danh bạ");
        String part = inputString.nextLine();
        if (phoneNumber.equals("") || name.equals("") || sex.equals("") || address.equals("") || part.equals("")) {
            System.out.println("Nhập lại");
            creatContract();
        }
        return new Contract(phoneNumber, part, name, sex, address);
    }

    public static void addContract(ContractManager contractManager) {
        Contract contract = creatContract();
        contractManager.addContract(contract);
    }

    public static void updateContract(ContractManager contractManager) {
        Scanner inputString = new Scanner(System.in);
        System.out.println("Nhập số điện thoại cần sửa");
        String phoneNumber = inputString.nextLine();
        int index = contractManager.findContract(phoneNumber);
        if (index != -1) {
            System.out.println("Nhập tên");
            String name = inputString.nextLine();
            System.out.println("Nhập giới tính");
            String sex = inputString.nextLine();
            System.out.println("Nhập địa chỉ");
            String address = inputString.nextLine();
            System.out.println("Nhập nhóm danh bạ");
            String part = inputString.nextLine();
            Contract contract = new Contract(phoneNumber, part, name, sex, address);
            contractManager.editContract(phoneNumber, contract);
        }
    }

    public static void deleteContract(ContractManager contractManager) {
        Scanner inputString = new Scanner(System.in);
        System.out.println("Nhập số điện thoại cần xóa");
        String phoneNumber = inputString.nextLine();
        contractManager.deleteContract(phoneNumber);
    }

    public static void searchComtractByPhoneNumber(ContractManager contractManager) {
        Scanner inputString = new Scanner(System.in);
        System.out.println("Nhập số điện thoại cần xóa");
        String phoneNumber = inputString.nextLine();
        int index = contractManager.findContract(phoneNumber);
        if (index == -1) {
            System.out.println("Không tìm thấy");
        } else {
            System.out.println("Thông tin số điện thoại là" + contractManager.getList().get(index));
        }
    }

    public static void writeFile(ContractManager contractManager) {
        contractManager.writeOnFile();
    }

    public static void readFile(ContractManager contractManager) {
        contractManager.readInFile();
    }
}

