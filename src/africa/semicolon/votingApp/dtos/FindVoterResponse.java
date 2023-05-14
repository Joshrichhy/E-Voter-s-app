package dtos;

public class FindVoterResponse {
    private String fullName;
    private String userName;
    private int age;
    private long votersId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
                "fullName='" + fullName +"\n"+ '\'' +
                ", userName =" + userName +"\n"+
                ", age=" + age +"\n"+
                ", votersId=" + votersId +"\n"+
                '}';
    }
}
