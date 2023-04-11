package org.epam.views.list;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.epam.model.Book;
import org.epam.model.Genre;
import org.epam.model.Tag;
import org.epam.service.BookService;

import java.util.stream.Collectors;

@PageTitle("Books")
@Route(value = "books")
public class BookView extends VerticalLayout {
    public BookView(BookService bookService){
        add(new H1("Hello, books!"));
        Grid<Book> bookGrid = new Grid<>();
        bookGrid.setItems(bookService.findAll());
        bookGrid.addColumn(Book::getBookId).setHeader("Book Id").setAutoWidth(true);
        bookGrid.addColumn(Book::getAuthor).setHeader("Author").setAutoWidth(true);
        bookGrid.addColumn(Book::getTitle).setHeader("Title").setAutoWidth(true);

        bookGrid.addColumn(book -> book.getGenres().stream()
                .map(Genre::getName)
                .collect(Collectors.joining(", ")))
                .setHeader("Genres").setAutoWidth(true);
        bookGrid.addColumn(book -> book.getTags()
                        .stream()
                                .map(Tag::getTagName)
                                        .collect(Collectors.joining(", ")))
                .setHeader("Tags")
                .setAutoWidth(true);
        add(bookGrid);
    }
}
