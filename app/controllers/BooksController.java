package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.books.*;

import javax.inject.Inject;
import java.util.Set;

public class BooksController extends Controller {


    @Inject
    FormFactory formFactory;

    // for all books
    public Result index() {
        Set<Book> books = Book.allBooks();
        return ok(index.render(books));
    }

    public Result create() {
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(create.render(bookForm));
    }

    public Result save() {
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        Book.add(book);
        return redirect(routes.BooksController.index());
    }

    public Result edit(Integer id) {

        Book book = Book.findById(id);
        if(book == null) {
            return notFound("Book Not Found");
        }
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);


        return ok(edit.render(bookForm));
    }

    public Result update() {

        Book book = formFactory.form(Book.class).bindFromRequest().get();
        Book oldBook = Book.findById(book.id);
        if(oldBook == null) {
            return notFound("Book not found");
        }
        oldBook.title = book.title;
        oldBook.author = book.author;
        oldBook.price = book.price;

        return redirect(routes.BooksController.index());
    }

    public Result destroy(Integer id) {
        Book book = Book.findById(id);
        if(book == null) {
            return notFound("Book not found");
        }

        Book.remove(book);

        return redirect(routes.BooksController.index());
    }

    public Result show(Integer id) {
        Book book = Book.findById(id);
        if(book == null) {
            return notFound("Book not found");
        }


        return ok(show.render(book));
    }

}
