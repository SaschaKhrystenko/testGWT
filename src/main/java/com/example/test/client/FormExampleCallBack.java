package com.example.test.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class FormExampleCallBack implements AsyncCallback<EmployeeModel> {

        @Override
        public void onFailure(Throwable caught) {
                Window.alert("Unable to obtain server response: "
                        + caught.getMessage());
        }

        @Override
        public void onSuccess(EmployeeModel result) {
                //Redirect
               //Window.Location.assign("http://127.0.0.1:8888/GridPage.html");
                Window.alert(result.getName() + " " + result.getPosition() + " " + result.getEmail());

                BasicGrid myGrid = new BasicGrid();
                myGrid.modelList.add(result);


        }
}
