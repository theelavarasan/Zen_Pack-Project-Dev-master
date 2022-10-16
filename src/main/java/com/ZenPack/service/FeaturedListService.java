package com.ZenPack.service;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.model.ZenPack;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FeaturedListService {

    FeaturedList save(FeaturedList featuredList);

    List<FeaturedList> findAllList();

    //Get Feature_list by keyword
    List<FeaturedList> findByKeyword(String keyword);

//    FeaturedList updateList(FeaturedList list, int id);

    void deleteList(int id);

    FeaturedList updatedList(FeaturedList updatedList);

    Optional<FeaturedList> getListById(int id);


}
