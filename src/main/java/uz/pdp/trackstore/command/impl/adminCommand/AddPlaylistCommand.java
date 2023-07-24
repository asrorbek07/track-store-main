package uz.pdp.trackstore.command.impl.adminCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.TrackPlaylist;
import uz.pdp.trackstore.service.PlaylistService;
import uz.pdp.trackstore.service.TrackPlaylistService;
import uz.pdp.trackstore.service.impl.PlaylistServiceImpl;
import uz.pdp.trackstore.service.impl.TrackPlaylistServiceImpl;

import java.util.UUID;

import static uz.pdp.trackstore.utills.AppConstants.*;

public class AddPlaylistCommand implements Command {
    private final PlaylistService playlistService = PlaylistServiceImpl.getInstance();

    private final TrackPlaylistService trackPlaylistService = TrackPlaylistServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String method = request.getMethod();
        if (method.equals("GET")) {
            return PAGE_ADD_PLAYLIST_PATH;
        } else {
            Track track = (Track) session.getAttribute(PARAMETER_TRACK_ID);
            UUID playlistId = UUID.fromString(request.getParameter(PARAMETER_PLAYLIST_ID));
            TrackPlaylist trackPlaylist = new TrackPlaylist(
                    UUID.randomUUID(),
                    track,
                    playlistService.findById(playlistId)
            );
            trackPlaylistService.insert(trackPlaylist);
            return PAGE_ADMIN_HOME;
        }
    }
}
