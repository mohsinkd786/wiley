package com.mohsinkd786.oops;

public class User {

    static {
        System.out.println("Static Block");
    }
    // instance block
    {
        System.out.println("Instance Block");
    }

    User(){
        System.out.println("Constructor");
    }

    // instance member variable
    public int userId;
    // class member variable
    public static String userName;
    // outer class
    // inner class
    // nested class

    // instance method
    public void process(){
        User.userName ="userOne";
    }

    // static method
    public static User execute(User user){
        // not permitted
        //this.userId = 1;
        user.userId = -1;

        // inner class
        Address address = new User().new Address();
        // private member
        address.addressId = "";

        // static
        EmailMessage emailMessage = new EmailMessage();
        // standard static member
        EmailMessage.id = 1;

        // private members
        emailMessage.emailId = "User";

        return user;
    }

    private int id;

    // inner class
    class Address{
        public String zipCode;
        private String addressId;
        public String getZipCode() {
            userId = 10;
            id = 1;
            userName = "userName Inner ";
            return zipCode;
        }
    }

    // static inner class
    static class EmailMessage{
        public int messageId;
        public static int id;
        private String emailId;

        public int getMessageId(){
            userName = "";
            return messageId;
        }
    }
}


