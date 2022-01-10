import JPAHibernate.repository.JpaBranchRepository;
import JPAHibernate.service.dao.domain.Branch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Репозиторий для работы с филиалами")
@DataJpaTest
@Import(JpaBranchRepository.class)
public class BranchRepositoryTest {
    private final static long FIRST_BRANCH_ID = 1L;
    @Autowired
    private JpaBranchRepository repository;

    @Autowired
    private TestEntityManager em;

    @DisplayName("информация о филиале по его id")
    @Test
    void shouldFondExpectedBranchById() {
        var optinalActualBranch = repository.findById(FIRST_BRANCH_ID);
        var expectedBranch = em.find(Branch.class, FIRST_BRANCH_ID);
        assertThat(optinalActualBranch)
                .isPresent()
                .get()
                .isEqualToComparingFieldByField(expectedBranch);
    }
}