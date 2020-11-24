////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillClass implements TakeAwayBill {

    public double getOrderPrice(List<MenuItem> itemsOrdered,User user) 
            throws TakeAwayBillException {

        double totalPrice = 0.0;
        double lowPrice = Double.MAX_VALUE;
        double totalDiscount = 0.0;
        int gelatiNumber = 0;
        double totalIceCreamAndBudin=0.0;
        
        for(MenuItem itemOrdered : itemsOrdered) {
            totalPrice += itemOrdered.getPrice();

            if(itemOrdered.getItemType() == ItemType.Gelati) {
                if(itemOrdered.getPrice() < lowPrice) {
                    lowPrice = itemOrdered.getPrice();
                }  
                
                totalIceCreamAndBudin += itemOrdered.getPrice();
               gelatiNumber++;
            }  
            if(itemOrdered.getItemType() == ItemType.Budini) {
                totalIceCreamAndBudin += itemOrdered.getPrice();
            }
        }
        
        if(gelatiNumber > 5) {
            totalDiscount += lowPrice / 2.0;
        }
        
        if(totalIceCreamAndBudin > 50.0) {
            totalDiscount += totalPrice * 0.10;
        }
        return totalPrice - totalDiscount;
    }

}