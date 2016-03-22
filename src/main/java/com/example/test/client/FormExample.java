package com.example.test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.EnableEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormExample implements IsWidget {

    private EmployeeModelServiceAsync employeeModelServiceAsync = GWT.create(EmployeeModelService.class);

    private VerticalPanel vp;

    @Override
    public Widget asWidget() {
        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(10);
            createForm();
        }
        return vp;
    }

    private void createForm() {
        FramedPanel form = new FramedPanel();
        form.setHeadingText("Simple Form with FieldSets");
        form.setWidth(350);

        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeadingText("Employee Information");
        fieldSet.setCollapsible(true);
        form.add(fieldSet, new MarginData(10));

        VerticalLayoutContainer p = new VerticalLayoutContainer();
        fieldSet.add(p);

        final TextField name = new TextField();
        name.setAllowBlank(false);
        p.add(new FieldLabel(name, "Name"), new VerticalLayoutData(1, -1));

        final TextField position = new TextField();
        position.setAllowBlank(false);
        p.add(new FieldLabel(position, "Position"), new VerticalLayoutData(1, -1));

        final TextField email = new TextField();
        email.setAllowBlank(false);
        p.add(new FieldLabel(email, "Email"), new VerticalLayoutData(1, -1));



        final BasicGrid myGrid = new BasicGrid();
        myGrid.setVisible(false);
        vp.add(myGrid);



        form.addButton((Widget) new TextButton("Save", new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                employeeModelServiceAsync.getModel(name.getValue(), position.getValue(), email.getValue(), new FormExampleCallBack());
                myGrid.setVisible(true);

            }
        }));

        form.addButton(new TextButton("Cancel"));

        vp.add(form);
    }


}
