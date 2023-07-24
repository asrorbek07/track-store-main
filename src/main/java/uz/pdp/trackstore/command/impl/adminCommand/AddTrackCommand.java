package uz.pdp.trackstore.command.impl.adminCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.Album;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.service.AlbumService;
import uz.pdp.trackstore.service.TrackService;
import uz.pdp.trackstore.service.impl.AlbumServiceImpl;
import uz.pdp.trackstore.service.impl.TrackServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.sql.Date;
import java.util.UUID;

public class AddTrackCommand implements Command {
    private final AlbumService albumService = AlbumServiceImpl.getInstance();
    private final TrackService trackService = TrackServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            return AppConstants.PAGE_ADD_TRACK_PATH;
        } else {
            UUID trackId = UUID.randomUUID();
            Date createdAt = new Date(System.currentTimeMillis());
            String trackName = request.getParameter(AppConstants.PARAMETER_TRACK_NAME);
            String trackArtistName = request.getParameter(AppConstants.PARAMETER_TRACK_ARTIST_NAME);
            String trackDescription = request.getParameter(AppConstants.PARAMETER_TRACK_DESCRIPTION);
            String trackGenreName = request.getParameter(AppConstants.PARAMETER_TRACK_GENRE_NAME);
            double trackPrice = Double.parseDouble(request.getParameter(AppConstants.PARAMETER_TRACK_PRICE));
            UUID trackAlbumId = UUID.fromString(request.getParameter(AppConstants.PARAMETER_TRACK_ALBUM_ID));
            Album album = albumService.findById(trackAlbumId);
            Track track = new Track(
                    trackId,
                    createdAt,
                    trackName,
                    trackArtistName,
                    trackDescription,
                    trackGenreName,
                    trackPrice,
                    album
            );
            boolean inserted = trackService.insert(track);
            if (inserted) {
                album.setTotalPrice(album.getTotalPrice() + trackPrice);
                albumService.update(album);
            }
            return AppConstants.PAGE_ADMIN_HOME;
        }
    }
}
