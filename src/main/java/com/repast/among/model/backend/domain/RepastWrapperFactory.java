package com.repast.among.model.backend.domain;

import org.springframework.stereotype.Service;


@Service
public class RepastWrapperFactory {
    private static final String MODEL_DIRECTORY= "models/";

    public void start(String modelName){

        String[] args=new String[]{MODEL_DIRECTORY + modelName};
        repast.simphony.runtime.RepastMain.main(args);
    }

}
