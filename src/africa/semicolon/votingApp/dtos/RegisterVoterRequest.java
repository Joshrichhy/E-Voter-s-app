package dtos;

public class RegisterVoterRequest {
    private String firstName;
    private String lastName;
    private String userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "RegisterVoterRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", votersId=" + votersId +
                '}';
    }
}
