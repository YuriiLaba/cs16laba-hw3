package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.lang.reflect.Array;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    final private MyComparator comp;

    public SortDecorator(SmartArray array, MyComparator comp) {
        super(array);
        this.comp = comp;
    }

    public Object[] toArray(){
        Object[] objects = smartArray.toArray();
        Arrays.sort(objects, comp);
        return objects;
    }

    @Override
    public String operationDescription() {
        return smartArray.toString();
    }

    @Override
    public int size() {
        return smartArray.toArray().length;
    }

}
