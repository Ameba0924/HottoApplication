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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import static android.view.View.VISIBLE;

public class InfoActivity extends Activity {


    Intent bonusit;
    int userball[] = new int[6];
    String uinfo[] = new String[45];
    String b1info[] = new String[3];
    String b2info[] = new String[3];
    String b3info[] = new String[3];
    String b4info[] = new String[3];
    String b5info;
    String b6info;
    int viewlay;     //저장변수
    String viewlay1; //저장변수
    Intent it;
    int bonus;
    ImageView backrainImg;
    ImageView infoball1, infoball2, infoball3, infoball4, infoball5, infoball6;
    ImageView star1, star2, star3, star4, star5, star6;
    ImageView user_img_1, user_img_2, user_img_3, user_img_4, user_img_5, user_img_6;
    ImageView info23, actor;
    LinearLayout userlay1, userlay2, userlay3, userlay4, userlay5, userlay6;
    LinearLayout bonuslay1, bonuslay2, bonuslay3, bonuslay4, bonuslay5, bonuslay6;
    LinearLayout starlay, firstlay;
    TextView bonustxt;
    ScrollView scv;
    TextView infotxt1, infotxt2, infotxt3, infotxt4, infotxt5, infotxt6;
    TextView bonustxt1, bonustxt2, bonustxt3, bonustxt4, bonustxt5, bonustxt6;
    Button infobtn1, infobtn2, infobtn3, infobtn4, infobtn5, infobtn6;
    Button bonusbtn1, bonusbtn2, bonusbtn3, bonusbtn4, bonusbtn5, bonusbtn6;
    LinearLayout infolay1, infolay2, infolay3, infolay4, infolay5, infolay6, infolay7, infolay8, infolay9, infolay10;
    LinearLayout infolay11, infolay12, infolay13, infolay14, infolay15, infolay16, infolay17, infolay18, infolay19, infolay20;
    LinearLayout infolay21, infolay22, infolay23, infolay24, infolay25, infolay26, infolay27, infolay28, infolay29, infolay30;
    LinearLayout infolay31, infolay32, infolay33, infolay34, infolay35, infolay36, infolay37, infolay38, infolay39, infolay40;
    LinearLayout infolay41, infolay42, infolay43, infolay44, infolay45;
    Button backbtn1, backbtn2, backbtn3, backbtn4, backbtn5, backbtn6, backbtn7, backbtn8, backbtn9, backbtn10;
    Button backbtn11, backbtn12, backbtn13, backbtn14, backbtn15, backbtn16, backbtn17, backbtn18, backbtn19, backbtn20;
    Button backbtn21, backbtn22, backbtn23, backbtn24, backbtn25, backbtn26, backbtn27, backbtn28, backbtn29, backbtn30;
    Button backbtn31, backbtn32, backbtn33, backbtn34, backbtn35, backbtn36, backbtn37, backbtn38, backbtn39, backbtn40;
    Button backbtn41, backbtn42, backbtn43, backbtn44, backbtn45;
    int b1 = (int) (Math.random() * 3);
    int b2 = (int) (Math.random() * 3);
    int b3 = (int) (Math.random() * 3);
    int b4 = (int) (Math.random() * 3);
    EndingCloseHandler endingCloseHandler;


    private static MediaPlayer infomp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        endingCloseHandler = new EndingCloseHandler(this);

        infomp = MediaPlayer.create(this, R.raw.cherry);
        infomp.setLooping(true);
        infomp.start();

        it = getIntent();
        userball[0] = it.getIntExtra("userball1", -1);
        userball[1] = it.getIntExtra("userball2", -1);
        userball[2] = it.getIntExtra("userball3", -1);
        userball[3] = it.getIntExtra("userball4", -1);
        userball[4] = it.getIntExtra("userball5", -1);
        userball[5] = it.getIntExtra("userball6", -1);
        bonus = it.getIntExtra("bonusnum", -1);
        //인텐트 값 받아오기

        backrainImg = findViewById(R.id.backrainImg);

        info23 = findViewById(R.id.info23);
        actor = findViewById(R.id.actor);

        GlideDrawableImageViewTarget gifImage_rain = new GlideDrawableImageViewTarget(backrainImg);
        Glide.with(getApplicationContext()).load(R.drawable.heartrain).into(gifImage_rain);
        //보상배경화면 화려하게 gif효과 주기

        GlideDrawableImageViewTarget gifImage_info23 = new GlideDrawableImageViewTarget(info23);
        Glide.with(getApplicationContext()).load(R.drawable.info23).into(gifImage_info23); //김치찌게 gif

        GlideDrawableImageViewTarget gifImage_actor = new GlideDrawableImageViewTarget(actor);
        Glide.with(getApplicationContext()).load(R.drawable.actor).into(gifImage_actor); //에밀리아클라크 gif


        infoball1 = findViewById(R.id.infoball1);
        infoball2 = findViewById(R.id.infoball2);
        infoball3 = findViewById(R.id.infoball3);
        infoball4 = findViewById(R.id.infoball4);
        infoball5 = findViewById(R.id.infoball5);
        infoball6 = findViewById(R.id.infoball6);

        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        star4 = findViewById(R.id.star4);
        star5 = findViewById(R.id.star5);
        star6 = findViewById(R.id.star6);

        bonustxt = findViewById(R.id.bonustxt);

        starlay = findViewById(R.id.starlay);
        firstlay = findViewById(R.id.firstlay);

        scv = findViewById(R.id.scv);

        //상세정보 layout
        userlay1 = findViewById(R.id.userlay1);
        userlay4 = findViewById(R.id.userlay4);
        userlay2 = findViewById(R.id.userlay2);
        userlay5 = findViewById(R.id.userlay5);
        userlay3 = findViewById(R.id.userlay3);
        userlay6 = findViewById(R.id.userlay6);

        Animation twinkle_anim = AnimationUtils.loadAnimation(this, R.anim.fadeanim);
        starlay.setAnimation(twinkle_anim);

        user_img_1 = findViewById(R.id.user_Img_1);
        user_img_2 = findViewById(R.id.user_img_2);
        user_img_3 = findViewById(R.id.user_img_3);
        user_img_4 = findViewById(R.id.user_img_4);
        user_img_5 = findViewById(R.id.user_img_5);
        user_img_6 = findViewById(R.id.user_img_6);

        infotxt1 = findViewById(R.id.infotxt1);
        infotxt2 = findViewById(R.id.infotxt2);
        infotxt3 = findViewById(R.id.infotxt3);
        infotxt4 = findViewById(R.id.infotxt4);
        infotxt5 = findViewById(R.id.infotxt5);
        infotxt6 = findViewById(R.id.infotxt6);

        bonustxt1 = findViewById(R.id.bonustxt1);
        bonustxt2 = findViewById(R.id.bonustxt2);
        bonustxt3 = findViewById(R.id.bonustxt3);
        bonustxt4 = findViewById(R.id.bonustxt4);
        bonustxt5 = findViewById(R.id.bonustxt5);
        bonustxt6 = findViewById(R.id.bonustxt6);

        bonuslay1 = findViewById(R.id.bonuslay1);
        bonuslay2 = findViewById(R.id.bonuslay2);
        bonuslay3 = findViewById(R.id.bonuslay3);
        bonuslay4 = findViewById(R.id.bonuslay4);
        bonuslay5 = findViewById(R.id.bonuslay5);
        bonuslay6 = findViewById(R.id.bonuslay6);

        infobtn1 = findViewById(R.id.infobtn1);
        infobtn2 = findViewById(R.id.infobtn2);
        infobtn3 = findViewById(R.id.infobtn3);
        infobtn4 = findViewById(R.id.infobtn4);
        infobtn5 = findViewById(R.id.infobtn5);
        infobtn6 = findViewById(R.id.infobtn6);

        bonusbtn1 = findViewById(R.id.bonusbtn1);
        bonusbtn2 = findViewById(R.id.bonusbtn2);
        bonusbtn3 = findViewById(R.id.bonusbtn3);
        bonusbtn4 = findViewById(R.id.bonusbtn4);
        bonusbtn5 = findViewById(R.id.bonusbtn5);
        bonusbtn6 = findViewById(R.id.bonusbtn6);


        //정보 보여주기위한 화면객체생성


        infolay1 = findViewById(R.id.infolay1);
        infolay2 = findViewById(R.id.infolay2);
        infolay3 = findViewById(R.id.infolay3);
        infolay4 = findViewById(R.id.infolay4);
        infolay5 = findViewById(R.id.infolay5);
        infolay6 = findViewById(R.id.infolay6);
        infolay7 = findViewById(R.id.infolay7);
        infolay8 = findViewById(R.id.infolay8);
        infolay9 = findViewById(R.id.infolay9);
        infolay10 = findViewById(R.id.infolay10);
        infolay11 = findViewById(R.id.infolay11);
        infolay12 = findViewById(R.id.infolay12);
        infolay13 = findViewById(R.id.infolay13);
        infolay14 = findViewById(R.id.infolay14);
        infolay15 = findViewById(R.id.infolay15);
        infolay16 = findViewById(R.id.infolay16);
        infolay17 = findViewById(R.id.infolay17);
        infolay18 = findViewById(R.id.infolay18);
        infolay19 = findViewById(R.id.infolay19);
        infolay20 = findViewById(R.id.infolay20);
        infolay21 = findViewById(R.id.infolay21);
        infolay22 = findViewById(R.id.infolay22);
        infolay23 = findViewById(R.id.infolay23);
        infolay24 = findViewById(R.id.infolay24);
        infolay25 = findViewById(R.id.infolay25);
        infolay26 = findViewById(R.id.infolay26);
        infolay27 = findViewById(R.id.infolay27);
        infolay28 = findViewById(R.id.infolay28);
        infolay29 = findViewById(R.id.infolay29);
        infolay30 = findViewById(R.id.infolay30);
        infolay31 = findViewById(R.id.infolay31);
        infolay32 = findViewById(R.id.infolay32);
        infolay33 = findViewById(R.id.infolay33);
        infolay34 = findViewById(R.id.infolay34);
        infolay35 = findViewById(R.id.infolay35);
        infolay36 = findViewById(R.id.infolay36);
        infolay37 = findViewById(R.id.infolay37);
        infolay38 = findViewById(R.id.infolay38);
        infolay39 = findViewById(R.id.infolay39);
        infolay40 = findViewById(R.id.infolay40);
        infolay41 = findViewById(R.id.infolay41);
        infolay42 = findViewById(R.id.infolay42);
        infolay43 = findViewById(R.id.infolay43);
        infolay44 = findViewById(R.id.infolay44);
        infolay45 = findViewById(R.id.infolay45);
        //정보 담겨있는 레이아웃 설정완료

        backbtn1 = findViewById(R.id.backbtn1);
        backbtn2 = findViewById(R.id.backbtn2);
        backbtn3 = findViewById(R.id.backbtn3);
        backbtn4 = findViewById(R.id.backbtn4);
        backbtn5 = findViewById(R.id.backbtn5);
        backbtn6 = findViewById(R.id.backbtn6);
        backbtn7 = findViewById(R.id.backbtn7);
        backbtn8 = findViewById(R.id.backbtn8);
        backbtn9 = findViewById(R.id.backbtn9);
        backbtn10 = findViewById(R.id.backbtn10);
        backbtn11 = findViewById(R.id.backbtn11);
        backbtn12 = findViewById(R.id.backbtn12);
        backbtn13 = findViewById(R.id.backbtn13);
        backbtn14 = findViewById(R.id.backbtn14);
        backbtn15 = findViewById(R.id.backbtn15);
        backbtn16 = findViewById(R.id.backbtn16);
        backbtn17 = findViewById(R.id.backbtn17);
        backbtn18 = findViewById(R.id.backbtn18);
        backbtn19 = findViewById(R.id.backbtn19);
        backbtn20 = findViewById(R.id.backbtn20);
        backbtn21 = findViewById(R.id.backbtn21);
        backbtn22 = findViewById(R.id.backbtn22);
        backbtn23 = findViewById(R.id.backbtn23);
        backbtn24 = findViewById(R.id.backbtn24);
        backbtn25 = findViewById(R.id.backbtn25);
        backbtn26 = findViewById(R.id.backbtn26);
        backbtn27 = findViewById(R.id.backbtn27);
        backbtn28 = findViewById(R.id.backbtn28);
        backbtn29 = findViewById(R.id.backbtn29);
        backbtn30 = findViewById(R.id.backbtn30);
        backbtn31 = findViewById(R.id.backbtn31);
        backbtn32 = findViewById(R.id.backbtn32);
        backbtn33 = findViewById(R.id.backbtn33);
        backbtn34 = findViewById(R.id.backbtn34);
        backbtn35 = findViewById(R.id.backbtn35);
        backbtn36 = findViewById(R.id.backbtn36);
        backbtn37 = findViewById(R.id.backbtn37);
        backbtn38 = findViewById(R.id.backbtn38);
        backbtn39 = findViewById(R.id.backbtn39);
        backbtn40 = findViewById(R.id.backbtn40);
        backbtn41 = findViewById(R.id.backbtn41);
        backbtn42 = findViewById(R.id.backbtn42);
        backbtn43 = findViewById(R.id.backbtn43);
        backbtn44 = findViewById(R.id.backbtn44);
        backbtn45 = findViewById(R.id.backbtn45);
        //버튼 객체 생성 완료


        //
        //1.유저공번호 이미지객체 뿌려주기
        String ub1 = "ball_" + userball[0];
        int ubid1 = getResources().getIdentifier(ub1, "drawable", getPackageName());
        infoball1.setImageResource(ubid1);
        user_img_1.setImageResource(ubid1);//밑에 보상정보 이미지 띄우기

        String ub2 = "ball_" + userball[1];
        int ubid2 = getResources().getIdentifier(ub2, "drawable", getPackageName());
        infoball2.setImageResource(ubid2);
        user_img_2.setImageResource(ubid2);

        String ub3 = "ball_" + userball[2];
        int ubid3 = getResources().getIdentifier(ub3, "drawable", getPackageName());
        infoball3.setImageResource(ubid3);
        user_img_3.setImageResource(ubid3);

        String ub4 = "ball_" + userball[3];
        int ubid4 = getResources().getIdentifier(ub4, "drawable", getPackageName());
        infoball4.setImageResource(ubid4);
        user_img_4.setImageResource(ubid4);

        String ub5 = "ball_" + userball[4];
        int ubid5 = getResources().getIdentifier(ub5, "drawable", getPackageName());
        infoball5.setImageResource(ubid5);
        user_img_5.setImageResource(ubid5);

        String ub6 = "ball_" + userball[5];
        int ubid6 = getResources().getIdentifier(ub6, "drawable", getPackageName());
        infoball6.setImageResource(ubid6);
        user_img_6.setImageResource(ubid6);

        //2.보너스 번호 개수에 따라서 보여주는 보너스별설정

        switch (bonus) {
            case 1:
                star1.setVisibility(VISIBLE);
                break;
            case 2:
                star1.setVisibility(VISIBLE);
                star2.setVisibility(VISIBLE);
                break;
            case 3:
                star1.setVisibility(VISIBLE);
                star2.setVisibility(VISIBLE);
                star3.setVisibility(VISIBLE);
                break;
            case 4:
                star1.setVisibility(VISIBLE);
                star2.setVisibility(VISIBLE);
                star3.setVisibility(VISIBLE);
                star4.setVisibility(VISIBLE);
                break;
            case 5:
                star1.setVisibility(VISIBLE);
                star2.setVisibility(VISIBLE);
                star3.setVisibility(VISIBLE);
                star4.setVisibility(VISIBLE);
                star5.setVisibility(VISIBLE);
                break;
            case 6:
                star1.setVisibility(VISIBLE);
                star2.setVisibility(VISIBLE);
                star3.setVisibility(VISIBLE);
                star4.setVisibility(VISIBLE);
                star5.setVisibility(VISIBLE);
                star6.setVisibility(VISIBLE);
                break;
            default:
                bonustxt.setVisibility(VISIBLE);
        }//switch

        //3.이제 공에 대한 정보 알려줍시다.
        switch (userball[0]) {  //첫번째 공이 1~45번 이면
            case 1:
                infotxt1.setText("태어난곳");
                break;
            case 2:
                infotxt1.setText("이름");
                break;
            case 3:
                infotxt1.setText("나이");
                break;
            case 4:
                infotxt1.setText("내가다닌초등학교");
                break;
            case 5:
                infotxt1.setText("내가다닌중학교");
                break;
            case 6:
                infotxt1.setText("내가다닌고등학교");
                break;
            case 7:
                infotxt1.setText("내가다닌대학교");
                break;
            case 8:
                infotxt1.setText("전공");
                break;
            case 9:
                infotxt1.setText("성별");
                break;
            case 10:
                infotxt1.setText("내 현재사진");
                break;
            case 11:
                infotxt1.setText("고등학교시절 사진");
                break;
            case 12:
                infotxt1.setText("중학교시절 사진");
                break;
            case 13:
                infotxt1.setText("생일");
                break;
            case 14:
                infotxt1.setText("내 instagram 아이디");
                break;
            case 15:
                infotxt1.setText("내 facebook 아이디");
                break;
            case 16:
                infotxt1.setText("내 전화번호");
                break;
            case 17:
                infotxt1.setText("2학년 1학기 자바성적");
                break;
            case 18:
                infotxt1.setText("2학년 1학기 C언어성적");
                break;
            case 19:
                infotxt1.setText("2학년 1학기 UI/UX성적");
                break;
            case 20:
                infotxt1.setText("2학년 1학기 아두이노성적");
                break;
            case 21:
                infotxt1.setText("2학년 1학기 안드로이드성적");
                break;
            case 22:
                infotxt1.setText("현재 학점평균");
                break;
            case 23:
                infotxt1.setText("내가제일좋아하는음식");
                break;
            case 24:
                infotxt1.setText("내가제일싫어하는음식");
                break;
            case 25:
                infotxt1.setText("내가 자주입는 옷 브랜드");
                break;
            case 26:
                infotxt1.setText("내가 자주신는 신발 브랜드");
                break;
            case 27:
                infotxt1.setText("내가제일 좋아하는 전공과목");
                break;
            case 28:
                infotxt1.setText("내가제일 싫어하는 전공과목");
                break;
            case 29:
                infotxt1.setText("내 노트북 브랜드");
                break;
            case 30:
                infotxt1.setText("내가좋아하는영화장르");
                break;
            case 31:
                infotxt1.setText("내가싫어하는영화장르");
                break;
            case 32:
                infotxt1.setText("인상깊게본영화");
                break;
            case 33:
                infotxt1.setText("제일재미없었던영화");
                break;
            case 34:
                infotxt1.setText("가장좋아하는가수");
                break;
            case 35:
                infotxt1.setText("가장종아하는영화배우");
                break;
            case 36:
                infotxt1.setText("내핸드폰기종");
                break;
            case 37:
                infotxt1.setText("내가좋아하는숫자");
                break;
            case 38:
                infotxt1.setText("내가싫어하는숫자");
                break;
            case 39:
                infotxt1.setText("이상형");
                break;
            case 40:
                infotxt1.setText("목표");
                break;
            case 41:
                infotxt1.setText("별자리");
                break;
            case 42:
                infotxt1.setText("혈액형");
                break;
            case 43:
                infotxt1.setText("내가나온부대");
                break;
            case 44:
                infotxt1.setText("내가좋아하는축구선수");
                break;
            case 45:
                infotxt1.setText("내가좋아하는게임장르");
                break;
        }
        switch (userball[1]) {  //첫번째 공이 1~45번 이면
            case 1:
                infotxt2.setText("태어난곳");
                break;
            case 2:
                infotxt2.setText("이름");
                break;
            case 3:
                infotxt2.setText("나이");
                break;
            case 4:
                infotxt2.setText("내가다닌초등학교");
                break;
            case 5:
                infotxt2.setText("내가다닌중학교");
                break;
            case 6:
                infotxt2.setText("내가다닌고등학교");
                break;
            case 7:
                infotxt2.setText("내가다닌대학교");
                break;
            case 8:
                infotxt2.setText("전공");
                break;
            case 9:
                infotxt2.setText("성별");
                break;
            case 10:
                infotxt2.setText("내 현재사진");
                break;
            case 11:
                infotxt2.setText("고등학교시절 사진");
                break;
            case 12:
                infotxt2.setText("중학교시절 사진");
                break;
            case 13:
                infotxt2.setText("생일");
                break;
            case 14:
                infotxt2.setText("내 instagram 아이디");
                break;
            case 15:
                infotxt2.setText("내 facebook 아이디");
                break;
            case 16:
                infotxt2.setText("내 전화번호");
                break;
            case 17:
                infotxt2.setText("2학년 1학기 자바성적");
                break;
            case 18:
                infotxt2.setText("2학년 1학기 C언어성적");
                break;
            case 19:
                infotxt2.setText("2학년 1학기 UI/UX성적");
                break;
            case 20:
                infotxt2.setText("2학년 1학기 아두이노성적");
                break;
            case 21:
                infotxt2.setText("2학년 1학기 안드로이드성적");
                break;
            case 22:
                infotxt2.setText("현재 학점평균");
                break;
            case 23:
                infotxt2.setText("내가제일좋아하는음식");
                break;
            case 24:
                infotxt2.setText("내가제일싫어하는음식");
                break;
            case 25:
                infotxt2.setText("내가 자주입는 옷 브랜드");
                break;
            case 26:
                infotxt2.setText("내가 자주신는 신발 브랜드");
                break;
            case 27:
                infotxt2.setText("내가제일 좋아하는 전공과목");
                break;
            case 28:
                infotxt2.setText("내가제일 싫어하는 전공과목");
                break;
            case 29:
                infotxt2.setText("내 노트북 브랜드");
                break;
            case 30:
                infotxt2.setText("내가좋아하는영화장르");
                break;
            case 31:
                infotxt2.setText("내가싫어하는영화장르");
                break;
            case 32:
                infotxt2.setText("인상깊게본영화");
                break;
            case 33:
                infotxt2.setText("제일재미없었던영화");
                break;
            case 34:
                infotxt2.setText("가장좋아하는가수");
                break;
            case 35:
                infotxt2.setText("가장종아하는영화배우");
                break;
            case 36:
                infotxt2.setText("내핸드폰기종");
                break;
            case 37:
                infotxt2.setText("내가좋아하는숫자");
                break;
            case 38:
                infotxt2.setText("내가싫어하는숫자");
                break;
            case 39:
                infotxt2.setText("이상형");
                break;
            case 40:
                infotxt2.setText("목표");
                break;
            case 41:
                infotxt2.setText("별자리");
                break;
            case 42:
                infotxt2.setText("혈액형");
                break;
            case 43:
                infotxt2.setText("내가나온부대");
                break;
            case 44:
                infotxt2.setText("내가좋아하는축구선수");
                break;
            case 45:
                infotxt2.setText("내가좋아하는게임장르");
                break;
        }
        switch (userball[2]) {  //첫번째 공이 1~45번 이면
            case 1:
                infotxt3.setText("태어난곳");
                break;
            case 2:
                infotxt3.setText("이름");
                break;
            case 3:
                infotxt3.setText("나이");
                break;
            case 4:
                infotxt3.setText("내가다닌초등학교");
                break;
            case 5:
                infotxt3.setText("내가다닌중학교");
                break;
            case 6:
                infotxt3.setText("내가다닌고등학교");
                break;
            case 7:
                infotxt3.setText("내가다닌대학교");
                break;
            case 8:
                infotxt3.setText("전공");
                break;
            case 9:
                infotxt3.setText("성별");
                break;
            case 10:
                infotxt3.setText("내 현재사진");
                break;
            case 11:
                infotxt3.setText("고등학교시절 사진");
                break;
            case 12:
                infotxt3.setText("중학교시절 사진");
                break;
            case 13:
                infotxt3.setText("생일");
                break;
            case 14:
                infotxt3.setText("내 instagram 아이디");
                break;
            case 15:
                infotxt3.setText("내 facebook 아이디");
                break;
            case 16:
                infotxt3.setText("내 전화번호");
                break;
            case 17:
                infotxt3.setText("2학년 1학기 자바성적");
                break;
            case 18:
                infotxt3.setText("2학년 1학기 C언어성적");
                break;
            case 19:
                infotxt3.setText("2학년 1학기 UI/UX성적");
                break;
            case 20:
                infotxt3.setText("2학년 1학기 아두이노성적");
                break;
            case 21:
                infotxt3.setText("2학년 1학기 안드로이드성적");
                break;
            case 22:
                infotxt3.setText("현재 학점평균");
                break;
            case 23:
                infotxt3.setText("내가제일좋아하는음식");
                break;
            case 24:
                infotxt3.setText("내가제일싫어하는음식");
                break;
            case 25:
                infotxt3.setText("내가 자주입는 옷 브랜드");
                break;
            case 26:
                infotxt3.setText("내가 자주신는 신발 브랜드");
                break;
            case 27:
                infotxt3.setText("내가제일 좋아하는 전공과목");
                break;
            case 28:
                infotxt3.setText("내가제일 싫어하는 전공과목");
                break;
            case 29:
                infotxt3.setText("내 노트북 브랜드");
                break;
            case 30:
                infotxt3.setText("내가좋아하는영화장르");
                break;
            case 31:
                infotxt3.setText("내가싫어하는영화장르");
                break;
            case 32:
                infotxt3.setText("인상깊게본영화");
                break;
            case 33:
                infotxt3.setText("제일재미없었던영화");
                break;
            case 34:
                infotxt3.setText("가장좋아하는가수");
                break;
            case 35:
                infotxt3.setText("가장종아하는영화배우");
                break;
            case 36:
                infotxt3.setText("내핸드폰기종");
                break;
            case 37:
                infotxt3.setText("내가좋아하는숫자");
                break;
            case 38:
                infotxt3.setText("내가싫어하는숫자");
                break;
            case 39:
                infotxt3.setText("이상형");
                break;
            case 40:
                infotxt3.setText("목표");
                break;
            case 41:
                infotxt3.setText("별자리");
                break;
            case 42:
                infotxt3.setText("혈액형");
                break;
            case 43:
                infotxt3.setText("내가나온부대");
                break;
            case 44:
                infotxt3.setText("내가좋아하는축구선수");
                break;
            case 45:
                infotxt3.setText("내가좋아하는게임장르");
                break;
        }
        switch (userball[3]) {  //첫번째 공이 1~45번 이면
            case 1:
                infotxt4.setText("태어난곳");
                break;
            case 2:
                infotxt4.setText("이름");
                break;
            case 3:
                infotxt4.setText("나이");
                break;
            case 4:
                infotxt4.setText("내가다닌초등학교");
                break;
            case 5:
                infotxt4.setText("내가다닌중학교");
                break;
            case 6:
                infotxt4.setText("내가다닌고등학교");
                break;
            case 7:
                infotxt4.setText("내가다닌대학교");
                break;
            case 8:
                infotxt4.setText("전공");
                break;
            case 9:
                infotxt4.setText("성별");
                break;
            case 10:
                infotxt4.setText("내 현재사진");
                break;
            case 11:
                infotxt4.setText("고등학교시절 사진");
                break;
            case 12:
                infotxt4.setText("중학교시절 사진");
                break;
            case 13:
                infotxt4.setText("생일");
                break;
            case 14:
                infotxt4.setText("내 instagram 아이디");
                break;
            case 15:
                infotxt4.setText("내 facebook 아이디");
                break;
            case 16:
                infotxt4.setText("내 전화번호");
                break;
            case 17:
                infotxt4.setText("2학년 1학기 자바성적");
                break;
            case 18:
                infotxt4.setText("2학년 1학기 C언어성적");
                break;
            case 19:
                infotxt4.setText("2학년 1학기 UI/UX성적");
                break;
            case 20:
                infotxt4.setText("2학년 1학기 아두이노성적");
                break;
            case 21:
                infotxt4.setText("2학년 1학기 안드로이드성적");
                break;
            case 22:
                infotxt4.setText("현재 학점평균");
                break;
            case 23:
                infotxt4.setText("내가제일좋아하는음식");
                break;
            case 24:
                infotxt4.setText("내가제일싫어하는음식");
                break;
            case 25:
                infotxt4.setText("내가 자주입는 옷 브랜드");
                break;
            case 26:
                infotxt4.setText("내가 자주신는 신발 브랜드");
                break;
            case 27:
                infotxt4.setText("내가제일 좋아하는 전공과목");
                break;
            case 28:
                infotxt4.setText("내가제일 싫어하는 전공과목");
                break;
            case 29:
                infotxt4.setText("내 노트북 브랜드");
                break;
            case 30:
                infotxt4.setText("내가좋아하는영화장르");
                break;
            case 31:
                infotxt4.setText("내가싫어하는영화장르");
                break;
            case 32:
                infotxt4.setText("인상깊게본영화");
                break;
            case 33:
                infotxt4.setText("제일재미없었던영화");
                break;
            case 34:
                infotxt4.setText("가장좋아하는가수");
                break;
            case 35:
                infotxt4.setText("가장종아하는영화배우");
                break;
            case 36:
                infotxt4.setText("내핸드폰기종");
                break;
            case 37:
                infotxt4.setText("내가좋아하는숫자");
                break;
            case 38:
                infotxt4.setText("내가싫어하는숫자");
                break;
            case 39:
                infotxt4.setText("이상형");
                break;
            case 40:
                infotxt4.setText("목표");
                break;
            case 41:
                infotxt4.setText("별자리");
                break;
            case 42:
                infotxt4.setText("혈액형");
                break;
            case 43:
                infotxt4.setText("내가나온부대");
                break;
            case 44:
                infotxt4.setText("내가좋아하는축구선수");
                break;
            case 45:
                infotxt4.setText("내가좋아하는게임장르");
                break;
        }
        switch (userball[4]) {  //첫번째 공이 1~45번 이면
            case 1:
                infotxt5.setText("태어난곳");
                break;
            case 2:
                infotxt5.setText("이름");
                break;
            case 3:
                infotxt5.setText("나이");
                break;
            case 4:
                infotxt5.setText("내가다닌초등학교");
                break;
            case 5:
                infotxt5.setText("내가다닌중학교");
                break;
            case 6:
                infotxt5.setText("내가다닌고등학교");
                break;
            case 7:
                infotxt5.setText("내가다닌대학교");
                break;
            case 8:
                infotxt5.setText("전공");
                break;
            case 9:
                infotxt5.setText("성별");
                break;
            case 10:
                infotxt5.setText("내 현재사진");
                break;
            case 11:
                infotxt5.setText("고등학교시절 사진");
                break;
            case 12:
                infotxt5.setText("중학교시절 사진");
                break;
            case 13:
                infotxt5.setText("생일");
                break;
            case 14:
                infotxt5.setText("내 instagram 아이디");
                break;
            case 15:
                infotxt5.setText("내 facebook 아이디");
                break;
            case 16:
                infotxt5.setText("내 전화번호");
                break;
            case 17:
                infotxt5.setText("2학년 1학기 자바성적");
                break;
            case 18:
                infotxt5.setText("2학년 1학기 C언어성적");
                break;
            case 19:
                infotxt5.setText("2학년 1학기 UI/UX성적");
                break;
            case 20:
                infotxt5.setText("2학년 1학기 아두이노성적");
                break;
            case 21:
                infotxt5.setText("2학년 1학기 안드로이드성적");
                break;
            case 22:
                infotxt5.setText("현재 학점평균");
                break;
            case 23:
                infotxt5.setText("내가제일좋아하는음식");
                break;
            case 24:
                infotxt5.setText("내가제일싫어하는음식");
                break;
            case 25:
                infotxt5.setText("내가 자주입는 옷 브랜드");
                break;
            case 26:
                infotxt5.setText("내가 자주신는 신발 브랜드");
                break;
            case 27:
                infotxt5.setText("내가제일 좋아하는 전공과목");
                break;
            case 28:
                infotxt5.setText("내가제일 싫어하는 전공과목");
                break;
            case 29:
                infotxt5.setText("내 노트북 브랜드");
                break;
            case 30:
                infotxt5.setText("내가좋아하는영화장르");
                break;
            case 31:
                infotxt5.setText("내가싫어하는영화장르");
                break;
            case 32:
                infotxt5.setText("인상깊게본영화");
                break;
            case 33:
                infotxt5.setText("제일재미없었던영화");
                break;
            case 34:
                infotxt5.setText("가장좋아하는가수");
                break;
            case 35:
                infotxt5.setText("가장종아하는영화배우");
                break;
            case 36:
                infotxt5.setText("내핸드폰기종");
                break;
            case 37:
                infotxt5.setText("내가좋아하는숫자");
                break;
            case 38:
                infotxt5.setText("내가싫어하는숫자");
                break;
            case 39:
                infotxt5.setText("이상형");
                break;
            case 40:
                infotxt5.setText("목표");
                break;
            case 41:
                infotxt5.setText("별자리");
                break;
            case 42:
                infotxt5.setText("혈액형");
                break;
            case 43:
                infotxt5.setText("내가나온부대");
                break;
            case 44:
                infotxt5.setText("내가좋아하는축구선수");
                break;
            case 45:
                infotxt5.setText("내가좋아하는게임장르");
                break;
        }
        switch (userball[5]) {  //첫번째 공이 1~45번 이면
            case 1:
                infotxt6.setText("태어난곳");
                break;
            case 2:
                infotxt6.setText("이름");
                break;
            case 3:
                infotxt6.setText("나이");
                break;
            case 4:
                infotxt6.setText("내가다닌초등학교");
                break;
            case 5:
                infotxt6.setText("내가다닌중학교");
                break;
            case 6:
                infotxt6.setText("내가다닌고등학교");
                break;
            case 7:
                infotxt6.setText("내가다닌대학교");
                break;
            case 8:
                infotxt6.setText("전공");
                break;
            case 9:
                infotxt6.setText("성별");
                break;
            case 10:
                infotxt6.setText("내 현재사진");
                break;
            case 11:
                infotxt6.setText("고등학교시절 사진");
                break;
            case 12:
                infotxt6.setText("중학교시절 사진");
                break;
            case 13:
                infotxt6.setText("생일");
                break;
            case 14:
                infotxt6.setText("내 instagram 아이디");
                break;
            case 15:
                infotxt6.setText("내 facebook 아이디");
                break;
            case 16:
                infotxt6.setText("내 전화번호");
                break;
            case 17:
                infotxt6.setText("2학년 1학기 자바성적");
                break;
            case 18:
                infotxt6.setText("2학년 1학기 C언어성적");
                break;
            case 19:
                infotxt6.setText("2학년 1학기 UI/UX성적");
                break;
            case 20:
                infotxt6.setText("2학년 1학기 아두이노성적");
                break;
            case 21:
                infotxt6.setText("2학년 1학기 안드로이드성적");
                break;
            case 22:
                infotxt6.setText("현재 학점평균");
                break;
            case 23:
                infotxt6.setText("내가제일좋아하는음식");
                break;
            case 24:
                infotxt6.setText("내가제일싫어하는음식");
                break;
            case 25:
                infotxt6.setText("내가 자주입는 옷 브랜드");
                break;
            case 26:
                infotxt6.setText("내가 자주신는 신발 브랜드");
                break;
            case 27:
                infotxt6.setText("내가제일 좋아하는 전공과목");
                break;
            case 28:
                infotxt6.setText("내가제일 싫어하는 전공과목");
                break;
            case 29:
                infotxt6.setText("내 노트북 브랜드");
                break;
            case 30:
                infotxt6.setText("내가좋아하는영화장르");
                break;
            case 31:
                infotxt6.setText("내가싫어하는영화장르");
                break;
            case 32:
                infotxt6.setText("인상깊게본영화");
                break;
            case 33:
                infotxt6.setText("제일재미없었던영화");
                break;
            case 34:
                infotxt6.setText("가장좋아하는가수");
                break;
            case 35:
                infotxt6.setText("가장종아하는영화배우");
                break;
            case 36:
                infotxt6.setText("내핸드폰기종");
                break;
            case 37:
                infotxt6.setText("내가좋아하는숫자");
                break;
            case 38:
                infotxt6.setText("내가싫어하는숫자");
                break;
            case 39:
                infotxt6.setText("이상형");
                break;
            case 40:
                infotxt6.setText("목표");
                break;
            case 41:
                infotxt6.setText("별자리");
                break;
            case 42:
                infotxt6.setText("혈액형");
                break;
            case 43:
                infotxt6.setText("내가나온부대");
                break;
            case 44:
                infotxt6.setText("내가좋아하는축구선수");
                break;
            case 45:
                infotxt6.setText("내가좋아하는게임장르");
                break;
        }
        //공번호에따라서 텍스트 띄워주기 설정 끝


        //4.보너스번호개수에따라서 보너스보상뷰 설정하기.ㅎㅎ (랜덤보상설정)

        //일단 배열에 보너스 값 넣기

        b1info[0] = "우리집주소";
        b1info[1] = "내계좌번호";
        b1info[2] = "잘생긴놈번호";
        b2info[0] = "첫사랑이름";
        b2info[1] = "첫사랑을만난나이";
        b2info[2] = "여자친구처음사귄나이";
        b3info[0] = "내꿈";
        b3info[1] = "내계좌비밀번호앞자리";
        b3info[2] = "통장잔고";
        b4info[0] = "내컴플렉스";
        b4info[1] = "여자친구사귄횟수";
        b4info[2] = "우리반에서가장좋아하는친구";
        b5info = "엄마랑아빠중내가좋아하는사람";
        b6info = "1급기밀";

        switch (bonus) {
            case 1:
                bonuslay1.setVisibility(View.VISIBLE);
                bonustxt1.setText(b1info[b1]); //보너스질문중 랜덤으로 뿌려주귀
                break;
            case 2:
                bonuslay1.setVisibility(View.VISIBLE);
                bonuslay2.setVisibility(View.VISIBLE);
                bonustxt1.setText(b1info[b1]);
                bonustxt2.setText(b2info[b2]);
                break;

            case 3:
                bonuslay1.setVisibility(View.VISIBLE);
                bonuslay2.setVisibility(View.VISIBLE);
                bonuslay3.setVisibility(View.VISIBLE);
                bonustxt1.setText(b1info[b1]);
                bonustxt2.setText(b2info[b2]);
                bonustxt3.setText(b3info[b3]);
                break;
            case 4:
                bonuslay1.setVisibility(View.VISIBLE);
                bonuslay2.setVisibility(View.VISIBLE);
                bonuslay3.setVisibility(View.VISIBLE);
                bonuslay4.setVisibility(View.VISIBLE);
                bonustxt1.setText(b1info[b1]);
                bonustxt2.setText(b2info[b2]);
                bonustxt3.setText(b3info[b3]);
                bonustxt4.setText(b4info[b4]);
                break;
            case 5:
                bonuslay1.setVisibility(View.VISIBLE);
                bonuslay2.setVisibility(View.VISIBLE);
                bonuslay3.setVisibility(View.VISIBLE);
                bonuslay4.setVisibility(View.VISIBLE);
                bonuslay5.setVisibility(View.VISIBLE);
                bonustxt1.setText(b1info[b1]);
                bonustxt2.setText(b2info[b2]);
                bonustxt3.setText(b3info[b3]);
                bonustxt4.setText(b4info[b4]);
                bonustxt5.setText(b5info);
                break;
            case 6:
                bonuslay1.setVisibility(View.VISIBLE);
                bonuslay2.setVisibility(View.VISIBLE);
                bonuslay3.setVisibility(View.VISIBLE);
                bonuslay4.setVisibility(View.VISIBLE);
                bonuslay5.setVisibility(View.VISIBLE);
                bonuslay6.setVisibility(View.VISIBLE);
                bonustxt1.setText(b1info[b1]);
                bonustxt2.setText(b2info[b2]);
                bonustxt3.setText(b3info[b3]);
                bonustxt4.setText(b4info[b4]);
                bonustxt5.setText(b5info);
                bonustxt6.setText(b6info);
                break;
        }

        //마지막. 보기 버튼 시 정보 보여주기 !!


        infobtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (userball[0]) {

                    case 1:
                        firstlay.setVisibility(View.GONE);
                        infolay1.setVisibility(VISIBLE);
                        break;
                    case 2:
                        firstlay.setVisibility(View.GONE);
                        infolay2.setVisibility(VISIBLE);
                        break;
                    case 3:
                        firstlay.setVisibility(View.GONE);
                        infolay3.setVisibility(VISIBLE);
                        break;
                    case 4:
                        firstlay.setVisibility(View.GONE);
                        infolay4.setVisibility(VISIBLE);
                        break;
                    case 5:
                        firstlay.setVisibility(View.GONE);
                        infolay5.setVisibility(VISIBLE);
                        break;
                    case 6:
                        firstlay.setVisibility(View.GONE);
                        infolay6.setVisibility(VISIBLE);
                        break;
                    case 7:
                        firstlay.setVisibility(View.GONE);
                        infolay7.setVisibility(VISIBLE);
                        break;
                    case 8:
                        firstlay.setVisibility(View.GONE);
                        infolay8.setVisibility(VISIBLE);
                        break;
                    case 9:
                        firstlay.setVisibility(View.GONE);
                        infolay9.setVisibility(VISIBLE);
                        break;
                    case 10:
                        firstlay.setVisibility(View.GONE);
                        infolay10.setVisibility(VISIBLE);
                        break;
                    case 11:
                        firstlay.setVisibility(View.GONE);
                        infolay11.setVisibility(VISIBLE);
                        break;
                    case 12:
                        firstlay.setVisibility(View.GONE);
                        infolay12.setVisibility(VISIBLE);
                        break;
                    case 13:
                        firstlay.setVisibility(View.GONE);
                        infolay13.setVisibility(VISIBLE);
                        break;
                    case 14:
                        firstlay.setVisibility(View.GONE);
                        infolay14.setVisibility(VISIBLE);
                        break;
                    case 15:
                        firstlay.setVisibility(View.GONE);
                        infolay15.setVisibility(VISIBLE);
                        break;
                    case 16:
                        firstlay.setVisibility(View.GONE);
                        infolay16.setVisibility(VISIBLE);
                        break;
                    case 17:
                        firstlay.setVisibility(View.GONE);
                        infolay17.setVisibility(VISIBLE);
                        break;
                    case 18:
                        firstlay.setVisibility(View.GONE);
                        infolay18.setVisibility(VISIBLE);
                        break;
                    case 19:
                        firstlay.setVisibility(View.GONE);
                        infolay19.setVisibility(VISIBLE);
                        break;
                    case 20:
                        firstlay.setVisibility(View.GONE);
                        infolay20.setVisibility(VISIBLE);
                        break;
                    case 21:
                        firstlay.setVisibility(View.GONE);
                        infolay21.setVisibility(VISIBLE);
                        break;
                    case 22:
                        firstlay.setVisibility(View.GONE);
                        infolay22.setVisibility(VISIBLE);
                        break;
                    case 23:
                        firstlay.setVisibility(View.GONE);
                        infolay23.setVisibility(VISIBLE);
                        break;
                    case 24:
                        firstlay.setVisibility(View.GONE);
                        infolay24.setVisibility(VISIBLE);
                        break;
                    case 25:
                        firstlay.setVisibility(View.GONE);
                        infolay25.setVisibility(VISIBLE);
                        break;
                    case 26:
                        firstlay.setVisibility(View.GONE);
                        infolay26.setVisibility(VISIBLE);
                        break;
                    case 27:
                        firstlay.setVisibility(View.GONE);
                        infolay27.setVisibility(VISIBLE);
                        break;
                    case 28:
                        firstlay.setVisibility(View.GONE);
                        infolay28.setVisibility(VISIBLE);
                        break;
                    case 29:
                        firstlay.setVisibility(View.GONE);
                        infolay29.setVisibility(VISIBLE);
                        break;
                    case 30:
                        firstlay.setVisibility(View.GONE);
                        infolay30.setVisibility(VISIBLE);
                        break;
                    case 31:
                        firstlay.setVisibility(View.GONE);
                        infolay31.setVisibility(VISIBLE);
                        break;
                    case 32:
                        firstlay.setVisibility(View.GONE);
                        infolay32.setVisibility(VISIBLE);
                        break;
                    case 33:
                        firstlay.setVisibility(View.GONE);
                        infolay33.setVisibility(VISIBLE);
                        break;
                    case 34:
                        firstlay.setVisibility(View.GONE);
                        infolay34.setVisibility(VISIBLE);
                        break;
                    case 35:
                        firstlay.setVisibility(View.GONE);
                        infolay35.setVisibility(VISIBLE);
                        break;
                    case 36:
                        firstlay.setVisibility(View.GONE);
                        infolay36.setVisibility(VISIBLE);
                        break;
                    case 37:
                        firstlay.setVisibility(View.GONE);
                        infolay37.setVisibility(VISIBLE);
                        break;
                    case 38:
                        firstlay.setVisibility(View.GONE);
                        infolay38.setVisibility(VISIBLE);
                        break;
                    case 39:
                        firstlay.setVisibility(View.GONE);
                        infolay39.setVisibility(VISIBLE);
                        break;
                    case 40:
                        firstlay.setVisibility(View.GONE);
                        infolay40.setVisibility(VISIBLE);
                        break;
                    case 41:
                        firstlay.setVisibility(View.GONE);
                        infolay41.setVisibility(VISIBLE);
                        break;
                    case 42:
                        firstlay.setVisibility(View.GONE);
                        infolay42.setVisibility(VISIBLE);
                        break;
                    case 43:
                        firstlay.setVisibility(View.GONE);
                        infolay43.setVisibility(VISIBLE);
                        break;
                    case 44:
                        firstlay.setVisibility(View.GONE);
                        infolay44.setVisibility(VISIBLE);
                        break;
                    case 45:
                        firstlay.setVisibility(View.GONE);
                        infolay45.setVisibility(VISIBLE);
                        break;
                }

            }
        });//보기버튼활성화

        infobtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (userball[1]) {

                    case 1:
                        firstlay.setVisibility(View.GONE);
                        infolay1.setVisibility(VISIBLE);
                        break;
                    case 2:
                        firstlay.setVisibility(View.GONE);
                        infolay2.setVisibility(VISIBLE);
                        break;
                    case 3:
                        firstlay.setVisibility(View.GONE);
                        infolay3.setVisibility(VISIBLE);
                        break;
                    case 4:
                        firstlay.setVisibility(View.GONE);
                        infolay4.setVisibility(VISIBLE);
                        break;
                    case 5:
                        firstlay.setVisibility(View.GONE);
                        infolay5.setVisibility(VISIBLE);
                        break;
                    case 6:
                        firstlay.setVisibility(View.GONE);
                        infolay6.setVisibility(VISIBLE);
                        break;
                    case 7:
                        firstlay.setVisibility(View.GONE);
                        infolay7.setVisibility(VISIBLE);
                        break;
                    case 8:
                        firstlay.setVisibility(View.GONE);
                        infolay8.setVisibility(VISIBLE);
                        break;
                    case 9:
                        firstlay.setVisibility(View.GONE);
                        infolay9.setVisibility(VISIBLE);
                        break;
                    case 10:
                        firstlay.setVisibility(View.GONE);
                        infolay10.setVisibility(VISIBLE);
                        break;
                    case 11:
                        firstlay.setVisibility(View.GONE);
                        infolay11.setVisibility(VISIBLE);
                        break;
                    case 12:
                        firstlay.setVisibility(View.GONE);
                        infolay12.setVisibility(VISIBLE);
                        break;
                    case 13:
                        firstlay.setVisibility(View.GONE);
                        infolay13.setVisibility(VISIBLE);
                        break;
                    case 14:
                        firstlay.setVisibility(View.GONE);
                        infolay14.setVisibility(VISIBLE);
                        break;
                    case 15:
                        firstlay.setVisibility(View.GONE);
                        infolay15.setVisibility(VISIBLE);
                        break;
                    case 16:
                        firstlay.setVisibility(View.GONE);
                        infolay16.setVisibility(VISIBLE);
                        break;
                    case 17:
                        firstlay.setVisibility(View.GONE);
                        infolay17.setVisibility(VISIBLE);
                        break;
                    case 18:
                        firstlay.setVisibility(View.GONE);
                        infolay18.setVisibility(VISIBLE);
                        break;
                    case 19:
                        firstlay.setVisibility(View.GONE);
                        infolay19.setVisibility(VISIBLE);
                        break;
                    case 20:
                        firstlay.setVisibility(View.GONE);
                        infolay20.setVisibility(VISIBLE);
                        break;
                    case 21:
                        firstlay.setVisibility(View.GONE);
                        infolay21.setVisibility(VISIBLE);
                        break;
                    case 22:
                        firstlay.setVisibility(View.GONE);
                        infolay22.setVisibility(VISIBLE);
                        break;
                    case 23:
                        firstlay.setVisibility(View.GONE);
                        infolay23.setVisibility(VISIBLE);
                        break;
                    case 24:
                        firstlay.setVisibility(View.GONE);
                        infolay24.setVisibility(VISIBLE);
                        break;
                    case 25:
                        firstlay.setVisibility(View.GONE);
                        infolay25.setVisibility(VISIBLE);
                        break;
                    case 26:
                        firstlay.setVisibility(View.GONE);
                        infolay26.setVisibility(VISIBLE);
                        break;
                    case 27:
                        firstlay.setVisibility(View.GONE);
                        infolay27.setVisibility(VISIBLE);
                        break;
                    case 28:
                        firstlay.setVisibility(View.GONE);
                        infolay28.setVisibility(VISIBLE);
                        break;
                    case 29:
                        firstlay.setVisibility(View.GONE);
                        infolay29.setVisibility(VISIBLE);
                        break;
                    case 30:
                        firstlay.setVisibility(View.GONE);
                        infolay30.setVisibility(VISIBLE);
                        break;
                    case 31:
                        firstlay.setVisibility(View.GONE);
                        infolay31.setVisibility(VISIBLE);
                        break;
                    case 32:
                        firstlay.setVisibility(View.GONE);
                        infolay32.setVisibility(VISIBLE);
                        break;
                    case 33:
                        firstlay.setVisibility(View.GONE);
                        infolay33.setVisibility(VISIBLE);
                        break;
                    case 34:
                        firstlay.setVisibility(View.GONE);
                        infolay34.setVisibility(VISIBLE);
                        break;
                    case 35:
                        firstlay.setVisibility(View.GONE);
                        infolay35.setVisibility(VISIBLE);
                        break;
                    case 36:
                        firstlay.setVisibility(View.GONE);
                        infolay36.setVisibility(VISIBLE);
                        break;
                    case 37:
                        firstlay.setVisibility(View.GONE);
                        infolay37.setVisibility(VISIBLE);
                        break;
                    case 38:
                        firstlay.setVisibility(View.GONE);
                        infolay38.setVisibility(VISIBLE);
                        break;
                    case 39:
                        firstlay.setVisibility(View.GONE);
                        infolay39.setVisibility(VISIBLE);
                        break;
                    case 40:
                        firstlay.setVisibility(View.GONE);
                        infolay40.setVisibility(VISIBLE);
                        break;
                    case 41:
                        firstlay.setVisibility(View.GONE);
                        infolay41.setVisibility(VISIBLE);
                        break;
                    case 42:
                        firstlay.setVisibility(View.GONE);
                        infolay42.setVisibility(VISIBLE);
                        break;
                    case 43:
                        firstlay.setVisibility(View.GONE);
                        infolay43.setVisibility(VISIBLE);
                        break;
                    case 44:
                        firstlay.setVisibility(View.GONE);
                        infolay44.setVisibility(VISIBLE);
                        break;
                    case 45:
                        firstlay.setVisibility(View.GONE);
                        infolay45.setVisibility(VISIBLE);
                        break;
                }
            }
        });

        infobtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (userball[2]) {

                    case 1:
                        firstlay.setVisibility(View.GONE);
                        infolay1.setVisibility(VISIBLE);
                        break;
                    case 2:
                        firstlay.setVisibility(View.GONE);
                        infolay2.setVisibility(VISIBLE);
                        break;
                    case 3:
                        firstlay.setVisibility(View.GONE);
                        infolay3.setVisibility(VISIBLE);
                        break;
                    case 4:
                        firstlay.setVisibility(View.GONE);
                        infolay4.setVisibility(VISIBLE);
                        break;
                    case 5:
                        firstlay.setVisibility(View.GONE);
                        infolay5.setVisibility(VISIBLE);
                        break;
                    case 6:
                        firstlay.setVisibility(View.GONE);
                        infolay6.setVisibility(VISIBLE);
                        break;
                    case 7:
                        firstlay.setVisibility(View.GONE);
                        infolay7.setVisibility(VISIBLE);
                        break;
                    case 8:
                        firstlay.setVisibility(View.GONE);
                        infolay8.setVisibility(VISIBLE);
                        break;
                    case 9:
                        firstlay.setVisibility(View.GONE);
                        infolay9.setVisibility(VISIBLE);
                        break;
                    case 10:
                        firstlay.setVisibility(View.GONE);
                        infolay10.setVisibility(VISIBLE);
                        break;
                    case 11:
                        firstlay.setVisibility(View.GONE);
                        infolay11.setVisibility(VISIBLE);
                        break;
                    case 12:
                        firstlay.setVisibility(View.GONE);
                        infolay12.setVisibility(VISIBLE);
                        break;
                    case 13:
                        firstlay.setVisibility(View.GONE);
                        infolay13.setVisibility(VISIBLE);
                        break;
                    case 14:
                        firstlay.setVisibility(View.GONE);
                        infolay14.setVisibility(VISIBLE);
                        break;
                    case 15:
                        firstlay.setVisibility(View.GONE);
                        infolay15.setVisibility(VISIBLE);
                        break;
                    case 16:
                        firstlay.setVisibility(View.GONE);
                        infolay16.setVisibility(VISIBLE);
                        break;
                    case 17:
                        firstlay.setVisibility(View.GONE);
                        infolay17.setVisibility(VISIBLE);
                        break;
                    case 18:
                        firstlay.setVisibility(View.GONE);
                        infolay18.setVisibility(VISIBLE);
                        break;
                    case 19:
                        firstlay.setVisibility(View.GONE);
                        infolay19.setVisibility(VISIBLE);
                        break;
                    case 20:
                        firstlay.setVisibility(View.GONE);
                        infolay20.setVisibility(VISIBLE);
                        break;
                    case 21:
                        firstlay.setVisibility(View.GONE);
                        infolay21.setVisibility(VISIBLE);
                        break;
                    case 22:
                        firstlay.setVisibility(View.GONE);
                        infolay22.setVisibility(VISIBLE);
                        break;
                    case 23:
                        firstlay.setVisibility(View.GONE);
                        infolay23.setVisibility(VISIBLE);
                        break;
                    case 24:
                        firstlay.setVisibility(View.GONE);
                        infolay24.setVisibility(VISIBLE);
                        break;
                    case 25:
                        firstlay.setVisibility(View.GONE);
                        infolay25.setVisibility(VISIBLE);
                        break;
                    case 26:
                        firstlay.setVisibility(View.GONE);
                        infolay26.setVisibility(VISIBLE);
                        break;
                    case 27:
                        firstlay.setVisibility(View.GONE);
                        infolay27.setVisibility(VISIBLE);
                        break;
                    case 28:
                        firstlay.setVisibility(View.GONE);
                        infolay28.setVisibility(VISIBLE);
                        break;
                    case 29:
                        firstlay.setVisibility(View.GONE);
                        infolay29.setVisibility(VISIBLE);
                        break;
                    case 30:
                        firstlay.setVisibility(View.GONE);
                        infolay30.setVisibility(VISIBLE);
                        break;
                    case 31:
                        firstlay.setVisibility(View.GONE);
                        infolay31.setVisibility(VISIBLE);
                        break;
                    case 32:
                        firstlay.setVisibility(View.GONE);
                        infolay32.setVisibility(VISIBLE);
                        break;
                    case 33:
                        firstlay.setVisibility(View.GONE);
                        infolay33.setVisibility(VISIBLE);
                        break;
                    case 34:
                        firstlay.setVisibility(View.GONE);
                        infolay34.setVisibility(VISIBLE);
                        break;
                    case 35:
                        firstlay.setVisibility(View.GONE);
                        infolay35.setVisibility(VISIBLE);
                        break;
                    case 36:
                        firstlay.setVisibility(View.GONE);
                        infolay36.setVisibility(VISIBLE);
                        break;
                    case 37:
                        firstlay.setVisibility(View.GONE);
                        infolay37.setVisibility(VISIBLE);
                        break;
                    case 38:
                        firstlay.setVisibility(View.GONE);
                        infolay38.setVisibility(VISIBLE);
                        break;
                    case 39:
                        firstlay.setVisibility(View.GONE);
                        infolay39.setVisibility(VISIBLE);
                        break;
                    case 40:
                        firstlay.setVisibility(View.GONE);
                        infolay40.setVisibility(VISIBLE);
                        break;
                    case 41:
                        firstlay.setVisibility(View.GONE);
                        infolay41.setVisibility(VISIBLE);
                        break;
                    case 42:
                        firstlay.setVisibility(View.GONE);
                        infolay42.setVisibility(VISIBLE);
                        break;
                    case 43:
                        firstlay.setVisibility(View.GONE);
                        infolay43.setVisibility(VISIBLE);
                        break;
                    case 44:
                        firstlay.setVisibility(View.GONE);
                        infolay44.setVisibility(VISIBLE);
                        break;
                    case 45:
                        firstlay.setVisibility(View.GONE);
                        infolay45.setVisibility(VISIBLE);
                        break;
                }
            }
        });

        infobtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (userball[3]) {

                    case 1:
                        firstlay.setVisibility(View.GONE);
                        infolay1.setVisibility(VISIBLE);
                        break;
                    case 2:
                        firstlay.setVisibility(View.GONE);
                        infolay2.setVisibility(VISIBLE);
                        break;
                    case 3:
                        firstlay.setVisibility(View.GONE);
                        infolay3.setVisibility(VISIBLE);
                        break;
                    case 4:
                        firstlay.setVisibility(View.GONE);
                        infolay4.setVisibility(VISIBLE);
                        break;
                    case 5:
                        firstlay.setVisibility(View.GONE);
                        infolay5.setVisibility(VISIBLE);
                        break;
                    case 6:
                        firstlay.setVisibility(View.GONE);
                        infolay6.setVisibility(VISIBLE);
                        break;
                    case 7:
                        firstlay.setVisibility(View.GONE);
                        infolay7.setVisibility(VISIBLE);
                        break;
                    case 8:
                        firstlay.setVisibility(View.GONE);
                        infolay8.setVisibility(VISIBLE);
                        break;
                    case 9:
                        firstlay.setVisibility(View.GONE);
                        infolay9.setVisibility(VISIBLE);
                        break;
                    case 10:
                        firstlay.setVisibility(View.GONE);
                        infolay10.setVisibility(VISIBLE);
                        break;
                    case 11:
                        firstlay.setVisibility(View.GONE);
                        infolay11.setVisibility(VISIBLE);
                        break;
                    case 12:
                        firstlay.setVisibility(View.GONE);
                        infolay12.setVisibility(VISIBLE);
                        break;
                    case 13:
                        firstlay.setVisibility(View.GONE);
                        infolay13.setVisibility(VISIBLE);
                        break;
                    case 14:
                        firstlay.setVisibility(View.GONE);
                        infolay14.setVisibility(VISIBLE);
                        break;
                    case 15:
                        firstlay.setVisibility(View.GONE);
                        infolay15.setVisibility(VISIBLE);
                        break;
                    case 16:
                        firstlay.setVisibility(View.GONE);
                        infolay16.setVisibility(VISIBLE);
                        break;
                    case 17:
                        firstlay.setVisibility(View.GONE);
                        infolay17.setVisibility(VISIBLE);
                        break;
                    case 18:
                        firstlay.setVisibility(View.GONE);
                        infolay18.setVisibility(VISIBLE);
                        break;
                    case 19:
                        firstlay.setVisibility(View.GONE);
                        infolay19.setVisibility(VISIBLE);
                        break;
                    case 20:
                        firstlay.setVisibility(View.GONE);
                        infolay20.setVisibility(VISIBLE);
                        break;
                    case 21:
                        firstlay.setVisibility(View.GONE);
                        infolay21.setVisibility(VISIBLE);
                        break;
                    case 22:
                        firstlay.setVisibility(View.GONE);
                        infolay22.setVisibility(VISIBLE);
                        break;
                    case 23:
                        firstlay.setVisibility(View.GONE);
                        infolay23.setVisibility(VISIBLE);
                        break;
                    case 24:
                        firstlay.setVisibility(View.GONE);
                        infolay24.setVisibility(VISIBLE);
                        break;
                    case 25:
                        firstlay.setVisibility(View.GONE);
                        infolay25.setVisibility(VISIBLE);
                        break;
                    case 26:
                        firstlay.setVisibility(View.GONE);
                        infolay26.setVisibility(VISIBLE);
                        break;
                    case 27:
                        firstlay.setVisibility(View.GONE);
                        infolay27.setVisibility(VISIBLE);
                        break;
                    case 28:
                        firstlay.setVisibility(View.GONE);
                        infolay28.setVisibility(VISIBLE);
                        break;
                    case 29:
                        firstlay.setVisibility(View.GONE);
                        infolay29.setVisibility(VISIBLE);
                        break;
                    case 30:
                        firstlay.setVisibility(View.GONE);
                        infolay30.setVisibility(VISIBLE);
                        break;
                    case 31:
                        firstlay.setVisibility(View.GONE);
                        infolay31.setVisibility(VISIBLE);
                        break;
                    case 32:
                        firstlay.setVisibility(View.GONE);
                        infolay32.setVisibility(VISIBLE);
                        break;
                    case 33:
                        firstlay.setVisibility(View.GONE);
                        infolay33.setVisibility(VISIBLE);
                        break;
                    case 34:
                        firstlay.setVisibility(View.GONE);
                        infolay34.setVisibility(VISIBLE);
                        break;
                    case 35:
                        firstlay.setVisibility(View.GONE);
                        infolay35.setVisibility(VISIBLE);
                        break;
                    case 36:
                        firstlay.setVisibility(View.GONE);
                        infolay36.setVisibility(VISIBLE);
                        break;
                    case 37:
                        firstlay.setVisibility(View.GONE);
                        infolay37.setVisibility(VISIBLE);
                        break;
                    case 38:
                        firstlay.setVisibility(View.GONE);
                        infolay38.setVisibility(VISIBLE);
                        break;
                    case 39:
                        firstlay.setVisibility(View.GONE);
                        infolay39.setVisibility(VISIBLE);
                        break;
                    case 40:
                        firstlay.setVisibility(View.GONE);
                        infolay40.setVisibility(VISIBLE);
                        break;
                    case 41:
                        firstlay.setVisibility(View.GONE);
                        infolay41.setVisibility(VISIBLE);
                        break;
                    case 42:
                        firstlay.setVisibility(View.GONE);
                        infolay42.setVisibility(VISIBLE);
                        break;
                    case 43:
                        firstlay.setVisibility(View.GONE);
                        infolay43.setVisibility(VISIBLE);
                        break;
                    case 44:
                        firstlay.setVisibility(View.GONE);
                        infolay44.setVisibility(VISIBLE);
                        break;
                    case 45:
                        firstlay.setVisibility(View.GONE);
                        infolay45.setVisibility(VISIBLE);
                        break;
                }
            }
        });

        infobtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (userball[4]) {

                    case 1:
                        firstlay.setVisibility(View.GONE);
                        infolay1.setVisibility(VISIBLE);
                        break;
                    case 2:
                        firstlay.setVisibility(View.GONE);
                        infolay2.setVisibility(VISIBLE);
                        break;
                    case 3:
                        firstlay.setVisibility(View.GONE);
                        infolay3.setVisibility(VISIBLE);
                        break;
                    case 4:
                        firstlay.setVisibility(View.GONE);
                        infolay4.setVisibility(VISIBLE);
                        break;
                    case 5:
                        firstlay.setVisibility(View.GONE);
                        infolay5.setVisibility(VISIBLE);
                        break;
                    case 6:
                        firstlay.setVisibility(View.GONE);
                        infolay6.setVisibility(VISIBLE);
                        break;
                    case 7:
                        firstlay.setVisibility(View.GONE);
                        infolay7.setVisibility(VISIBLE);
                        break;
                    case 8:
                        firstlay.setVisibility(View.GONE);
                        infolay8.setVisibility(VISIBLE);
                        break;
                    case 9:
                        firstlay.setVisibility(View.GONE);
                        infolay9.setVisibility(VISIBLE);
                        break;
                    case 10:
                        firstlay.setVisibility(View.GONE);
                        infolay10.setVisibility(VISIBLE);
                        break;
                    case 11:
                        firstlay.setVisibility(View.GONE);
                        infolay11.setVisibility(VISIBLE);
                        break;
                    case 12:
                        firstlay.setVisibility(View.GONE);
                        infolay12.setVisibility(VISIBLE);
                        break;
                    case 13:
                        firstlay.setVisibility(View.GONE);
                        infolay13.setVisibility(VISIBLE);
                        break;
                    case 14:
                        firstlay.setVisibility(View.GONE);
                        infolay14.setVisibility(VISIBLE);
                        break;
                    case 15:
                        firstlay.setVisibility(View.GONE);
                        infolay15.setVisibility(VISIBLE);
                        break;
                    case 16:
                        firstlay.setVisibility(View.GONE);
                        infolay16.setVisibility(VISIBLE);
                        break;
                    case 17:
                        firstlay.setVisibility(View.GONE);
                        infolay17.setVisibility(VISIBLE);
                        break;
                    case 18:
                        firstlay.setVisibility(View.GONE);
                        infolay18.setVisibility(VISIBLE);
                        break;
                    case 19:
                        firstlay.setVisibility(View.GONE);
                        infolay19.setVisibility(VISIBLE);
                        break;
                    case 20:
                        firstlay.setVisibility(View.GONE);
                        infolay20.setVisibility(VISIBLE);
                        break;
                    case 21:
                        firstlay.setVisibility(View.GONE);
                        infolay21.setVisibility(VISIBLE);
                        break;
                    case 22:
                        firstlay.setVisibility(View.GONE);
                        infolay22.setVisibility(VISIBLE);
                        break;
                    case 23:
                        firstlay.setVisibility(View.GONE);
                        infolay23.setVisibility(VISIBLE);
                        break;
                    case 24:
                        firstlay.setVisibility(View.GONE);
                        infolay24.setVisibility(VISIBLE);
                        break;
                    case 25:
                        firstlay.setVisibility(View.GONE);
                        infolay25.setVisibility(VISIBLE);
                        break;
                    case 26:
                        firstlay.setVisibility(View.GONE);
                        infolay26.setVisibility(VISIBLE);
                        break;
                    case 27:
                        firstlay.setVisibility(View.GONE);
                        infolay27.setVisibility(VISIBLE);
                        break;
                    case 28:
                        firstlay.setVisibility(View.GONE);
                        infolay28.setVisibility(VISIBLE);
                        break;
                    case 29:
                        firstlay.setVisibility(View.GONE);
                        infolay29.setVisibility(VISIBLE);
                        break;
                    case 30:
                        firstlay.setVisibility(View.GONE);
                        infolay30.setVisibility(VISIBLE);
                        break;
                    case 31:
                        firstlay.setVisibility(View.GONE);
                        infolay31.setVisibility(VISIBLE);
                        break;
                    case 32:
                        firstlay.setVisibility(View.GONE);
                        infolay32.setVisibility(VISIBLE);
                        break;
                    case 33:
                        firstlay.setVisibility(View.GONE);
                        infolay33.setVisibility(VISIBLE);
                        break;
                    case 34:
                        firstlay.setVisibility(View.GONE);
                        infolay34.setVisibility(VISIBLE);
                        break;
                    case 35:
                        firstlay.setVisibility(View.GONE);
                        infolay35.setVisibility(VISIBLE);
                        break;
                    case 36:
                        firstlay.setVisibility(View.GONE);
                        infolay36.setVisibility(VISIBLE);
                        break;
                    case 37:
                        firstlay.setVisibility(View.GONE);
                        infolay37.setVisibility(VISIBLE);
                        break;
                    case 38:
                        firstlay.setVisibility(View.GONE);
                        infolay38.setVisibility(VISIBLE);
                        break;
                    case 39:
                        firstlay.setVisibility(View.GONE);
                        infolay39.setVisibility(VISIBLE);
                        break;
                    case 40:
                        firstlay.setVisibility(View.GONE);
                        infolay40.setVisibility(VISIBLE);
                        break;
                    case 41:
                        firstlay.setVisibility(View.GONE);
                        infolay41.setVisibility(VISIBLE);
                        break;
                    case 42:
                        firstlay.setVisibility(View.GONE);
                        infolay42.setVisibility(VISIBLE);
                        break;
                    case 43:
                        firstlay.setVisibility(View.GONE);
                        infolay43.setVisibility(VISIBLE);
                        break;
                    case 44:
                        firstlay.setVisibility(View.GONE);
                        infolay44.setVisibility(VISIBLE);
                        break;
                    case 45:
                        firstlay.setVisibility(View.GONE);
                        infolay45.setVisibility(VISIBLE);
                        break;
                }

            }
        });

        infobtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (userball[5]) {

                    case 1:
                        firstlay.setVisibility(View.GONE);
                        infolay1.setVisibility(VISIBLE);
                        break;
                    case 2:
                        firstlay.setVisibility(View.GONE);
                        infolay2.setVisibility(VISIBLE);
                        break;
                    case 3:
                        firstlay.setVisibility(View.GONE);
                        infolay3.setVisibility(VISIBLE);
                        break;
                    case 4:
                        firstlay.setVisibility(View.GONE);
                        infolay4.setVisibility(VISIBLE);
                        break;
                    case 5:
                        firstlay.setVisibility(View.GONE);
                        infolay5.setVisibility(VISIBLE);
                        break;
                    case 6:
                        firstlay.setVisibility(View.GONE);
                        infolay6.setVisibility(VISIBLE);
                        break;
                    case 7:
                        firstlay.setVisibility(View.GONE);
                        infolay7.setVisibility(VISIBLE);
                        break;
                    case 8:
                        firstlay.setVisibility(View.GONE);
                        infolay8.setVisibility(VISIBLE);
                        break;
                    case 9:
                        firstlay.setVisibility(View.GONE);
                        infolay9.setVisibility(VISIBLE);
                        break;
                    case 10:
                        firstlay.setVisibility(View.GONE);
                        infolay10.setVisibility(VISIBLE);
                        break;
                    case 11:
                        firstlay.setVisibility(View.GONE);
                        infolay11.setVisibility(VISIBLE);
                        break;
                    case 12:
                        firstlay.setVisibility(View.GONE);
                        infolay12.setVisibility(VISIBLE);
                        break;
                    case 13:
                        firstlay.setVisibility(View.GONE);
                        infolay13.setVisibility(VISIBLE);
                        break;
                    case 14:
                        firstlay.setVisibility(View.GONE);
                        infolay14.setVisibility(VISIBLE);
                        break;
                    case 15:
                        firstlay.setVisibility(View.GONE);
                        infolay15.setVisibility(VISIBLE);
                        break;
                    case 16:
                        firstlay.setVisibility(View.GONE);
                        infolay16.setVisibility(VISIBLE);
                        break;
                    case 17:
                        firstlay.setVisibility(View.GONE);
                        infolay17.setVisibility(VISIBLE);
                        break;
                    case 18:
                        firstlay.setVisibility(View.GONE);
                        infolay18.setVisibility(VISIBLE);
                        break;
                    case 19:
                        firstlay.setVisibility(View.GONE);
                        infolay19.setVisibility(VISIBLE);
                        break;
                    case 20:
                        firstlay.setVisibility(View.GONE);
                        infolay20.setVisibility(VISIBLE);
                        break;
                    case 21:
                        firstlay.setVisibility(View.GONE);
                        infolay21.setVisibility(VISIBLE);
                        break;
                    case 22:
                        firstlay.setVisibility(View.GONE);
                        infolay22.setVisibility(VISIBLE);
                        break;
                    case 23:
                        firstlay.setVisibility(View.GONE);
                        infolay23.setVisibility(VISIBLE);
                        break;
                    case 24:
                        firstlay.setVisibility(View.GONE);
                        infolay24.setVisibility(VISIBLE);
                        break;
                    case 25:
                        firstlay.setVisibility(View.GONE);
                        infolay25.setVisibility(VISIBLE);
                        break;
                    case 26:
                        firstlay.setVisibility(View.GONE);
                        infolay26.setVisibility(VISIBLE);
                        break;
                    case 27:
                        firstlay.setVisibility(View.GONE);
                        infolay27.setVisibility(VISIBLE);
                        break;
                    case 28:
                        firstlay.setVisibility(View.GONE);
                        infolay28.setVisibility(VISIBLE);
                        break;
                    case 29:
                        firstlay.setVisibility(View.GONE);
                        infolay29.setVisibility(VISIBLE);
                        break;
                    case 30:
                        firstlay.setVisibility(View.GONE);
                        infolay30.setVisibility(VISIBLE);
                        break;
                    case 31:
                        firstlay.setVisibility(View.GONE);
                        infolay31.setVisibility(VISIBLE);
                        break;
                    case 32:
                        firstlay.setVisibility(View.GONE);
                        infolay32.setVisibility(VISIBLE);
                        break;
                    case 33:
                        firstlay.setVisibility(View.GONE);
                        infolay33.setVisibility(VISIBLE);
                        break;
                    case 34:
                        firstlay.setVisibility(View.GONE);
                        infolay34.setVisibility(VISIBLE);
                        break;
                    case 35:
                        firstlay.setVisibility(View.GONE);
                        infolay35.setVisibility(VISIBLE);
                        break;
                    case 36:
                        firstlay.setVisibility(View.GONE);
                        infolay36.setVisibility(VISIBLE);
                        break;
                    case 37:
                        firstlay.setVisibility(View.GONE);
                        infolay37.setVisibility(VISIBLE);
                        break;
                    case 38:
                        firstlay.setVisibility(View.GONE);
                        infolay38.setVisibility(VISIBLE);
                        break;
                    case 39:
                        firstlay.setVisibility(View.GONE);
                        infolay39.setVisibility(VISIBLE);
                        break;
                    case 40:
                        firstlay.setVisibility(View.GONE);
                        infolay40.setVisibility(VISIBLE);
                        break;
                    case 41:
                        firstlay.setVisibility(View.GONE);
                        infolay41.setVisibility(VISIBLE);
                        break;
                    case 42:
                        firstlay.setVisibility(View.GONE);
                        infolay42.setVisibility(VISIBLE);
                        break;
                    case 43:
                        firstlay.setVisibility(View.GONE);
                        infolay43.setVisibility(VISIBLE);
                        break;
                    case 44:
                        firstlay.setVisibility(View.GONE);
                        infolay44.setVisibility(VISIBLE);
                        break;
                    case 45:
                        firstlay.setVisibility(View.GONE);
                        infolay45.setVisibility(VISIBLE);
                        break;
                }

            }
        });
        //일반번호 보기 버튼 설정 완료


        //돌아가기버튼 클릭시

        backbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        backbtn45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userball[0] > 0) {
                    infolay1.setVisibility(View.GONE);
                    infolay2.setVisibility(View.GONE);
                    infolay3.setVisibility(View.GONE);
                    infolay4.setVisibility(View.GONE);
                    infolay5.setVisibility(View.GONE);
                    infolay6.setVisibility(View.GONE);
                    infolay7.setVisibility(View.GONE);
                    infolay8.setVisibility(View.GONE);
                    infolay9.setVisibility(View.GONE);
                    infolay10.setVisibility(View.GONE);
                    infolay11.setVisibility(View.GONE);
                    infolay12.setVisibility(View.GONE);
                    infolay13.setVisibility(View.GONE);
                    infolay14.setVisibility(View.GONE);
                    infolay15.setVisibility(View.GONE);
                    infolay16.setVisibility(View.GONE);
                    infolay17.setVisibility(View.GONE);
                    infolay18.setVisibility(View.GONE);
                    infolay19.setVisibility(View.GONE);
                    infolay20.setVisibility(View.GONE);
                    infolay21.setVisibility(View.GONE);
                    infolay22.setVisibility(View.GONE);
                    infolay23.setVisibility(View.GONE);
                    infolay24.setVisibility(View.GONE);
                    infolay25.setVisibility(View.GONE);
                    infolay26.setVisibility(View.GONE);
                    infolay27.setVisibility(View.GONE);
                    infolay28.setVisibility(View.GONE);
                    infolay29.setVisibility(View.GONE);
                    infolay30.setVisibility(View.GONE);
                    infolay31.setVisibility(View.GONE);
                    infolay32.setVisibility(View.GONE);
                    infolay33.setVisibility(View.GONE);
                    infolay34.setVisibility(View.GONE);
                    infolay35.setVisibility(View.GONE);
                    infolay36.setVisibility(View.GONE);
                    infolay37.setVisibility(View.GONE);
                    infolay38.setVisibility(View.GONE);
                    infolay39.setVisibility(View.GONE);
                    infolay40.setVisibility(View.GONE);
                    infolay41.setVisibility(View.GONE);
                    infolay42.setVisibility(View.GONE);
                    infolay43.setVisibility(View.GONE);
                    infolay44.setVisibility(View.GONE);
                    infolay45.setVisibility(View.GONE);
                    //
                    firstlay.setVisibility(VISIBLE);
                }
            }
        });

        // 모든 백버튼 활성화 !! -------------> 누를시 모든창다내리고 메인창띄우는것.


        // 보너스 버튼 눌렀을때에 인텐트로 보너스액티비티로 넘어가기

        bonusbtn1.setOnClickListener(new View.OnClickListener() { //가져가는값 bonas == 보너스개수 +  bonasnum1 = 보너스배열랜덤값
            @Override
            public void onClick(View v) {

                //보너스보러가기전에 경고창띄우기

                AlertDialog.Builder builder = new AlertDialog.Builder(InfoActivity.this);
                builder.setTitle("!!WARNING!!");
                builder.setMessage("정말 6급정보를 열람하시겠습니까?\n" + "6급정보내용 : " + b1info[b1]);

                builder.setPositiveButton("열람하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "보너스정보보러 고고싱!", Toast.LENGTH_SHORT).show();

                        bonusit = new Intent(getApplicationContext(), BonusActivity.class);
                        bonusit.putExtra("bonas", bonus);
                        bonusit.putExtra("bonasnum1", b1);
                        bonusit.putExtra("btn", 1); //어떤버튼클릭해서 넘어온 액티비티인지 확인.
                        startActivity(bonusit);
                    }
                });

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "취소를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("처음으로", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "첫화면으로 갑니다~", Toast.LENGTH_SHORT).show();
                        Intent start_at = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(start_at);
                        finish();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show(); //다이얼로그 보여주기

            }
        });

        bonusbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(InfoActivity.this);
                builder.setTitle("!!WARNING!!");
                builder.setMessage("정말 5급정보를 열람하시겠습니까?\n" + "5급정보내용 : " + b2info[b2]);

                builder.setPositiveButton("열람하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "보너스정보보러 고고싱!", Toast.LENGTH_SHORT).show();

                        bonusit = new Intent(getApplicationContext(), BonusActivity.class);
                        bonusit.putExtra("bonas", bonus);
                        bonusit.putExtra("bonasnum2", b2);
                        bonusit.putExtra("btn", 2);
                        startActivity(bonusit);
                    }
                });

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "취소를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("끝내기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "수고하셨습니다(__ )( __)", Toast.LENGTH_SHORT).show();
                        Intent start_at = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(start_at);
                        finish();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show(); //다이얼로그 보여주기

            }
        });

        bonusbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(InfoActivity.this);
                builder.setTitle("!!WARNING!!");
                builder.setMessage("정말 4급정보를 열람하시겠습니까?\n" + "4급정보내용 : " + b3info[b3]);

                builder.setPositiveButton("열람하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "보너스정보보러 고고싱!", Toast.LENGTH_SHORT).show();

                        bonusit = new Intent(getApplicationContext(), BonusActivity.class);
                        bonusit.putExtra("bonas", bonus);
                        bonusit.putExtra("bonasnum3", b3);
                        bonusit.putExtra("btn", 3);
                        startActivity(bonusit);
                    }
                });

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "취소를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("처음으로", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "첫화면으로 갑니다~", Toast.LENGTH_SHORT).show();
                        Intent start_at = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(start_at);
                        finish();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show(); //다이얼로그 보여주기


            }
        });

        bonusbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(InfoActivity.this);
                builder.setTitle("!!!!WARNING!!!!");
                builder.setMessage("정말 3급정보를 열람하시겠습니까?\n" + "3급정보내용 : " + b4info[b4]);

                builder.setPositiveButton("열람하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "보너스정보보러 고고싱!", Toast.LENGTH_SHORT).show();

                        bonusit = new Intent(getApplicationContext(), BonusActivity.class);
                        bonusit.putExtra("bonas", bonus);
                        bonusit.putExtra("bonasnum4", b4);
                        bonusit.putExtra("btn", 4);
                        startActivity(bonusit);
                    }
                });

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "취소를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("처음으로", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "첫화면으로 갑니다~", Toast.LENGTH_SHORT).show();
                        Intent start_at = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(start_at);
                        finish();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show(); //다이얼로그 보여주기


            }
        });

        bonusbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(InfoActivity.this);
                builder.setTitle("!!!!!WARNING!!!!!");
                builder.setMessage("정말 2급정보를 열람하시겠습니까?\n" + "2급정보내용 : " + b5info);

                builder.setPositiveButton("열람하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "보너스정보보러 고고싱!", Toast.LENGTH_SHORT).show();

                        bonusit = new Intent(getApplicationContext(), BonusActivity.class);
                        bonusit.putExtra("bonas", bonus);
                        bonusit.putExtra("btn", 5);
                        startActivity(bonusit);
                    }
                });

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "취소를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("처음으로", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "첫화면으로 갑니다~", Toast.LENGTH_SHORT).show();
                        Intent start_at = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(start_at);
                        finish();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show(); //다이얼로그 보여주기


            }
        });

        bonusbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(InfoActivity.this);
                builder.setTitle("!!!!!!WARNING!!!!!!");
                builder.setMessage("정말 1급정보를 열람하시겠습니까?\n" + "1급정보내용 : " + b6info);

                builder.setPositiveButton("열람하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "보너스정보보러 고고싱!", Toast.LENGTH_SHORT).show();

                        bonusit = new Intent(getApplicationContext(), BonusActivity.class);
                        bonusit.putExtra("bonas", bonus);
                        bonusit.putExtra("btn", 6);
                        //1급기밀은 하나이므로 인텐트할필요가없음.
                        startActivity(bonusit);
                    }
                });

                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "취소를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("처음으로", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InfoActivity.this, "첫화면으로 갑니다~", Toast.LENGTH_SHORT).show();
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
        infomp.pause();
        super.onUserLeaveHint();
    }

    @Override
    protected void onResume() {
        infomp.start();
        super.onResume();
    }

    @Override
    protected void onDestroy() { //앱이 정지되었을때
        infomp.stop();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() { //백버튼을 눌렀을시.
        infomp.stop();
        endingCloseHandler.onBackPressed();
    }

}//class
