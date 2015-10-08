package com.taylorbest.mariobros.sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;



/**
 * Created by chadley on 10/7/2015.
 */
public class Coin extends InteractiveTileObject {
    public Coin(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
    }

    @Override
    public void onHeadHit() {

    }
}
