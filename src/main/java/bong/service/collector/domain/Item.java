package bong.service.collector.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String url;

    private LocalDateTime uploadAt;

    private String description;

    @OneToMany(mappedBy = "item")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<CollectionItem> collectionItems = new ArrayList<>();

}
