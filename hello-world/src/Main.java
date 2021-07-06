import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

//        Iterator itr = list.iterator();
//
//        while(itr.hasNext()){
//            //int num = (Integer) itr.next();
//            System.out.println(itr.next());
//            //list.add(10);
//            //list.remove(1);
//            list.add(5);
//        }

        for(Object i: list){
            System.out.println(i);
            //list.add(5);
        }

        Map mp = new HashMap();

        Key key = new Key("");
        Key key11 = key;

        if(key == key11){
            System.out.println("are same..");
        }

        mp.put(key,"1");
        mp.put(key11,"2");

        Set<Map.Entry> set = mp.entrySet();

        for(Map.Entry<Object,Object> entry: set ){
            System.out.println("KEY "+entry.getKey());
        }

//        mp.put("one",1);
//        mp.put("two",2);
//        mp.put("one",4);


//        mp.put(key,1);
//        mp.put(key1,2);
//        mp.put(key2,3);

        Key key2 = new Key("One");

        mp.put(key2,1);

        Key key1 = new Key("Two");

        mp.put(key1,2);

        System.out.println(mp.get(key1));

    }
}

class Key{

    private String id;

    public Key(String id){
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}


