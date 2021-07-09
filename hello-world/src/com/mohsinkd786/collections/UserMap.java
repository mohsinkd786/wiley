package com.mohsinkd786.collections;

import java.util.*;
import static java.util.Comparator.*;

import static java.lang.System.out;
public class UserMap {

    public void execute(){
        // Map - HashMap , TreeMap, LinkedHashMap, ConcurrentHashMap
        // Dictionary - HashTable
        // obselete class now
        //Dictionary dictionary = new Hashtable();
        Hashtable<String,String> hashtable = new Hashtable();

        String str = "";
        String str1 = new String("");
        str1.intern();

        // uniqueness for keys
        // no null keys & values
        // no duplication allowed
        hashtable.put("1","on");

        hashtable.put("2","off");
        // not permitted
        //hashtable.put(null,"");
        //hashtable.put("#",null);

        // new object();
        // new object();

        // hashtable working

        // hashCode
        // equals

        //String
        // uses a term referred as hashcode


        String oldVal = hashtable.put("1","pause");

        out.println("old value "+oldVal);

        hashtable.entrySet().forEach(entry -> out.println(entry.getKey() +"---"+entry.getValue()));


        HashMap<UserKey,String> map = new HashMap<>();

//        map.put("1","one");
//        map.put("1","1");
//        map.put("2","two");

        UserKey usr1 = new UserKey("1","User1");
        UserKey usr2 = new UserKey("1","User2");
        UserKey usr3 = new UserKey("2","User2");
        UserKey usr4 = new UserKey("3","User3");

        int hashCode1 = usr1.hashCode();
        int hashCode2 = usr2.hashCode();
        int hashCode3 = usr3.hashCode();
        int hashCode4 = usr4.hashCode();

        map.put(usr1,"Hola");
        map.put(usr2,"Hey");
        map.put(usr3,"Hello");
        map.put(usr4,"Wassup");


        map.entrySet().forEach(e-> out.println(e.getKey() +" -- " +e.getValue()));

        String val = map.get(new UserKey("1","User1"));

        out.println("VAL : "+val);
        out.println("HashCode  : "+hashCode1 +",  "+hashCode2 + ", "+hashCode3 + ", "+hashCode4);
        // allows one null key
        // allows multiple null values
        // is not thread safe


        out.println("TREE MAP :::::: ");
        // TreeMap
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("one","one");
        treeMap.put("Hi","twotwo");
        treeMap.put("Hello","three");
        treeMap.put("Helo","three");
        treeMap.put("Hola","three");

        treeMap.forEach((k,v)-> out.println("Key "+k+" Value : "+v));

        Map<UserKey,String> userKeyMap = new TreeMap<>((u1,u2)-> u2.id.compareTo(u1.id));

        UserKey usr5 = new UserKey("1","User1");
        UserKey usr6 = new UserKey("4","User4");
        UserKey usr7 = new UserKey("2","User2");
        UserKey usr8 = new UserKey("3","User3");

        userKeyMap.put(usr5,"Hola");
        userKeyMap.put(usr6,"Hey");
        userKeyMap.put(usr7,"Hello");
        userKeyMap.put(usr8,"Wassup");


        userKeyMap.forEach((k,v)-> out.println("User TREE MAP : "+k +" "+v));


    }
}

class UserKey{
    String id;
    String name;

    public UserKey(String id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        UserKey userKey = (UserKey)obj;

        return this.id.equals(userKey.id) && this.name.equals(userKey.name);
    }

    @Override
    public String toString() {
        return this.id +" "+this.name;
    }
}

/**
 *
 * List: [
*          User{id:3,name: User3, address: [
 *                                          { city: BLR, zipCode: 560001 },
 *                                          { city: BLR , zipCode: 560002 },
 *                                          { city: DEL, zipCode: 110001}]}
 *         User{id:44,name: User44, address: [
 *  *                                          { city: BLR, zipCode: 560038 },
 *  *                                          { city: DEL , zipCode: 110096 },
 *  *                                          { city: DEL, zipCode: 110001}]}
 *          User{id:2,name: User2, address: [
 *  *  *                                          { city: BOM, zipCode: 400018 },
 *  *  *                                          { city: BOM , zipCode: 400037 },
 *  *  *                                          { city: DEL, zipCode: 110001 }
 *                                                { city: BLR, zipCode: 560001 }]}
 *                                          ]
 *  Build a ranking system for cities based on employees functioning from there, to identify / designate a city as hub office
 *  [
 *      { city:DEL, zipCode:110001 }, [
 *                                         User{id:2, name: User2 }, User{id:3, name: User3 }, User{id:44, name: User44 }
 *                                  ],
 *      { city:BLR, zipCode:560001 }, [
 *  *                                         User{id:2, name: User2 }, User{id:3, name: User3 }
 *  *                                  ],
 *       *                                  ],
 *          { city: BLR, zipCode: 560002 },[
 *  *  *  *                                         User{id:3, name: User3 }
 *  *  *  *                                  ],
 *  *    { city: BOM, zipCode: 400018 },[
 *  *  *  *                                         User{id:2, name: User2 }
 *  *  *  *                                  ],
 *  *
 *  *      { city: BOM, zipCode: 400037 },[
 *  *  *  *  *                                         User{id:2, name: User2 }
 *  *  *  *
 *  *
 *  ]
 *
 *
 *
 * */
