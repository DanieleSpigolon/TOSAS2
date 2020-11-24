////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;

public class TakeAwayBillClassTest {

    private TakeAwayBillClass takeAwayBill;

    @Before
    public void before() {
        takeAwayBill = new TakeAwayBillClass();
    }

    @Test
    public void testWithoutDiscountOrderPriceCalculation() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User user = new User("110","Daniele","Spigolon",21);
        for(int i = 0; i < 3; ++i) {
            itemsOrdered.add(new MenuItem(ItemType.Gelati, "BananaSplit", 4.0));
        }

        try {
            assertEquals(12.0, takeAwayBill.getOrderPrice(itemsOrdered,user), 0);
        } catch (TakeAwayBillException e) {
            fail("TakeAwayBillException thrown");
        }
    }
    @Test
    public void testDiscountForLowPriceIceCreamsIfMoreThan5IceCreams() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User user = new User("110","Daniele","Spigolon",21);
        for(int i = 0; i < 5; ++i) {
            itemsOrdered.add(new MenuItem(ItemType.Gelati, "BananaSplit", 5.0));
        }
        itemsOrdered.add(new MenuItem(ItemType.Gelati, "CoppaNafta", 4.0));

        try {
            assertEquals(27.0, takeAwayBill.getOrderPrice(itemsOrdered,user), 0);
        } catch (TakeAwayBillException e) {
            fail("TakeAwayBillException thrown");
        }
    }
}