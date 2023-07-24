package uz.pdp.trackstore.command.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.utills.AppConstants;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return AppConstants.PAGE_DEFAULT;
    }
}
