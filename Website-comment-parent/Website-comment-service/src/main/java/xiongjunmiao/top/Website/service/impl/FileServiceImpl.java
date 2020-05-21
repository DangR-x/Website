package xiongjunmiao.top.Website.service.impl;

import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.service.IFileService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by J on 2020/5/19 15:12
 */
@Service
public class FileServiceImpl implements IFileService {

    public void FileUpload(InputStream file, HttpServletRequest request){
        byte[] check = new byte[1024];

        try {

            while (file.read(check)!=-1)
            {
                System.out.println(check);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String images = request.getServletContext().getRealPath("images");


    }


}
