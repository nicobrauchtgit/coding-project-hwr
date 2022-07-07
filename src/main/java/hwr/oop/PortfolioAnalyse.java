package hwr.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class PortfolioAnalyse {

    private Portfolio portfolio;
    private HashMap<String, Double> positionValue;

    private double portfolioValue;
    PortfolioAnalyse(Portfolio portfolio) {
        this.portfolio = portfolio;
        this.positionValue = portfolio.getPositionValues();
        this.portfolioValue = portfolio.value();

    }

    public String SecurityTypeAllocation() throws IOException, ParseException {
        HashMap<String, Double> securityTypeAllocation = new HashMap<>();
        for(String key: positionValue.keySet()) {
            if(!securityTypeAllocation.containsKey(ShareMetaData.getSecurityType(key))){
                securityTypeAllocation.put(ShareMetaData.getSecurityType(key), positionValue.get(key));
            }else{
                securityTypeAllocation.computeIfPresent(ShareMetaData.getSecurityType(key),
                        (securityType, overallValue) -> overallValue += positionValue.get(key));
            }
        }
        return securityTypeAllocation.toString();
    }

}
