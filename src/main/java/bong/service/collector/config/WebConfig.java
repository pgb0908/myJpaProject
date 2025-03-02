package bong.service.collector.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${upload.dir}")  // application.yaml에서 설정값 가져오기
    private String uploadDir;

    public static String UPLOAD_DIR;

    @PostConstruct
    public void init(){
        UPLOAD_DIR = uploadDir;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(uploadDir + "**")
                .addResourceLocations("file:" + uploadDir);
    }
}
