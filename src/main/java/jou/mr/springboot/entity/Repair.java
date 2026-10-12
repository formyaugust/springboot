package jou.mr.springboot.entity;

public class Repair {
    private Integer repairId;
    private Integer houseId;
    private Integer ownerId;
    private String content;
    private String status;

    @Override
    public String toString() {
        return "Repair{" +
                "repairId=" + repairId +
                ", houseId=" + houseId +
                ", ownerId=" + ownerId +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Repair() {
    }

    public Repair(Integer repairId, Integer houseId, Integer ownerId, String content, String status) {
        this.repairId = repairId;
        this.houseId = houseId;
        this.ownerId = ownerId;
        this.content = content;
        this.status = status;
    }

    public Repair(Integer houseId, Integer ownerId, String content, String status) {
        this.houseId = houseId;
        this.ownerId = ownerId;
        this.content = content;
        this.status = status;
    }
}