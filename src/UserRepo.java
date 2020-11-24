import java.util.*;

public class UserRepo {

    ArrayList<User> listOfUsers;

    public UserRepo(){

        listOfUsers=new ArrayList<>();
    }

    ArrayList<User> getAll(){
        return listOfUsers;
    }

    public void saveUser(User u){
        listOfUsers.add(u);
    }

}
