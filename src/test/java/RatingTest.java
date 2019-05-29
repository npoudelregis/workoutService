import com.workoutService.Dao.RatingDao;
import com.workoutService.Entities.Rating;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RatingTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RatingDao ratingDao;

    @Test
    public void whenFindById_thenReturnRating() {
        Rating rating = new Rating();
        entityManager.persist(rating);
        entityManager.flush();

        Optional<Rating> found = ratingDao.findById(rating.getId());
        if (found.isPresent()) {
            Rating thing = found.get();
            assertThat(thing.getId())
                    .isEqualTo(rating.getId());
        }
    }
}
