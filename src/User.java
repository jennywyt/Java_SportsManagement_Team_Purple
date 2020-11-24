public class User {

    private  int user_ID;
    private String userFirstname;
    private String userLastname;
    private String userEmail;
    private static int counter = 1;

    public User(String userFirstname,String userLastname,String userEmail){
        this.user_ID = counter++;
        this.userFirstname = userFirstname;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    @Override
    public String toString() {
        return "User" +
                "user_ID=" + user_ID +
                ", userFirstname='" + userFirstname + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userEmail='" + userEmail ;
    }
}