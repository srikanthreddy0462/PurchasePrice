package purchaseprice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import purchaseprice.helper.GetChange;
import purchaseprice.model.AppResponse;
import purchaseprice.model.TotalPrice;
import purchaseprice.service.DenominationService;

@Service
public class DenominationServiceImpl implements DenominationService {


    @Autowired
    private GetChange getChange;
    @Override
    public AppResponse getDenominations(TotalPrice totalPrice) {

            String totalCost = totalPrice.getTotalPrice();
            try {
                double str = Double.parseDouble(totalCost);
                return new AppResponse(null, getChange.getDenmination(totalCost));
            }catch(Exception e){
                return new AppResponse("Pls Enter Valid Input",null);
            }
    }


}
