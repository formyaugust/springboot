package jou.mr.springboot.entity;

import java.util.Date;

public class Announcement {
    private Integer announcementId;
    private String title;
    private String content;
    private Integer publisherId;
    private String createTime;

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId=" + announcementId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publisherId=" + publisherId +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Announcement() {
    }

    public Announcement(Integer announcementId, String title, String content, Integer publisherId, String createTime) {
        this.announcementId = announcementId;
        this.title = title;
        this.content = content;
        this.publisherId = publisherId;
        this.createTime = createTime;
    }

    public Announcement(String title, String content, Integer publisherId, String createTime) {
        this.title = title;
        this.content = content;
        this.publisherId = publisherId;
        this.createTime = createTime;
    }
}