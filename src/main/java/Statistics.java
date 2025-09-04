import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    public static List<Fee> getLateFees(List<Fee> fees, Instant t) {
        return fees.stream()
                .filter(f -> f.getStatus(t) == Status.LATE)
                .collect(Collectors.toList());
    }

    public static double getTotalMissingFees(List<Fee> fees, Instant t) {
        return getLateFees(fees, t).stream()
                .mapToDouble(f -> f.getAmount())
                .sum();
    }
}