package com.taylorbest.mariobros.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.taylorbest.mariobros.MarioBros;
import com.taylorbest.mariobros.scenes.Hud;


/**
 * Created by chadley on 10/7/2015.
 */
public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;
    public Coin(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin", "Collision");
        if (manager != null) {
            if (getCell().getTile().getId() == BLANK_COIN)
                manager.get("audio/sounds/coin.wav", Sound.class).play();
            else
                manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        //setCategoryFilter(MarioBros.DESTROYED_BIT);
        getCell().setTile(tileSet.getTile(BLANK_COIN));
        Hud.addScore(100);
    }
}
