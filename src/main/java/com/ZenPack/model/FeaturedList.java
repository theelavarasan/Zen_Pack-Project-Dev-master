package com.ZenPack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "Features")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeaturedList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "resource_id")
    private String featureId;
    @Column(name = "features")
    private String text;
    @Column(name = "icon")
    private String icon;
    @Column(name = "is_setting_menu")
    private Boolean isSettingMenu;
    @Column(name = "feature_url")
    private String featureUrl;
}
