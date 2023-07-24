package uz.pdp.trackstore.command.impl.clientCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.Review;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.service.ReviewService;
import uz.pdp.trackstore.service.impl.ReviewServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.util.List;

public class AllReviewCommand implements Command {
    ReviewService reviewService = ReviewServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User current_user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
        List<Review> reviewList = reviewService.findAllByUserId(current_user.getId());
        session.setAttribute(AppConstants.PARAMETER_CLIENT_ALL_REVIEW_COMMAND, reviewList);
        return AppConstants.PAGE_ALL_REVIEW_PATH;
    }
}
