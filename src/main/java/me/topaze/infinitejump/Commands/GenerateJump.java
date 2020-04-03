package me.topaze.infinitejump.Commands;

import me.topaze.infinitejump.InfiniteJump;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class GenerateJump implements CommandsTemplate {

    private InfiniteJump instance;

    public GenerateJump(InfiniteJump infiniteJump) {
        instance = infiniteJump;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Vous devez être un joueur pour pouvoir éxécuter cette commande");
        }

        final Player player = (Player) sender;
        final ArrayList<Material> materialList = new ArrayList<>();

        materialList.add(Material.RED_CONCRETE);
        materialList.add(Material.BLACK_CONCRETE);
        materialList.add(Material.BLUE_CONCRETE);
        materialList.add(Material.YELLOW_CONCRETE);
        materialList.add(Material.ORANGE_CONCRETE);
        materialList.add(Material.PINK_CONCRETE);
        materialList.add(Material.MAGENTA_CONCRETE);
        materialList.add(Material.CYAN_CONCRETE);



        new BukkitRunnable() {
            Location loc = player.getLocation();


            public Material getMaterial() {
                return materialList.get((int) Math.round(Math.random() * 7));
            }


            public Vector generateRandomVector() {
                double randomX = (Math.random() * 3);
                double randomY = 1;
                double randomZ = (Math.random() * 3);


                if(Math.round(Math.random()) == 0) {
                    randomX = -randomX;
                }

                if(Math.round(Math.random()) == 0) {
                    randomZ = -randomZ;
                }

                return new Vector(randomX, randomY, randomZ);
            }

            @Override
            public void run() {

                Vector actualvector = generateRandomVector();
                Material mat = getMaterial();

                loc.add(actualvector);



                if(Math.round(loc.getY()) == 254) {
                    this.cancel();
                }

                if(!(loc.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY() - 1, loc.getBlockZ()).getType().equals(Material.AIR))) {

                    loc.add(- actualvector.getX(), - actualvector.getY(), - actualvector.getZ());

                } else if(!(loc.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY() - 2, loc.getBlockZ()).getType().equals(Material.AIR))) {

                    loc.add(- actualvector.getX(), - actualvector.getY(), - actualvector.getZ());


                } else {

                    loc.getBlock().setType(mat);
                }


            }
        }.runTaskTimer(instance,0, 1);



        return false;
    }
}
