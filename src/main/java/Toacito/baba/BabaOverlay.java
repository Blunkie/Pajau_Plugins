package Toacito.baba;

import Toacito.ToacitoConfig;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;

public class BabaOverlay extends Overlay {

	@Inject
	private Client client;

	@Inject
	private Baba baba;

	@Inject
	protected ToacitoConfig config;

	@Inject
	BabaOverlay(Client client, Baba baba, ToacitoConfig toacitoConfig){
		this.client=client;
		this.baba=baba;
		this.config=toacitoConfig;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics) {
		if(this.baba.getCount()>=0 && this.config.babaConfig()){
			graphics.setFont(new Font("Arial",Font.BOLD,24));
			LocalPoint lp = baba.getMona().getLocalLocation();
			Point punto = Perspective.getCanvasTextLocation(client,graphics,lp,String.valueOf(baba.getCount()),0);
			OverlayUtil.renderTextLocation(graphics,punto,String.valueOf(baba.getCount()), Color.WHITE);
		}

		return null;
	}
}
