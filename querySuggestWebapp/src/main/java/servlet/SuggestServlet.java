package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * @author rambodu 2014-3-8 ����12:45:08
 */
public class SuggestServlet extends HttpServlet {

	private static final long serialVersionUID = 6429054973446767234L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		// {"content":"[\"��������\",\"����������ô��\",\"���������\",\"������������\",\"�����������\",\"������ʲô����\",\"�������ڼ�\",\"�����������ô��\",\"���켸��\",\"������ٶ�\"]","errorMsg":{"code":"","desc":"","exception":""},"status":"success","task":"query suggestion"}
		// String json = "{result:}";
		JSONArray array = new JSONArray();
		array.add(new Suggest("��������"));
		array.add(new Suggest("���������"));
		array.add(new Suggest("������������"));
		array.add(new Suggest("������ʲô����"));
		array.add(new Suggest("�������ڼ�"));
		array.add(new Suggest("�����������ô��"));
		array.add(new Suggest("���켸��"));
		array.add(new Suggest("������ٶ�"));
		resp.getWriter().write(array.toString());
	}

	// public static void main(String[] args) {
	// JSONArray array = new JSONArray();
	// array.add(new Suggest("��������"));
	// array.add(new Suggest("���������"));
	// array.add(new Suggest("������������"));
	// array.add(new Suggest("������ʲô����"));
	// array.add(new Suggest("�������ڼ�"));
	// array.add(new Suggest("�����������ô��"));
	// array.add(new Suggest("���켸��"));
	// array.add(new Suggest("������ٶ�"));
	// System.out.println(array.toString());
	// }
}
