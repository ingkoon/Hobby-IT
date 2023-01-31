package com.a505.hobbyit.common.file;

import com.a505.hobbyit.common.file.exception.FileStorageException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class FileUploader {

    public String upload(MultipartFile uploadFile, String domain) {
        // 파일경로/ + nanotime + 유니크한 스트링 + 원본파일이름
        String uploadPath = "C:/Users/SSAFY/Desktop/o/img";

        String path = uploadPath + File.separator + System.nanoTime() + domain +StringUtils.cleanPath(uploadFile.getOriginalFilename());
        Path copyOfLocation = Paths.get(path);

        try {
            // inputStream을 가져와서
            // copyOfLocation (저장위치)로 파일을 쓴다.
            // copy의 옵션은 기존에 존재하면 REPLACE(대체한다), 오버라이딩 한다
            Files.copy(uploadFile.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileStorageException();
        }

        return path;
    }

}
