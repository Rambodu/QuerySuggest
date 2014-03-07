package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * @author rambodu 2014-3-8 上午12:45:08
 */
public class SuggestServlet extends HttpServlet {

	private static final long serialVersionUID = 6429054973446767234L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		// {"content":"[\"今天天气\",\"今天天气怎么样\",\"今天的天气\",\"今天天气怎样\",\"今天天气如何\",\"今天有什么新闻\",\"今天星期几\",\"今天的天气怎么样\",\"今天几号\",\"今天多少度\"]","errorMsg":{"code":"","desc":"","exception":""},"status":"success","task":"query suggestion"}
		// String json = "{result:}";
		JSONArray array = new JSONArray();
		array.add(new Suggest("今天天气"));
		array.add(new Suggest("今天的天气"));
		array.add(new Suggest("今天天气怎样"));
		array.add(new Suggest("今天有什么新闻"));
		array.add(new Suggest("今天星期几"));
		array.add(new Suggest("今天的天气怎么样"));
		array.add(new Suggest("今天几号"));
		array.add(new Suggest("今天多少度"));
		resp.getWriter().write(array.toString());
	}

	// public static void main(String[] args) {
	// JSONArray array = new JSONArray();
	// array.add(new Suggest("今天天气"));
	// array.add(new Suggest("今天的天气"));
	// array.add(new Suggest("今天天气怎样"));
	// array.add(new Suggest("今天有什么新闻"));
	// array.add(new Suggest("今天星期几"));
	// array.add(new Suggest("今天的天气怎么样"));
	// array.add(new Suggest("今天几号"));
	// array.add(new Suggest("今天多少度"));
	// System.out.println(array.toString());
	// }
}
