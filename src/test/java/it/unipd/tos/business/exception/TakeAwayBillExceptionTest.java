////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TakeAwayBillExceptionTest {

    private static TakeAwayBillException takeAwayBillException;

    @BeforeClass
    public static void beforeClass() {
        takeAwayBillException = new TakeAwayBillException("ProvaException");
    }

    @Test
    public void testGetMessage() {
        assertEquals("ProvaException", takeAwayBillException.getMessage());
    }

}