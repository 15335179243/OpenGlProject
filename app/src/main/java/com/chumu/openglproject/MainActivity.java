package com.chumu.openglproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView mGlSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGlSurfaceView = findViewById(R.id.glsurface);
        initData();
    }
//    我们用的是2.0版本，所以判断手机是否支持2.0版本
    private boolean supportsEs2() {
        ActivityManager activityManager =
                (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager
                .getDeviceConfigurationInfo();

        final boolean supportsEs2 =
                configurationInfo.reqGlEsVersion >= 0x20000
                        || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
                        && (Build.FINGERPRINT.startsWith("generic")
                        || Build.FINGERPRINT.startsWith("unknown")
                        || Build.MODEL.contains("google_sdk")
                        || Build.MODEL.contains("Emulator")
                        || Build.MODEL.contains("Android SDK built for x86")));

        return supportsEs2;
    }
    private void initData() {
        if (supportsEs2()) {
            AirHockKeyRender myGlRender = new AirHockKeyRender(this);
            //设置opengl版本
            mGlSurfaceView.setEGLContextClientVersion(2);
            mGlSurfaceView.setRenderer(myGlRender);
            //RenderMode 有两种，RENDERMODE_WHEN_DIRTY 和 RENDERMODE_CONTINUOUSLY，前者是懒惰渲染，需要手动调用
            // glSurfaceView.requestRender() 才会进行更新，而后者则是不停渲染。
            mGlSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        } else {
            Log.d("mmm", "不支持2.0版本");
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        mGlSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGlSurfaceView.onPause();
    }
    float[] tableVertices = {
            //第一个三角
            0f, 0f,
            9f, 14f,
            0,14f,
            //第二个三角
            0f,0f,
            9f, 0f,
            9f, 14f,
    };


}
