package bong.service.collector.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "collections")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "collection_seq")
    @SequenceGenerator(name = "collection_seq", sequenceName = "collection_seq", allocationSize = 1)
    @Column(name = "collection_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createAt;

    private String name;

    private String desc;

    @OneToMany(mappedBy = "collection")
    private List<CollectionItem> collectionItems = new ArrayList<>();


}
