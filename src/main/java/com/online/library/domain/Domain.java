    package com.online.library.domain;

    import jakarta.persistence.*;
    import lombok.Getter;

    import java.time.LocalDateTime;

    @Getter
    @MappedSuperclass
    public class Domain {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        protected Long id;

        @Column(updatable = false)
        protected LocalDateTime created = LocalDateTime.now();

    }
