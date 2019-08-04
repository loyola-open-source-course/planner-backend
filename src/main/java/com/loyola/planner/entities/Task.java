package com.loyola.planner.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

/**
 * @author Alexander Kohonovsky
 * @since 2019-07-03
 */
@Getter
@Setter
@Entity(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User author;

}
