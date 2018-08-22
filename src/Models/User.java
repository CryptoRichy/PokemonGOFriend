package Models;

public class User {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainerLVL() {
        return trainerLVL;
    }

    public void setTrainerLVL(int trainerLVL) {
        this.trainerLVL = trainerLVL;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public int getFriendCOde() {
        return friendCOde;
    }

    public void setFriendCOde(int friendCOde) {
        this.friendCOde = friendCOde;
    }

    private int trainerLVL;
    private String team;
    private String location;
    private String User_Name;
    private int friendCOde;

}
