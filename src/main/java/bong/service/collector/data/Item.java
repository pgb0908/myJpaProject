package bong.service.collector.data;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String url;

    private LocalDateTime uploadAt;

    private String description;

}
