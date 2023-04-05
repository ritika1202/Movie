package Recommendation.Movie.service;

import Recommendation.Movie.entity.UserEntity;
import Recommendation.Movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    //Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity userDetails) {
        userRepository.save(userDetails);
        return userRepository.findByEmail(userDetails.getEmail());
    }

    @Override
    public UserEntity getUser(String id) {
        Optional<UserEntity> userEntity = userRepository.findById(Integer.parseInt(id));

        return userEntity.get();
    }
    List<Object> arr=new ArrayList();
    List<String> movieName=new ArrayList<>();

    HashMap<Integer,List<String>> history=new HashMap<>();
    @Override
    public String getRecommendation(int id) {
        String url="https://api.tvmaze.com/shows";
        RestTemplate restTemplate= new RestTemplate();
        Object Movies=restTemplate.getForObject(url,Object[].class);
        arr= Arrays.asList(Movies);
        if (Movies != null && Movies.getClass().isArray()) {

            for (Object each : (Object[])Movies) {

                //    String movie = each.getClass(movieName).ToString();
                String movie= (String) ((LinkedHashMap) each).get("name");
                movieName.add(movie);
                //System.out.println(each);
            }
        }
        Random rand = new Random();
        String randomMovie = movieName.get(rand.nextInt(movieName.size()));

        if(history.containsKey(id)) {
            List<String> movieList=new ArrayList<>();
            movieList.addAll(history.get(id));
            movieList.add(randomMovie);
            history.put(id, movieList);
        }
        else
        {
            List<String> movieList=new ArrayList<>();
            movieList.add(randomMovie);
            history.put(id, movieList);

        }
        return randomMovie;

    }

    @Override
    public List<String> getHistory(int id) {
        return history.get(id);
    }

    @Override
    public void getReset(int i) {
        history.remove(i);
    }
}
