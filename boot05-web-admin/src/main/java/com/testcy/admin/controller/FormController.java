package com.testcy.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormController {

    @RequestMapping("/form_layouts")
    public String formLayouts() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("username") String username,
                             @RequestParam("email") String email,
                             @RequestPart("headerImg") MultipartFile headerImg,
                             @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息：username={},email={},headImg={}.photos={}", username, email, headerImg.getSize(), photos.length);
        if (!headerImg.isEmpty()) {
            headerImg.transferTo(new File("F:\\fileCD\\" + headerImg.getOriginalFilename()));
        }
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    photo.transferTo(new File("F:\\fileCD\\" + photo.getOriginalFilename()));
                }
            }
        }

        return "main";
    }

}
