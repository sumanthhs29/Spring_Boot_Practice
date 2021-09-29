package com.example.practice.Service;

import com.example.practice.Model.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicTestAssets {

    public TopicTestAssets() {}

    public Topic topic1 = new Topic("Java", "Java Basic", "Java Basic Description");

    public List<Topic> allTopics = new ArrayList<Topic>(){{
            add(topic1);
        }};
}
