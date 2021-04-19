import com.franchise.qa.model.FranchiseModel;
import com.franchise.qa.persistance.entity.Franchise;
import com.franchise.qa.persistance.repository.FranchiseRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.mockito.Mockito.mock;

/**
 * Created by noravingal on 14/03/21.
 */
@SpringBootTest
public class FranchiseServiceClassTest {

    @Autowired
    FranchiseRepository franchiseRepository = mock(FranchiseRepository.class);
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void franchiseServiceTest() throws Exception {
        FranchiseModel franchiseModel = new FranchiseModel("Ali","123",new Date(),"Addr","987"
        ,"naseem@gmail.com","exp","intr",12.13,"area","addnotes");

        Franchise franchise = new Franchise();
        BeanUtils.copyProperties(franchiseModel, franchise);

        franchise.setId(System.currentTimeMillis());
        franchiseRepository.save(franchise);

        System.out.println(franchise.getApplicantName());
    }

}