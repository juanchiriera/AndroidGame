package com.example.juanc.androidgame;


import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.IGameInterface;
import org.andengine.ui.activity.BaseGameActivity;

/**
 * Created by juanc on 1/11/2016.
 */

public class GameActivity extends BaseGameActivity{

    private Camera camera;
    private ResourcesManager resourcesManager;

    @Override
    public Engine onCreateEngine(EngineOptions pEngineOptions){
        return new LimitedFPSEngine(pEngineOptions,60);
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        camera = new Camera(0,0,800,480);
        EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,
                new RatioResolutionPolicy(800,480),this.camera);
        engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
        engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
        return engineOptions;
    }

    @Override
    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
        ResourcesManager.prepareManager(mEngine,this,camera,getVertexBufferObjectManager());
        resourcesManager = ResourcesManager.getInstancia();
        pOnCreateResourcesCallback.onCreateResourcesFinished();
    }

    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
        SceneManager.getInstance().createSplashScene(pOnCreateSceneCallback);
    }

    @Override
    public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
        mEngine.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback()
        {
            public void onTimePassed(final TimerHandler pTimerHandler)
            {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                // load menu resources, create menu scene
                // set menu scene using scene manager
                // disposeSplashScene();
                // READ NEXT ARTICLE FOR THIS PART.
            }
        }));
        pOnPopulateSceneCallback.onPopulateSceneFinished();
    }
}
