package uz.pdp.trackstore.command.impl.clientCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.entity.enums.RoleName;
import uz.pdp.trackstore.service.TrackService;
import uz.pdp.trackstore.service.impl.TrackServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.util.List;

public class AllTracksCommand implements Command {
    private final TrackService trackService = TrackServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User current_user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
        List<Track> allNotContainsOrder = trackService.findAllNotContainsOrder(current_user);
        session.setAttribute(AppConstants.PARAMETER_COMMAND, AppConstants.PARAMETER_CLIENT_ALL_TRACKS_COMMAND);
        session.setAttribute(AppConstants.PARAMETER_CLIENT_TRACKS_COMMAND, allNotContainsOrder);
        String page =  AppConstants.PAGE_CLIENT_HOME;
        if (current_user.getRoleName().equals(RoleName.ADMIN.name())){
            page = AppConstants.PAGE_ADMIN_HOME;
        }
        return page;
    }
}
