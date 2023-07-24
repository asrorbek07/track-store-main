package uz.pdp.trackstore.utills;

public class AppConstants {
    //commands
    public static final String PARAMETER_COMMAND = "command";
    public static final String PARAMETER_LOGIN = "login";

    public static final String PARAMETER_LOGOUT = "logout";
    public static final String PARAMETER_REGISTER = "register";
    public static final String PARAMETER_CLIENT_ADD_REVIEW_COMMAND = "add_review";
    public static final String PARAMETER_CLIENT_ALL_REVIEW_COMMAND = "all_review";
    public static final String PARAMETER_CLIENT_ALL_TRACKS_COMMAND = "all_tracks";
    public static final String PARAMETER_CLIENT_ALL_PLAYLIST_COMMAND = "all_playlist";
    public static final String PARAMETER_CLIENT_START_ADD_TO_PLAYLIST = "start_add_to_playlist";
    public static final String PARAMETER_CLIENT_BUY_TRACK = "buy_track";
    public static final String PARAMETER_CLIENT_INFO_COMMAND = "client_info";
    public static final String PARAMETER_CLIENT_INFO_EDIT_COMMAND = "client_info_edit";
    public static final String PARAMETER_CLIENT_TRACKS_COMMAND = "client_tracks";
    public static final String PARAMETER_ADMIN_ADD_ALBUM_COMMAND = "add_album";
    public static final String PARAMETER_ADMIN_ADD_PLAYLIST_COMMAND = "add_playlist";
    public static final String PARAMETER_ADMIN_CREATE_PLAYLIST_COMMAND = "create_playlist";
    public static final String PARAMETER_ADMIN_ADD_TRACK_COMMAND = "add_track";
    public static final String PARAMETER_ADMIN_ALL_USERS_COMMAND = "all_users";
    public static final String PARAMETER_ADMIN_BLOCK_OR_ACTIVATE_USER_COMMAND = "block_or_activate_user";
    public static final String PARAMETER_ADMIN_GIVE_USER_DISCOUNT_COMMAND = "give_user_discount";

    //inputs
    public static final String PARAMETER_USER_ID = "user_id";
    public static final String PARAMETER_USER_FULL_NAME = "user_full_name";
    public static final String PARAMETER_USER_NAME = "user_name";
    public static final String PARAMETER_USER_PHONE_NUMBER = "user_phone_number";
    public static final String PARAMETER_USER_PASSWORD = "user_password";
    public static final String PARAMETER_USER_EMAIL = "user_email";

    public static final String PARAMETER_CURRENT_USER = "current_user";

    public static final String PARAMETER_TRACK_ID = "track_id";
    public static final String PARAMETER_TRACK_NAME = "track_name";
    public static final String PARAMETER_TRACK_ARTIST_NAME = "track_artist_name";
    public static final String PARAMETER_TRACK_DESCRIPTION = "track_description";
    public static final String PARAMETER_TRACK_GENRE_NAME = "track_genre_name";
    public static final String PARAMETER_TRACK_PRICE = "track_price";
    public static final String PARAMETER_TRACK_ALBUM_ID = "track_album_id";
    public static final String PARAMETER_ALBUM_NAME = "album_name";
    public static final String PARAMETER_PLAYLIST_ID = "playlist_id";
    public static final String PARAMETER_PLAYLIST_NAME = "playlist_name";
    public static final String PARAMETER_REVIEW = "review";
    public static final String PARAMETER_RATE = "rate";


    //pages
    public static final String PAGE_DEFAULT = "index.jsp";
    public static final String PAGE_LOGIN = "pages/login.jsp";
    public static final String PAGE_REGISTER = "pages/register.jsp";
    public static final String PAGE_CLIENT_HOME = "pages/clientPages/ClientPage.jsp";
    public static final String PAGE_CLIENT_EDIT = "pages/clientPages/ClientInfoEdit.jsp";

    public static final String PAGE_ADMIN_HOME = "pages/adminPages/AdminPage.jsp";
    public static final String PAGE_ALL_TRACKS = "AllTracks.jsp";
    public static final String PAGE_CLIENT_TRACKS = "ClientTracks.jsp";
    public static final String PAGE_ALL_REVIEW = "AddReview.jsp";
    public static final String PAGE_ADD_REVIEW_PATH = "pages/clientPages/AddReview.jsp";
    public static final String PAGE_ALL_REVIEW_PATH = "pages/clientPages/AllReview.jsp";
    public static final String PAGE_CLIENT_INFO = "ClientInfo.jsp";
    public static final String PAGE_ADD_ALBUM_PATH = "pages/adminPages/AddAlbum.jsp";
    public static final String PAGE_ADD_PLAYLIST_PATH = "pages/adminPages/AddPlaylist.jsp";
    public static final String PAGE_ADD_TRACK_PATH = "pages/adminPages/AddTrack.jsp";
    public static final String PAGE_ALL_USERS = "AllUsers.jsp";
    public static final String PAGE_CREATE_PLAYLIST = "/pages/adminPages/CreatePlaylist.jsp";
}
