package purchaseprice.helper;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetChange {

    public List<String>  getDenmination(String totalPrice){
        List< String>  change=new ArrayList<>();
        int len=totalPrice.length();
        int preDec=totalPrice.indexOf(".");
        if(preDec==-1) {
            preDec = len;
        }
        int preNumber = convertToInt(totalPrice.substring(0,preDec));
            getNotes(change, preNumber, " £", "");
            if (preDec < len) {
                int postNumber = convertToInt(totalPrice.substring(preDec  + 1));
                getNotes(change, postNumber, " ", "p");
            }
        return change;
    }



    private void getNotes(List< String> change, int totalPrice,String presymbol,String postsymbol) {
        int notes=0;
        if(totalPrice>=50){
            notes=totalPrice/50;
            totalPrice=totalPrice%50;
            change.add(notes +" *"+ presymbol+"50"+postsymbol);
        }
        if(totalPrice>=20){
            notes=totalPrice/20;
            totalPrice=totalPrice%20;
            change.add(notes +" *"+ presymbol+"20"+postsymbol);
        }
        if(totalPrice>=10){
            notes=totalPrice/10;
            totalPrice=totalPrice%10;
            change.add(notes +" *"+ presymbol+"10"+postsymbol);
        }
        if(totalPrice>=5){
            notes=totalPrice/5;
            totalPrice=totalPrice%5;
            change.add(notes +" *"+ presymbol+"5"+postsymbol);
        }
        if(totalPrice>=2){
            notes=totalPrice/2;
            totalPrice=totalPrice%2;
            change.add(notes +" *"+ presymbol+"2"+postsymbol);
        }
        if(totalPrice>=1){
            notes=totalPrice/1;
            totalPrice=totalPrice;
            change.add(notes +" *"+ presymbol+"1"+postsymbol);
        }


    }

    public int convertToInt(String s){
        int cost=0;
        for(char c:s.toCharArray()){
            cost=cost*10;
            cost=cost+(c-'0');
        }
        return cost;
    }

}
