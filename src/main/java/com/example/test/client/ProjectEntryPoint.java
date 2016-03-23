package com.example.test.client;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SimpleHtmlSanitizer;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.sencha.gxt.core.client.GXT;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProjectEntryPoint implements EntryPoint {

    /*private MessageServiceAsync messageService = GWT.create(MessageService.class);

    private class MessageCallBack implements AsyncCallback<Message> {
        @Override
        public void onFailure(Throwable caught) {
         *//* server side error occured *//*
            Window.alert("Unable to obtain server response: "
                    + caught.getMessage());
        }
        @Override
        public void onSuccess(Message result) {
          *//* server returned result, show user the message *//*
            Window.alert(result.getMessage());
        }
    }
    @Override
    public void onModuleLoad() {

        final TextBox txtName = new TextBox();
        txtName.setWidth("200");
        txtName.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
               *//* make remote call to server to get the message *//*
                    messageService.getMessage(txtName.getValue(),
                            new MessageCallBack());
                }
            }
        });
        Label lblName = new Label("Enter your name: ");

        Button buttonMessage = new Button("Click Me!");

        buttonMessage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
         *//* make remote call to server to get the message *//*
                messageService.getMessage(txtName.getValue(),
                        new MessageCallBack());
            }
        });

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(lblName);
        hPanel.add(txtName);
        hPanel.setCellWidth(lblName, "130");

        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setSpacing(10);
        vPanel.add(hPanel);
        vPanel.add(buttonMessage);
        vPanel.setCellHorizontalAlignment(buttonMessage,
                HasHorizontalAlignment.ALIGN_RIGHT);

        DecoratorPanel panel = new DecoratorPanel();
        panel.add(vPanel);


        TextField textField = new TextField();
        FieldLabel fieldLabel = new FieldLabel(textField, "TextField");






        // Add widgets to the root panel.
        RootPanel.get("gwtContainer").add(panel);*/



    @Override
    public void onModuleLoad() {
        FormExample myForm = new FormExample();

        RootPanel.get().add(myForm.asWidget());
        //RootPanel.get().add(BasicGrid.getInstance());


    }
}

   /* // simple table  based on GWT only
  // A simple data type that represents a contact.

    private static class Contact {
        private final String address;
        private final Date birthday;
        private final String name;

        public Contact(String name, Date birthday, String address) {
            this.name = name;
            this.birthday = birthday;
            this.address = address;
        }
    }


     // The list of data to display.

    private static final List<Contact> CONTACTS = Arrays.asList(
            new Contact("John", new Date(80, 4, 12), "123 Fourth Avenue"),
            new Contact("Joe", new Date(85, 2, 22), "22 Lance Ln"),
            new Contact("George",new Date(46, 6, 6),"1600 Pennsylvania Avenue"));

    public void onModuleLoad() {
        // Create a CellTable.
        CellTable<Contact> table = new CellTable<Contact>();
        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        // Add a text column to show the name.
        TextColumn<Contact> nameColumn =
                new TextColumn<Contact>() {
                    @Override
                    public String getValue(Contact object) {
                        return object.name;
                    }
                };
        table.addColumn(nameColumn, "Name");

        // Add a date column to show the birthday.
        DateCell dateCell = new DateCell();
        Column<Contact, Date> dateColumn
                = new Column<Contact, Date>(dateCell) {
            @Override
            public Date getValue(Contact object) {
                return object.birthday;
            }
        };
        table.addColumn(dateColumn, "Birthday");

        // Add a text column to show the address.
        TextColumn<Contact> addressColumn
                = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact object) {
                return object.address;
            }
        };
        table.addColumn(addressColumn, "Address");

        // Add a selection model to handle user selection.
        final SingleSelectionModel<Contact> selectionModel
                = new SingleSelectionModel<Contact>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(
                new SelectionChangeEvent.Handler() {
                    public void onSelectionChange(SelectionChangeEvent event) {
                        Contact selected = selectionModel.getSelectedObject();
                        if (selected != null) {
                            Window.alert("You selected: " + selected.name);
                        }
                    }
                });

        // Set the total row count. This isn't strictly necessary,
        // but it affects paging calculations, so its good habit to
        // keep the row count up to date.
        table.setRowCount(CONTACTS.size(), true);

        // Push the data into the widget.
        table.setRowData(0, CONTACTS);

        VerticalPanel panel = new VerticalPanel();
        panel.setBorderWidth(1);
        panel.setWidth("400");
        panel.add(table);

        // Add the widgets to the root panel.
        RootPanel.get().add(panel);
    }*/


                 /*То что я делаю по книге GWT in action*/

  /*  static final int DECK_HOME = 0;
    HTMLPanel homePanel;
    HTMLPanel productsPanel;
    HTMLPanel contactPanel;
    TabLayoutPanel content;*/


   /* @Override
   public void onModuleLoad() {

      setUpGui();
  }

        *//*String LOGO_IMAGE_NAME= "image.jpg";
        Image logo = new Image(GWT.getModuleBaseURL()+ LOGO_IMAGE_NAME);
        final Label label = new Label("thia is my project URL = "+GWT.getModuleBaseURL());
        RootPanel.get().add(label);*//*
        private void setUpGui() {
        buildTabContent();


        }
            private void buildTabContent(){
                homePanel = new HTMLPanel(getContent("home"));
                productsPanel = new HTMLPanel(getContent("product"));
                contactPanel = new HTMLPanel(getContent("contact"));
                content = new TabLayoutPanel(20, Style.Unit.PX);
                content.add(homePanel, "home");
                content.add(productsPanel, "products");
                content.add(contactPanel, "contacts");
                content.selectTab(DECK_HOME);
            }




    private String getContent(String id) {
        String toReturn = "";
        Element element = DOM.getElementById(id);
        if (element != null) {
            toReturn = DOM.getInnerHTML(element);
            DOM.setInnerText(element, "");
            SafeHtml sfHtml = SimpleHtmlSanitizer.sanitizeHtml(toReturn);
            return toReturn = sfHtml.asString();
        } else {
            return toReturn = "Unable to find " + id + " content in HTML page";
        }
    }*/




 /* @Override
  public void onModuleLoad() {
    String version = GXT.getVersion().getRelease();
    TextButton textButton = new TextButton("Verify GXT Works: Version=" + version);
    RootPanel.get().add(textButton);
    textButton.addSelectHandler(new SelectHandler() {
      @Override
      public void onSelect(SelectEvent event) {
        AlertMessageBox d = new AlertMessageBox("Нажата кнопка", "Вы нажали кнопку");
        d.setIcon(MessageBox.ICONS.info());
        d.show();
        MessageBox messageBox = new MessageBox("GXT Works.");
        messageBox.show();


      }
    });
  }*/



    // simple first example

 /* public void onModuleLoad() {
    final Label label = new Label("Hello, GWT!!!");
    final Button button = new Button("Click me!");

   button.addClickHandler(new ClickHandler() {
     @Override
     public void onClick(ClickEvent clickEvent) {
        label.setVisible(!label.isVisible());
     }
   });

    button.addClickListener(new ClickListener(){
      public void onClick(Widget w) {
        label.setVisible(!label.isVisible());
      }
    });

    RootPanel.get().add(button);
    RootPanel.get().add(label);

  }*/



  

