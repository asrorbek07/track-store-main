package uz.pdp.trackstore.command.impl.clientCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.Order;
import uz.pdp.trackstore.entity.Track;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.service.OrderService;
import uz.pdp.trackstore.service.impl.OrderServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class ClientTracksCommand implements Command {
    private final OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User current_user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
        List<Order> orderList = orderService.findByUserId(current_user.getId());
        List<Track> clientTracks = new ArrayList<>();
        for (Order order : orderList) {
            clientTracks.add(order.getTrackId());
        }
        session.setAttribute(AppConstants.PARAMETER_COMMAND, AppConstants.PARAMETER_CLIENT_TRACKS_COMMAND);
        session.setAttribute(AppConstants.PARAMETER_CLIENT_TRACKS_COMMAND, clientTracks);
        return AppConstants.PAGE_CLIENT_HOME;
    }
}
