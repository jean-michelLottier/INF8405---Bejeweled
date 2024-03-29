package com.inf8402.tps.tp1.bejeweled.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {
	SharedPreferences sharedPreferences;
	Editor editor;
	private Context context;
	int PRIVATE_MODE = 0;

	private static final String PREF_NAME = "PlayerSession";
	private static final String KEY_ID = "playerID";
	private static final String KEY_PSEUDO = "pseudo";
	private static final String KEY_SCORE_SPEED_MODE = "scoreSpeedMode";
	private static final String KEY_SCORE_TACTIC_MODE = "scoreTacticMode";
	private static final String KEY_RANK = "rank";
	private static final String KEY_START = "start";

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public boolean hasStarted() {
		return sharedPreferences.getBoolean(KEY_START, false);
	}

	public void setHasStarted(boolean start) {
		editor.putBoolean(KEY_START, start);
	}

	public SessionManager(Context context) {
		this.setContext(context);
		sharedPreferences = context.getSharedPreferences(PREF_NAME,
				PRIVATE_MODE);
		editor = sharedPreferences.edit();
	}

	public void initPlayerSession(Player player) {
		editor.putInt(KEY_ID, player.getPlayerID());
		editor.putString(KEY_PSEUDO, player.getPseudo());
		editor.putInt(KEY_SCORE_SPEED_MODE, player.getScoreSpeedMode());
		editor.putInt(KEY_SCORE_TACTIC_MODE, player.getScoreTacticalMode());
		editor.putBoolean(KEY_START, true);
		editor.commit();
	}

	public int getPlayerID() {
		return sharedPreferences.getInt(KEY_ID, 0);
	}

	public String getPlayerPseudo() {
		return sharedPreferences.getString(KEY_PSEUDO, null);
	}

	public int getPlayerScoreSpeedMode() {
		return sharedPreferences.getInt(KEY_SCORE_SPEED_MODE, 0);
	}

	public void setPlayerScoreSpeedMode(int score) {
		editor.putInt(KEY_SCORE_SPEED_MODE, score);
		editor.commit();
	}

	public int getPlayerScoreTacticMode() {
		return sharedPreferences.getInt(KEY_SCORE_TACTIC_MODE, 0);
	}

	public void setPlayerScoreTacticMode(int score) {
		editor.putInt(KEY_SCORE_TACTIC_MODE, score);
		editor.commit();
	}

	public Player getPlayerDetails() {
		Player player = new Player();

		player.setPlayerID(this.getPlayerID());
		player.setPseudo(this.getPlayerPseudo());
		player.setScoreSpeedMode(this.getPlayerScoreSpeedMode());
		player.setScoreTacticalMode(this.getPlayerScoreTacticMode());

		return player;
	}

	public void clearSession() {
		editor.clear();
		editor.commit();
	}

}
