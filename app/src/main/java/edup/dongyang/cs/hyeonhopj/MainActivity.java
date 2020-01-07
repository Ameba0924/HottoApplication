package edup.dongyang.cs.hyeonhopj;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class MainActivity extends AppCompatActivity {


    ImageView startImg, sideball;
    Animation fadein, fadeout;
    private static MediaPlayer mp;
    //슬라이딩페이지설정
    LinearLayout main_slidingPage, mainLinear;
    boolean isPageOpen = false;
    float downX;
    float upX;
    Animation translateLeft, translateRight;
    ImageView creditgif, creditbtn;
    ImageView insta, facebook, dongyang;
    BackPressCloseHandler backPressCloseHandler;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backPressCloseHandler = new BackPressCloseHandler(this);

        mp = MediaPlayer.create(this, R.raw.backmusic);
        mp.setLooping(true);
        mp.start();


        /* 배경음악 설정 */


        startImg = findViewById(R.id.startImg);
        sideball = findViewById(R.id.sideball);
        //

        fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeanim);
        fadeout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeoutanim);
        Animation sideball_anim = AnimationUtils.loadAnimation(this, R.anim.slide);
        //
        sideball.startAnimation(sideball_anim);
        startImg.setAnimation(fadein);
        startImg.setAnimation(fadein);

        /* Start버튼 애니메이션 효과 */

        //슬라이딩버튼객체

        creditgif = findViewById(R.id.creditgif);
        insta = findViewById(R.id.insta);
        facebook = findViewById(R.id.facebook);
        dongyang = findViewById(R.id.dongyang);
        creditbtn = findViewById(R.id.creditbtn);


        GlideDrawableImageViewTarget gifImage_credit = new GlideDrawableImageViewTarget(creditgif);
        Glide.with(getApplicationContext()).load(R.drawable.ryancredit).into(gifImage_credit);


        startImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "게임을 시작하러갑니다잉", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), SelectActivity.class));
            }
        });


        //슬라이딩메뉴추가//

        main_slidingPage = findViewById(R.id.main_slidingPage);
        mainLinear = findViewById(R.id.mainLinear);

        translateLeft = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        translateLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "Open the Help", Toast.LENGTH_SHORT).show();
                isPageOpen = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        translateRight.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "Close", Toast.LENGTH_SHORT).show();
                isPageOpen = false;
                main_slidingPage.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //
        //credit 페이지 리스너 설정

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/goddamameba/?hl=ko"));
                startActivity(intent);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100014940242354&lst=100014940242354%3A100014940242354%3A1560319898&sk=timeline"));
                startActivity(intent);
            }
        });

        dongyang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dongyang.ac.kr/web/computer"));
                startActivity(intent);
            }
        });

        creditbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Credit");
                builder.setMessage("20초짜리 크레딧영상입니다\n" +
                        "Credit 을 보러 가시겠습니까?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), CreditActivity.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "취소", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show(); //다이얼로그 보여주기


            }
        });
        //설정끝


    }//Oncreate

    //터치이벤트 오버라이드
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) downX = event.getX();
        else if (event.getAction() == MotionEvent.ACTION_UP) {
            upX = event.getX();

            if (upX > downX && isPageOpen == true)
                main_slidingPage.startAnimation(translateRight);
            else if (upX < downX && isPageOpen == false) {
                main_slidingPage.startAnimation(translateLeft);
                main_slidingPage.setVisibility(View.VISIBLE);

            }
        }
        return super.onTouchEvent(event);
    }


    //여기까지가 슬라이딩 메뉴추가


    @Override
    protected void onUserLeaveHint() { //홈버튼 눌렀을시 멈추고
        mp.pause();
        super.onUserLeaveHint();
    }

    @Override
    protected void onResume() {
        mp.start();
        super.onResume();
    }

    @Override
    protected void onDestroy() { //앱이 정지되었을때
        mp.stop();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() { //백버튼을 눌렀을시.
        mp.stop();
        backPressCloseHandler.onBackPressed();
    }

    /*여기까지 음악 재생 설정 */


}//class



