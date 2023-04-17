package Toacito.wardenP34;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

import javax.inject.Inject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class WardenP4Overlay extends Overlay {
	@Inject
	private Client client;

	@Inject
	private WardenP4 wardenP4;

	@Inject
	WardenP4Overlay(Client client, WardenP4 wardenP4){
		this.client = client;
		this.wardenP4=wardenP4;
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}


	@Override
	public Dimension render(Graphics2D graphics) {
		if(WardenP4.piedra != null && !WardenP4.piedra.finished()){
			Polygon Poly = Perspective.getCanvasTilePoly(client,WardenP4.piedra.getLocation());
			OverlayUtil.renderPolygon(graphics,Poly,Color.RED,new BasicStroke(2));
		}
		return null;
	}
}
