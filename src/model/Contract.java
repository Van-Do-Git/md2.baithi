package model;

public class Contract {
    private String phoneNumber;
    private String partContract;
    private String name;
    private String sex;
    private String address;
    private String birthDay;
    private String email;

    public Contract() {
    }

    public Contract(String phoneNumber, String partContract, String name, String sex, String address, String birthDay, String email) {
        this.phoneNumber = phoneNumber;
        this.partContract = partContract;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birthDay = birthDay;
        this.email = email;
    }
    public Contract(String phoneNumber, String partContract, String name, String sex, String address) {
        this.phoneNumber = phoneNumber;
        this.partContract = partContract;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birthDay = birthDay;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPartContract() {
        return partContract;
    }

    public void setPartContract(String partContract) {
        this.partContract = partContract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", partContract='" + partContract + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
