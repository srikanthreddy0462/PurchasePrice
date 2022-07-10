package purchaseprice;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import purchaseprice.model.AppResponse;
import purchaseprice.model.TotalPrice;


@SpringBootTest(classes = PurchasePriceApplication.class, webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ContextConfiguration(classes = PurchasePriceApplication.class)
@RunWith(SpringRunner.class)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    private static RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationTest.class);


    @BeforeAll
    static void initAll() {
        PurchasePriceApplication.main(new String[]{});
    }

    private String url(String uri) {
        return "http://localhost:" + port + uri;
    }



    @Test
    public void getDenominationSuccess()  {

        TotalPrice totalPrice=new TotalPrice();
        totalPrice.setTotalPrice("125.45");
        ResponseEntity<AppResponse> response = null;

            response = getStatus("/get/denominations", totalPrice);
            Assertions.assertEquals(200, response.getStatusCodeValue()
                    , "Success");

    }

    public ResponseEntity<AppResponse> getStatus(String uri, TotalPrice request)  {
        RestTemplate restTemplate = new RestTemplate();
        String url = url(uri);
        LOGGER.info("URL : {}", url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TotalPrice> entity = new HttpEntity<>(request, headers);
        ResponseEntity<AppResponse> response = restTemplate.exchange(url, HttpMethod.POST,
                entity, AppResponse.class);

        return response;
    }

    @Test
    public void getDenominationFail()  {

        TotalPrice totalPrice=new TotalPrice();
        totalPrice.setTotalPrice("0");
        ResponseEntity<AppResponse> response = null;

        response = getStatus("/get/denominations", totalPrice);
        Assertions.assertNull( response.getBody().getMessage());

    }

}
