package uz.pdp.trackstore.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.command.CommandType;
import uz.pdp.trackstore.utills.AppConstants;

import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/controller")
public class Controller extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String command = request.getParameter(AppConstants.PARAMETER_COMMAND);
        Command currentCommand = CommandType.define(command);
        String page = currentCommand.execute(request, response);
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String command = request.getParameter(AppConstants.PARAMETER_COMMAND);
        Command currentCommand = CommandType.define(command);
        String page = currentCommand.execute(request, response);
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}