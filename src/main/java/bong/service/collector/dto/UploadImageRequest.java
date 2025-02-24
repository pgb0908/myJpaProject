package bong.service.collector.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadImageRequest {
    private String title;
    private String desc;
    private MultipartFile file;
}
