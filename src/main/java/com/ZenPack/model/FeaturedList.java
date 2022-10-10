package com.ZenPack.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "Featured_List")
public class FeaturedList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "feature_name")
    private String featureName;
    @Column(name = "feature_url")
    private String featureUrl;
    @Column(name = "created_time")
    private LocalDate createdTime;
    @Column(name = "created_by")
    private String createdBy;
}
