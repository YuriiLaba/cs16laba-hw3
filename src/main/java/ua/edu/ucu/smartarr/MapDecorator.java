package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    final private MyFunction fnc;

    public MapDecorator(SmartArray array, MyFunction fnc) {
        super(array);
        this.fnc = fnc;
    }


    public Object[] toArray(){
        Object[] objects = smartArray.toArray();
        for (int i = 0; i<objects.length; i++){
            objects[i] = fnc.apply(objects[i]);
        }
        return objects;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + ", plus map decorator";
    }

    @Override
    public int size() {
        return smartArray.toArray().length;
    }

}
