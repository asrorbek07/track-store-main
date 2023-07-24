package uz.pdp.trackstore.command.impl.adminCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.Playlist;
import uz.pdp.trackstore.service.PlaylistService;
import uz.pdp.trackstore.service.impl.PlaylistServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.sql.Date;
import java.util.UUID;

public class CreatePlaylistCommand implements Command {
    PlaylistService playlistService = PlaylistServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();
        if (method.equals("GET")){
            return AppConstants.PAGE_CREATE_PLAYLIST;
        }else {
            String playlistName = request.getParameter(AppConstants.PARAMETER_PLAYLIST_NAME);
            UUID playlistId = UUID.randomUUID();
            Date createdAt = new Date(System.currentTimeMillis());
            Playlist playlist = new Playlist(
                    playlistId,
                    createdAt,
                    playlistName
            );

            playlistService.insert(playlist);
            return AppConstants.PAGE_ADMIN_HOME;
        }
    }
}
