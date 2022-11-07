package com.arka99.AB_Bank_Backend.controller;

import com.arka99.AB_Bank_Backend.model.Notice;
import com.arka99.AB_Bank_Backend.repositories.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NoticesController {

    @Autowired
    private NoticeRepository noticeRepository;
    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices()
    {
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices != null ) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        }else {
            return null;
        }
    }
}
