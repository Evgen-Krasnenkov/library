package org.epam.views.list;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.epam.model.User;
import org.epam.service.UserService;

@PageTitle("Flow")
@Route(value = "")
public class FlowView extends VerticalLayout {
    private UserService userService;
    public FlowView(UserService userService){
        add(new H1("Hello, fellow!"));
        this.userService = userService;
        Grid<User> userGrid = new Grid<>(User.class);
        userGrid.setItems(userService.getAllUsers());
        add(userGrid);
    }
}
