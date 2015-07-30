
package et.android.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 该Activity是主界面对应的Activity
 * 
 * @author 张荣超
 */
public class MainActivity extends Activity implements OnClickListener {

    private Button mOpenDialogButton;
    private Button mTransitToDialogStyleActivityButton;
    private static final String TAG = "Activity_LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity_onCreate Method is called.");

        setContentView(R.layout.activity_main);

        findViewsById();
        setClickListeners();
    }

    private void findViewsById() {
        mOpenDialogButton = (Button) findViewById(R.id.button_open_dialog);
        mTransitToDialogStyleActivityButton = (Button) findViewById(R.id.button_transit_to_dialogstyle_activity);
    }

    private void setClickListeners() {
        mOpenDialogButton.setOnClickListener(this);
        mTransitToDialogStyleActivityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_open_dialog:
                openDialog();
                break;
            case R.id.button_transit_to_dialogstyle_activity:
                transitToDialogStyleActivity();
                break;
            default:
                break;
        }
    }

    /**
     * 打开一个对话框
     */
    private void openDialog() {
        new AlertDialog.Builder(this).setMessage(R.string.dialog_message).show();
    }

    /**
     * 切换到一个对话框风格的界面
     */
    private void transitToDialogStyleActivity() {
        Intent intent = new Intent(this, DialogStyleActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity_onStart Methond is called.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity_onRestart Method is called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity_onResume Method is called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity_onPause Method is called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity_onStop Method is called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity_onDestroy Method is called.");
    }

}
