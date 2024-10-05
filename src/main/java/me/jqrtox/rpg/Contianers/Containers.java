package me.jqrtox.rpg.Contianers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Containers implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        //Collection stats
        ContainerSetter.ContainerSetter("spruceCollection", p,0);
        ContainerSetter.ContainerSetter("birchCollection", p,0);
        ContainerSetter.ContainerSetter("acaciaCollection", p,0);
        ContainerSetter.ContainerSetter("jungleCollection", p,0);
        ContainerSetter.ContainerSetter("oakCollection", p, 0);

        //Collection requirements
        ContainerSetter.ContainerSetter("spruceCollectionreq", p, 50);
        ContainerSetter.ContainerSetter("birchCollectionreq", p, 50);
        ContainerSetter.ContainerSetter("acaciaCollectionreq", p, 50);
        ContainerSetter.ContainerSetter("jungleCollectionreq", p, 50);
        ContainerSetter.ContainerSetter("oakCollectionreq", p, 50);

        //Collection levels
        ContainerSetter.ContainerSetter("spruceCollectionlevel", p,1);
        ContainerSetter.ContainerSetter("birchCollectionlevel", p,1);
        ContainerSetter.ContainerSetter("acaciaCollectionlevel", p,1);
        ContainerSetter.ContainerSetter("jungleCollectionlevel", p,1);
        ContainerSetter.ContainerSetter("oakCollectionlevel", p,1);

    }

}
