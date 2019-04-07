package com.eul.eulproject.controller.Public.upload;

import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

@RestController
public class Document {
    private Logger logger = LoggerFactory.getLogger(Document.class);

    private String path;

    {
        try {
            path = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/uploadOneFile")
    public String oneFileUpload(@Param(value = "static/file") MultipartFile file) {
        logger.info("上传的文件名字是：" + file.getName());
        logger.info("文件原名称为：" + file.getOriginalFilename());
        try {
            BufferedInputStream stream = new BufferedInputStream(file.getInputStream());
            String type = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().indexOf(".") + 1);
            File tempFile = new File(path + "/static/file/", file.getOriginalFilename());
            if (!tempFile.exists()) {
                if (checkFileType(type)) {
                    byte[] bs = new byte[1024];
                    // 读取到的数据长度
                    int len;
                    //创建一个空文件，若文件应经存在则只更改文件的最近修改时间：touch(File file)
                    FileUtils.touch(tempFile);
                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tempFile));
                    while ((len = stream.read(bs, 0, bs.length)) != -1) {
                        outputStream.write(bs, 0, len);
                    }
                    stream.close();
                    outputStream.flush();
                    outputStream.close();
                    JsonObject json = new JsonObject();
                    json.addProperty("status", "1");
                    json.addProperty("data", "上传成功");
                    logger.info("文件上成功");
                    return json.toString();
                } else {
                    JsonObject json = new JsonObject();
                    json.addProperty("status", "0");
                    json.addProperty("data", "不支持该文件类型");
                    return json.toString();
                }
            } else {
                JsonObject json = new JsonObject();
                json.addProperty("status", "0");
                json.addProperty("data", "文件已经存在了");
                return json.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JsonObject json = new JsonObject();
            json.addProperty("status", "0");
            json.addProperty("data", "不支持该文件类型");
            return json.toString();
        }
    }

    private boolean checkFileType(String type) {
        String[] types = {"docx", "doc"};
        for (String i : types) {
            if (type.equalsIgnoreCase(i)) {
                return true;
            }
        }
        return false;
    }
}
