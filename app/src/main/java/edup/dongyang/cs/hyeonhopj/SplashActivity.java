package edup.dongyang.cs.hyeonhopj;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class SplashActivity extends Activity {
    private static MediaPlayer mp;
    Animation anim;
    ImageView ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        mp = MediaPlayer.create(this, R.raw.disney);
        mp.setLooping(true);
        mp.start();


        ImageView = findViewById(R.id.ImageView);

        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        anim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mp.stop();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        ImageView.startAnimation(anim);


    }
}