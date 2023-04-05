package Recommendation.Movie.service;

import Recommendation.Movie.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity userDetails);

    UserEntity getUser(String id);


    String getRecommendation(int i);


    List<String> getHistory(int i);

    void getReset(int i);
}
