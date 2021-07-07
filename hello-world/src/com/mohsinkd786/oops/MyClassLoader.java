package com.mohsinkd786.oops;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    public MyClassLoader(){

    }
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("My custom class loader "+name);
        byte[] bytes = loadClassFromfile(name);
        return defineClass(name,bytes,0,bytes.length);

    }

    private byte[] loadClassFromfile(String name){
        byte[] bytes;
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try{
            int nextVal=0;
            while ((nextVal = inputStream.read()) !=-1){
                outputStream.write(nextVal);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        bytes = outputStream.toByteArray();
        return bytes;
    }
}
