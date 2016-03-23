package com.example.test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.user.client.ui.Composite;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.RegExValidator;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.sencha.gxt.widget.core.client.grid.editing.GridRowEditing;
import com.sencha.gxt.widget.core.client.grid.filters.GridFilters;
import com.sencha.gxt.widget.core.client.grid.filters.StringFilter;

import java.util.ArrayList;
import java.util.List;


public class BasicGrid extends Composite {

    Grid<EmployeeModel> grid;

    ListStore<EmployeeModel> listStore;

    public Grid<EmployeeModel> getGrid(){
        return grid;
    }

    // Property access definitions for the values in the NameModel
    public interface GridProperties extends PropertyAccess<EmployeeModel> {
        ModelKeyProvider<EmployeeModel> id();

        ValueProvider<EmployeeModel, String> name();

        ValueProvider<EmployeeModel, String> position();

        ValueProvider<EmployeeModel, String> email();
    }

    // Setup the property access definitions for the values for the grid columns
    public static GridProperties gridProperties = GWT.create(GridProperties.class);


    List<EmployeeModel> modelList = new ArrayList<EmployeeModel>();



    public BasicGrid(){
        EmployeeModel myNameModel1 = new EmployeeModel("Sasha", "programmer", "SaschaKhrystenko@gmail.com");
        EmployeeModel myNameModel2 = new EmployeeModel("Anna", "designer", "Something");
        modelList.add(myNameModel1);
        modelList.add(myNameModel2);


        // Setup the ListStore.
        listStore= new ListStore<EmployeeModel>(gridProperties.id());
        listStore.addAll(modelList);

        // Setup the grid columns
        //The column config is a configuration object that should only be used when creating a column model. After the column model is created, any changes should be made to the column model, not the column config.

        ColumnConfig<EmployeeModel, String> nameCol = new ColumnConfig<EmployeeModel, String>(gridProperties.name(), 50, "Name");
        ColumnConfig<EmployeeModel, String> positionCol = new ColumnConfig<EmployeeModel, String>(gridProperties.position(), 30, "Position");
        ColumnConfig<EmployeeModel, String> emailCol = new ColumnConfig<EmployeeModel, String>(gridProperties.email(), 70, "email");
        nameCol.setColumnStyle(SafeStylesUtils.fromTrustedString("background-color: blue; color: yellow;"));


        List<ColumnConfig<EmployeeModel, ?>> columns = new ArrayList<ColumnConfig<EmployeeModel, ?>>();
        columns.add(nameCol);
        columns.add(positionCol);
        columns.add(emailCol);

        //ColumnModel initialization requires a list of ColumnConfigs<M>.
        ColumnModel<EmployeeModel> columnModel = new ColumnModel<EmployeeModel>(columns);

        // Setup the grid view for styling
        GridView<EmployeeModel> gridView = new GridView<EmployeeModel>();
        /*gridView.setAutoExpandColumn(nameCol);
        gridView.setAutoExpandColumn(positionCol);
        gridView.setAutoExpandColumn(salaryCol);
        gridView.setAutoExpandColumn(statusCol);*/

        gridView.setAutoFill(true);


        // Setup the grid
        grid = new Grid<EmployeeModel>(listStore, columnModel, gridView);
        // Setup a size if not depending on the parent container to give it a size.
        grid.setPixelSize(500, 200);
        grid.setBorders(true);

        // Filter
        StringFilter<EmployeeModel> nameFilter = new StringFilter<EmployeeModel>(gridProperties.name());

        GridFilters<EmployeeModel> filters = new GridFilters<EmployeeModel>();
        filters.initPlugin(grid);
        filters.setLocal(true);

        filters.addFilter(nameFilter);


        TextField textField = new TextField();
        // textField.addValidator(new EmptyValidator<String>()); // or textField.setAllowBlank(false);
        //  textField.setAllowBlank(false);
        // textField.addValidator(new MinLengthValidator(3));
        // textField.addValidator(new MaxLengthValidator(10));
        textField.addValidator(new RegExValidator("^[^a-z]+$", "Only uppercase letters allowed"));

        // Row editing configuration
        GridEditing<EmployeeModel> editing = new GridRowEditing<EmployeeModel>(grid);
        //Inline editing configuration
        // GridEditing<NameModel> editing = new GridInlineEditing<NameModel>(grid);
        editing.addEditor(nameCol, textField);

        FramedPanel framedPanel = new FramedPanel();
        framedPanel.setHeadingText("Editing Inline");
        framedPanel.setPixelSize(500, 200);
        framedPanel.add(grid);

        initWidget(grid);

    }

}

