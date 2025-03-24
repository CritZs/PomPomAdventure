package main;

import object.EndTile;
import object.FastPotion;
import object.SlowTrap;
import object.StuckTrap;
import object.TeleportTrap;

public class AssetSetter{
    public TeleportTrap obj[] = new TeleportTrap[20];
    RpgPanel gp;

    public AssetSetter(RpgPanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new FastPotion();
        gp.obj[0].worldX = 36 * 48;
        gp.obj[0].worldY = 23 * 48;

        gp.obj[1] = new FastPotion();
        gp.obj[1].worldX = 8 * 48;
        gp.obj[1].worldY = 25 * 48;

        gp.obj[2] = new SlowTrap();
        gp.obj[2].worldX = 30 * 48;
        gp.obj[2].worldY = 12 * 48;

        gp.obj[3] = new SlowTrap();
        gp.obj[3].worldX = 29 * 48;
        gp.obj[3].worldY = 40 * 48;

        gp.obj[4] = new TeleportTrap();
        gp.obj[4].worldX = 40 * 48;
        gp.obj[4].worldY = 26 * 48;

        gp.obj[5] = new TeleportTrap();
        gp.obj[5].worldX = 4 * 48;
        gp.obj[5].worldY = 22 * 48;

        gp.obj[6] = new TeleportTrap();
        gp.obj[6].worldX = 32 * 48;
        gp.obj[6].worldY = 10 * 48;

        gp.obj[7] = new TeleportTrap();
        gp.obj[7].worldX = 23 * 48;
        gp.obj[7].worldY = 38 * 48;

        gp.obj[8] = new EndTile();
        gp.obj[8].worldX = 49 * 48;
        gp.obj[8].worldY = 28 * 48;

        gp.obj[9] = new EndTile();
        gp.obj[9].worldX = 0 * 48;
        gp.obj[9].worldY = 15 * 48;

        gp.obj[10] = new EndTile();
        gp.obj[10].worldX = 45 * 48;
        gp.obj[10].worldY = 0 * 48;

        gp.obj[11] = new EndTile();
        gp.obj[11].worldX = 28 * 48;
        gp.obj[11].worldY = 49 * 48;

        gp.obj[12] = new StuckTrap();
        gp.obj[12].worldX = 40 * 48;
        gp.obj[12].worldY = 18 * 48;

        gp.obj[13] = new StuckTrap();
        gp.obj[13].worldX = 11 * 48;
        gp.obj[13].worldY = 31 * 48;

        gp.obj[14] = new StuckTrap();
        gp.obj[14].worldX = 38 * 48;
        gp.obj[14].worldY = 15 * 48;

        gp.obj[15] = new StuckTrap();
        gp.obj[15].worldX = 24 * 48;
        gp.obj[15].worldY = 43 * 48;
    }
}