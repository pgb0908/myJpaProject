package bong.service.collector.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String title;

    private String type;

    private String imageUrl; // 고해상도 이미지 URL

    private String thumbnailUrl; // 썸네일 이미지 URL

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "item")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<CollectionItem> collectionItems = new ArrayList<>();


    public static Item createImage(String title,
                                   String type,
                                   String imageUrl,
                                   String thumbnailUrl,
                                   String desc,  User user)  {
        Item item = new Item();
        item.setTitle(title);
        item.setType(type);
        item.setImageUrl(imageUrl);
        item.setThumbnailUrl(thumbnailUrl);
        item.setDescription(desc);

        if(user != null){
            item.setUser(user);
        }


        return item;
    }

}
