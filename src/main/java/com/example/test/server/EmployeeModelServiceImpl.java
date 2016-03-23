package com.example.test.server;

import com.example.test.client.EmployeeModel;
import com.example.test.client.EmployeeModelService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Created by ua001022 on 18.03.2016.
 */
public class EmployeeModelServiceImpl  extends RemoteServiceServlet implements EmployeeModelService {


    @Override
    public EmployeeModel getModel (String name, String position, String email) {

        String modelName = name;
        String modelPosition = position;
        String modelEmail= email;
        EmployeeModel myEmp = new EmployeeModel();
        myEmp.setName(modelName);
        myEmp.setPosition(modelPosition);
        myEmp.setEmail(modelEmail);

        return myEmp;
    }
}
