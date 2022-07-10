package purchaseprice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import purchaseprice.model.AppResponse;
import purchaseprice.model.TotalPrice;
import purchaseprice.service.DenominationService;

@RestController
@RequestMapping("/get")
public class PurchasePrice {

    @Autowired
    private DenominationService denominationService;

    @PostMapping("/denominations")
    public AppResponse getDenominations(@RequestBody TotalPrice request) {
        return denominationService.getDenominations(request);
    }

}
