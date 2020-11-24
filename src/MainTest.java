import java.util.HashMap;

public class MainTest {
    public static void main(String[] args) {

        User user1 = new User("maxi", "malo", "malo@mgx.com");
        User user2 = new User("Doe", "Harey", "Deo@gmail.com");
        User user3 = new User("smith", "longa", "Smith@yahoo.com");
        User user4 = new User("Mise", "sasa", "Mise@gmail.com");
        User user5 = new User("Anna", "Bitize", "Anna@gmail.com");
        User user6 = new User("pual", "Zizo", "Pual@gmail.com");
        User user7 = new User("Keven", "Sami", "Keven@gmx.com");
        User user8 = new User("Leon", "Nizari", "Leon@gmail.com");
        User user9 = new User("jack", "Maxi", "Jack@outlook.com");
        User user10 = new User("Tobi", "Lizer", "Tobi@hotmail.com");


        HashMap<Integer, User> allUsers = new HashMap<>();
        allUsers.put(user1.getUser_ID(), user1);
        allUsers.put(user2.getUser_ID(), user2);
        allUsers.put(user3.getUser_ID(), user3);
        allUsers.put(user4.getUser_ID(), user4);
        allUsers.put(user5.getUser_ID(), user5);
        allUsers.put(user6.getUser_ID(), user6);
        allUsers.put(user7.getUser_ID(), user7);
        allUsers.put(user8.getUser_ID(), user8);
        allUsers.put(user9.getUser_ID(), user9);
        allUsers.put(user10.getUser_ID(), user10);


        System.out.println("Printing all users");
        for (HashMap.Entry m : allUsers.entrySet()) {
            User users = (User) m.getValue();
            System.out.println("User_ID " + m.getKey() + " " + users.getUserFirstname() + " " + users.getUserLastname() + "  " + users.getUserEmail());
        }

    }
}

