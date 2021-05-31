package com.ct.leetcode.offer;

import com.sun.xml.internal.org.jvnet.fastinfoset.sax.PrimitiveTypeContentHandler;

import javax.lang.model.type.PrimitiveType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Created by CT on 2021/4/21.
 */
public class VerifyPostorder {


    public static void main(String args[]){

        Data<String> data = new Data<>();
        Data<String> data1 = new Data<String>(){};
        //反射回去
        try {
            Field field = data.getClass().getDeclaredField("data");
            Type type = field.getType();
            System.out.print(type.getTypeName());



        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }





    static class Data<T>{
        private T data;


    }



}
