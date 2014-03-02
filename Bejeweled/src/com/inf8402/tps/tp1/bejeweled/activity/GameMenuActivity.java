package com.inf8402.tps.tp1.bejeweled.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;

import com.inf8402.tps.tp1.bejeweled.R;
import com.inf8402.tps.tp1.bejeweled.service.MediaService;
import com.inf8402.tps.tp1.bejeweled.service.MenuService;

public class GameMenuActivity extends IActivity {

	/*
	 * private ImageView button_play = null; private ImageView button_score =
	 * null; private ImageView button_quit = null;
	 */

	private LinearLayout buttons = null;
	private Intent intentMediaService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_menu);
		menuService = new MenuService(this);
		/*
		 * button_score = (ImageView) findViewById(R.id.boutonMenu_score);
		 * button_score.setOnClickListener(onClickListener);
		 * 
		 * button_play = (ImageView) findViewById(R.id.boutonMenu_jouer);
		 * button_play.setOnClickListener(onClickListener);
		 * 
		 * button_quit = (ImageView) findViewById(R.id.boutonMenu_quitter);
		 * button_quit.setOnClickListener(onClickListener);
		 */
		buttons = (LinearLayout) findViewById(R.id.menuButtonsLayout);
		buttons.setOnTouchListener(multipleButtonsListener);

		intentMediaService = new Intent(this, MediaService.class);
		getApplicationContext().startService(intentMediaService);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_menu, menu);
		return true;
	}

	@Override
	void buttonManager(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case R.id.boutonMenu_score:
			menuService.goListScores();
			break;
		case R.id.boutonMenu_jouer:
			menuService.goPlayGame();
			break;
		case R.id.boutonMenu_quitter:
			menuService.goQuit(intentMediaService);
			break;
		default:
			break;
		}
		
	}

}
