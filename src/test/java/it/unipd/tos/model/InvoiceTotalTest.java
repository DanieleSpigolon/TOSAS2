////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import it.unipd.tos.model.InvoiceTotal;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.model.ItemType;

public class InvoiceTotalTest {

    private User user;
    private List<MenuItem> lista;
    private InvoiceTotal invoiceTotal;

    @Before
    public void setup(){
        user = new User("110","Daniele","Spigolon",18);
        lista = new ArrayList<MenuItem>();
        invoiceTotal = new InvoiceTotal(lista, user, 1336, 3.00);
        lista.add(new MenuItem(ItemType.Bevande, "LemonSoda", 3.00));
    }

    @Test
    public void getListaTest() {
        assertEquals(lista, invoiceTotal.getLista());
    }

    @Test
    public void getUserTest() {
        assertEquals(user, invoiceTotal.getUser());
    }

    @Test
    public void getTimeTest() {
        assertEquals(1336,invoiceTotal.gettempoInSecondi());
    }

    @Test
    public void getPriceTest() {
        assertEquals(3.00,invoiceTotal.getPrice(),0);
    }

}