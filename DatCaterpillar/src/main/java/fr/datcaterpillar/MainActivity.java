/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package fr.datcaterpillar;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.mwt.Desktop;
import ej.mwt.MWT;
import ej.mwt.Panel;
import ej.style.Stylesheet;
import ej.style.background.SimpleRoundedPlainBackground;
import ej.style.outline.SimpleOutline;
import ej.style.selector.TypeSelector;
import ej.style.selector.combinator.ChildCombinator;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.wadapps.app.Activity;
import ej.widget.basic.Label;
import ej.widget.composed.ButtonWrapper;
import ej.widget.container.transition.SlideScreenshotTransitionContainer;
import ej.widget.container.transition.TransitionContainer;
import ej.widget.navigation.page.Page;
import fr.datcaterpillar.pages.MainPage;

/**
 * The first activity displayed.
 */
public class MainActivity implements Activity {

	public static TransitionContainer transition;

	@Override
	public void onStart() {
		MicroUI.start();
		Panel panel = new Panel();
		Desktop dsk = new Desktop();

		transition = new SlideScreenshotTransitionContainer(MWT.LEFT, false, false);
		show(new MainPage());
		initializeStylelist();

		panel.setWidget(transition);
		panel.showFullScreen(dsk);
		dsk.show();
	}

	public static void show(Page page) {
		transition.show(page, true);
	}

	public static void home() {
		transition.show(new MainPage(), false);
	}

	public void initializeStylelist() {
		Stylesheet sheet = StyleHelper.getStylesheet();

		EditableStyle btnStyle = new EditableStyle();
		SimpleOutline btnMargin = new SimpleOutline(5);
		btnStyle.setMargin(btnMargin);
		btnStyle.setPadding(btnMargin);
		SimpleOutline myOutline = new SimpleOutline(5);
		btnStyle.setMargin(myOutline);
		SimpleRoundedPlainBackground myBackground = new SimpleRoundedPlainBackground(20);
		btnStyle.setBackground(myBackground);
		btnStyle.setBackgroundColor(Colors.MAGENTA);
		btnStyle.setForegroundColor(Colors.WHITE);
		btnStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		// Rule for labels child of buttons
		TypeSelector lblSel = new TypeSelector(Label.class);
		TypeSelector btnSel = new TypeSelector(ButtonWrapper.class);
		ChildCombinator parentBtnSel = new ChildCombinator(btnSel, lblSel);

		sheet.addRule(parentBtnSel, btnStyle);

		EditableStyle titleStyle = new EditableStyle();
		titleStyle.setBackgroundColor(Colors.PURPLE);
		titleStyle.setForegroundColor(Colors.WHITE);
		titleStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		// FontProfile titleFontProfile = new FontProfile(getID(), 20, 0);
		// titleStyle.setFontProfile(titleFontProfile);

		sheet.addRule(new TypeSelector(Label.class), titleStyle);
	}

	@Override
	public String getID() {
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
	}

}
