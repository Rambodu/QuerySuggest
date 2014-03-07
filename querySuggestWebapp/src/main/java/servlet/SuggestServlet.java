package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rambodu 2014-3-8 12:45:08
 */
public class SuggestServlet extends HttpServlet {

	private static final long serialVersionUID = 6429054973446767234L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		// {"content":"[\"今天天气\",\"今天天气怎么样\",\"今天的天气\",\"今天天气怎样\",\"今天天气如何\",\"今天有什么新闻\",\"今天星期几\",\"今天的天气怎么样\",\"今天几号\",\"今天多少度\"]","errorMsg":{"code":"","desc":"","exception":""},"status":"success","task":"query suggestion"}
		// String json = "{result:}";
		req.setCharacterEncoding("UTF-8");
		// JSONArray array = new JSONArray();
		// array.add(new Suggest("今天天气"));
		// array.add(new Suggest("今天天气怎么样"));
		// array.add(new Suggest("今天有什么新闻"));
		// array.add(new Suggest("今天星期几"));
		// array.add(new Suggest("今天的天气怎么样"));

		String str = "[\"今天天气\",\"今天星期几\"]";

		resp.setContentType("text/plain;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// resp.getWriter().write(array.toString());
		resp.getWriter().write(str);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		doGet(req, resp);
	}

}
