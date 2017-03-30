package com.example.juanc.androidgame;

import android.app.Activity;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;


/**
 * Created by juanc on 1/11/2016.
 */

public abstract class BaseScene extends Scene{

    protected Engine engine;
    protected Activity activity;
    protected ResourcesManager resourcesManager;
    protected VertexBufferObjectManager vertexBufferObjectManager;
    protected Camera camera;

    public BaseScene(){
        this.resourcesManager = ResourcesManager.getInstancia();
        this.engine = resourcesManager.getEngine();
        this.activity = resourcesManager.getActivity();
        this.vertexBufferObjectManager = resourcesManager.getVertexBufferObjectManager();
        this.camera = resourcesManager.camera;
        createScene();
    }

    public abstract void createScene();
    public abstract void onBackKeyPressed();
    public abstract SceneManager.SceneType getSceneType();
    public abstract void disposeScene();


}
