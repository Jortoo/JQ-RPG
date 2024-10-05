package me.jqrtox.rpg.Main;

import me.dovide.utils.Util;
import org.bukkit.Bukkit;

public class ProgressBar {

    public static String progressBar(Double i1, Double i2){

        Double percent = (double) ((i1 / i2) * 100);
        Bukkit.broadcastMessage(percent+"");
        if (percent >= 99) {
            return Util.cc("&2&m                    ");
        }else if(percent >= 95){
            return Util.cc("&2&m                   &7&m ");
        }else if(percent >= 90){
            return Util.cc("&2&m                  &7&m  ");
        }else if(percent >= 85){
            return Util.cc("&2&m                 &7&m   ");
        }else if(percent >= 80){
            return Util.cc("&2&m                &7&m    ");
        }else if(percent >= 75){
            return Util.cc("&2&m               &7&m     ");
        }else if(percent >= 70){
            return Util.cc("&2&m              &7&m      ");
        }else if(percent >= 65){
            return Util.cc("&2&m             &7&m       ");
        }else if(percent >= 60){
            return Util.cc("&2&m            &7&m        ");
        }else if(percent >= 55){
            return Util.cc("&2&m           &7&m         ");
        }else if(percent >= 50){
            return Util.cc("&2&m          &7&m          ");
        }else if(percent >= 45){
            return Util.cc("&2&m         &7&m           ");
        }else if(percent >= 40){
            return Util.cc("&2&m        &7&m            ");
        }else if(percent >= 35){
            return Util.cc("&2&m       &7&m             ");
        }else if(percent >= 30){
            return Util.cc("&2&m      &7&m              ");
        }else if(percent >= 25){
            return Util.cc("&2&m     &7&m               ");
        }else if(percent >= 20){
            return Util.cc("&2&m    &7&m                ");
        }else if(percent >= 15){
            return Util.cc("&2&m   &7&m                 ");
        }else if(percent >= 10){
            return Util.cc("&2&m  &7&m                  ");
        }else if(percent >= 5){
            return Util.cc("&2&m &7&m                   ");
        }else{
            return Util.cc("&2&7&m                    ");
        }

    }

}
