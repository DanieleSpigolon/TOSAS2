////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.model.InvoiceTotal;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.model.ItemType;

public class InvoiceTotalTest {

    @Test
    public void InvoiceTotalFirstTest(){
        List<MenuItem> listaOrder = new ArrayList<MenuItem>();
        listaOrder.add(new MenuItem(ItemType.Bevande, "LemonSoda", 3.00));

        User user = new User("110","Daniele", "Spigolon", 2);

        InvoiceTotal InvoiceTotal = new InvoiceTotal(listaOrder, user, 2008, 7.00);

        assertEquals(listaOrder, InvoiceTotal.getLista());
        assertEquals(user, InvoiceTotal.getUser());
        assertEquals(2008,InvoiceTotal.gettempoInSecondi());
        assertEquals(7.00,InvoiceTotal.getPrice(),0);
    }
}