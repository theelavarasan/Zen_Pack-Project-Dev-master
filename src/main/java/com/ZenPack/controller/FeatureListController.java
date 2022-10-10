package com.ZenPack.controller;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.service.FeaturedListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FeatureListController {

    @Autowired
    private FeaturedListServiceImpl service;

    @PostMapping("/create_feature_list")
    @ResponseStatus(HttpStatus.CREATED)
    public FeaturedList create(@RequestBody FeaturedList featuredList){
        return service.save(featuredList);
    }

    @GetMapping("/get_feature_list")
    @ResponseStatus(HttpStatus.OK)
    public List<FeaturedList> findAllFeatureList(){
        return service.findAllList();
    }

    @GetMapping("/search_by_name")
    @ResponseStatus(HttpStatus.OK)
    public List<FeaturedList> findByName(@RequestParam String keyword){
        return service.findByKeyword(keyword);
    }

    @PutMapping("/update_list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FeaturedList updateList(@PathVariable int id,@RequestBody FeaturedList list){
        return service.updateList(list,id);
    }

    @DeleteMapping("/deleteList/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.deleteMovie(id);
    }


}
