////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

@SuppressWarnings("serial")
public class TakeAwayBillException extends Exception {

    public TakeAwayBillException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }

}