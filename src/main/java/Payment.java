import java.time.Instant;

public class Payment {

    private int id;
    private double amount;
    private Instant date;
    private PaymentType type;

    public Payment(int id, double amount, Instant date, PaymentType type) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public Instant getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public PaymentType getType() {
        return type;
    }

}
