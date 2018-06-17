/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package fr.datcaterpillar.pages;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.exit.ExitHandler;
import ej.widget.basic.Label;
import ej.widget.composed.ButtonWrapper;
import ej.widget.container.List;
import ej.widget.container.Split;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import fr.datcaterpillar.MainActivity;

/**
 * The first page displayed
 */
public class MainPage extends Page {

	private final Split container;
	private ButtonWrapper gameBtn;
	private ButtonWrapper scoresBtn;
	private ButtonWrapper exitBtn;

	public MainPage() {
		Label title = new Label("Party caterpillar");
		title.addClassSelector("TITLE");
		List btnList = createBtnList();

		this.container = new Split(false, 0.2f);
		this.container.setFirst(title);
		this.container.setLast(btnList);

		setWidget(this.container);
	}

	private List createBtnList() {
		List btnList = new List(false);

		this.gameBtn = new ButtonWrapper();
		this.gameBtn.setWidget(new Label("PLAY"));
		this.gameBtn.addOnClickListener(new OnClickListener() {

			@Override
			public void onClick() {
				MainActivity.show(new GamePage());
			}
		});

		this.scoresBtn = new ButtonWrapper();
		this.scoresBtn.setWidget(new Label("SCORES"));
		this.scoresBtn.addOnClickListener(new OnClickListener() {

			@Override
			public void onClick() {
				MainActivity.show(new ScorePage());

			}
		});

		this.exitBtn = new ButtonWrapper();
		this.exitBtn.setWidget(new Label("EXIT"));
		this.exitBtn.addOnClickListener(new OnClickListener() {

			@Override
			public void onClick() {
				ExitHandler exitHandler = ServiceLoaderFactory.getServiceLoader().getService(ExitHandler.class);
				if (exitHandler != null) {
					exitHandler.exit();
				}
			}
		});

		btnList.add(this.gameBtn);
		btnList.add(this.scoresBtn);
		btnList.add(this.exitBtn);

		return btnList;
	}

}
