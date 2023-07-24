package uz.pdp.trackstore.command.impl.clientCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.service.UserService;
import uz.pdp.trackstore.service.impl.UserServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

public class ClientInfoEditCommand implements Command {
    UserService userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User current_user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
        String method = request.getMethod();
        if (method.equals("GET")) {
            session.setAttribute(AppConstants.PARAMETER_CURRENT_USER, current_user);
            session.setAttribute(AppConstants.PARAMETER_COMMAND, AppConstants.PARAMETER_CLIENT_INFO_EDIT_COMMAND);
            return AppConstants.PAGE_CLIENT_EDIT;
        } else {
            String userName = request.getParameter(AppConstants.PARAMETER_USER_NAME);
            String fullName = request.getParameter(AppConstants.PARAMETER_USER_FULL_NAME);
            String password = request.getParameter(AppConstants.PARAMETER_USER_PASSWORD);
            String phoneNumber = request.getParameter(AppConstants.PARAMETER_USER_PHONE_NUMBER);
            String email = request.getParameter(AppConstants.PARAMETER_USER_EMAIL);
            current_user.setUserName(userName);
            current_user.setFullName(fullName);
            current_user.setPassword(password);
            current_user.setPhoneNumber(phoneNumber);
            current_user.setEmail(email);
            boolean edited = userService.update(current_user);
            return AppConstants.PAGE_CLIENT_HOME;
        }
    }
}
