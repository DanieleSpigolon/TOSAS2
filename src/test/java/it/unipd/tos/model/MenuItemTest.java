////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class MenuItemTest {

    private static MenuItem menuItem;

    @BeforeClass
    public static void beforeClass() {
        menuItem = new MenuItem(ItemType.Gelati, "BananaSplit", 4.00);
    }

    @Test
    public void testGetItemType() {
        assertEquals(ItemType.Gelati, menuItem.getItemType());
    }

    @Test
    public void testGetName() {
        assertEquals("BananaSplit", menuItem.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(4.00, menuItem.getPrice(), 0);
    }

}
