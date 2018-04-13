package controllers;

import models.Book;
import play.mvc.Controller;
import play.mvc.Result;

public class BooksController extends Controller {


    // for all books
    public Result index() {
        Set<Book> books = Book.allBooks();
        return ;
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
