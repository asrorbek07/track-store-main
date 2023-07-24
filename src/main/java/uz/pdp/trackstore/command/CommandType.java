package uz.pdp.trackstore.command;

import uz.pdp.trackstore.command.impl.LoginCommand;
import uz.pdp.trackstore.command.impl.LogoutCommand;
import uz.pdp.trackstore.command.impl.RegisterCommand;
import uz.pdp.trackstore.command.impl.adminCommand.*;
import uz.pdp.trackstore.command.impl.clientCommand.*;

public enum CommandType {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    REGISTER(new RegisterCommand()),
    ADD_REVIEW(new AddReviewCommand()),
    ALL_REVIEW(new AllReviewCommand()),
    ALL_TRACKS(new AllTracksCommand()),
    BUY_TRACK(new BuyTrackCommand()),
    CLIENT_INFO(new ClientInfoCommand()),
    CLIENT_INFO_EDIT(new ClientInfoEditCommand()),
    CLIENT_TRACKS(new ClientTracksCommand()),
    ADD_ALBUM(new AddAlbumCommand()),
    ADD_PLAYLIST(new AddPlaylistCommand()),
    CREATE_PLAYLIST(new CreatePlaylistCommand()),
    ADD_TRACK(new AddTrackCommand()),
    ALL_USERS(new AllUsersCommand()),
    BLOCK_OR_ACTIVATE_USER(new BlockOrActivateUserCommand()),
    GIVE_USER_DISCOUNT(new GiveUserDiscountCommand()),
    START_ADD_TO_PLAYLIST(new StartAddToPlayList());

    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public static Command define(String str) {
        CommandType commandType = CommandType.valueOf(str.toUpperCase());
        return commandType.command;
    }
}
