# Spring_Boot_Practice
1]  add topics -> POST /topics
{
    "id": "java",
    "name": "Java",
    "description": "Java Description"
}

2] get all topics -> /topics

3] get a topic -> http://localhost:8080/topics/{topicId}

4] update a topic -> PUT http://localhost:8080/topics/{topicId}
{
    "id": "typescript",
    "name": "TypeScript",
    "description": "Updated TypeScript Description"
}

5] delete a topic -> http://localhost:8080/topics/{topicId}

6] add course -> POST http://localhost:8080/topics/{topicId}/courses
{
    "id": "java-streams",
    "name": "Java Streams",
    "description": "Java Streams Description"
}

7] get courses under all topic -> http://localhost:8080/topics/{topicId}/courses

8] get courses under a topic -> http://localhost:8080/topics/{topicId}/courses/{courseId}

9] update a course -> PUT http://localhost:8080/topics/{topicId}/courses/{courseId}
{
    "id": "java-streams",
    "name": "Java Streams",
    "description": "Java 8 Streams Description"
}

10] delete a course http://localhost:8080/topics/{topicId}/courses/{courseId}
