package com.ZenPack;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.repository.FeaturedListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@DataJpaTest
@AutoConfigureMockMvc
@SpringBootTest
public class FeaturedListRepositoryTest {
    @Autowired
    private FeaturedListRepository featuredListRepository;

    @Autowired
    private MockMvc mockMvc;

    private FeaturedList list;
    private FeaturedList list1;


    @Test
    @DisplayName("It Should save the list to database")
    void save(){
        FeaturedList list=new FeaturedList();
        list.setId(1);
        list.setFeatureName("Project Management");
        list.setFeatureUrl(null);
//        list.setCreatedTime(LocalDate.of(2022, Month.OCTOBER,06));
       // list.setCreatedTime(ZonedDateTime.now().toLocalDate());
        list.setCreatedBy("Elavarasan");
        FeaturedList newList = featuredListRepository.save(list);
        assertNotNull(newList);
        assertThat(newList.getId()).isNotEqualTo(null);
    }

    @Test
    @DisplayName("It should return List from database")
    void getAllList(){
        List<FeaturedList> featuredLists = featuredListRepository.findAll();

        assertNotNull(featuredLists);
        assertThat(featuredLists).isNotNull();
        assertEquals(22,featuredLists.size());
    }

    @Test
    @DisplayName("It should update the list name with PROJECT")
    void updateList() {
        FeaturedList list=new FeaturedList();
        list.setId(2);
        list.setFeatureName("Project Management");
        list.setFeatureUrl(null);
        list.setCreatedBy("Elavarasan");

        featuredListRepository.save(list);

        FeaturedList existingMovie = featuredListRepository.findById(list.getId()).get();
        existingMovie.setFeatureName("Project Management");
        FeaturedList updatedList = featuredListRepository.save(existingMovie);

        assertEquals("Project Management", updatedList.getFeatureName());
    }

    @Test
    @DisplayName("It should delete the existing list")
    void deleteList() {

        FeaturedList list=new FeaturedList();
        list.setId(2);
        list.setFeatureName("Project Management");
        list.setFeatureUrl(null);
        list.setCreatedBy("Elavarasan");

        featuredListRepository.save(list);
        Integer id = list.getId();

        //featuredListRepository.save(list1);

        featuredListRepository.delete(list);

        List<FeaturedList> list1 = featuredListRepository.findAll();

        Optional<FeaturedList> exitingMovie = featuredListRepository.findById(id);

        assertEquals(7, list1.size());
        assertThat(exitingMovie).isEmpty();

    }
}
