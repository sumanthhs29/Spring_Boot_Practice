package com.example.practice.Service;

import com.example.practice.Model.Topic;
import com.example.practice.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
//        List<Topic> topics = new ArrayList<>();
//        topicRepository.findAll()
//                .forEach((topics::add));
//        return topics;
        return(List<Topic>) topicRepository.findAll();
    }

    public Topic getTopic(String id) {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    public String addTopic(Topic topic) throws Exception {
        Topic t = topicRepository.getById(topic.getId());
        if(t == null)
        {
            topicRepository.save(topic);
            return "Topic added successfully";
        }
        else
            throw new Exception("Topic already exists");
    }

    public String updateTopic(Topic topic, String id) throws Exception {
        Topic t = topicRepository.getById(id);
        if(t == null) {
            throw new Exception("Topic not found");
        }
        t=topicRepository.save(topic);
        return "Topic updated";
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
