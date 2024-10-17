package com.example.projectbase.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    private String id;

    @Nationalized
    @Column(nullable = false)
    private String content;

    @Nationalized
    @Column(nullable = false)
    private LocalDateTime createdTime;

    //Link to table User
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_QUESTION_USER"))
    private User user;

    //Link to table Answer
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnore
    private Set<Answer> Answer = new HashSet<>();
}