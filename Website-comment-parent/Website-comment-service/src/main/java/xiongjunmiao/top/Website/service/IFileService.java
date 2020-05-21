package xiongjunmiao.top.Website.service;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * Created by J on 2020/5/19 15:12
 */
public interface IFileService {

    void FileUpload(InputStream file, HttpServletRequest request);

}
