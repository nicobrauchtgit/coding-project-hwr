package hwr.oop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RealPortfolio {

    private HashMap<String, SecurityPosition> portfolio;

    private static final String[] securitiesAvailableArray = new String[]{"SAP"};

    private static final HashSet<String> securitiesAvailable =
            new HashSet<>(Arrays.asList(securitiesAvailableArray));

    RealPortfolio(){ //maybe add name of owner or sth
        this.portfolio = new HashMap<>();
    }

    public void buyShares(String companyAcronym, String purchaseDate, int numberOfShares){
        if(!securitiesAvailable.contains(companyAcronym))
            throw new RuntimeException("Security paper not available!");
        if(numberOfShares < 1)
            throw new RuntimeException("Invalid number of shares");

        if(!portfolio.containsKey(companyAcronym)){
            portfolio.put(companyAcronym,new SecurityPosition(companyAcronym));
        }
        portfolio.get(companyAcronym).addShare(purchaseDate, numberOfShares);
    }

    public void sellShares(String companyAcronym, int numberOfShares){
        if(!portfolio.containsKey(companyAcronym))
            throw new RuntimeException("You don't own that security paper!");
        if(numberOfShares > portfolio.get(companyAcronym).getPositionSize())
            throw new RuntimeException("You don't own this many shares");

        portfolio.get(companyAcronym).removeShare(numberOfShares);

        if(portfolio.get(companyAcronym).isEmpty()){
            portfolio.remove(companyAcronym);
        }
    }

    double value(){
        double totalValue = 0;
        for(SecurityPosition position : portfolio.values()){
            totalValue+= position.getPositionSize() * position.getCurrentPricePerShare();
        }
        return totalValue;
    }
}