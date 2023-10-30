package nm.vamk.assignment5;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText userNametEditText = null;
    EditText passwordEditText = null;
    TextView summaryTextView = null;
    LayoutParams viewLayoutParams = null;
    LayoutParams viewLayoutParamsSecond = null;

    Button firstButton;
    Button secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Here we define parameters for views
        viewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        viewLayoutParams.leftMargin = 20;
        viewLayoutParams.rightMargin = 40;
        viewLayoutParams.topMargin = 40;
        viewLayoutParams.bottomMargin = 10;

        // Here we create the layout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //First Button
        firstButton = new Button(this);
        firstButton.setId(R.id.first_button);
        firstButton.setText(R.string.firstButton_txt);
        firstButton.setLayoutParams(viewLayoutParams);
        firstButton.setBackgroundColor(getColor(R.color.android_green));
        firstButton.setOnClickListener(buttonClickListener);
        linearLayout.addView(firstButton);

        //Second Button
        secondButton = new Button(this);
        secondButton.setId(R.id.second_button);
        secondButton.setText(R.string.secondButton_txt);
        secondButton.setLayoutParams(viewLayoutParams);
        secondButton.setBackgroundColor(getColor(R.color.android_green));
        secondButton.setOnClickListener(buttonClickListener);
        linearLayout.addView(secondButton);

        // Here we define LinearLayouts width and height
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        this.addContentView(linearLayout, linearLayoutParams);
    }

    private OnClickListener buttonClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Button clickedButton = (Button) v;
            //First button clicked
            if(clickedButton.equals(firstButton)) {
                if(secondButton.getVisibility() == View.VISIBLE) {
                    secondButton.setVisibility(View.INVISIBLE);
                } else {
                    secondButton.setVisibility(View.VISIBLE);
                }
            }

            //Second button clicked
            if(clickedButton.equals(secondButton)) {
                if(firstButton.getY() == viewLayoutParams.topMargin) {
                    firstButton.setY(1900);
                } else {
                    firstButton.setY(viewLayoutParams.topMargin);
                }
            }
        }
    };
}
