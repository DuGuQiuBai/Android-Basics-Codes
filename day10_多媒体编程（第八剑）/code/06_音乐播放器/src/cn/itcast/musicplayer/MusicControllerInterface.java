package cn.itcast.musicplayer;

public interface MusicControllerInterface {

	void play();
	void pause();
	void continuePlay();
	void seekTo(int progress);
}
