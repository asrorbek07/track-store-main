package uz.pdp.trackstore.command.impl.adminCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.utills.AppConstants;

public class GiveUserDiscountCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute(AppConstants.PARAMETER_COMMAND, AppConstants.PARAMETER_ADMIN_GIVE_USER_DISCOUNT_COMMAND);
        return AppConstants.PAGE_ADMIN_HOME;
    }
}
