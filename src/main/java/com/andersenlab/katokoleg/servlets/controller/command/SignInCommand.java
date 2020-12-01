package com.andersenlab.katokoleg.servlets.controller.command;

import com.andersenlab.katokoleg.servlets.dto.UserDTO;
import com.andersenlab.katokoleg.servlets.exception.InvalidPasswordException;
import com.andersenlab.katokoleg.servlets.exception.NoSuchUserException;
import com.andersenlab.katokoleg.servlets.service.UserService;
import lombok.AllArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@AllArgsConstructor
public class SignInCommand implements Command{

    private UserService userService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserDTO userDTO = null;
        try {
            userDTO = userService.signIn(login, password);
        } catch (NoSuchUserException | InvalidPasswordException e) {
            request.setAttribute("message", e.getMessage());
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5 * 60);
        session.setAttribute("user", userDTO);
        request.getRequestDispatcher("/view/personal_account.jsp").forward(request, response);
    }
}