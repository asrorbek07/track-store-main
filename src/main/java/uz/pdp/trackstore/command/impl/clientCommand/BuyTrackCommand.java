package uz.pdp.trackstore.command.impl.clientCommand;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.*;
import uz.pdp.trackstore.service.BalanceService;
import uz.pdp.trackstore.service.DiscountService;
import uz.pdp.trackstore.service.OrderService;
import uz.pdp.trackstore.service.TrackService;
import uz.pdp.trackstore.service.impl.BalanceServiceImpl;
import uz.pdp.trackstore.service.impl.DiscountServiceImpl;
import uz.pdp.trackstore.service.impl.OrderServiceImpl;
import uz.pdp.trackstore.service.impl.TrackServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class BuyTrackCommand implements Command {
    private final TrackService trackService = TrackServiceImpl.getInstance();
    private final OrderService orderService = OrderServiceImpl.getInstance();
    private final BalanceService balanceService = BalanceServiceImpl.getInstance();
    private final DiscountService discountService = DiscountServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute(AppConstants.PARAMETER_COMMAND, AppConstants.PARAMETER_CLIENT_BUY_TRACK);
        UUID track_id = UUID.fromString(request.getParameter(AppConstants.PARAMETER_TRACK_ID));
        Track track = trackService.findById(track_id);
        User current_user = (User) session.getAttribute(AppConstants.PARAMETER_CURRENT_USER);
        Balance balance = balanceService.findByUserId(current_user.getId());
        Discount discount = discountService.findByUserId(current_user.getId());
        boolean inserted = false;
        if (balance.getBalance() >= track.getPrice() * (1 - discount.getPercentage() / 100)) {
            List<Order> orderList = orderService.findByUserId(current_user.getId());
            boolean bought = false;
            for (Order order : orderList) {
                if (order.getTrackId().getId().equals(track.getId())) {
                    bought = true;
                }
            }

            if (!bought) {
                Order order = new Order();
                order.setId(UUID.randomUUID());
                order.setCreatedAt(new Date(System.currentTimeMillis()));
                order.setOrderStatus("NEW");
                order.setTotalPrice(track.getPrice());
                order.setUserId(current_user);
                order.setTrackId(track);
                inserted = orderService.insert(order);
            }
        }
        if (inserted) {
            balance.setBalance(balance.getBalance() - track.getPrice() * (1 - discount.getPercentage() / 100));
            balanceService.update(balance);
        }
        return AppConstants.PAGE_CLIENT_HOME;
    }
}
