package com.eul.eulproject.controller.Public.download;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

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

    @GetMapping("/download")
    public void downLoad(HttpServletResponse response) {
        File tempFile = new File(path + "/static/file/", "java类和对象.docx");
        if (tempFile.exists()) {
            try {
                BufferedInputStream inputStream = new BufferedInputStream(FileUtils.openInputStream(tempFile));
                response.setContentType("application/force-download");
                //通过设置头信息给文件命名，也即是，在前端，文件流被接受完还原成原文件的时候会以你传递的文件名来命名
                response.addHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", URLEncoder.encode(tempFile.getName(), "utf-8")));
                logger.info(tempFile.getName());
                OutputStream os = response.getOutputStream();
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;
                while ((len = inputStream.read(bs, 0, bs.length)) != -1) {
                    os.write(bs, 0, len);
                }
                inputStream.close();
                os.flush();
                os.close();
                logger.info("下载成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.info("文件不存在");
        }
    }
}
