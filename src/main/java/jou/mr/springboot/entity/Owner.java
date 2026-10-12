package jou.mr.springboot.entity;

public class Owner {
    private Integer ownerId;
    private String ownerName;
    private char gender;
    private String phone;
    private String idCard;

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", ownerName='" + ownerName + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Owner() {
    }

    public Owner(Integer ownerId, String ownerName, char gender, String phone, String idCard) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.gender = gender;
        this.phone = phone;
        this.idCard = idCard;
    }

    public Owner(String ownerName, char gender, String phone, String idCard) {
        this.ownerName = ownerName;
        this.gender = gender;
        this.phone = phone;
        this.idCard = idCard;
    }
}