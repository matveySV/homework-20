package com.example.nix_spring1.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "photo",schema = "nix")
public class PhotoEntity {
        @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name="hibernate_sequence",
//    sequenceName = "hibernate_sequence", allocationSize = 1)
    private long id;

    @Column(name="url")
    private String url;

    @Column(name="description")
    private String descripion;

    @ManyToOne
    @JoinColumn(name="student_id")
    @ToString.Exclude
    private StudentEntity student;
}
