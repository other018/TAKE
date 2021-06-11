package view.backing;

public class Student {

    private String firstName;
    private String secondName;
    private Double average;

    Student() {
    }

    Student(String firstName, String secondName, Double average) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.average = average;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Double getAverage() {
        return average;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}
