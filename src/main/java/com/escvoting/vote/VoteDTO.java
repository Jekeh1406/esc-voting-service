package com.escvoting.vote;

public class VoteDTO {
    private int userId;
    private int musicId;
    private double musicNote;
    private double voiceNote;
    private double interpretationNote;
    private double showNote;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public double getMusicNote() {
        return musicNote;
    }

    public void setMusicNote(double musicNote) {
        this.musicNote = musicNote;
    }

    public double getVoiceNote() {
        return voiceNote;
    }

    public void setVoiceNote(double voiceNote) {
        this.voiceNote = voiceNote;
    }

    public double getInterpretationNote() {
        return interpretationNote;
    }

    public void setInterpretationNote(double interpretationNote) {
        this.interpretationNote = interpretationNote;
    }

    public double getShowNote() {
        return showNote;
    }

    public void setShowNote(double showNote) {
        this.showNote = showNote;
    }
}
