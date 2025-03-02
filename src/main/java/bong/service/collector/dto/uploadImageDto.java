package bong.service.collector.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
public class uploadImageDto {
    private Long id;
    private String title;
    private String type;
    private String imageUrl;
    private LocalDateTime updatedAt;
    private String desc;
    private MultipartFile file;

    public uploadImageDto(Long id, String title, String description, MultipartFile file){
        this.id = id;
        this.title = title;
        this.type = file.getContentType();
        this.imageUrl = file.getOriginalFilename();
        this.desc = description;
        this.file = file;
    }


}
