package ua.edu.ucu.smartarr;

import java.lang.reflect.Array;
import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] arr;

    public BaseArray(Object[] arr) {
        this.arr = arr;
    }
    public Object[] toArray(){
        return Arrays.copyOf(arr, arr.length);
    }
    public String operationDescription(){
        return "This is BaseArray";
    }
    public int size(){
        return arr.length;
    }

}
