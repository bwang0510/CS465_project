package edu.illinois.cs465.fweestuff.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import edu.illinois.cs465.fweestuff.R;

public class Pop extends Activity {

    EditText yc;
    ImageButton postComment;
    LinearLayout cfeed;
    TextView ych1, ych2, ych3, ych4, ych5;
    LinearLayout comment1, comment2, comment3, comment4, comment5;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.85), (int)(height*.85));
        yc = findViewById(R.id.yourcomment);
        postComment = findViewById(R.id.writecomment);
        ych1 = findViewById(R.id.ych1);
        ych2 = findViewById(R.id.ych2);
        ych3 = findViewById(R.id.ych3);
        ych4 = findViewById(R.id.ych4);
        ych5 = findViewById(R.id.ych5);

        cfeed = findViewById(R.id.cfeed);

        comment1 = findViewById(R.id.comment1);
        comment2 = findViewById(R.id.comment2);
        comment3 = findViewById(R.id.comment3);
        comment4 = findViewById(R.id.comment4);
        comment5 = findViewById(R.id.comment5);


        postComment.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(yc.getText().toString().length() == 0){
                    //do nothing
                }
                else{
                    Context context = v.getContext();
                    LayoutInflater inflater = LayoutInflater.from(context);
                    LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.new_comment, null, false);
                    ((TextView)layout.findViewById(R.id.customcommentpost)).setText(yc.getText().toString());
                    cfeed.addView(layout);
                    yc.setText("");
                }
            }
        });
    }
}
