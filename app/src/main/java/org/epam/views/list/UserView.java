package org.epam.views.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.epam.model.Book;
import org.epam.model.User;
import org.epam.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@PageTitle("Users")
@Route(value = "users")
public class UserView extends VerticalLayout {
    private UserService userService;
    private Grid<User> userGrid = new Grid<>();
    public UserView(UserService userService){

        add(new H1("Hello, users!"));
        this.userService = userService;
        var form = new Form();
        userGrid.addColumn(User::getUserId).setHeader("ID");
        userGrid.addColumn(User::getName).setHeader("Name");
        userGrid.addColumn(user -> user.getContributedBooks()
                        .stream()
                        .map(Book::getTitle)
                        .collect(Collectors.joining(", ")))
                .setHeader("Contributed books");
        userGrid.addColumn(User::getPhone).setHeader("Phone");
        userGrid.addColumn(User::getEmail).setHeader("Email");
        userGrid.addColumn(User::getAddress).setHeader("Address");
        userGrid.addColumn(User::getCity).setHeader("City");
        userGrid.asSingleSelect().addValueChangeListener(e -> {
            form.setUser(e.getValue());
        });
        add(userGrid, form);
        update();
    }

    private void update() {
        userGrid.setItems(userService.findAll());
    }

    class Form extends FormLayout {
       TextField name = new TextField("Name");
       EmailField email = new EmailField("Email");
       TextField phone = new TextField("Phone");
       TextField address = new TextField("Your street name and number");
       TextField city = new TextField("Your city");
       Binder<User> userBinder = new BeanValidationBinder<>(User.class);
       private User user;

       Form(){
           var saveButton = new Button("Save");
           userBinder.bindInstanceFields(this);
           add(name, email, phone, address, city, saveButton);
           saveButton.addClickListener(click -> {
               try {
                   userBinder.writeBean(user);
                   userService.save(user);
                   update();
               } catch (ValidationException e) {
                   throw new RuntimeException("Can't write user's date", e);
               }
           });
       }
       void setUser(User user){
           this.user = user;
           userBinder.readBean(user);
       }
    }
}
