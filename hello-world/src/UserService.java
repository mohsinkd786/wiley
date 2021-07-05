import java.util.*;

public class UserService {

    public void process(){

        // fetch me
        List numbers = Arrays.asList(1,4,2,5,16,7);
        // sort the list
        Collections.sort(numbers);

        for (Object i: numbers) {
            System.out.println(i);
        }
        // traversing via the list of users now
        List users =  Arrays.asList(
                new User(1,"User1"),
                new User(1,"User4"),
                new User(3,"User3"),
                new User(2,"User2"));

        //Collections.sort(users); // need to implement the comparable interface
        // sort using comparator
        Collections.sort(users,new UserSortByName());
        Collections.sort(users,new UserReverseSortByName());

        // convert list to array
        Object[] arrs = users.toArray();

        for (Object u:users) {
            User user = (User)u;
            System.out.println(user.id +" -- "+user.name);
        }
    }
}

class User implements Comparable{
    public int id;
    public String name;

    public User(int id,String name){
        this.id = id;
        this.name = name;
    }

    // 1 , -1 , 0
    @Override
    public int compareTo(Object o) {
        User user = (User)o;

        if(this.id > user.id){
            return 1;
        }else if(this.id < user.id){
            return -1;
        }else{
            return 0;
        }
    }
}

class UserSortByName implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        User user1 = (User)o1;
        User user2 = (User)o2;

        // first sorting
        int comparedTo = user1.compareTo(user2);
        if(comparedTo !=0){
            return comparedTo;
        }
        // second sorting
        String name1 = user1.name;
        String name2 = user2.name;
//
        return name1.compareTo(name2);
        //return user1.id - user2.id;
    }
}
class UserReverseSortByName implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        User user1 = (User)o1;
        User user2 = (User)o2;

        // first sorting
        int comparedTo = user2.compareTo(user1);
        if(comparedTo !=0){
            return comparedTo;
        }
        // second sorting
        String name2 = user2.name;
        String name1 = user1.name;
//
        return name2.compareTo(name1);
        //return user1.id - user2.id;
    }
}
