package com.apexSystems.utils;

import com.apexSystems.pojo.Puppy;
import net.andreinc.mockneat.MockNeat;

import java.util.List;

public class Utils {

    static MockNeat mockNeat = MockNeat.threadLocal();

    //takes into account that the first word is the pet sex
    public static String getSex(String sexBreed) {
        return sexBreed.split(" ")[0];
    }

    //takes into account that after the sex comes the breed, that is, after the
    //first space.
    public static String getBreed(String sexBreed) {
        return sexBreed.substring(
                sexBreed.indexOf(' ') + 1
        );
    }
    //takes into account that the fees are at the end of the string after the '$' sign.
    public static double getAdoptionFees(String text) {
        return Double.parseDouble(
                text.substring(
                        text.indexOf("$") + 1
                )
        );
    }

    public static Puppy findPuppy(List<Puppy> puppyCandidates, String puppyName) {
        for(Puppy p: puppyCandidates)
            if(p.getName().equals(puppyName))
                return p;
        return null;
    }

    public static boolean isPuppyInList(List<Puppy> puppyCart, Puppy p) {
        for(Puppy pup: puppyCart)
            if(pup.equals(p))
                return true;
        return false;
    }

    public static String randomName() {
        return mockNeat.names().get();
    }

    public static String randomAddress() {
        return mockNeat.cities().us().get();
    }

    public static String randomEmail() {
        return mockNeat.emails().get();
    }
}
