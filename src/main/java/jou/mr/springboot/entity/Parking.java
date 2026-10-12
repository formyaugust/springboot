package jou.mr.springboot.entity;

public class Parking {
    private Integer parkingId;
    private String parkingNo;
    private String status;
    private Integer ownerId;
    private String carPlate;

    @Override
    public String toString() {
        return "Parking{" +
                "parkingId=" + parkingId +
                ", parkingNo='" + parkingNo + '\'' +
                ", status='" + status + '\'' +
                ", ownerId=" + ownerId +
                ", carPlate='" + carPlate + '\'' +
                '}';
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public Parking() {
    }

    public Parking(Integer parkingId, String parkingNo, String status, Integer ownerId, String carPlate) {
        this.parkingId = parkingId;
        this.parkingNo = parkingNo;
        this.status = status;
        this.ownerId = ownerId;
        this.carPlate = carPlate;
    }

    public Parking(String parkingNo, String status, Integer ownerId, String carPlate) {
        this.parkingNo = parkingNo;
        this.status = status;
        this.ownerId = ownerId;
        this.carPlate = carPlate;
    }
}