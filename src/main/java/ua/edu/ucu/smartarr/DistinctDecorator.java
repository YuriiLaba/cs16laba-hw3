package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.List;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {


    public DistinctDecorator(SmartArray array) {
        super(array);
    }
    public Object[] toArray(){
        Object[] objects = smartArray.toArray();
        ArrayList<Object> list = new ArrayList<Object>();
        for(int i = 0; i< objects.length; i++){
            list.add(objects[i]);
        }
        for(int q = 0; q< list.size(); q++){
            for(int a = q+1; a< list.size(); a++) {
                if (list.get(a).toString().equals(list.get(q).toString())) {
                    list.remove(q);
                }
            }
        }

        Object[] final_objects = new Object[list.size()];
        for (int q = 0; q < list.size(); q++)
        {
            final_objects[q] = list.get(q);
        }
        return final_objects;
    }
    public String operationDescription(){
        return smartArray.operationDescription() + ", plus distinct decorator";
    }

    @Override
    public int size() {
        return smartArray.toArray().length;
    }

}
