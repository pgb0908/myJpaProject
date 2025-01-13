package bong.service.collector.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "collection_items")
public class CollectionItem {

    @Id
    @Column(name = "collection_item_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private LocalDateTime addAt;
}
