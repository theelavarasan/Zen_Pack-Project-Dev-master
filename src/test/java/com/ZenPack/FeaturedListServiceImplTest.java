//package com.ZenPack;
//
//import com.ZenPack.model.FeaturedList;
//import com.ZenPack.repository.FeaturedListRepository;
//import com.ZenPack.service.FeaturedListService;
//import com.ZenPack.service.FeaturedListServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class FeaturedListServiceImplTest {
//
//    @Mock
//    private FeaturedListRepository featuredListRepository;
//
//    @InjectMocks
//    private FeaturedListServiceImpl featuredListServiceImpl;
//
////    @Autowired
////    private FeaturedListService service;
//
//    private FeaturedList list;
//    private FeaturedList list1;
//
//    @BeforeEach
//    void init(){
//        FeaturedList list=new FeaturedList();
//        list.setId(1);
//        list.setFeatureId("#");
//        list.setText("Project Management");
//        list.setFeatureUrl(null);
//        list.setIcon("#");
//        list.setIsSettingMenu(true);
//
//        FeaturedList list1=new FeaturedList();
//        list.setId(2);
//        list.setFeatureId("#");
//        list.setText("Project Management");
//        list.setFeatureUrl(null);
//        list.setIcon("#");
//        list.setIsSettingMenu(true);
//    }
//
//    @Test
//    void save(){
//        FeaturedList list=new FeaturedList();
//        list.setId(1);
//        list.setFeatureId("#");
//        list.setText("Project Management");
//        list.setFeatureUrl(null);
//        list.setIcon("#");
//        list.setIsSettingMenu(true);
//        when(featuredListRepository.save(any(FeaturedList.class))).thenReturn(list);
//        FeaturedList newList = featuredListServiceImpl.save(list);
//
//        assertNotNull(newList);
//        assertThat(newList.getText()).isEqualTo("Project Management");
//    }
//
//    @Test
//    void getList(){
//        List<FeaturedList> featuredLists = new ArrayList<>();
//        featuredLists.add(list);
//        featuredLists.add(list1);
//        when(featuredListRepository.findAll()).thenReturn(featuredLists);
//        List<FeaturedList> featuredLists1 =featuredListServiceImpl.findAllList();
//
//        assertEquals(2,featuredLists1.size());
//        assertNotNull(featuredLists);
//    }
//
//    @Test
//    void updateList() {
//
//        when(featuredListRepository.findById(anyInt())).thenReturn(Optional.of(list));
//
//        when(featuredListRepository.save(any(FeaturedList.class))).thenReturn(list);
//        list.setFeatureName("Project");
//        FeaturedList exisitingMovie = featuredListServiceImpl.updateList(list, list.getId());
//
//        assertNotNull(exisitingMovie);
//        assertEquals("Project Management", list.getFeatureUrl());
//    }
////
////    @Test
////    void deleteList() {
////
////        Integer listId = 1;
////        when(featuredListRepository.findById(anyInt())).thenReturn(Optional.of(list));
////        doNothing().when(featuredListRepository).delete(any(FeaturedList.class));
////
////        featuredListServiceImpl.deleteMovie(listId);
////
////        verify(featuredListRepository, times(1)).delete(list);
////
////    }
//
//
//}
