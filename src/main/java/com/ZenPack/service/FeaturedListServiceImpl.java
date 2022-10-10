package com.ZenPack.service;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.repository.FeaturedListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeaturedListServiceImpl implements FeaturedListService  {


    @Autowired
    private FeaturedListRepository repository;

    @Override
    public FeaturedList save(FeaturedList featuredList) {
        return repository.save(featuredList);
//         new ResponseEntity<>(featuredList,HttpStatus.CREATED);
    }

    //Get the Feature_List
    @Override
    public List<FeaturedList> findAllList() {
        return repository.findAll();
//        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //Get Feature_list by keyword
    @Override
    public List<FeaturedList> findByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }

    @Override
    public FeaturedList updateList(FeaturedList list, int id) {
        FeaturedList existingList = repository.findById(id).get();
        existingList.setFeatureName(list.getFeatureName());
        existingList.setFeatureUrl(list.getFeatureUrl());
        existingList.setCreatedTime(list.getCreatedTime());
        existingList.setCreatedBy(list.getCreatedBy());
        return repository.save(existingList);
    }

    public void deleteMovie(int id) {
        FeaturedList existingList=repository.findById(id).get();
        repository.delete(existingList);
    }


}
