package edup.dongyang.cs.hyeonhopj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class EndActivity extends Activity {

    TextView resulttxt, testtxt, endtxt, secrettxt;
    Intent intent, infoit;

    int luck[] = new int[6];
    int user[] = new int[6];
    int temp[] = new int[6]; //값넘겨받을 배열
    int end[] = new int[6]; //최종합 공 숫자 넣을 배열
    int twincount = 0;
    int endcount = 0;

    private static MediaPlayer endmp;
    ImageView lucknum1, lucknum2, lucknum3, lucknum4, lucknum5, lucknum6;
    ImageView usernum1, usernum2, usernum3, usernum4, usernum5, usernum6;
    ImageView countImg, endgif;
    ImageView endnum1, endnum2, endnum3, endnum4, endnum5, endnum6;
    LinearLayout slidelay;
    Button infobtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        endmp = MediaPlayer.create(this, R.raw.end);
        endmp.setLooping(true);
        endmp.start();

        //end 노래 설정


        intent = getIntent();
        luck[0] = intent.getIntExtra("luck1", 1);
        luck[1] = intent.getIntExtra("luck2", 1);
        luck[2] = intent.getIntExtra("luck3", 1);
        luck[3] = intent.getIntExtra("luck4", 1);
        luck[4] = intent.getIntExtra("luck5", 1);
        luck[5] = intent.getIntExtra("luck6", 1);
        //인텐트값 받아오기
        user[0] = intent.getIntExtra("user1", 1);
        user[1] = intent.getIntExtra("user2", 1);
        user[2] = intent.getIntExtra("user3", 1);
        user[3] = intent.getIntExtra("user4", 1);
        user[4] = intent.getIntExtra("user5", 1);
        user[5] = intent.getIntExtra("user6", 1);
        //인텐트값 받아오기

        lucknum1 = findViewById(R.id.lucknum1);
        usernum1 = findViewById(R.id.usernum1);
        lucknum2 = findViewById(R.id.lucknum2);
        usernum2 = findViewById(R.id.usernum2);
        lucknum3 = findViewById(R.id.lucknum3);
        usernum3 = findViewById(R.id.usernum3);
        lucknum4 = findViewById(R.id.lucknum4);
        usernum4 = findViewById(R.id.usernum4);
        lucknum5 = findViewById(R.id.lucknum5);
        usernum5 = findViewById(R.id.usernum5);
        lucknum6 = findViewById(R.id.lucknum6);
        usernum6 = findViewById(R.id.usernum6);

        endnum1 = findViewById(R.id.endnum1);
        endnum2 = findViewById(R.id.endnum2);
        endnum3 = findViewById(R.id.endnum3);
        endnum4 = findViewById(R.id.endnum4);
        endnum5 = findViewById(R.id.endnum5);
        endnum6 = findViewById(R.id.endnum6);

        endgif = findViewById(R.id.endgif);

        countImg = findViewById(R.id.countImg);

        endtxt = findViewById(R.id.endtxt);

        secrettxt = findViewById(R.id.secrettxt);

        slidelay = findViewById(R.id.slidelay);

        //애니메이션설정
        Animation slidelay_anim = AnimationUtils.loadAnimation(this, R.anim.slide);
        slidelay.startAnimation(slidelay_anim);
        Animation twinkle_anim = AnimationUtils.loadAnimation(this, R.anim.fadeanim);
        secrettxt.setAnimation(twinkle_anim);

        //

        //이미지 객체 컨트롤 생성

        //행운번호 이미지 접근
        String luck1 = "ball_" + luck[0];
        int luckid1 = getResources().getIdentifier(luck1, "drawable", getPackageName());
        lucknum1.setImageResource(luckid1);

        String luck2 = "ball_" + luck[1];
        int luckid2 = getResources().getIdentifier(luck2, "drawable", getPackageName());
        lucknum2.setImageResource(luckid2);

        String luck3 = "ball_" + luck[2];
        int luckid3 = getResources().getIdentifier(luck3, "drawable", getPackageName());
        lucknum3.setImageResource(luckid3);

        String luck4 = "ball_" + luck[3];
        int luckid4 = getResources().getIdentifier(luck4, "drawable", getPackageName());
        lucknum4.setImageResource(luckid4);

        String luck5 = "ball_" + luck[4];
        int luckid5 = getResources().getIdentifier(luck5, "drawable", getPackageName());
        lucknum5.setImageResource(luckid5);

        String luck6 = "ball_" + luck[5];
        int luckid6 = getResources().getIdentifier(luck6, "drawable", getPackageName());
        lucknum6.setImageResource(luckid6);
        //

        //유저 번호 객체 접근
        String user1 = "ball_" + user[0];
        int userid1 = getResources().getIdentifier(user1, "drawable", getPackageName());
        usernum1.setImageResource(userid1);

        String user2 = "ball_" + user[1];
        int userid2 = getResources().getIdentifier(user2, "drawable", getPackageName());
        usernum2.setImageResource(userid2);

        String user3 = "ball_" + user[2];
        int userid3 = getResources().getIdentifier(user3, "drawable", getPackageName());
        usernum3.setImageResource(userid3);

        String user4 = "ball_" + user[3];
        int userid4 = getResources().getIdentifier(user4, "drawable", getPackageName());
        usernum4.setImageResource(userid4);

        String user5 = "ball_" + user[4];
        int userid5 = getResources().getIdentifier(user5, "drawable", getPackageName());
        usernum5.setImageResource(userid5);

        String user6 = "ball_" + user[5];
        int userid6 = getResources().getIdentifier(user6, "drawable", getPackageName());
        usernum6.setImageResource(userid6);
        //


        //중복 비교 맞는 숫자 비교

        for (int i = 0; i < luck.length; i++) {
            for (int j = 0; j < user.length; j++) {
                if (luck[i] == user[j]) {
                    twincount++;


                    temp[i] = luck[i];
                }
            }
        }
        //twincount 에  일치하는 공 갯수 저장

        //twincount 일치하는 공개수에따라서 이미지 바꿔 띄워주기

        if (twincount == 0) {
            countImg.setImageResource(R.drawable.count0);
            GlideDrawableImageViewTarget gifImage_end0 = new GlideDrawableImageViewTarget(endgif);
            Glide.with(this).load(R.drawable.countkakao0).into(gifImage_end0);
            endtxt.setText("일치하는 공이 없습니다");
            secrettxt.setText("!!비밀정보 획득실패!!");

        }
        if (twincount == 1) {
            countImg.setImageResource(R.drawable.count6);
            GlideDrawableImageViewTarget gifImage_end1 = new GlideDrawableImageViewTarget(endgif);
            Glide.with(this).load(R.drawable.countkakao6).into(gifImage_end1);
            endtxt.setText(twincount + "개의 공이 일치합니다");
            secrettxt.setText("!!비밀정보 1개 획득!!");

        }
        if (twincount == 2) {
            countImg.setImageResource(R.drawable.count5);
            GlideDrawableImageViewTarget gifImage_end2 = new GlideDrawableImageViewTarget(endgif);
            Glide.with(this).load(R.drawable.countkakao5).into(gifImage_end2);
            endtxt.setText(twincount + "개의 공이 일치합니다");
            secrettxt.setText("!!비밀정보 2개 획득!!");

        }
        if (twincount == 3) {
            countImg.setImageResource(R.drawable.count4);
            GlideDrawableImageViewTarget gifImage_end3 = new GlideDrawableImageViewTarget(endgif);
            Glide.with(this).load(R.drawable.countkakao4).into(gifImage_end3);
            endtxt.setText(twincount + "개의 공이 일치합니다");
            secrettxt.setText("!!비밀정보 3개 획득!!");

        }
        if (twincount == 4) {
            countImg.setImageResource(R.drawable.count3);
            GlideDrawableImageViewTarget gifImage_end4 = new GlideDrawableImageViewTarget(endgif);
            Glide.with(this).load(R.drawable.countkakao3).into(gifImage_end4);
            endtxt.setText(twincount + "개의 공이 일치합니다");
            secrettxt.setText("!!비밀정보 4개 획득!!");
        }
        if (twincount == 5) {
            countImg.setImageResource(R.drawable.count2);
            GlideDrawableImageViewTarget gifImage_end5 = new GlideDrawableImageViewTarget(endgif);
            Glide.with(this).load(R.drawable.countkakao2).into(gifImage_end5);
            secrettxt.setText("!!비밀정보 5개 획득!!");

        }
        if (twincount == 6) {
            countImg.setImageResource(R.drawable.count1);
            GlideDrawableImageViewTarget gifImage_end6 = new GlideDrawableImageViewTarget(endgif);
            Glide.with(this).load(R.drawable.countkakao1).into(gifImage_end6);
            endtxt.setText(twincount + "개의 공이 일치합니다");
            secrettxt.setText("!!비밀정보 6개 획득!!");

        }
        ///////////////////////////////////////////////////////////////


        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                end[endcount] = temp[i];
                endcount++;
            }
        }
        //end[] 에 일치하는 공 번호 저장 일치하지않으면 0저장됨 default값으로

        //end이미지에 일치하는 공번호 띄워주기 만약에 일치하지않는공은 X처리

        if (end[0] != 0) {
            String end1 = "ball_" + end[0];
            int resend1 = getResources().getIdentifier(end1, "drawable", getPackageName());
            endnum1.setImageResource(resend1);
        } else {
            String end1 = "x";
            int resend1 = getResources().getIdentifier(end1, "drawable", getPackageName());
            endnum1.setImageResource(resend1);
        }
        //
        if (end[1] != 0) {
            String end2 = "ball_" + end[1];
            int resend2 = getResources().getIdentifier(end2, "drawable", getPackageName());
            endnum2.setImageResource(resend2);
        } else {
            String end2 = "x";
            int resend2 = getResources().getIdentifier(end2, "drawable", getPackageName());
            endnum2.setImageResource(resend2);
        }
        //
        if (end[2] != 0) {
            String end3 = "ball_" + end[2];
            int resend3 = getResources().getIdentifier(end3, "drawable", getPackageName());
            endnum3.setImageResource(resend3);
        } else {
            String end3 = "x";
            int resend3 = getResources().getIdentifier(end3, "drawable", getPackageName());
            endnum3.setImageResource(resend3);
        }
        //
        if (end[3] != 0) {
            String end4 = "ball_" + end[3];
            int resend4 = getResources().getIdentifier(end4, "drawable", getPackageName());
            endnum4.setImageResource(resend4);
        } else {
            String end4 = "x";
            int resend4 = getResources().getIdentifier(end4, "drawable", getPackageName());
            endnum4.setImageResource(resend4);
        }
        //
        if (end[4] != 0) {
            String end5 = "ball_" + end[4];
            int resend5 = getResources().getIdentifier(end5, "drawable", getPackageName());
            endnum5.setImageResource(resend5);
        } else {
            String end5 = "x";
            int resend5 = getResources().getIdentifier(end5, "drawable", getPackageName());
            endnum5.setImageResource(resend5);
        }
        //
        if (end[5] != 0) {
            String end6 = "ball_" + end[5];
            int resend6 = getResources().getIdentifier(end6, "drawable", getPackageName());
            endnum6.setImageResource(resend6);
        } else {
            String end6 = "x";
            int resend6 = getResources().getIdentifier(end6, "drawable", getPackageName());
            endnum6.setImageResource(resend6);
        }
        //

        //보상받기 버튼 리스너 활성화
        infobtn = findViewById(R.id.infobtn);
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다이얼로그 설정
                AlertDialog.Builder builder = new AlertDialog.Builder(EndActivity.this);
                builder.setTitle("!!WARNING!!");
                builder.setMessage("당신이 뽑은 번호\n"
                        + user[0] + "번\n"
                        + user[1] + "번\n"
                        + user[2] + "번\n"
                        + user[3] + "번\n"
                        + user[4] + "번\n"
                        + user[5] + "번\n" + "★보너스" + twincount + "개 획득★\n" + "맞습니까?");

                builder.setPositiveButton("보상받기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(EndActivity.this, "개발자 정보가 담겨있는 화면으로 이동합니다", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(getApplicationContext(), InfoActivity.class);
                        it.putExtra("userball1", user[0]);
                        it.putExtra("userball4", user[3]);
                        it.putExtra("userball2", user[1]);
                        it.putExtra("userball5", user[4]);
                        it.putExtra("userball3", user[2]);
                        it.putExtra("userball6", user[5]);
                        it.putExtra("bonusnum", twincount);

                        startActivity(it);
                        finish();
                    }
                });

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(EndActivity.this, "취소를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("처음으로", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(EndActivity.this, "첫화면으로 갑니다~~", Toast.LENGTH_SHORT).show();
                        Intent start_at = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(start_at);
                        finish();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show(); //다이얼로그 보여주기
            }
        });


    }//Oncreate


    @Override
    protected void onUserLeaveHint() { //홈버튼 눌렀을시 멈추고
        endmp.pause();
        super.onUserLeaveHint();
    }

    @Override
    protected void onResume() {
        endmp.start();
        super.onResume();
    }

    @Override
    protected void onDestroy() { //앱이 정지되었을때
        endmp.stop();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() { //백버튼을 눌렀을시.
        endmp.stop();
        super.onBackPressed();
    }


}//class
