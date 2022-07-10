package purchaseprice.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class AppResponse {


    private String message;

    private Object Data;
}
