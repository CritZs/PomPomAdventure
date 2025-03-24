package main;

import java.util.Timer;
import java.util.TimerTask;

import entity.Entity;

public class CollisionCheck{

    RpgPanel gp;

    boolean executed = false;

    private int second = 0; 
    
    public CollisionCheck(RpgPanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity){
        
        int entityLeftDefaultX = entity.defaultX + entity.solidArea.x;
        int entityRightDefaultX = entity.defaultX + entity.solidArea.x + entity.solidArea.width;
        int entityTopDefaultY = entity.defaultY + entity.solidArea.y;
        int entityBottomDefaultY = entity.defaultY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftDefaultX / gp.TileSize;
        int entityRightCol = entityRightDefaultX / gp.TileSize;
        int entityTopRow = entityTopDefaultY / gp.TileSize;
        int entityBottomRow = entityBottomDefaultY / gp.TileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopDefaultY - entity.speed) / gp.TileSize;
                tileNum1 = gp.tiles.mapTile[entityLeftCol][entityTopRow];
                tileNum2 = gp.tiles.mapTile[entityRightCol][entityTopRow];
                if(gp.tiles.tile[tileNum1].collision == true || gp.tiles.tile[tileNum2].collision == true){
                    if(!executed){
                        gp.playSE(8);
                        executed = true;
                        Timer collideTimer = new Timer();
                        TimerTask collideTask = new TimerTask() {
                            public void run() {
                                second++;
                                if (second == 2) {
                                    executed = false;
                                    second = 0;
                                    collideTimer.cancel();
                                }
                            }
                        };
                        collideTimer.scheduleAtFixedRate(collideTask, 0, 1000);
                    }
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomDefaultY + entity.speed) / gp.TileSize;
                tileNum1 = gp.tiles.mapTile[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tiles.mapTile[entityRightCol][entityBottomRow];
                if(gp.tiles.tile[tileNum1].collision == true || gp.tiles.tile[tileNum2].collision == true){
                    if(!executed){
                        gp.playSE(8);
                        executed = true;
                        Timer collideTimer = new Timer();
                        TimerTask collideTask = new TimerTask() {
                            public void run() {
                                second++;
                                if (second == 2) {
                                    executed = false;
                                    second = 0;
                                    collideTimer.cancel();
                                }
                            }
                        };
                        collideTimer.scheduleAtFixedRate(collideTask, 0, 1000);
                    }
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftDefaultX - entity.speed) / gp.TileSize;
                tileNum1 = gp.tiles.mapTile[entityLeftCol][entityTopRow];
                tileNum2 = gp.tiles.mapTile[entityLeftCol][entityBottomRow];
                if(gp.tiles.tile[tileNum1].collision == true || gp.tiles.tile[tileNum2].collision == true){
                    if(!executed){
                        gp.playSE(8);
                        executed = true;
                        Timer collideTimer = new Timer();
                        TimerTask collideTask = new TimerTask() {
                            public void run() {
                                second++;
                                if (second == 2) {
                                    executed = false;
                                    second = 0;
                                    collideTimer.cancel();
                                }
                            }
                        };
                        collideTimer.scheduleAtFixedRate(collideTask, 0, 1000);
                    }
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightDefaultX + entity.speed) / gp.TileSize;
                tileNum1 = gp.tiles.mapTile[entityRightCol][entityTopRow];
                tileNum2 = gp.tiles.mapTile[entityRightCol][entityBottomRow];
                if(gp.tiles.tile[tileNum1].collision == true || gp.tiles.tile[tileNum2].collision == true){
                    if(!executed){
                        gp.playSE(8);
                        executed = true;
                        Timer collideTimer = new Timer();
                        TimerTask collideTask = new TimerTask() {
                            public void run() {
                                second++;
                                if (second == 2) {
                                    executed = false;
                                    second = 0;
                                    collideTimer.cancel();
                                }
                            }
                        };
                        collideTimer.scheduleAtFixedRate(collideTask, 0, 1000);
                    }
                    entity.collisionOn = true;
                }
                break;
        }
    }
    public int checkObject(Entity entity, boolean player){

        int index = 999;

        for(int i = 0; i < gp.obj.length; i++){

            if(gp.obj[i] != null){

                entity.solidArea.x = entity.defaultX + entity.solidArea.x;
                entity.solidArea.y = entity.defaultY + entity.solidArea.y;

                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){ 
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break; 
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}
