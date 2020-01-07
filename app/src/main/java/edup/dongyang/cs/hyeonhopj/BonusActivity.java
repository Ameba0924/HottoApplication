package edup.dongyang.cs.hyeonhopj;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class BonusActivity extends Activity {

    int bnumber[] = new int[4];
    int btn;
    int bonuscount;
    Intent bonusintent;
    private static MediaPlayer bmp;
    ImageView starbackImg, snowImg;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14;
    ImageView maps1, htImg, moneyImg;
    Spinner banksp, banksp2;
    TextView banktxt, banktxt10, banktxt15;
    Animation one;
    LinearLayout bimg1num1, bimg1num2, bimg1num3;
    LinearLayout bimg2num1, bimg2num2, bimg2num3;
    LinearLayout bimg3num1, bimg3num2, bimg3num3;
    LinearLayout bimg4num1, bimg4num2, bimg4num3;
    LinearLayout bimg5, bimg6;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        bmp = MediaPlayer.create(this, R.raw.byulbit);
        bmp.setLooping(true);
        bmp.start();

        //인텐트값 설정
        bonusintent = getIntent();
        bonuscount = bonusintent.getIntExtra("bonas", -1);
        bnumber[0] = bonusintent.getIntExtra("bonasnum1", -1);
        bnumber[1] = bonusintent.getIntExtra("bonasnum2", -1);
        bnumber[2] = bonusintent.getIntExtra("bonasnum3", -1);
        bnumber[3] = bonusintent.getIntExtra("bonasnum4", -1);
        btn = bonusintent.getIntExtra("btn", -1);

        starbackImg = findViewById(R.id.starbackImg);
        GlideDrawableImageViewTarget gifImage_starrain = new GlideDrawableImageViewTarget(starbackImg);
        Glide.with(getApplicationContext()).load(R.drawable.starrain).into(gifImage_starrain);
        //백그라운드 gif설정

        //1-1보상 관련 설정 구글맵
        maps1 = findViewById(R.id.maps1);
        btn1 = findViewById(R.id.btn1);

        maps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q=37.577449, 127.062697,(우리쥡쓰)");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });


        //1-2보상 관련 설정 스피너객체
        banksp = findViewById(R.id.backsp);
        banktxt = findViewById(R.id.banktxt);

        banksp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) banktxt.setText("110-279-444407");
                if (position == 1) banktxt.setText("774-602-04-102634");
                if (position == 2) banktxt.setText("010-5126-5770");
                if (position == 3) banktxt.setText("3333-04-1837023");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //2-2 설정 효과
        snowImg = findViewById(R.id.snowImg);
        GlideDrawableImageViewTarget gifImage_snow = new GlideDrawableImageViewTarget(snowImg);
        Glide.with(getApplicationContext()).load(R.drawable.snowrain).into(gifImage_snow);
        htImg = findViewById(R.id.htImg);
        GlideDrawableImageViewTarget gifImage_ht = new GlideDrawableImageViewTarget(htImg);
        Glide.with(getApplicationContext()).load(R.drawable.heartrain).into(gifImage_ht);

        //3-2 퀴즈 설정
        final EditText ettxt = findViewById(R.id.ettxt);
        Button etbtn = findViewById(R.id.etbtn);
        final TextView rstxt = findViewById(R.id.rstxt);


        etbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ettxt1 = (ettxt.getText().toString());
                if (ettxt1.equalsIgnoreCase("HOTTO")) {
                    rstxt.setText("1");
                    Toast.makeText(BonusActivity.this, "정답입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BonusActivity.this, "정답이아닙니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //

        //3-3 통장잔고 스피너 설정

        banksp2 = findViewById(R.id.backsp2);
        banktxt10 = findViewById(R.id.banktxt10);

        banksp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) banktxt10.setText("4720000원");
                if (position == 1) banktxt10.setText("350000원");
                if (position == 2) banktxt10.setText("0원");
                if (position == 3) banktxt10.setText("4200000원");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //1등 화면설정

        banktxt15 = findViewById(R.id.banktxt15);
        one = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeanim);
        banktxt15.setAnimation(one); //통누르라는 애니메이션설정
        moneyImg = findViewById(R.id.moneyImg);
        GlideDrawableImageViewTarget gifImage_my = new GlideDrawableImageViewTarget(moneyImg);
        Glide.with(getApplicationContext()).load(R.drawable.money).into(gifImage_my);

        //

        //이제 보너스 보기 눌렀을때 화면 띄워주기 설정합니다.

        bimg1num1 = findViewById(R.id.bimg1num1);
        bimg1num2 = findViewById(R.id.bimg1num2);
        bimg1num3 = findViewById(R.id.bimg1num3);
        bimg2num1 = findViewById(R.id.bimg2num1);
        bimg2num2 = findViewById(R.id.bimg2num2);
        bimg2num3 = findViewById(R.id.bimg2num3);
        bimg3num1 = findViewById(R.id.bimg3num1);
        bimg3num2 = findViewById(R.id.bimg3num2);
        bimg3num3 = findViewById(R.id.bimg3num3);
        bimg4num1 = findViewById(R.id.bimg4num1);
        bimg4num2 = findViewById(R.id.bimg4num2);
        bimg4num3 = findViewById(R.id.bimg4num3);
        bimg5 = findViewById(R.id.bimg5);
        bimg6 = findViewById(R.id.bimg6);


        switch (btn) { //넘어온버튼의값 ex)1이면 보너스6등 2이면 보너스5등.
            case 1:
                if (bnumber[0] == 0) {
                    bimg1num1.setVisibility(View.VISIBLE);
                } else if (bnumber[0] == 1) {
                    bimg1num2.setVisibility(View.VISIBLE);
                    starbackImg.setVisibility(View.GONE);
                    moneyImg.setVisibility(View.VISIBLE);
                } else if (bnumber[0] == 2) {
                    bimg1num3.setVisibility(View.VISIBLE);

                }
                break;
            case 2:
                if (bnumber[1] == 0) {
                    bimg2num1.setVisibility(View.VISIBLE);
                    starbackImg.setVisibility(View.GONE);
                    htImg.setVisibility(View.VISIBLE);

                } else if (bnumber[1] == 1) {
                    bimg2num2.setVisibility(View.VISIBLE);
                    starbackImg.setVisibility(View.GONE);
                    snowImg.setVisibility(View.VISIBLE);
                } else if (bnumber[1] == 2) {
                    bimg2num3.setVisibility(View.VISIBLE);
                    starbackImg.setVisibility(View.GONE);
                    htImg.setVisibility(View.VISIBLE);
                }
                break;
            case 3:
                if (bnumber[2] == 0) {
                    bimg3num1.setVisibility(View.VISIBLE);
                } else if (bnumber[2] == 1) {
                    bimg3num2.setVisibility(View.VISIBLE);
                    starbackImg.setVisibility(View.GONE);
                    moneyImg.setVisibility(View.VISIBLE);
                } else if (bnumber[2] == 2) {
                    bimg3num3.setVisibility(View.VISIBLE);
                    bimg1num2.setVisibility(View.VISIBLE);
                    starbackImg.setVisibility(View.GONE);
                    moneyImg.setVisibility(View.VISIBLE);
                }
                break;
            case 4:
                if (bnumber[3] == 0) {
                    bimg4num1.setVisibility(View.VISIBLE);
                } else if (bnumber[3] == 1) {
                    bimg4num2.setVisibility(View.VISIBLE);
                    starbackImg.setVisibility(View.GONE);
                    htImg.setVisibility(View.VISIBLE);
                } else if (bnumber[3] == 2) {
                    bimg4num3.setVisibility(View.VISIBLE);
                    starbackImg.setVisibility(View.GONE);
                    htImg.setVisibility(View.VISIBLE);
                }
                break;
            case 5:
                bimg5.setVisibility(View.VISIBLE);
                starbackImg.setVisibility(View.GONE);
                htImg.setVisibility(View.VISIBLE);
                break;
            case 6:
                bimg6.setVisibility(View.VISIBLE);
                break;

        } // 설정끝

        //뒤로가기 버튼 눌렀을때 현재화면종료 설정

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BonusActivity.this, "보상정보화면으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                finish();
                bmp.stop();
            }
        });


        //설정완료!!! 마지막 끝내기화면만 만들면됌 !! 휴우 11:35분 6월11일 =


    }//Oncreate


    @Override
    protected void onUserLeaveHint() { //홈버튼 눌렀을시 멈추고
        bmp.pause();
        super.onUserLeaveHint();
    }

    @Override
    protected void onResume() {
        bmp.start();
        super.onResume();
    }

    @Override
    protected void onDestroy() { //앱이 정지되었을때
        bmp.stop();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() { //백버튼을 눌렀을시.
        bmp.stop();
        super.onBackPressed();
    }

}//class


