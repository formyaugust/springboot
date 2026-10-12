package jou.mr.springboot.controller;

import jou.mr.springboot.entity.Result;
import jou.mr.springboot.entity.Announcement;
import jou.mr.springboot.mapper.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/announcement")
@CrossOrigin
public class AnnouncementController {

    @Autowired
    AnnouncementMapper announcementMapper;

    @RequestMapping("/insertAnnouncement")
    public Result insertAnnouncement(@RequestBody Announcement announcement) {
        return announcementMapper.insertAnnouncement(announcement) > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }

    @RequestMapping(value = "/updateAnnouncementById", produces = "application/json;charset=utf-8")
    public Result updateAnnouncementById(@RequestBody Announcement announcement) {
        return announcementMapper.updateAnnouncementById(announcement) > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @RequestMapping(value = "/deleteAnnouncementById", produces = "application/json;charset=utf-8")
    public Result deleteAnnouncementById(Integer announcementId) {
        return announcementMapper.deleteAnnouncementById(announcementId) > 0 ? Result.success("删除成功") : Result.fail("删除失败");
    }

    @RequestMapping(value = "/selectAnnouncementById", produces = "application/json;charset=utf-8")
    public Result selectAnnouncementById(Integer announcementId) {
        return Result.success(announcementMapper.selectAnnouncementById(announcementId));
    }

    @RequestMapping(value = "/selectAnnouncementAll", produces = "application/json;charset=utf-8")
    public Result selectAnnouncementAll() {
        return Result.success(announcementMapper.selectAnnouncementAll());
    }
}