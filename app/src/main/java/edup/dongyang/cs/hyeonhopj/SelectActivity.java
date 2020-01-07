package edup.dongyang.cs.hyeonhopj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class SelectActivity extends Activity {


    ImageView selectImg, Lotto_num1, Lotto_num2, Lotto_num3, Lotto_num4, Lotto_num5, Lotto_num6;
    ImageView neoImg1, neoImg2;
    Button random_lotto_btn, intent_lotto_btn;
    int Hotto[] = new int[6];
    TextView txt;
    private static MediaPlayer mp;
    Intent it;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        mp = MediaPlayer.create(this, R.raw.select);
        mp.setLooping(true);
        mp.start();

        selectImg = findViewById(R.id.selectImg);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(selectImg);
        Glide.with(this).load(R.drawable.ballanim).into(gifImage);
        //공돌아가는화면
        neoImg1 = findViewById(R.id.neoImg1);
        GlideDrawableImageViewTarget gifImage_neo = new GlideDrawableImageViewTarget(neoImg1);
        Glide.with(this).load(R.drawable.neo).into(gifImage_neo);
        //네오 춤추는거
        neoImg2 = findViewById(R.id.neoImg2);
        GlideDrawableImageViewTarget gifImage_neo2 = new GlideDrawableImageViewTarget(neoImg2);
        Glide.with(this).load(R.drawable.neo).into(gifImage_neo2);
        //네오 춤추는거

        /* GIF 이미지 넣는거 */


        //
        random_lotto_btn = findViewById(R.id.random_lotto_btn);
        Lotto_num1 = findViewById(R.id.Lotto_num1);
        Lotto_num2 = findViewById(R.id.Lotto_num2);
        Lotto_num3 = findViewById(R.id.Lotto_num3);
        Lotto_num4 = findViewById(R.id.Lotto_num4);
        Lotto_num5 = findViewById(R.id.Lotto_num5);
        Lotto_num6 = findViewById(R.id.Lotto_num6);
        txt = findViewById(R.id.txt);

        random_lotto_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(SelectActivity.this, "오늘의 행운번호를 뽑습니다.", Toast.LENGTH_SHORT).show();

                int j, result;
                for (int i = 0; i < 6; ) {

                    result = (int) (Math.random() * 45 + 1);

                    for (j = 0; j < i; j++) {
                        if (Hotto[j] == result) break;
                    }
                    if (j == i) {
                        Hotto[i] = result;
                        i++;
                    }
                } // 로또 번호 중복되지 않게 설정 .

                random_lotto_btn.setBackgroundResource(R.drawable.rebutton);

                String res1 = "ball_" + Hotto[0];
                int resid1 = getResources().getIdentifier(res1, "drawable", getPackageName());
                Lotto_num1.setImageResource(resid1);

                String res2 = "ball_" + Hotto[1];
                int resid2 = getResources().getIdentifier(res2, "drawable", getPackageName());
                Lotto_num2.setImageResource(resid2);

                String res3 = "ball_" + Hotto[2];
                int resid3 = getResources().getIdentifier(res3, "drawable", getPackageName());
                Lotto_num3.setImageResource(resid3);

                String res4 = "ball_" + Hotto[3];
                int resid4 = getResources().getIdentifier(res4, "drawable", getPackageName());
                Lotto_num4.setImageResource(resid4);

                String res5 = "ball_" + Hotto[4];
                int resid5 = getResources().getIdentifier(res5, "drawable", getPackageName());
                Lotto_num5.setImageResource(resid5);

                String res6 = "ball_" + Hotto[5];
                int resid6 = getResources().getIdentifier(res6, "drawable", getPackageName());
                Lotto_num6.setImageResource(resid6);

                txt.setText(Hotto[0] + "번♥\n" + Hotto[1] + "번♥\n" + Hotto[2] + "번♥\n" + Hotto[3] + "번♥\n"
                        + Hotto[4] + "번♥\n" + Hotto[5] + "번♥\n");
                /* 랜덤 로또 번호 생성시 스트링객체로 접근하는방법 ㅜㅜ */

            }//Onclick
        }); //랜덤버튼setOnclickListener


        //다 선택하고 유저 공 뽑기 하러 가는 화면

        intent_lotto_btn = findViewById(R.id.intent_lotto_btn);

        intent_lotto_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Hotto[0] == 0 || Hotto[1] == 0 || Hotto[2] == 0 || Hotto[3] == 0 || Hotto[4] == 0 || Hotto[5] == 0) {
                    Toast.makeText(SelectActivity.this, "행운번호를 뽑아주세요", Toast.LENGTH_SHORT).show(); //번호안뽑았을경우
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SelectActivity.this);
                    builder.setTitle("!!!WARNING!!!");
                    builder.setMessage("오늘의 행운번호\n" + Hotto[0] + "번," + Hotto[1] + "번," + Hotto[2] + "번," + Hotto[3] + "번,"
                            + Hotto[4] + "번," + Hotto[5] + "번\n" + "맞습니까?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(SelectActivity.this, "공을 뽑으러 갑니다.", Toast.LENGTH_SHORT).show();


                            it = new Intent(getApplicationContext(), UserActivity.class);
                            it.putExtra("hotto1", Hotto[0]);
                            it.putExtra("hotto2", Hotto[1]);
                            it.putExtra("hotto3", Hotto[2]);
                            it.putExtra("hotto4", Hotto[3]);
                            it.putExtra("hotto5", Hotto[4]);
                            it.putExtra("hotto6", Hotto[5]);

                            //행운 번호 가지고 넘어가기
                            startActivity(it);
                            finish();
                        }
                    }); //긍정화면

                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(SelectActivity.this, "돌아갑니다.", Toast.LENGTH_SHORT).show();
                        }
                    }); //부정화면

                    AlertDialog alert = builder.create();
                    alert.show(); //다이얼로그 보여주기

                }
            }
        }); //button


    }//onCreate


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