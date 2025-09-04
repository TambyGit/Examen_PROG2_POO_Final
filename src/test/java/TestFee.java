import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class TestFee {

    @Test
    public void testFeeStatus_PAID() {
        Student student = new Student(1, "Tamby", "Nandrianina", LocalDateTime.now().atZone(ZoneId.systemDefault()).toLocalDate());
        Fee fee = new Fee(1, "Scolarité", 100000, Instant.now().plusSeconds(3600), student);
        fee.addPayment(new Payment(1, 1000, Instant.now(), PaymentType.BANK_TRANSFER));
        assertEquals(Status.PAID, fee.getStatus(Instant.now()));
    }

    @Test
    void getStatus_Late() {
        Fee fee = new Fee(1, "Vacances HEI a Dubai", 230000, Instant.now().minusSeconds(100), new Student(1, "A", "B", null));
        fee.addPayment(new Payment(1, 230000, Instant.now(), PaymentType.CASH));
        assertEquals(Status.LATE, fee.getStatus(Instant.now()));
    }

}