package com.example.practice.Repository;

import com.example.practice.Model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic,String> {

    Topic getById(String id);
}
