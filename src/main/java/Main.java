import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student(1, "Tamby", "Nandrianina", LocalDateTime.now().minusDays(30).atZone(ZoneId.systemDefault()).toLocalDate());

        Fee fee1 = new Fee(1, "Scolarité 2025", 318000, Instant.now().plusSeconds(3600), student1);
        Fee fee2 = new Fee(2, "Sortie D'intédrations pour janvier", 20000, Instant.now().minusSeconds(3600), student1);

        fee1.addPayment(new Payment(4, 2000000, Instant.now(), PaymentType.BANK_TRANSFER));
        fee1.addPayment(new Payment(5, 30000, Instant.now(), PaymentType.ONLINE));
        fee2.addPayment(new Payment(6, 500, Instant.now().minusSeconds(1800), PaymentType.CASH));

        List<Fee> allFees = new ArrayList<>();
        allFees.add(fee1);
        allFees.add(fee2);

        Instant now = Instant.now();

        System.out.println("Statut des frais:");
        System.out.println("Frais 1: " + fee1.getStatus(now));
        System.out.println("Frais 2: " + fee2.getStatus(now));

        List<Fee> lateFees = Statistics.getLateFees(allFees, now);
        System.out.println("\nFrais en retard:");
        for (Fee fee : lateFees) {
            System.out.println(fee.getStudent());
        }

        double missingTotal = Statistics.getTotalMissingFees(allFees, now);
        System.out.println("\nMontant total manquant pour les frais en retard: " + missingTotal + " Ar");

    }
}