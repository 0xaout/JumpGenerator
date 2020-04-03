package me.topaze.infinitejump.Commands;

import me.topaze.infinitejump.InfiniteJump;
import org.bukkit.command.CommandExecutor;

public class CommandManager {

    private InfiniteJump instance;

    public CommandManager(InfiniteJump infiniteJump) {
        instance = infiniteJump;

        registerCommands("generate", new GenerateJump(instance));
    }

    public void registerCommands(String commandName, CommandExecutor commandExecutor) {
        instance.getCommand(commandName).setExecutor(commandExecutor);

    }
}
