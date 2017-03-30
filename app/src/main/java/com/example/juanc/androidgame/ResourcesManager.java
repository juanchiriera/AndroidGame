package com.example.juanc.androidgame;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by juanc on 1/11/2016.
 */

public class ResourcesManager {

    public Engine engine;
    public Camera camera;
    public VertexBufferObjectManager vertexBufferObjectManager;
    public GameActivity activity;

    private static ResourcesManager instancia;
    public ITextureRegion splash_region;
    private BitmapTextureAtlas splashTextureAtlas;

    /** Methods **/
    public void loadMenuResources(){
        loadMenuGraphics();
        loadMenuAudio();
    }

    public void loadGameResources(){
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }

    private void loadMenuGraphics() {

    }

    private void loadMenuAudio() {
    }

    private void loadGameGraphics() {
    }

    private void loadGameFonts() {
    }

    private void loadGameAudio() {

    }

    public static void prepareManager(Engine engine, GameActivity gameActivity, Camera camera, VertexBufferObjectManager vertexBufferObjectManager) {
        getInstancia().engine = engine;
        getInstancia().activity = gameActivity;
        getInstancia().camera = camera;
        getInstancia().vertexBufferObjectManager = vertexBufferObjectManager;
    }

    public static ResourcesManager getInstancia() {
        return instancia;
    }

    public void setInstancia(ResourcesManager instancia) {
        this.instancia = instancia;
    }

    /** Getters and Setters **/

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public GameActivity getActivity() {
        return activity;
    }

    public void setActivity(GameActivity activity) {
        this.activity = activity;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public VertexBufferObjectManager getVertexBufferObjectManager() {
        return vertexBufferObjectManager;
    }

    public void setVertexBufferObjectManager(VertexBufferObjectManager vertexBufferObjectManager) {
        this.vertexBufferObjectManager = vertexBufferObjectManager;
    }

    public void loadSplashScreen(){
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
        splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
        splashTextureAtlas.load();
    }

    public void unloadSplashScreen(){
        splashTextureAtlas.unload();
        splash_region = null;
    }

}
