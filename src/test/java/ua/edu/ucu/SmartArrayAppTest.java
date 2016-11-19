package ua.edu.ucu;

import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import static org.junit.Assert.*;

/**
 *
 * @author Andrii_Rodionov
 */
public class SmartArrayAppTest {

    @Test
    public void testFilterPositiveIntegersSortAndMultiplyBy2() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};

        Integer[] res =
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyBy2(integers);
        Integer[] expectedRes = {2, 4, 6};

        assertArrayEquals(expectedRes, res);
    }

    @Test
    public void testFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames =
                SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Sutter Burr"};

        assertArrayEquals(expectedStudentNames, studentNames);
    }

    @Test
    public void testOperationDescription() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        MyPredicate pr = t -> ((Integer) t) > 0;
        MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);
        MyFunction func = t -> 2 * ((Integer) t);

        SmartArray sa = new BaseArray(integers);
        String expectedRes = "This is BaseArray";
        assertEquals(expectedRes, sa.operationDescription());

        sa = new DistinctDecorator(sa);
        expectedRes = "This is BaseArray, plus distinct decorator";
        assertEquals(expectedRes, sa.operationDescription());

        sa = new FilterDecorator(sa, pr);
        expectedRes = "This is BaseArray, plus distinct decorator, plus filter decorator";
        assertEquals(expectedRes, sa.operationDescription());

        sa = new SortDecorator(sa, cmp);
        expectedRes = "This is BaseArray, plus distinct decorator, plus filter decorator, plus sort decorator";
        assertEquals(expectedRes, sa.operationDescription());

        sa = new MapDecorator(sa, func);
        expectedRes = "This is BaseArray, plus distinct decorator, plus filter decorator, plus sort " +
                "decorator, plus map decorator";
        assertEquals(expectedRes, sa.operationDescription());
    }

    @Test
    public void testArraySize(){
        Integer[] integers = {-1, 2, 0, 1, -5, 3};
        MyPredicate pr = t -> ((Integer) t) > 0;
        MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);
        MyFunction func = t -> 2 * ((Integer) t);

        SmartArray sa = new BaseArray(integers);
        int expectedRes = 6;
        assertEquals(expectedRes, sa.size());

        sa = new DistinctDecorator(sa);
        expectedRes = 6;
        assertEquals(expectedRes, sa.size());

        sa = new FilterDecorator(sa, pr);
        expectedRes = 6;
        assertEquals(expectedRes, sa.size());

        sa = new SortDecorator(sa, cmp);
        expectedRes = 3;
        assertEquals(expectedRes, sa.size());

        sa = new MapDecorator(sa, func);
        expectedRes = 3;
        assertEquals(expectedRes, sa.size());
    }
    @Test
    public void testStudentSize(){
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};
        MyPredicate pr = t -> (((Student)t).getYear() == 2 && ((Student)t).getGPA() >= 4);
        MyComparator cmp = (o1, o2) -> (((Student) o1).getSurname().compareTo(((Student) o2).getSurname()));
        MyFunction func = t -> ((Student) t).getSurname() + " " + ((Student) t).getName();


        SmartArray sa = new BaseArray(students);
        int expectedRes = 8;
        assertEquals(expectedRes, sa.size());

        sa = new DistinctDecorator(sa);
        expectedRes = 8;
        assertEquals(expectedRes, sa.size());

        sa = new FilterDecorator(sa, pr);
        expectedRes = 6;
        assertEquals(expectedRes, sa.size());

        sa = new SortDecorator(sa, cmp);
        expectedRes = 3;
        assertEquals(expectedRes, sa.size());

        sa = new MapDecorator(sa, func);
        expectedRes = 3;
        assertEquals(expectedRes, sa.size());
    }

}