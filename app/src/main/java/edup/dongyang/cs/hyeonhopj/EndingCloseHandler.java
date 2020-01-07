package edup.dongyang.cs.hyeonhopj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

public class EndingCloseHandler { //엔딩크레딧보여주기위한 화면클래스 생성.
    private long backKeyPressedTime = 0;
    private Toast toast;

    private Activity activity;
    int closecount = 0;

    public EndingCloseHandler(Activity context) {
        this.activity = context;
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            toast.cancel();

            /*Intent t = new Intent(activity, MainActivity.class);
            activity.startActivity(t);

            activity.moveTaskToBack(true);
            activity.finish();
            android.os.Process.killProcess(android.os.Process.myPid());*/
        }
    }

    public void showGuide() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("종료하시기전에!");
        builder.setMessage("20초 크레딧이존재합니다 보시겠습니까?");
        builder.setPositiveButton("네 볼래요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent it = new Intent(activity, CreditActivity.class);
                activity.startActivity(it);
            }
        });

        builder.setNegativeButton("그냥 끌래요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent t = new Intent(activity, MainActivity.class);
                activity.startActivity(t);

                activity.moveTaskToBack(true);
                activity.finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

}


