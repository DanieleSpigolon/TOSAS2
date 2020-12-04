////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.model.InvoiceTotal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TakeAwayBillClass implements TakeAwayBill {

    public double getOrderPrice(List<MenuItem> itemsOrdered,User user) 
            throws TakeAwayBillException {

        double totalPrice = 0.0;
        double lowPrice = Double.MAX_VALUE;
        double totalDiscount = 0.0;
        int gelatiNumber = 0;
        double totalIceCreamAndBudin=0.0;
        
        if(itemsOrdered == null) {
            throw new TakeAwayBillException("La lista non esiste, e' nulla"); 
        }
        if(itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("Non consentito, >30 elementi di ordinazione");
        }
        if(itemsOrdered.contains(null)) {
            throw new TakeAwayBillException
                ("Attenzione!, lista contiene elementi nulli"); 
        }
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
        if(totalPrice > 0.0 && totalPrice < 10.0) {
            totalDiscount -= 0.5; //per aggiungere ricorda di mettere meno
        }
        return totalPrice - totalDiscount;
    }
    
    public List<InvoiceTotal> getGratisInvoce(List<InvoiceTotal> invoice){

        List<InvoiceTotal> gratis = new ArrayList<InvoiceTotal>();
        //attenzione alle ore in secondi
        for (int i = 0; i < invoice.size(); i++) {
            if(invoice.get(i).getUser().getEta()<18 &&
             !gratis.contains(invoice.get(i)) &&
             invoice.get(i).gettempoInSecondi()> 64800 &&
             invoice.get(i).gettempoInSecondi()< 68400)
            {
                gratis.add(invoice.get(i));
            }
        }

        if(gratis.size()>9){
            long times = System.nanoTime();
            Collections.shuffle(gratis, new Random(times));
            //mettiamo a zero i prezzi
            gratis = gratis.subList(0,10);
            for (InvoiceTotal i : gratis) {
                i.setPrice(0.0);
            }
        }

        return gratis;
    }

}