package uz.pdp.trackstore.command.impl.adminCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.Album;
import uz.pdp.trackstore.service.AlbumService;
import uz.pdp.trackstore.service.impl.AlbumServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.sql.Date;
import java.util.UUID;

public class AddAlbumCommand implements Command {
    private final AlbumService albumService = AlbumServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            return AppConstants.PAGE_ADD_ALBUM_PATH;
        }
        UUID albumId = UUID.randomUUID();
        Date createdAt = new Date(System.currentTimeMillis());
        double albumTotalPrice = 0;
        String albumName = request.getParameter(AppConstants.PARAMETER_ALBUM_NAME);
        Album album = new Album(
                albumId,
                createdAt,
                albumName,
                albumTotalPrice
        );
        albumService.insert(album);
        return AppConstants.PAGE_ADMIN_HOME;
    }
}
