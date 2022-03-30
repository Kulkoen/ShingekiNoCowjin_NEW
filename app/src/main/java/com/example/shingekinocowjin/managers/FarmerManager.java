package com.example.shingekinocowjin.managers;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.shingekinocowjin.farmers.Farmer;
import com.example.shingekinocowjin.scenes.PlayScene;

public class FarmerManager {
    private PlayScene playScene;
    private Farmer normalFarmer;
    private Farmer fasterFarmer;
    private Farmer fastestFarmer;

    public FarmerManager(PlayScene playScene){
        this.playScene = playScene;
        normalFarmer = new Farmer(10,310,0,0);
        fasterFarmer = new Farmer(10,310,1,1);
        fastestFarmer = new Farmer(10,310,2,2);
    }
    public void drawEnemies(Canvas canvas){
        drawFarmerType(normalFarmer,canvas);

        fasterFarmer.setFarmerBody(Color.BLUE);
        drawFarmerType(fasterFarmer,canvas);

        fastestFarmer.setFarmerBody(Color.YELLOW);
        drawFarmerType(fastestFarmer,canvas);
    }
    public void drawFarmerType(Farmer f, Canvas canvas){
        f.drawFarmer(canvas);
    }
    public void moveFarmer(Farmer farmer, float speed) {
        if ((farmer.getXCoordinate() < 240
                || (farmer.getYCoordinate() >= 650 && farmer.getXCoordinate() < 575))
                || (farmer.getYCoordinate() <= 100 && farmer.getXCoordinate() < 905)
                || (farmer.getYCoordinate() >= 860 && farmer.getXCoordinate() < 1300)
                || (farmer.getYCoordinate() >= 425 && farmer.getYCoordinate() <= 430
                    && farmer.getXCoordinate() >= 1300 && farmer.getXCoordinate() < 1800)
                || (farmer.getYCoordinate() > 650 && farmer.getXCoordinate() >= 1800)) {
            farmer.move(speed, 0);
        } else if ((farmer.getXCoordinate() >= 240 && farmer.getXCoordinate() < 575
                    && farmer.getYCoordinate() < 650)
                    || (farmer.getXCoordinate() >= 905 && farmer.getYCoordinate() < 860
                    && farmer.getXCoordinate() < 1300)
                    || (farmer.getXCoordinate() >= 1800 && farmer.getYCoordinate() < 1000)) {
            farmer.move(0, speed);
        } else {
            farmer.move(0, -speed);
        }
    }
    public void update() {
        moveFarmer(normalFarmer, (float)3);
        moveFarmer(fasterFarmer, (float)4);
        moveFarmer(fastestFarmer, (float)5);
    }
}
