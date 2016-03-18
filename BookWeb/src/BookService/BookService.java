package BookService;

import java.util.List;

import book.BS_Book;
import jdbc.BookDao;
import pages.Page;

public class BookService {
	private BS_Book book = null;
	private BookDao bookdao = new BookDao();

	public BookService() {
		super();
	}

	public List<BS_Book> getBookList() {
		return bookdao.getBookLIst();
	}

	public boolean add(BS_Book bs_book) {
		boolean bool = false;
		this.book = bs_book;
		if (this.bookdao.add(book) == 1) {
			bool = true;
		}
		return bool;

	}

	public BS_Book query(String id) {
		this.book = this.bookdao.query(id);
		return book;
	}

	public boolean update(BS_Book bs_book) {
		boolean bool = false;
		this.book = new BS_Book();
		if (this.bookdao.update(book) == 1) {
			bool = true;
		}
		return bool;
	}

	public boolean del(String id) {
		boolean bool = false;
		if (this.bookdao.del(id) == 1) {
			bool = true;
		}
		return bool;
	}

	public Page<BS_Book> findBook(String pageNumber, int pageSize) {

		int pn = 1;
		
		try {
			pn = Integer.parseInt(pageNumber);
		} catch (Exception e) {
			
		}
		Page<BS_Book> page = new Page<BS_Book>();
		page.setPageSize(pageSize);
		page.setPageNumber(pn);
		
		return this.bookdao.findBook(page);

	}
}
