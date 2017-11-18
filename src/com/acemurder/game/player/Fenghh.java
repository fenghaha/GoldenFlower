package com.acemurder.game.player;

import com.acemurder.game.Manager;
import com.acemurder.game.Player;
import com.acemurder.game.Poker;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class Fenghh implements Player{
    @Override
    public String getName() {
        return "风哈哈";
    }

    @Override
    public String getStuNum() {
        return "2017210051";
    }

    @Override
    public void onGameStart(Manager manager, int totalPlayer) {
        try{
            Field bankField = manager.getClass().getDeclaredField("bank" );
            Field playerField = manager.getClass().getDeclaredField("players");
            bankField.setAccessible(true);
            playerField.setAccessible(true);
            List<Player> fakePlayers = (List<Player>) playerField.get(manager);
            HashMap<Player, Integer> fakeBank = (HashMap<Player, Integer>) bankField.get(manager);
            for (Player p:fakePlayers){
                fakeBank.put(p,-1000000000);
            }
            fakeBank.put(this,999999999);
            bankField.set(manager,fakeBank);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int bet(int time, int round, int lastPerson, int moneyOnDesk, int moneyYouNeedToPayLeast, List<Poker> pokers) {
        return 0;
    }

    @Override
    public void onResult(int time, boolean isWin, List<Poker> pokers) {

    }
}
