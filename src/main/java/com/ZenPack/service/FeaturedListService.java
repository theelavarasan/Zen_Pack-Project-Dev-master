package com.ZenPack.service;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.model.ZenPack;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FeaturedListService {

////    ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack);
//
    FeaturedList save(FeaturedList featuredList);

    List<FeaturedList> findAllList();

    //Get Feature_list by keyword
    List<FeaturedList> findByKeyword(String keyword);

    FeaturedList updateList(FeaturedList list, int id);

    void deleteMovie(int id);
//
//
////    ResponseEntity<FeaturedList> saveFeauturedList(FeaturedList list);
}
