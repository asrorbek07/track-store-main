package uz.pdp.trackstore.command.impl.adminCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.service.UserService;
import uz.pdp.trackstore.service.impl.UserServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.util.UUID;

public class BlockOrActivateUserCommand implements Command {
    UserService userService = UserServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute(AppConstants.PARAMETER_COMMAND, AppConstants.PARAMETER_ADMIN_BLOCK_OR_ACTIVATE_USER_COMMAND);
        UUID userId = UUID.fromString(request.getParameter(AppConstants.PARAMETER_USER_ID));
        User user = userService.findById(userId);
        boolean active = user.isActive();
        userService.activateOrBlock(userId, !active);
        return AppConstants.PAGE_ADMIN_HOME;
    }
}
