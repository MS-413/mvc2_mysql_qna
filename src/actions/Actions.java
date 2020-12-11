package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface Actions {
	void excute(HttpServletRequest req, HttpServletResponse res);
}
