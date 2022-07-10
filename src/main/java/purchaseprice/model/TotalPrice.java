package purchaseprice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalPrice {

    @NotBlank(message = "total price can't be null")
    private String totalPrice;

}
