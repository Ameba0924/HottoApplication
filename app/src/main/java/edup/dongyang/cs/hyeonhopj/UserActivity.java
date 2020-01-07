package edup.dongyang.cs.hyeonhopj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import static android.view.View.GONE;

public class UserActivity extends Activity {

    Intent intent;
    Intent result_it;
    private static MediaPlayer mp, clickmp;
    int intent_Hotto[] = new int[6]; //행운번호 저장 로또번호 배열
    int user_Hotto[] = new int[6]; //유저 로또번호 저장배열
    TextView gettxt, randomtxt;
    ImageView userdrum, Hotto_num1, Hotto_num2, Hotto_num3, Hotto_num4, Hotto_num5, Hotto_num6;
    ImageView startanim;
    ImageView user_lottonum1, user_lottonum2, user_lottonum3, user_lottonum4, user_lottonum5, user_lottonum6;
    ImageView frameImg;
    ImageView resultsimsn1, resultsimsn2, resultfont;
    int hotto_count = 0;
    Animation fadein, scaleball, result;
    LinearLayout lay, lay2;
    Vibrator mVibe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mVibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);  // 바이브레이터를 사용하려면 바이브레이터권한설정을 해야함  *manifests*


        mp = MediaPlayer.create(this, R.raw.user);
        mp.setLooping(true);
        mp.start();

        //gettxt = findViewById(R.id.gettxt);
        intent = getIntent();
        intent_Hotto[0] = intent.getIntExtra("hotto1", -1);
        //gettxt.setText(intent_Hotto[0]+""); //setText 는 문자열이라 ""를 붙여줘야함
        intent_Hotto[1] = intent.getIntExtra("hotto2", -1);
        intent_Hotto[2] = intent.getIntExtra("hotto3", -1);
        intent_Hotto[3] = intent.getIntExtra("hotto4", -1);
        intent_Hotto[4] = intent.getIntExtra("hotto5", -1);
        intent_Hotto[5] = intent.getIntExtra("hotto6", -1);
        //가져온 행운추첨결과 값 새로운 배열에 저장

        userdrum = findViewById(R.id.userdrum);
        GlideDrawableImageViewTarget gifImage_user = new GlideDrawableImageViewTarget(userdrum);
        Glide.with(this).load(R.drawable.ballanim).into(gifImage_user); // gif 드럼 설정

        Hotto_num1 = findViewById(R.id.hotto_num1);
        Hotto_num2 = findViewById(R.id.hotto_num2);
        Hotto_num3 = findViewById(R.id.hotto_num3);
        Hotto_num4 = findViewById(R.id.hotto_num4);
        Hotto_num5 = findViewById(R.id.hotto_num5);
        Hotto_num6 = findViewById(R.id.hotto_num6);

        String res1 = "ball_" + intent_Hotto[0];
        int resid1 = getResources().getIdentifier(res1, "drawable", getPackageName());
        Hotto_num1.setImageResource(resid1);

        String res2 = "ball_" + intent_Hotto[1];
        int resid2 = getResources().getIdentifier(res2, "drawable", getPackageName());
        Hotto_num2.setImageResource(resid2);

        String res3 = "ball_" + intent_Hotto[2];
        int resid3 = getResources().getIdentifier(res3, "drawable", getPackageName());
        Hotto_num3.setImageResource(resid3);

        String res4 = "ball_" + intent_Hotto[3];
        int resid4 = getResources().getIdentifier(res4, "drawable", getPackageName());
        Hotto_num4.setImageResource(resid4);

        String res5 = "ball_" + intent_Hotto[4];
        int resid5 = getResources().getIdentifier(res5, "drawable", getPackageName());
        Hotto_num5.setImageResource(resid5);

        String res6 = "ball_" + intent_Hotto[5];
        int resid6 = getResources().getIdentifier(res6, "drawable", getPackageName());
        Hotto_num6.setImageResource(resid6);

        startanim = findViewById(R.id.startanim);
        fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeanim);
        startanim.startAnimation(fadein);


        //user가 뽑은 로또공 보여주기객체컨트롤
        user_lottonum1 = findViewById(R.id.user_lottonum1);
        user_lottonum2 = findViewById(R.id.user_lottonum2);
        user_lottonum3 = findViewById(R.id.user_lottonum3);
        user_lottonum4 = findViewById(R.id.user_lottonum4);
        user_lottonum5 = findViewById(R.id.user_lottonum5);
        user_lottonum6 = findViewById(R.id.user_lottonum6);


        //드럼통 누르면 유저 번호 뽑기 시작.
        userdrum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickmp = MediaPlayer.create(getApplicationContext(), R.raw.red);
                clickmp.setLooping(true);

                mVibe.vibrate(1000); //1초 진동줌


                //Frame 레이아웃을통한 애니메이션 등록.
                frameImg = findViewById(R.id.frameImg);

                scaleball = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_anim);
                scaleball.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        userdrum.setVisibility(View.INVISIBLE);
                        frameImg.setVisibility(View.VISIBLE);
                        clickmp.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        frameImg.setVisibility(GONE);
                        userdrum.setVisibility(View.VISIBLE);
                        clickmp.stop();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                frameImg.setAnimation(scaleball);

                // 등록설정 끝

                if (hotto_count == 0) {
                    user_Hotto[0] = (int) (Math.random() * 45 + 1);

                    hotto_count++; //값증가

                    String fhotto1 = "ball_" + user_Hotto[0];
                    int resuser_fid1 = getResources().getIdentifier(fhotto1, "drawable", getPackageName());
                    frameImg.setImageResource(resuser_fid1); // 애니메이션 효과주기
                    frameImg.setVisibility(View.VISIBLE);
                    userdrum.setVisibility(GONE);//애니메이션 강제 실행

                    String res_hotto1 = "ball_" + user_Hotto[0];
                    int resuser_id1 = getResources().getIdentifier(res_hotto1, "drawable", getPackageName());
                    user_lottonum1.setImageResource(resuser_id1);
                } else if (hotto_count == 1) {
                    user_Hotto[1] = (int) (Math.random() * 45 + 1);
                    if (user_Hotto[0] == user_Hotto[1]) {
                        hotto_count = 1;
                        Toast.makeText(UserActivity.this, user_Hotto[0] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else {

                        hotto_count++;

                        String fhotto2 = "ball_" + user_Hotto[1];
                        int resuser_fid2 = getResources().getIdentifier(fhotto2, "drawable", getPackageName());
                        frameImg.setImageResource(resuser_fid2);
                        frameImg.setVisibility(View.VISIBLE);
                        userdrum.setVisibility(GONE);

                        String res_hotto2 = "ball_" + user_Hotto[1];
                        int resuser_id2 = getResources().getIdentifier(res_hotto2, "drawable", getPackageName());
                        user_lottonum2.setImageResource(resuser_id2);
                    }
                } else if (hotto_count == 2) {
                    user_Hotto[2] = (int) (Math.random() * 45 + 1);
                    if (user_Hotto[2] == user_Hotto[0]) {
                        hotto_count = 2;
                        Toast.makeText(UserActivity.this, user_Hotto[0] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[2] == user_Hotto[1]) {
                        hotto_count = 2;
                        Toast.makeText(UserActivity.this, user_Hotto[1] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else {

                        hotto_count++;

                        String fhotto3 = "ball_" + user_Hotto[2];
                        int resuser_fid3 = getResources().getIdentifier(fhotto3, "drawable", getPackageName());
                        frameImg.setImageResource(resuser_fid3);
                        frameImg.setVisibility(View.VISIBLE);
                        userdrum.setVisibility(GONE);//애니메이션 강제 실행

                        String res_hotto3 = "ball_" + user_Hotto[2];
                        int resuser_id3 = getResources().getIdentifier(res_hotto3, "drawable", getPackageName());
                        user_lottonum3.setImageResource(resuser_id3);
                    }
                } else if (hotto_count == 3) {
                    user_Hotto[3] = (int) (Math.random() * 45 + 1);
                    if (user_Hotto[3] == user_Hotto[0]) {
                        hotto_count = 3;
                        Toast.makeText(UserActivity.this, user_Hotto[0] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[3] == user_Hotto[1]) {
                        hotto_count = 3;
                        Toast.makeText(UserActivity.this, user_Hotto[1] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[3] == user_Hotto[2]) {
                        hotto_count = 3;
                        Toast.makeText(UserActivity.this, user_Hotto[2] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else {

                        hotto_count++;

                        String fhotto4 = "ball_" + user_Hotto[3];
                        int resuser_fid4 = getResources().getIdentifier(fhotto4, "drawable", getPackageName());
                        frameImg.setImageResource(resuser_fid4);
                        frameImg.setVisibility(View.VISIBLE);
                        userdrum.setVisibility(GONE);//애니메이션 강제 실행

                        String res_hotto4 = "ball_" + user_Hotto[3];
                        int resuser_id4 = getResources().getIdentifier(res_hotto4, "drawable", getPackageName());
                        user_lottonum4.setImageResource(resuser_id4);
                    }
                } else if (hotto_count == 4) {
                    user_Hotto[4] = (int) (Math.random() * 45 + 1);
                    if (user_Hotto[4] == user_Hotto[0]) {
                        hotto_count = 4;
                        Toast.makeText(UserActivity.this, user_Hotto[0] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[4] == user_Hotto[1]) {
                        hotto_count = 4;
                        Toast.makeText(UserActivity.this, user_Hotto[1] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[4] == user_Hotto[2]) {
                        hotto_count = 4;
                        Toast.makeText(UserActivity.this, user_Hotto[2] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[4] == user_Hotto[3]) {
                        hotto_count = 4;
                        Toast.makeText(UserActivity.this, user_Hotto[3] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else {

                        hotto_count++;

                        String fhotto5 = "ball_" + user_Hotto[4];
                        int resuser_fid5 = getResources().getIdentifier(fhotto5, "drawable", getPackageName());
                        frameImg.setImageResource(resuser_fid5);
                        frameImg.setVisibility(View.VISIBLE);
                        userdrum.setVisibility(GONE);//애니메이션 강제 실행

                        String res_hotto5 = "ball_" + user_Hotto[4];
                        int resuser_id5 = getResources().getIdentifier(res_hotto5, "drawable", getPackageName());
                        user_lottonum5.setImageResource(resuser_id5);
                    }

                } else if (hotto_count == 5) {
                    user_Hotto[5] = (int) (Math.random() * 45 + 1);
                    if (user_Hotto[5] == user_Hotto[0]) {
                        hotto_count = 5;
                        Toast.makeText(UserActivity.this, user_Hotto[0] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[5] == user_Hotto[1]) {
                        hotto_count = 5;
                        Toast.makeText(UserActivity.this, user_Hotto[1] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[5] == user_Hotto[2]) {
                        hotto_count = 5;
                        Toast.makeText(UserActivity.this, user_Hotto[2] + "번공 중복입니다 다시뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[5] == user_Hotto[3]) {
                        hotto_count = 5;
                        Toast.makeText(UserActivity.this, user_Hotto[3] + "번공 중복입니다 다시 뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else if (user_Hotto[5] == user_Hotto[4]) {
                        hotto_count = 5;
                        Toast.makeText(UserActivity.this, user_Hotto[4] + "번공 중복입니다 다시 뽑아주세요", Toast.LENGTH_SHORT).show();
                    } else {

                        hotto_count++;

                        String fhotto6 = "ball_" + user_Hotto[5];
                        int resuser_fid6 = getResources().getIdentifier(fhotto6, "drawable", getPackageName());
                        frameImg.setImageResource(resuser_fid6);
                        frameImg.setVisibility(View.VISIBLE);
                        userdrum.setVisibility(GONE);//애니메이션 강제 실행

                        String res_hotto6 = "ball_" + user_Hotto[5];
                        int resuser_id6 = getResources().getIdentifier(res_hotto6, "drawable", getPackageName());
                        user_lottonum6.setImageResource(resuser_id6);

                        //result값 확인하려하는 애니메이션 생성 ~~~심슨 !!
                        lay = findViewById(R.id.lay);
                        lay2 = findViewById(R.id.lay2);
                        resultsimsn1 = findViewById(R.id.resultsimsn1);
                        resultsimsn2 = findViewById(R.id.resultsimsn2);

                        resultfont = findViewById(R.id.resultfont);
                        result = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeanim);
                        resultfont.setAnimation(result);//결과확인버튼 빤짝이

                        GlideDrawableImageViewTarget gifImage_simsn1 = new GlideDrawableImageViewTarget(resultsimsn1);
                        Glide.with(getApplicationContext()).load(R.drawable.simsn).into(gifImage_simsn1);
                        GlideDrawableImageViewTarget gifImage_simsn2 = new GlideDrawableImageViewTarget(resultsimsn2);
                        Glide.with(getApplicationContext()).load(R.drawable.simsn).into(gifImage_simsn2);

                        lay2.setVisibility(GONE);
                        lay.setVisibility(View.VISIBLE);

                        // 심슨값 설정완료,


                    }
                } else if (hotto_count == 6) {
                    Toast.makeText(UserActivity.this, "6개의 공을 모두뽑았습니다. 결과를 확인하세요", Toast.LENGTH_SHORT).show();

                   /* AlertDialog.Builder builder = new AlertDialog.Builder(UserActivity.this);
                    builder.setTitle("!!WARNING!!");
                    builder.setMessage("당신이 뽑은 번호\n"
                            +user_Hotto[0]+"번\n"
                            +user_Hotto[1]+"번\n"
                            +user_Hotto[2]+"번\n"
                            +user_Hotto[3]+"번\n"
                            +user_Hotto[4]+"번\n"
                            +user_Hotto[5]+"번\n"+ "맞습니까?"); */
                }
            }
        }); //drum 클릭리스너

        //결과확인 버튼 눌렀을때 리스너 등록
        resultfont = findViewById(R.id.resultfont);
        resultfont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //다이얼로그 설정
                AlertDialog.Builder builder = new AlertDialog.Builder(UserActivity.this);
                builder.setTitle("!!WARNING!!");
                builder.setMessage("당신이 뽑은 번호\n"
                        + user_Hotto[0] + "번\n"
                        + user_Hotto[1] + "번\n"
                        + user_Hotto[2] + "번\n"
                        + user_Hotto[3] + "번\n"
                        + user_Hotto[4] + "번\n"
                        + user_Hotto[5] + "번\n" + "맞습니까?\n" + "==번호는 다시 뽑을수없습니다==\n" + "다시뽑으시려면 처음으로를 클릭!");

                builder.setPositiveButton("결과확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UserActivity.this, "결과를 확인하러갑니다잉", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(getApplicationContext(), EndActivity.class);
                        it.putExtra("luck1", intent_Hotto[0]);
                        it.putExtra("user1", user_Hotto[0]);
                        it.putExtra("luck2", intent_Hotto[1]);
                        it.putExtra("user2", user_Hotto[1]);
                        it.putExtra("luck3", intent_Hotto[2]);
                        it.putExtra("user3", user_Hotto[2]);
                        it.putExtra("luck4", intent_Hotto[3]);
                        it.putExtra("user4", user_Hotto[3]);
                        it.putExtra("luck5", intent_Hotto[4]);
                        it.putExtra("user5", user_Hotto[4]);
                        it.putExtra("luck6", intent_Hotto[5]);
                        it.putExtra("user6", user_Hotto[5]);
                        startActivity(it);
                        finish();
                    }
                });

                builder.setNeutralButton("돌아가기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UserActivity.this, "돌아갑니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("처음으로", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UserActivity.this, "첫화면으로 갑니다~", Toast.LENGTH_SHORT).show();
                        Intent start_at = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(start_at);
                        finish();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show(); //다이얼로그 보여주기
                //intent설정
               /* Intent it = new Intent(getApplicationContext(),EndActivity.class);
                it.putExtra("luck1",intent_Hotto[0]);  it.putExtra("user1",user_Hotto[0]);
                it.putExtra("luck2",intent_Hotto[1]);  it.putExtra("user1",user_Hotto[1]);
                it.putExtra("luck3",intent_Hotto[2]);  it.putExtra("user1",user_Hotto[2]);
                it.putExtra("luck4",intent_Hotto[3]);  it.putExtra("user1",user_Hotto[3]);
                it.putExtra("luck5",intent_Hotto[4]);  it.putExtra("user1",user_Hotto[4]);
                it.putExtra("luck6",intent_Hotto[5]);  it.putExtra("user1",user_Hotto[5]);
                startActivity(it);
                finish();*/
            }
        });//IMAGE LISTENER


    }//Oncreate


    //음악설정
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
        super.onBackPressed();
    }

}//class

