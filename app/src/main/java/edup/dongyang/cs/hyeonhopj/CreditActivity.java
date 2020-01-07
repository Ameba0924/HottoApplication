package edup.dongyang.cs.hyeonhopj;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class CreditActivity extends Activity {

    ImageView endinggif, endingrabbit;
    LinearLayout endinglay;
    Animation creditanim;

    private static MediaPlayer creditmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        endinggif = findViewById(R.id.endinggif);

        GlideDrawableImageViewTarget gifImage_ending = new GlideDrawableImageViewTarget(endinggif);
        Glide.with(getApplicationContext()).load(R.drawable.endinggif).into(gifImage_ending);

        endingrabbit = findViewById(R.id.endingrabbit);

        GlideDrawableImageViewTarget gifImage_rabbit = new GlideDrawableImageViewTarget(endingrabbit);
        Glide.with(getApplicationContext()).load(R.drawable.rabbit).into(gifImage_rabbit);


        creditmp = MediaPlayer.create(this, R.raw.endingcredit);
        creditmp.setLooping(true);


        endinglay = findViewById(R.id.endinglay);

        creditanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_credit);
        creditanim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                creditmp.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                creditmp.stop();
                finish();


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        endinglay.startAnimation(creditanim);


    }

    //음악설정
    @Override
    protected void onUserLeaveHint() { //홈버튼 눌렀을시 멈추고
        creditmp.pause();
        super.onUserLeaveHint();
    }

    @Override
    protected void onResume() {
        creditmp.start();
        super.onResume();
    }

    @Override
    protected void onDestroy() { //앱이 정지되었을때
        creditmp.stop();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() { //백버튼을 눌렀을시.
        creditmp.stop();
        super.onBackPressed();
    }


}