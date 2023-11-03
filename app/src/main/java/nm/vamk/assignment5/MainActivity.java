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
    LayoutParams viewLayoutParams;
    LinearLayout linearLayout;
    Button firstButton;
    Button secondButton;
    int yIncrement = 0;
    boolean goUp = false;

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
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //First Button
        firstButton = new Button(this);
        firstButton.setId(R.id.first_button);
        firstButton.setText(R.string.hide);
        firstButton.setLayoutParams(viewLayoutParams);
        firstButton.setBackgroundColor(getColor(R.color.android_green));
        firstButton.setOnClickListener(buttonClickListener);
        firstButton.setX(220);
        linearLayout.addView(firstButton);

        //Second Button
        secondButton = new Button(this);
        secondButton.setId(R.id.second_button);
        secondButton.setText(R.string.go_down);
        secondButton.setLayoutParams(viewLayoutParams);
        secondButton.setBackgroundColor(getColor(R.color.android_green));
        secondButton.setOnClickListener(buttonClickListener);
        secondButton.setX(560);
        secondButton.setY(-182);
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
                    firstButton.setText(R.string.display);
                } else {
                    secondButton.setVisibility(View.VISIBLE);
                    firstButton.setText(R.string.hide);
                }
            }

            //Second button clicked
            if(clickedButton.equals(secondButton)) {
                yIncrement = 60;

                if (goUp == false) {
                    secondButton.setText(R.string.go_down);
                    firstButton.setY(firstButton.getY() + yIncrement);
                    if(firstButton.getY() >= linearLayout.getMeasuredHeight()) {
                        goUp = true;
                    }
                }

                if(goUp == true) {
                    secondButton.setText(R.string.go_up);
                    firstButton.setY(firstButton.getY() - yIncrement);
                    if (firstButton.getY() <= secondButton.getY()) {
                        goUp = false;
                    }
                }

            }
        }
    };
}
