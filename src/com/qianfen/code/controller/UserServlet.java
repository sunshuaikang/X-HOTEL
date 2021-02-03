package com.qianfen.code.controller;

import com.qianfen.code.entity.User;
import com.qianfen.code.service.UserService;
import com.qianfen.code.service.impl.UserServiceImpl;
import com.qianfen.code.utils.BaseServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 用户注册
     * @param request
     * @param response
     * @throws UnsupportedEncodingException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        int register = userService.register(user);
        if(register ==1)
            response.sendRedirect(request.getContextPath()+"/before/before-login.jsp");
    }

    /**
     * 用户的登录功能
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String flag = request.getParameter("automaticLogin");
        User user = userService.login(username);
        if(user != null){
            if(user.getPassword().equals(password)){
                //密码正确
//                request.getRequestDispatcher("/before/before-index.jsp").forward(request,response);
                request.getSession().setAttribute("user",user);
                response.sendRedirect(request.getContextPath()+"/roomTypeServlet?method=getAllRoomType");

            }else {
                //密码错误
                response.getWriter().print("对不起，密码错误");
                return;
            }
        }
        if (user == null){
            //用户不存在
            response.getWriter().print("对不起，您输入的账户不存在");
            return;
        }
    }

    /**
     * 退出当前登录
     * @param request
     * @param response
     */
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //清除session
        request.getSession().invalidate();
        //跳转页面
        response.sendRedirect(request.getContextPath()+"/before/before-login.jsp");
    }
    /**
     * 查询全部的用户，没有进行分页
     * @param request
     * @param response
     */
    public void getAllUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    List<User> userList = userService.getAllUser();
    request.setAttribute("userList",userList);
    request.getRequestDispatcher("/after/after-user-manage.jsp").forward(request,response);
    }

    /**
     * 查看个人信息
     * @param request
     * @param response
     */
    public void getMyInformation(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        User sessionUser = (User) request.getSession(false).getAttribute("user");
        int id = sessionUser.getId();
        User user = userService.getUserById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/before/before-see-my-information.jsp").forward(request,response);
    }
    /**
     * 编辑的时候回显个人信息
     * @param request
     * @param response
     */
    public void showMyInformation(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        User sessionUser = (User) request.getSession(false).getAttribute("user");
        int id = sessionUser.getId();
        User user = userService.getUserById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/before/before-edit-information.jsp").forward(request,response);
    }
    /**
     * 根据用户的电话查询用户
     * @param request
     * @param response
     */
    public void getUserByPhone(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        List<User> userList = userService.getUserByPhone(phone);
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/after/after-user-manage.jsp").forward(request,response);
    }

    /**
     * 根据用户的Id删除用户
     * @param request
     * @param response
     */
    public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        int i = userService.deleteUser(Integer.parseInt(id));
        if(i==1){
            response.sendRedirect(request.getContextPath()+"/userServlet?method=getAllUser");
        }else {
            response.getWriter().print("删除失败");
        }
    }

    /**
     * 根据用户的id 修改用户信息
     * @param request
     * @param response
     */
    public void editUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String sign = request.getParameter("sign");
        String picture = request.getParameter("picture");
        User user = new User(Integer.parseInt(id), name, null, phone, picture, sign);
        int i = userService.editUser(user);
        if(i==1){
            response.sendRedirect(request.getContextPath()+"/userServlet?method=getMyInformation");
        }
    }

    /**
     * 根据用户的id 重置用户的密码 --管理员行为
     * @param request
     * @param response
     */
    public void resetPassWord(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        int i = userService.resetPassWord(Integer.parseInt(id));
        if (i==1){
            response.sendRedirect(request.getContextPath()+"/userServlet?method=getAllUser");
        }else {
            response.getWriter().print("重置密码失败");
        }
    }

    /**
     * 修改用户的登录密码 -- 用户行为
     * @param request
     * @param response
     */
    public void alertPassWord(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");
        User sessionUser = (User) request.getSession(false).getAttribute("user");
        int id = sessionUser.getId();
        User user = userService.getUserById(id);
        if(!oldPassword.equals(user.getPassword())){
            response.getWriter().print("原密码不正确，请重新输入");
            return;
        }
        if(!newPassword1.equals(newPassword2)){
            response.getWriter().print("两次密码不一致");
            return;
        }
        int i = userService.alterPassWord(id, newPassword1);
        if(i==1){
            response.sendRedirect(request.getContextPath()+"/roomTypeServlet?method=getAllRoomType");
        }else {
            response.getWriter().print("服务器出现问题，无法修改");
            return;
        }
    }
}
