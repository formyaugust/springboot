package jou.mr.springboot.entity;

import java.math.BigDecimal;

public class Fee {
    private Integer feeId;
    private Integer houseId;
    private Integer ownerId;
    private String feeType;
    private BigDecimal amount;
    private String billMonth;
    private String payStatus;

    @Override
    public String toString() {
        return "Fee{" +
                "feeId=" + feeId +
                ", houseId=" + houseId +
                ", ownerId=" + ownerId +
                ", feeType='" + feeType + '\'' +
                ", amount=" + amount +
                ", billMonth='" + billMonth + '\'' +
                ", payStatus='" + payStatus + '\'' +
                '}';
    }

    public Integer getFeeId() {
        return feeId;
    }

    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
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

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Fee() {
    }

    public Fee(Integer feeId, Integer houseId, Integer ownerId, String feeType, BigDecimal amount, String billMonth, String payStatus) {
        this.feeId = feeId;
        this.houseId = houseId;
        this.ownerId = ownerId;
        this.feeType = feeType;
        this.amount = amount;
        this.billMonth = billMonth;
        this.payStatus = payStatus;
    }

    public Fee(Integer houseId, Integer ownerId, String feeType, BigDecimal amount, String billMonth, String payStatus) {
        this.houseId = houseId;
        this.ownerId = ownerId;
        this.feeType = feeType;
        this.amount = amount;
        this.billMonth = billMonth;
        this.payStatus = payStatus;
    }
}