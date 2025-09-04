import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfSchool;
    private List<GroupHistoryEntry> groupHistory = new ArrayList<>();

    public Student(int id, String name, String surname, LocalDate enrollmentDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfSchool = enrollmentDate;
    }

    public void changeGroup(Group newGroup) {
        groupHistory.add(new GroupHistoryEntry(newGroup, Instant.now()));
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfSchool() {
        return dateOfSchool;
    }

    public void setDateOfSchool(LocalDate dateOfSchool) {
        this.dateOfSchool = dateOfSchool;
    }

    public List<GroupHistoryEntry> getGroupHistory() {
        return groupHistory;
    }

    public void setGroupHistory(List<GroupHistoryEntry> groupHistory) {
        this.groupHistory = groupHistory;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

class GroupHistoryEntry {
    private Group group;
    private Instant changeDate;

    public GroupHistoryEntry(Group group, Instant changeDate) {
        this.group = group;
        this.changeDate = changeDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Instant getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Instant changeDate) {
        this.changeDate = changeDate;
    }

}

