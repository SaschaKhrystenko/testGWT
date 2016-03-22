package com.example.test.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("EmployeeModel")
public interface EmployeeModelService extends RemoteService {

    EmployeeModel getModel(String name, String position, String email);
}
