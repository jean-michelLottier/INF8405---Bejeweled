package com.inf8402.tps.tp1.bejeweled.activity;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.inf8402.tps.tp1.bejeweled.R;
import com.inf8402.tps.tp1.bejeweled.dao.SessionManager;

public class GameModeActivity extends Activity {

	private ImageView button_speed;
	private ImageView button_tactic;
	private ImageView button_return;

	private SessionManager session;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_mode);

		DialogFragment dialog = new GameDialogFragment();
		Bundle args = new Bundle();
		args.putInt(GameDialogFragment.BOX_DIALOG_KEY,
				GameDialogFragment.BOX_DIALOG_REGISTER);
		dialog.setArguments(args);
		dialog.show(getFragmentManager(), "GameDialogFragment");

		button_return = (ImageView) findViewById(R.id.boutonMode_retour);
		button_return.setOnClickListener(onClickListener);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.game_mode, menu);
		return true;
	}

	private final OnClickListener onClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = null;
			switch (v.getId()) {
			case R.id.boutonMode_retour:
				intent = new Intent(GameModeActivity.this,
						GameMenuActivity.class);
				session = new SessionManager(getApplicationContext());
				session.clearSession();
				startActivity(intent);
				break;

			default:
				break;
			}
		}
	};

}