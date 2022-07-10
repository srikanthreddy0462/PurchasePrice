package purchaseprice;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import purchaseprice.helper.GetChange;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DenominationServiceTest {

    @InjectMocks
    private GetChange getChange;



    @BeforeAll
    static void initAll() {
        PurchasePriceApplication.main(new String[]{});
    }


    @Test
    public void doubleValue(){
       GetChange getChange=new GetChange();
        List<String> denom=getChange.getDenmination("123.45");
        Assertions.assertNotNull(denom);
    }

   // @Test
    public void nondoubleValue(){
        GetChange getChange=new GetChange();
        List<String> denom=getChange.getDenmination("46");
        Assertions.assertNotNull(denom);
    }

}
