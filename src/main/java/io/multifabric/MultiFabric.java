package io.multifabric;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import puregero.multipaper.server.CommandLineInput;
import puregero.multipaper.server.MultiPaperServer;

import static net.minecraft.server.command.CommandManager.*;

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

		registerMultiFabricCommand();
	}

	private static void registerMultiFabricCommand() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher
			.register(literal("multifabric")
			.requires(source -> source.hasPermissionLevel(4))
					.then(literal("debug")).executes(context -> 1)
					.then(literal("servers")).executes(context -> 1)
					.then(literal("map")).executes(context -> 1)
					.then(literal("list")).executes(context -> 1)
			.executes(context -> {
				context.getSource()
						.sendMessage(Text.literal("Usage: /multifabric <debug|servers|map|list>")
								.setStyle(Style.EMPTY.withColor(Formatting.RED)));
				return 1;
			}
		)));
	}
}
