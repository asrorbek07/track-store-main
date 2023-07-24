package uz.pdp.trackstore.command.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.entity.enums.RoleName;
import uz.pdp.trackstore.service.PlaylistService;
import uz.pdp.trackstore.service.TrackService;
import uz.pdp.trackstore.service.UserService;
import uz.pdp.trackstore.service.impl.PlaylistServiceImpl;
import uz.pdp.trackstore.service.impl.TrackServiceImpl;
import uz.pdp.trackstore.service.impl.UserServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

public class LoginCommand implements Command {

    private final TrackService trackService = TrackServiceImpl.getInstance();

    private final PlaylistService playlistService = PlaylistServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();
        HttpSession session = request.getSession();
        if (method.equals("GET")) {
            return AppConstants.PAGE_LOGIN;
        } else {
            String userName = request.getParameter(AppConstants.PARAMETER_USER_NAME);
            String password = request.getParameter(AppConstants.PARAMETER_USER_PASSWORD);
            UserService userService = UserServiceImpl.getInstance();
            String page = AppConstants.PAGE_DEFAULT;
            if (userService.authenticate(userName, password)) {
                User user = userService.findByUserName(userName);
                session.setAttribute(AppConstants.PARAMETER_CURRENT_USER, user);
                session.setAttribute(AppConstants.PARAMETER_CLIENT_TRACKS_COMMAND, trackService.findAll());
                if (user.getRoleName().equals(RoleName.CLIENT.name())) {
                    if (user.isActive()){
                        page = AppConstants.PAGE_CLIENT_HOME;
                    }
                } else if (user.getRoleName().equals(RoleName.ADMIN.name())) {
                    session.setAttribute(AppConstants.PARAMETER_COMMAND, AppConstants.PARAMETER_CLIENT_ALL_TRACKS_COMMAND);
                    page = AppConstants.PAGE_ADMIN_HOME;
                }
            }
            return page;
        }
    }
}
