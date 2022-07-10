package purchaseprice.service;

import purchaseprice.model.AppResponse;
import purchaseprice.model.TotalPrice;

public interface DenominationService {

    AppResponse getDenominations(TotalPrice totalPrice);

}
