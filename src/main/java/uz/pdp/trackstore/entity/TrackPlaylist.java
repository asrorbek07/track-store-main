package uz.pdp.trackstore.entity;

import java.util.UUID;

public class TrackPlaylist {
    private UUID id;
    private Track trackId;
    private Playlist playlistId;

    public TrackPlaylist() {
    }

    public TrackPlaylist(UUID id, Track trackId, Playlist playlistId) {
        this.id = id;
        this.trackId = trackId;
        this.playlistId = playlistId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Track getTrackId() {
        return trackId;
    }

    public void setTrackId(Track trackId) {
        this.trackId = trackId;
    }

    public Playlist getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Playlist playlistId) {
        this.playlistId = playlistId;
    }

    @Override
    public String toString() {
        return "TrackPlaylist{" +
                "id=" + id +
                ", trackId=" + trackId +
                ", playlistId=" + playlistId +
                '}';
    }
}
