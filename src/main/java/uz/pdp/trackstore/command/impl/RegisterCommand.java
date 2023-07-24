package uz.pdp.trackstore.command.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.trackstore.command.Command;
import uz.pdp.trackstore.entity.Balance;
import uz.pdp.trackstore.entity.User;
import uz.pdp.trackstore.entity.enums.RoleName;
import uz.pdp.trackstore.service.BalanceService;
import uz.pdp.trackstore.service.UserService;
import uz.pdp.trackstore.service.impl.BalanceServiceImpl;
import uz.pdp.trackstore.service.impl.UserServiceImpl;
import uz.pdp.trackstore.utills.AppConstants;

import java.sql.Date;
import java.util.UUID;

public class RegisterCommand implements Command {
    private final UserService userService = UserServiceImpl.getInstance();
    private final BalanceService balanceService = BalanceServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            return AppConstants.PAGE_REGISTER;
        } else {
            UUID id = UUID.randomUUID();
            String userName = request.getParameter(AppConstants.PARAMETER_USER_NAME);
            String fullName = request.getParameter(AppConstants.PARAMETER_USER_FULL_NAME);
            String password = request.getParameter(AppConstants.PARAMETER_USER_PASSWORD);
            String phoneNumber = request.getParameter(AppConstants.PARAMETER_USER_PHONE_NUMBER);
            String email = request.getParameter(AppConstants.PARAMETER_USER_EMAIL);
            String roleName = RoleName.CLIENT.name();
            Date createdAt = new Date(System.currentTimeMillis());
            User user = new User(
                    id,
                    createdAt,
                    userName,
                    fullName,
                    password,
                    phoneNumber,
                    email,
                    roleName
            );
            user.setActive(true);
            userService.insert(user);
            Balance balance = new Balance(
                    UUID.randomUUID(),
                    createdAt,
                    100,
                    user
            );
            balanceService.insert(balance);
            return AppConstants.PAGE_DEFAULT;
        }
    }
}
