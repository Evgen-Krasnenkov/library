package org.epam.views.list;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.epam.model.User;
import org.epam.service.UserService;

import java.awt.*;
import java.util.Arrays;

@PageTitle("Users")
@Route(value = "users")
public class FlowView extends VerticalLayout {
    private UserService userService;
    public FlowView(UserService userService){
        add(new H1("Hello, users!"));
        this.userService = userService;
        Grid<User> userGrid = new Grid<>(User.class);
//        var form = new Form();
        userGrid.setItems(userService.getAllUsers());
//        userGrid.asSingleSelect().addValueChangeListener(e -> {
//            form.setUser(e.getValue());
//        });
//        add(userGrid, form);
        add(userGrid);
    }
//    class Form extends FormLayout{
//       TextField name = new TextField("Name");
//       TextField email = new TextField("Email");
//       TextField phone = new TextField("+1 647-9169");
//       TextField address = new TextField("Your street name and number");
//       TextField city = new TextField("Your city");
////       Binder<User> userBinder = new BeanValidationBinder<>(User.class);
////       private User user;
//
//       Form(){
//           var saveButton = new Button("Save");
////           userBinder.bindInstanceFields(this);
////           Component[] components = new Component[]{name, email, phone, address, city, saveButton};
////           add(Arrays.toString(components));
//       }
//       void setUser(User user){
////           this.user = user;
////           userBinder.readBean(user);
//       }
//
//    }
}
