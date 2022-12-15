package io.multifabric;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import puregero.multipaper.server.CommandLineInput;
import puregero.multipaper.server.MultiPaperServer;

public class MultiFabric implements DedicatedServerModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final int DEFAULT_PORT = 35353;
	public static final Logger LOGGER = LoggerFactory.getLogger("multifabric");
	public static final MultiPaperServer MASTER = new MultiPaperServer(DEFAULT_PORT);

	@Override
	public void onInitializeServer() {
		// TODO Actual Implementation of Master and Shards
		(new CommandLineInput()).start();
	}
}
