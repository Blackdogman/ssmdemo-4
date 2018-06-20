package framework.controller;

import javax.servlet.http.HttpServlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.service.system.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController extends HttpServlet {
	@Autowired
    protected UserRoleService userRoleService;
	@Autowired
    protected UserService userService;
	@Autowired
    protected RoleService roleService;
    @Autowired
    protected RoleMenuService roleMenuService;
    @Autowired
    protected MenuService menuService;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3412511940987849417L;

	/**
	 * <p>
	 * 时间属性的编辑器
	 * </p>
	 * 
	 * @author zlf
	 * @Date 2017年6月4日
	 * @param servletRequestDataBinder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder servletRequestDataBinder) {
		servletRequestDataBinder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
