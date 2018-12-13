package songbird.lists;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IntervallList {

    private static final int NO_TIP_LEFT_TO_SAY = -1;

    private final String[] intervallList = new String[] {
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervalle/int1.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervalle/int2.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervalle/int3.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervalle/int4.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervalle/int5.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervalle/int6.mp3\"/>",
            "<audio src=\"https://s3.amazonaws.com/songbirdrolebucket/Intervalle/int7.mp3\"/>",
    };

    private Random randomGenerator = new Random();
    private static Map<Integer, Boolean> intervallTrainingAvailability;

    /**
     * Constructor of Intervalllist. Sets up the map for the intervallList.
         */
    public IntervallList() {
        intervallTrainingAvailability = new HashMap<>();
        for (int index = 0; index < intervallList.length; ++index) {
            intervallTrainingAvailability.put(index, false);
        }
    }

    /**
     * Returns an random intervallclip from the list with the help of a pseudorandom Number.
     * @return A random intervallclip from the list.
     */
    public String getRandomIntervall() {
        int randomInt = randomGenerator.nextInt(intervallList.length);

        if (intervallTrainingAvailability.get(randomInt)) {
            randomInt = getIndexFromUnsaidIntervall();
        }
        if (randomInt == NO_TIP_LEFT_TO_SAY) {
            resetAllMapValues();
            randomInt = randomGenerator.nextInt(intervallList.length);
        }

        intervallTrainingAvailability.replace(randomInt, true);

        return intervallList[randomInt];
    }



    /**
     * Access an specific field from the list. Index can only be between 0 and 13!
     * @param index The index of the intervalltraining in the list, starting from 0.
     * @return The intervalltraining from index.
     */
     String getListField(int index) {
        if ( index >= 0 && index < intervallList.length) {
            return intervallList[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index can only be between 0 and 13!");
        }
    }

    /**
     * This method sets all values of the Map tipListMap... to false -> items were not said.
     * To use, when all intervalltraining were played.
     */
    private void resetAllMapValues() {
         for (int index = 0; index < intervallList.length; ++index) {
             intervallTrainingAvailability.replace(index, false);
         }
    }

    /**
     * Get an index for the intervallList, that was not used by the AlexaSkill.
     * @return Get the index or a negative Number, if everything was used.
     */
    private int getIndexFromUnsaidIntervall() {
        return intervallTrainingAvailability.entrySet().stream().
                filter(s -> !s.getValue()).
                map(Map.Entry::getKey).
                findAny().orElse(NO_TIP_LEFT_TO_SAY);
    }

    /**
     * Getter Method to get the information, if the list element on the index was said or not.
     * @param index index from the list, to check the fitting value.
     * @return if the intervallclip from this index was used or not.
     */
    public boolean getValueFromMap(int index) {
        if (index >= 0 && index < intervallList.length) {
            return intervallTrainingAvailability.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index can only be between 0 and 13");
        }
    }
}
