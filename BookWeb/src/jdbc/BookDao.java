package jdbc;

import java.util.List;

import book.BS_Book;
import pages.Page;

public class BookDao extends BseaDao<BS_Book> {

	public BS_Book query(String id) { // 查询

		String sql = "select id,title,author,price,sales,stock,img_path from bs_book where id=?";

		BS_Book book_query = this.Query_Bean(sql, id);

		return book_query; //

	}

	public int DelTitle(BS_Book book) {
		String sql = "delete from bs_book where title=? and author=? ";
		int i = this.Update(sql, book.getTitle(), book.getAuthor());
		return i;
	}

	public int add(BS_Book book) { // 添加
		String sql = "insert into bs_book(title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
		int i = this.Update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImg_path());
		return i;

	}

	public int del(String id) {
		String sql = "delete from bs_book where id=?";
		int i = this.Update(sql, id);
		return i;
	}

	public int update(BS_Book book) {
		String sql = " UPDATE bs_book SET title=?,author=?,price=?,sales=?,stock=?,img_path=? WHERE id=?";
		int i = this.Update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImg_path(), book.getId());
		return i;
	}

	public List<BS_Book> getBookLIst() {
		String sql = "select  id,title,author,price,sales,stock,img_path from bs_book";
		List<BS_Book> List = this.QueryList(sql);
		return List;
	}

	public Page<BS_Book> findBook(Page<BS_Book> page) {
		String sql = "select count(*) from bs_book";

		long totalRecord = (long) this.getSingleValue(sql);
		page.setTotalRecord((int) totalRecord);

		sql = "select  id,title,author,price,sales,stock,img_path from bs_book limit ?,?";
		List<BS_Book> queryList = this.QueryList(sql, page.getIndex(), page.getPageSize());

		page.setDate(queryList);
		return page;

	}
	
	
	public void batchUpdat(Object [][] params){
		String sql = " UPDATE bs_book SET sales=?,stock=? WHERE id=?";
		System.out.println("xiugai");
		this.batch(sql, params);
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		BS_Book Book = new BS_Book(3, "三国志", "陈寿", 30.00, 100, 100, "static/price");
//		BookDao bookDao = new BookDao();
//		int add = bookDao.update(Book);
//		System.out.println(add);
		//

		// BookDao bookDao = new BookDao();
		// System.out.println(bookDao.del("33"));

		// BookDao bookDao = new BookDao();
		// BS_Book query2 = bookDao.query("34");
		// System.out.println(query2);
		
		Page<BS_Book> page = new Page<BS_Book>();
		page.setPageNumber(1);
		page.setPageSize(4);
		BookDao bookdao = new BookDao();
		bookdao.findBook(page);
		for (BS_Book book : page.getDate()) {
			System.out.println(book);
		}

	}

}
