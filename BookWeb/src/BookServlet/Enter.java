package BookServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dispose.Found;
import dispose.OperateUser;

/**
 * Servlet implementation class Enter
 */
public class Enter extends BookServlet {
	private static final long serialVersionUID = 1L;

	public Enter() {
		super();

	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		System.out.println(name);
		OperateUser user = new OperateUser(name, password);
		if (user.getUser() != null) {
			session.setAttribute("username", user);
			response.sendRedirect("/BookWeb/pages/user/login_success.jsp");
			System.out.println("登入成功");
		} else {

			response.setContentType("text/html;charset=utf-8");

			// 设置错误显示
			request.setAttribute("tag", "用户名或密码错误");
			request.setAttribute("name", name);

			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);

			// writer.println("<h2>您的密码或者用户名输错了</h2>");

		}

	}

	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("regist");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String repwd = request.getParameter("reqwd");
		System.out.println(name);
		Found found = new Found(name, password, name);

		String sessionCode = (String) request.getSession().getAttribute("code");
		String parameterCode = request.getParameter("code");
		if (sessionCode.equals(parameterCode)) {

			if (found.Found()) {

				response.sendRedirect("/BookWeb/pages/user/regist_success.jsp");
				System.out.println("注册成功");
			} else {
				System.out.println("cuowu");
				request.setAttribute("hintname", "用户名已经存在");
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("hintname", "验证码错误");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}

	}

	protected void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();

		try {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
