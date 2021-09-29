package com.example.practice.Service;

import com.example.practice.Model.Topic;
import com.example.practice.Repository.TopicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TopicServiceTest {

    @InjectMocks
    TopicService topicService;
//    private TopicService topicService;

    @Mock private TopicRepository topicRepository;

    TopicTestAssets topicTestAssets = new TopicTestAssets();

//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        topicService = new TopicService(topicRepository);
//    }

    @Test
    void getAllTopics() throws Exception {
        //Arrange
        Mockito.when(topicRepository.findAll()).thenReturn(topicTestAssets.allTopics);
        //Act
        List<Topic> result =topicService.getAllTopics();
        //Assert
        assertThat(result,equalTo(topicTestAssets.allTopics));
    }

    @Test
    void getTopic() throws Exception {
        //Arrange
        Mockito.when(topicRepository.findById("Java")).thenReturn(java.util.Optional.ofNullable(topicTestAssets.topic1));
        //Act
        Topic result = topicService.getTopic("Java");
        //Assert
        assertThat(result,equalTo(topicTestAssets.topic1));
    }

    @Test
    void addTopic() throws Exception {
        //Arrange
        String success ="Topic added successfully";
        Mockito.when(topicRepository.save(ArgumentMatchers.any(Topic.class))).thenReturn(topicTestAssets.topic1);
        //Act
        String result = topicService.addTopic(topicTestAssets.topic1);
        //Assert
        assertThat(result,equalTo(success));
    }

    @Test
    void whenTopicIsNotFoundForUpdate_thenThrowException () {
        Exception ex = assertThrows(Exception.class,
                () -> topicService.updateTopic(topicTestAssets.topic1,"Java"),
                "Expecting bad request exception when topic already exists");
        assertThat(ex.getMessage(),equalTo("Topic not found"));
    }

}