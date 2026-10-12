package jou.mr.springboot.entity;

public class House {
    private Integer houseId;
    private String buildingNo;
    private String unitNo;
    private String roomNo;
    private String roomStatus;
    private Integer ownerId; // 可能为 null，代表空置

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public House(String buildingNo, String unitNo, String roomNo, String roomStatus, Integer ownerId) {
        this.buildingNo = buildingNo;
        this.unitNo = unitNo;
        this.roomNo = roomNo;
        this.roomStatus = roomStatus;
        this.ownerId = ownerId;
    }

    public House(String roomNo, Integer houseId, String buildingNo, String unitNo, String roomStatus, Integer ownerId) {
        this.roomNo = roomNo;
        this.houseId = houseId;
        this.buildingNo = buildingNo;
        this.unitNo = unitNo;
        this.roomStatus = roomStatus;
        this.ownerId = ownerId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public House() {
    }
}