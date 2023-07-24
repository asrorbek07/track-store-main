/*------------------------Users------------------------*/
create table users
(
    id           uuid    not null
        constraint users_pk
            primary key,
    user_name    varchar not null,
    full_name    varchar not null,
    password     varchar not null,
    phone_number varchar not null,
    email        varchar not null,
    role_name    varchar not null,
    active       boolean,
    created_at   date    not null
);

alter table users
    owner to postgres;

create unique index users_email_uindex
    on users (email);

create unique index users_phone_number_uindex
    on users (phone_number);

create unique index users_user_name_uindex
    on users (user_name);

/*------------------------Balance------------------------*/
create table balance
(
    id         uuid not null
        constraint balance_pk
            primary key,
    created_at date not null,
    balance    double precision,
    user_id    uuid not null
        constraint balance_users_id_fk
            references users
);

alter table balance
    owner to postgres;

create unique index balance_user_id_uindex
    on balance (user_id);

/*------------------------Discount------------------------*/
create table discount
(
    id         uuid not null
        constraint discount_pk
            primary key,
    created_at date not null,
    percentage double precision,
    user_id    uuid not null
        constraint discount_users_id_fk
            references users
);

alter table discount
    owner to postgres;

create unique index discount_user_id_uindex
    on discount (user_id);

/*------------------------Album------------------------*/
create table album
(
    id          uuid    not null
        constraint album_pk
            primary key,
    created_at  date    not null,
    name        varchar not null,
    total_price double precision
);

alter table album
    owner to postgres;

create unique index album_name_uindex
    on album (name);

/*------------------------Track------------------------*/
create table track
(
    id          uuid    not null
        constraint track_pk
            primary key,
    created_at  date    not null,
    name        varchar not null,
    artist_name varchar not null,
    description varchar not null,
    genre_name  varchar not null,
    price       double precision,
    album_id    uuid    not null
);

alter table track
    owner to postgres;

/*------------------------Review------------------------*/
create table review
(
    id         uuid    not null
        constraint review_pk
            primary key,
    created_at date    not null,
    review     varchar not null,
    rate       integer,
    track_id   uuid    not null
        constraint review_track_id_fk
            references track,
    user_id    uuid
        constraint review_users_id_fk
            references users
);

alter table review
    owner to postgres;

/*------------------------Order------------------------*/
create table orders
(
    id           uuid    not null
        constraint order_pk
            primary key,
    created_at   date    not null,
    order_status varchar not null,
    total_price  double precision,
    user_id      uuid    not null
        constraint order_users_id_fk
            references users,
    track_id     uuid    not null
        constraint orders_track_id_fk
            references track
);

alter table orders
    owner to postgres;

/*------------------------Playlist------------------------*/
create table playlist
(
    id         uuid    not null
        constraint playlist_pk
            primary key,
    created_at date    not null,
    name       varchar not null
);

alter table playlist
    owner to postgres;

/*------------------------TrackPlaylist------------------------*/
create table track_playlist
(
    id          uuid not null
        constraint track_playlist_pk
            primary key,
    track_id    uuid not null
        constraint track_playlist_track_id_fk
            references track,
    playlist_id uuid not null
        constraint track_playlist_playlist_id_fk
            references playlist
);

alter table track_playlist
    owner to postgres;

