package me.topaze.infinitejump;

import me.topaze.infinitejump.Commands.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteJump extends JavaPlugin {
    CommandManager commandManager;

    @Override
    public void onEnable() {
        super.onEnable();

        commandManager = new CommandManager(this);
    }
}
