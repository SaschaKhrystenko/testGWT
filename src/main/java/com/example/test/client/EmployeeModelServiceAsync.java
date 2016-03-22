package com.example.test.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

public interface EmployeeModelServiceAsync {


    void getModel(String name, String position, String email, AsyncCallback<EmployeeModel> async);
}
