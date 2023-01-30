package com.a505.hobbyit.common;

import org.hibernate.TypeMismatchException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class FileProcess {

    public String upload(MultipartFile uploadFile){

        if(!uploadFile.getContentType().startsWith("image")) ;

        String originName = uploadFile.getOriginalFilename();
        String fileName = originName.substring(originName.lastIndexOf("\\")+1);
        return "";
    }

    private String makeFolder() {

        String uploadPath = "";

        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folderPath = str.replace("/", File.separator);

        // make folder ----
        File uploadPatheFolder = new File(uploadPath,folderPath);

        if(!uploadPatheFolder.exists()){
            uploadPatheFolder.mkdirs();
        }

        return folderPath;
    }
}
