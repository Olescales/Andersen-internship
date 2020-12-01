package com.andersenlab.katokoleg.servlets.controller;

import com.andersenlab.katokoleg.servlets.controller.command.Command;
import com.andersenlab.katokoleg.servlets.controller.command.CommandStorage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command_name");
        Command command = CommandStorage.getCommand(commandName);
        if (command == null) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            command.execute(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
