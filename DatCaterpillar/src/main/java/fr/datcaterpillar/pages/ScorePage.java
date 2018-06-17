/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package fr.datcaterpillar.pages;

import ej.widget.basic.Label;
import ej.widget.composed.ButtonWrapper;
import ej.widget.container.Split;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import fr.datcaterpillar.MainActivity;

/**
 *
 */
public class ScorePage extends Page {

	private final ButtonWrapper backBtn;
	private final Split container;

	/**
	 *
	 */
	public ScorePage() {
		super();

		this.backBtn = new ButtonWrapper();
		this.backBtn.setWidget(new Label("BACK"));
		this.backBtn.addOnClickListener(new OnClickListener() {

			@Override
			public void onClick() {
				MainActivity.home();
			}
		});

		this.container = new Split(false, 0.2f);
		this.container.setFirst(this.backBtn);
		// this.container.setLast(btnList);

		setWidget(this.container);

	}

}
