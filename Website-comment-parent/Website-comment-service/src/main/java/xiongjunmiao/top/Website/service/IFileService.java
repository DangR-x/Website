package xiongjunmiao.top.Website.service;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 *
 */
public interface IFileService {

    void FileUpload(InputStream file, HttpServletRequest request);

}
