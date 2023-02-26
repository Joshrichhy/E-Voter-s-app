package data.models;

public class Voter {
    private String firstName;
    private String lastName;
    private int age;
    private long votersId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getVotersId() {
        return votersId;
    }

    public void setVotersId(long votersId) {
        this.votersId = votersId;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "firstName='" + firstName +"\n"+ '\'' +
                ", lastName='" + lastName +"\n" + '\'' +
                ", age=" + age +"\n"+
                ", votersId=" + votersId +"\n"+
                '}';
    }
}
