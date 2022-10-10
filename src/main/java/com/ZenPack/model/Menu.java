package com.ZenPack.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Menu")
@Getter
@Setter
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "created_time")
    private Date createdTime = new Date();
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "zen_pack_id")
    private int zenPackId;
    @Column(name = "feature_id")
    private int featureId;
}
