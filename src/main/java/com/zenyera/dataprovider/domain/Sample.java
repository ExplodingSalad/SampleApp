package com.zenyera.dataprovider.domain;

import jakarta.persistence.*;

@Entity
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SAMPLE_ID")
    private Long id;

    @Column(name = "SAMPLE_NAME", nullable = false)
    private String name;

    @Column(name = "SAMPLE_DESCRIPTION")
    private String description;

    @Column(name = "SAMPLE_NUMBER", nullable = false)
    private Integer number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
