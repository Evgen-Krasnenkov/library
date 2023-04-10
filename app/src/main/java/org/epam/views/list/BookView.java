package org.epam.views.list;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.epam.model.Book;
import org.epam.service.BookService;

@PageTitle("Books")
@Route(value = "books")
public class BookView extends VerticalLayout {
    private BookService bookService;
        public BookView(BookService bookService){
            add(new H1("Hello, books!"));
            this.bookService = bookService;
            Grid<Book> bookGrid = new Grid<>(Book.class);
            bookGrid.setItems(bookService.findAll());
            add(bookGrid);
        }
}
