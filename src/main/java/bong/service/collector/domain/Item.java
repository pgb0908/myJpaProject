package bong.service.collector.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String url;

    private LocalDateTime uploadAt;

    private String description;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] imageData;

    @OneToMany(mappedBy = "item")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<CollectionItem> collectionItems = new ArrayList<>();


    public static Item createImage(String title,
                                   String desc, MultipartFile file, User user)  {
        Item item = new Item();
        item.setTitle(title);
        item.setDescription(desc);
        item.setUploadAt(LocalDateTime.now());

        if(user != null){
            item.setUser(user);
        }

        try {
            item.setImageData(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return item;
    }

}
