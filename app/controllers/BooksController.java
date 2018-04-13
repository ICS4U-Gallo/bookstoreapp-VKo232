package controllers;

import models.Book;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Set;
import views.html.books.*;

public class BooksController extends Controller {


    // for all books
    public Result index() {
        Set<Book> books = Book.allBooks();
        return ok(index.render(books));
    }

    public Result create() {
        return TODO;
    }

    public Result save() {
        return TODO;
    }

    public Result edit(Integer id) {
        return TODO;
    }

    public Result update() {
        return TODO;
    }

    public Result destroy(Integer id) {
        return TODO;
    }

    public Result show(Integer id) {
        return TODO;
    }

}
