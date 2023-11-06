package com.java.Prog;
import java.util.ArrayList;

public class ListManipulator {

    // Add elements to an ArrayList
    public void manipulate(ArrayList<Integer> list, int element) {
        list.add(element);
    }

    // Add multiple elements to an ArrayList
    public void manipulate(ArrayList<Integer> list, ArrayList<Integer> elements) {
        list.addAll(elements);
    }

    // Remove an element from an ArrayList
    public void manipulate(ArrayList<Integer> list, Integer element) {
        list.remove(element);
    }

    // Search for an element in an ArrayList
    public boolean manipulate(ArrayList<Integer> list, int element, boolean search) {
        return list.contains(element);
    }

    public static void main(String[] args) {
        ListManipulator manipulator = new ListManipulator();
        ArrayList<Integer> list = new ArrayList<>();

        manipulator.manipulate(list, 42);
        ArrayList<Integer> elementsToAdd = new ArrayList<>();
        elementsToAdd.add(1);
        elementsToAdd.add(2);
        elementsToAdd.add(3);
        manipulator.manipulate(list, elementsToAdd);
        manipulator.manipulate(list, 2);
        boolean containsElement = manipulator.manipulate(list, 5, true);

        System.out.println("Modified ArrayList: " + list);
        System.out.println("Contains element 5: " + containsElement);
    }
}
