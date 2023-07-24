package uz.pdp.trackstore.command.impl.adminCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.service.PlaylistService;
import uz.pdp.trackstore.service.TrackService;
import uz.pdp.trackstore.service.impl.PlaylistServiceImpl;
import uz.pdp.trackstore.service.impl.TrackServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.util.UUID;

public class StartAddToPlayList implements Command {
    PlaylistService playlistService = PlaylistServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TrackService trackService = TrackServiceImpl.getInstance();
        HttpSession session = request.getSession();
        UUID trackId = UUID.fromString(request.getParameter(AppConstants.PARAMETER_TRACK_ID));
        session.setAttribute(AppConstants.PARAMETER_CLIENT_ALL_PLAYLIST_COMMAND, playlistService.findAll());
        session.setAttribute(AppConstants.PARAMETER_TRACK_ID, trackService.findById(trackId));
        return AppConstants.PAGE_ADD_PLAYLIST_PATH;
    }
}
