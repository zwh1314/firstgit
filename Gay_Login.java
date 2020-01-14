package gay_Zhang;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gay
 */
@WebServlet("/Gay_Login")
public class Gay_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String target1 = "/findpage(1).jsp";//查询界面  
	private String target2 = "/Onload.jsp";//上传界面 
	private String target3 = "/Login.jsp";//登录界面  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gay_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("a_value", "张文瀚");//前端链接的文字
		// TODO Auto-generated method stub
		//用户||管理员
		String type=request.getParameter("type");//得到用户类型
		String username = request.getParameter("username");
		//读取表单中的口令
		String password = request.getParameter("password");
		//匹配用户名和密码
		boolean user_exist=false;
		if(type.equals("管理员")&&user_exist) {//user_exist=军哥的查询管理表函数，返回值为boolean
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher =context.getRequestDispatcher(target2);
			dispatcher.forward(request, response);
		}
		else if(type.equals("用户")&&user_exist){//user_exist=军哥的查询用户表函数，返回值为boolean
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher =context.getRequestDispatcher(target1);
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "此用户名不存在或密码错误，请确认后再输入！");//前端显示提示框
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher =context.getRequestDispatcher(target3);
			dispatcher.forward(request, response);
		}
		return;
	}

}
