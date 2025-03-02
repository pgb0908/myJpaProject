package bong.service.collector.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
public class imageDto {
    private Long id;
    private String title;
    private String type;
    private String imageUrl;
    private LocalDateTime updatedAt;
    private String desc;

    public imageDto(Long id, String title, String type, String url,  String description, LocalDateTime time){
        this.id = id;
        this.title = title;
        this.type = type;
        this.imageUrl = url;
        this.desc = description;
        this.updatedAt = time;
    }
}
