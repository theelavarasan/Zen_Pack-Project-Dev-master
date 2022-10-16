package com.ZenPack.controller;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.service.FeaturedListServiceImpl;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class FeatureListController {

    @Autowired
    private FeaturedListServiceImpl service;

    private static final Logger logger =LoggerFactory.getLogger(FeatureListController.class);

    @PostMapping("/create_feature_list")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(code = 201,message ="created successfully")
    public FeaturedList create(@RequestBody FeaturedList featuredList){
        logger.info("Create Api log");
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

//    @PutMapping("/update_list/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public FeaturedList updateList(@PathVariable int id,@RequestBody FeaturedList list){
//        return service.updateList(list,id);
//    }

    @DeleteMapping("/deleteList/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.deleteList(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeaturedList> updateEmployee(@PathVariable("id") int listId,
                                                       @RequestBody FeaturedList featuredList){
        return service.getListById(listId)
                .map(savedList -> {
                    savedList.setText(featuredList.getText());
                    savedList.setFeatureUrl(featuredList.getFeatureUrl());
                    savedList.setIcon(featuredList.getIcon());
                    savedList.setIsSettingMenu(featuredList.getIsSettingMenu());

                    FeaturedList updatedList = service.updatedList(savedList);
                    return new ResponseEntity<>(updatedList, HttpStatus.OK);

                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<FeaturedList> getList(@PathVariable int id){
        return service.getListById(id);
    }


}
