import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Fee {
    private int id;
    private String label;
    private double amount;
    private Instant deadline;
    private Student student;
    private List<Payment> payments = new ArrayList<>();

    public Fee(int id, String label, double amount, Instant deadline, Student student) {
        this.id = id;
        this.label = label;
        this.amount = amount;
        this.deadline = deadline;
        this.student = student;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public double getTotalPaid() {
        return payments.stream().mapToDouble(Payment::getAmount).sum();
    }

    public Status getStatus(Instant now) {
        double totalPaid = getTotalPaid();
        if (now.isAfter(deadline)) {
            if (totalPaid < amount) return Status.LATE;
            else if (totalPaid > amount) return Status.OVERPAID;
            else return Status.PAID;
        } else {
            if (totalPaid == 0) return Status.NULL;
            else if (totalPaid < amount) return Status.IN_PROGRESS;
            else if (totalPaid == amount) return Status.PAID;
            else return Status.OVERPAID;
        }
    }

    public double getAmount() {
        return amount;
    }
    public Instant getDeadline() {
        return deadline;
    }
    public Student getStudent() {
        return student;
    }
}

enum Status {
    NULL, IN_PROGRESS, PAID, LATE, OVERPAID
}