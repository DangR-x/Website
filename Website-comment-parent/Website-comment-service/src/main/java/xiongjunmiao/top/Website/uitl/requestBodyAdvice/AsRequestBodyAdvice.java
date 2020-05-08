package xiongjunmiao.top.Website.uitl.requestBodyAdvice;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.*;
import java.lang.reflect.Type;

/**
 * RequestBodyAdvice，针对所有以@RequestBody的参数，在读取请求body之前或者在body转换成对象之前可以做相应的增强。
 * 我们处理了有参数和没有参数的情况，打印出请求类、方法、请求参数。注意：这里要加上@ControllerAdvice请求才能增强
 */
@Component
@RestControllerAdvice(annotations = RestController.class)
public class AsRequestBodyAdvice implements RequestBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        //这里设置成false 它就不会再走这个类了
        return false;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            //这个request其实就是入参 可以从这里获取流
            //入参放在HttpInputMessage里面  这个方法的返回值也是HttpInputMessage
            InputStream inputStream = httpInputMessage.getBody();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        //获取请求数据
        String string = stringBuilder.toString();
        System.out.println("httpInputMessage:"+string);
        System.out.println("methodParameter:"+methodParameter);
        System.out.println("type:"+type);
        System.out.println("aClass:"+aClass);

        //把数据放到我们封装的对象中
        return new MyHttpInputMessage(httpInputMessage.getHeaders(), new ByteArrayInputStream(string.getBytes("UTF-8")));
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }


    /**
     *  这里实现了HttpInputMessage 封装一个自己的HttpInputMessage
     */
    static class MyHttpInputMessage implements HttpInputMessage {
        HttpHeaders headers;
        InputStream body;

        public MyHttpInputMessage(HttpHeaders headers, InputStream body) {
            this.headers = headers;
            this.body = body;
        }

        @Override
        public InputStream getBody() throws IOException {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
    }
}
