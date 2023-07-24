package uz.pdp.trackstore.command.impl.clientCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.Review;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.service.ReviewService;
import uz.pdp.trackstore.service.TrackService;
import uz.pdp.trackstore.service.impl.ReviewServiceImpl;
import uz.pdp.trackstore.service.impl.TrackServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.sql.Date;
import java.util.UUID;

public class AddReviewCommand implements Command {
    private final TrackService trackService = TrackServiceImpl.getInstance();
    private final ReviewService reviewService = ReviewServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User current_user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
        String method = request.getMethod();
        if (method.equals("POST")) {
            String trackId = request.getParameter(AppConstants.PARAMETER_TRACK_ID);
            if (!trackId.equals("null")) {
                System.out.println("Add review command");
                UUID reviewId = UUID.randomUUID();
                Date createdAt = new Date(System.currentTimeMillis());
                String review = request.getParameter(AppConstants.PARAMETER_REVIEW);
                String rate = request.getParameter(AppConstants.PARAMETER_RATE);
                UUID track_id = UUID.fromString(request.getParameter(AppConstants.PARAMETER_TRACK_ID));
                Track track = trackService.findById(track_id);
                Review trackReview = new Review(
                        reviewId,
                        createdAt,
                        review,
                        track,
                        current_user,
                        Integer.parseInt(rate)
                );
                reviewService.insert(trackReview);
                session.setAttribute(AppConstants.PARAMETER_COMMAND, AppConstants.PARAMETER_CLIENT_ADD_REVIEW_COMMAND);
            }
        } else {
            return AppConstants.PAGE_ADD_REVIEW_PATH;
        }
        return AppConstants.PAGE_CLIENT_HOME;
    }
}
