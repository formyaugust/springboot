package jou.mr.springboot.mapper;

import jou.mr.springboot.entity.Announcement;
import java.util.List;

public interface AnnouncementMapper {
    Integer insertAnnouncement(Announcement announcement);

    Integer updateAnnouncementById(Announcement announcement);

    Integer deleteAnnouncementById(Integer announcementId);

    Announcement selectAnnouncementById(Integer announcementId);

    // 查询所有公告
    List<Announcement> selectAnnouncementAll();
}