package com.repast.among.model.backend.services;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Service
public class AmongModelService {

//    @Value("${aggregate_data_output}")
//    private String aggregateDataOutput;
//
//    @Value("${cgt_shock_magnitude}")
//    private String cgtShockMagnitude;
//
//    @Value("${capital_gains_tax_discount}")
//    private String capitalGainsTaxDiscount;
//
//    @Value("${default_random_seed}")
//    private String defaultRandomSeed;
//
//    @Value("${demand_shock}")
//    private String demandShock;
//
//    @Value("${demand_shock_magnitude}")
//    private String demandShockMagnitude;
//
//    @Value("${file_output_enabled}")
//    private String fileOutputEnabled;
//
//    @Value("${households}")
//    private String households;
//
//    @Value("${income_shock}")
//    private String incomeShock;
//
//    @Value("${income_shock_magnitude}")
//    private String incomeShockMagnitude;
//
//    @Value("${ng_shock_magnitude}")
//    private String ngShockMagnitude;
//
//    @Value("${negative_gearing}")
//    private String negativeGearing;
//
//    @Value("${policy_shock}")
//    private String policyShock;
//
//    @Value("${run}")
//    private String run;
//
//    @Value("${supply_shock}")
//    private String supplyShock;
//
//    @Value("${supply_shock_magnitude}")
//    private String supplyShockMagnitude;


    private final Map<String,Object> paramSourceMap = new HashMap<>();
    public Map<String, Object> generateInitalParamMap() {


//        paramSourceMap.put("aggregateDataOutput", aggregateDataOutput);
//        paramSourceMap.put("cgtShockMagnitude", cgtShockMagnitude);
//        paramSourceMap.put("capitalGainsTaxDiscount", capitalGainsTaxDiscount);
////        map1.put("Parameter1",paramSourceMap);
//
//        paramSourceMap.put("defaultRandomSeed", defaultRandomSeed);
//        paramSourceMap.put("demandShock", demandShock);
//        paramSourceMap.put("demandShockMagnitude", demandShockMagnitude);
//        paramSourceMap.put("csv", fileOutputEnabled);
//        paramSourceMap.put("households", households);
//        paramSourceMap.put("incomeShock", incomeShock);
//        paramSourceMap.put("incomeShockMagnitude", incomeShockMagnitude);
//        paramSourceMap.put("ngShockMagnitude", ngShockMagnitude);
//        paramSourceMap.put("negativeGearing", negativeGearing);
//        paramSourceMap.put("policyShock", policyShock);
//        paramSourceMap.put("run", run);
//        paramSourceMap.put("supplyShock", supplyShock);
//        paramSourceMap.put("supplyShockMagnitude", supplyShockMagnitude);

        return paramSourceMap;
    }

    public void setParamValue(Map<String,Map<String,String>> receivedParams ) {

        Iterator it = receivedParams.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            paramSourceMap.put(pair.getKey().toString(),pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

    }
}
