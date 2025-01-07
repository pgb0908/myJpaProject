package bong.service.collector.data;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String password;

    private String name;

    private LocalDateTime createAt;

    @OneToOne(mappedBy = "user")
    private Item item;

    @OneToMany
    @JoinColumn(name)
    private Like like;
}
