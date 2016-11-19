package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    final private MyPredicate prd;



    public FilterDecorator(SmartArray array, MyPredicate prd) {
        super(array);
        this.prd = prd;
    }
    public Object[] toArray(){
        Object[] objects = smartArray.toArray();
        int count = 0;
        for(int i = 0; i < objects.length; i++)
        {
            if (!prd.test(objects[i]))
            {
                objects[i] = -1;
                count ++;
            }
        }
        Object[] final_objects = new Object[objects.length - count];
        count = 0;
        for (int p = 0; p < objects.length; p++)
        {
            if(!objects[p].equals(-1))
            {
                final_objects[count] = objects[p];
                count++;
            }
        }
        return final_objects;
    }
    public String operationDescription()
    {
        return smartArray.operationDescription() + ", plus filter decorator";
    }

    @Override
    public int size()
    {
        return smartArray.toArray().length;
    }
}
