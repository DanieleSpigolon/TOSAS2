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
import it.unipd.tos.model.InvoiceTotal;

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
    public void testDiscountForLowestPriceIceCreamsIfMoreThan5IcreCreams() {
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
    @Test
    public void testDiscountIfIceCreamAndBudinPriceIfMoreThan50() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User user = new User("110","Daniele","Spigolon",21);
        for(int i = 0; i < 4; ++i) {
            itemsOrdered.add(new MenuItem(ItemType.Gelati, "CoppaNafta", 5.0));
            itemsOrdered.add(new MenuItem(ItemType.Budini, "Pinguino", 10.0));
        }

        try {
            assertEquals(54, takeAwayBill.getOrderPrice(itemsOrdered,user), 0);
        } catch (TakeAwayBillException e) {
            fail("TakeAwayBillException thrown");
        }
    }

    @Test
    public void test2DiscountForMoreThan5IceCreamsAndPriceMoreThan50() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User user = new User("110","Daniele","Spigolon",21);
        for(int i = 0; i < 7; ++i) {
            itemsOrdered.add(new MenuItem(ItemType.Gelati, "BananaSplit", 5.0));
            itemsOrdered.add(new MenuItem(ItemType.Budini, "Pinguino", 10.0));
        }

        try {
            assertEquals(92, takeAwayBill.getOrderPrice(itemsOrdered,user), 0);
        } catch (TakeAwayBillException e) {
            fail("TakeAwayBillException thrown");
        }
    }
    @Test(expected = TakeAwayBillException.class) 
    public void testMore30Elements() 
            throws TakeAwayBillException {

        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User user = new User("110","Daniele","Spigolon",21);
        for(int i = 0; i < 31; ++i) {
            itemsOrdered.add(new MenuItem(ItemType.Bevande, "Cola", 3.5));
        }

        takeAwayBill.getOrderPrice(itemsOrdered,user);
    }
    @Test
    public void testForOrderWithPriceMinorThan10euro() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User user = new User("110","Daniele","Spigolon",21);
        for(int i = 0; i < 3; ++i) {
            itemsOrdered.add(new MenuItem(ItemType.Bevande, "LemonSoda", 1.5));
        }

        try {
            assertEquals(5.0, takeAwayBill.getOrderPrice(itemsOrdered,user), 0);
        } catch (TakeAwayBillException e) {
            fail("TakeAwayBillException thrown");
        }
    }

    @Test
    public void testOrderWith0ElementThereforeWithoutElements() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        User user = new User("110","Daniele","Spigolon",21);

        try {
            assertEquals(0.0, takeAwayBill.getOrderPrice(itemsOrdered,user), 0);
        } catch (TakeAwayBillException e) {
            fail("TakeAwayBillException thrown");
        }
    }
    @Test
    public void orderGratisForChildrenUnderageBetween18And19Test() {
        List<InvoiceTotal> ordinazioni = new ArrayList<InvoiceTotal>();
        List<MenuItem> lista = new ArrayList<MenuItem>();
        lista.add(new MenuItem(ItemType.Gelati, "BananaSplit", 3.00));

        User user = null;
        try{
        for (int i = 0; i < 12; i++) {
            user = new User("110","Spigolon", "Daniele", 5+i);
            ordinazioni.add(new InvoiceTotal(lista, user,  66950, takeAwayBill.getOrderPrice(lista, user)));
        }

        List<InvoiceTotal> ordinazioniGratis = takeAwayBill.getGratisInvoce(ordinazioni);
        assertEquals(10, ordinazioniGratis.size());
        for (InvoiceTotal i : ordinazioniGratis) {
            assertEquals(0.0, i.getPrice(),0);
        }
        } catch (TakeAwayBillException e) {
            fail("TakeAwayBillException thrown");
        }
    }
}