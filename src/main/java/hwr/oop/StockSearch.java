package hwr.oop;

import java.util.Arrays;
import java.util.HashSet;

public class StockSearch {

    private static final String earliestDatePossible = "2022-02-01";
    private static final String[] securitiesAvailableArray = new String[]{"SAP", "IBM", "MBG", "EUNL", "IS3N", "SXRJ"};

    private static final HashSet<String> securitiesAvailable =
            new HashSet<>(Arrays.asList(securitiesAvailableArray));

    private final String security;
    private final String earliestDate;


    StockSearch(String securityAcronym){
        this.security = securityAcronym.toUpperCase();
        this.earliestDate = earliestDatePossible;
    }
    public boolean securityIsAvailable(){
        return securitiesAvailable.contains(security);
    }

    public void weeklyCourseDifference(String date) {
        //ToDo return weekly Data
    }
    public void monthlyCourseDifference(String month) {
        //ToDo return monthly Data

    }
    public void maxCourseDifference() {
    //ToDo return difference between dateToday and earliest date Possible
    }

    //ToDo do costume dates if there is time
}
