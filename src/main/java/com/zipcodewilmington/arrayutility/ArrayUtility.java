package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    private E array[];
    private E[] arrayMerged;


    public ArrayUtility(E[] inputArray) {

        array = inputArray;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {

        int counter = 0;

        for( E element : arrayToMerge) {
            if (element.equals(valueToEvaluate))
                counter++;
        }

        return counter + getNumberOfOccurrences(valueToEvaluate);
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {

        concatenate(array, arrayToMerge);

        Integer finalCounter = 0;
        Integer currentCounter = 0;
        E element = null;

        for(int index1 = 0; index1 < arrayMerged.length; index1++){
            for(int index2 = 1; index2 < arrayMerged.length; index2++) {
                if(arrayMerged[index1].equals(arrayMerged[index2]))
                    currentCounter++;
            }

            if(currentCounter > finalCounter) {
                finalCounter = currentCounter;
                element = arrayMerged[index1];
            }

            currentCounter = 0;
        }

        return element;
    }

    public E[] removeValue(E valueToRemove) {

        int count = array.length - getNumberOfOccurrences(valueToRemove);
        int counter = 0;

        E[] result = (E[])Array.newInstance(valueToRemove.getClass(), count);

        for(E element : array){
            if (!element.equals(valueToRemove)) {
            result[counter] = element;
            counter++;
            }
        }

        return result;
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        Integer counter = 0;

        for(E value : array){
            if(value == valueToEvaluate)
                counter++;
        }
        return  counter;
    }

    public E[] concatenate(E[] first, E[] second) {

        arrayMerged = Arrays.copyOf(first, first.length + second.length);

        System.arraycopy(second, 0, arrayMerged, first.length, second.length);

        return arrayMerged;
    }
}
