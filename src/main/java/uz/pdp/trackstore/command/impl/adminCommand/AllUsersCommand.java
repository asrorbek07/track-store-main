package uz.pdp.trackstore.command.impl.adminCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.service.UserService;
import uz.pdp.trackstore.service.impl.UserServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.util.List;

public class AllUsersCommand implements Command {
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User current_user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
        List<User> allWithoutUser = userService.findAllWithoutUser(current_user.getId());
        session.setAttribute(AppConstants.PARAMETER_ADMIN_ALL_USERS_COMMAND, allWithoutUser);
        session.setAttribute(AppConstants.PARAMETER_COMMAND, AppConstants.PARAMETER_ADMIN_ALL_USERS_COMMAND);
        return AppConstants.PAGE_ADMIN_HOME;
    }
}
