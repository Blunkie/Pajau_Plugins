package com.example;

import Toacito.ToacitoPlugin;
import constru.ConstruPlugin;
import faldita.FaldaPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class PajauPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ExamplePlugin.class, ToacitoPlugin.class, FaldaPlugin.class, ConstruPlugin.class);
		RuneLite.main(args);
	}
}