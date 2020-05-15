package edu.illinois.cs465.fweestuff.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import edu.illinois.cs465.fweestuff.MainActivity;
import edu.illinois.cs465.fweestuff.R;

public class FeedTab extends Fragment {

    Button postButton;
    EditText post;
    LinearLayout feed;
    ToggleButton like1, like2, like3, like4, like5;
    TextView ln1, ln2, ln3, ln4, ln5;
    ImageButton c1, c2, c3, c4, c5;

    ToggleButton invisLike1,invisLike2,invisLike3,invisLike4,invisLike5;
    TextView cln1, cln2,cln3, cln4, cln5;
    ImageButton cc1, cc2, cc3, cc4, cc5;

    TextView invisPost1, invisPost2, invisPost3, invisPost4, invisPost5;
    LinearLayout invisLayout1, invisLayout2, invisLayout3, invisLayout4, invisLayout5;
    int invisCount = 5;
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_tab, container, false);
        postButton = view.findViewById(R.id.postButton);
        post = view.findViewById(R.id.post);
        feed = view.findViewById(R.id.feed);

        like1 = view.findViewById(R.id.like1);
        like2 = view.findViewById(R.id.like2);
        like3 = view.findViewById(R.id.like3);
        like4 = view.findViewById(R.id.like4);
        like5 = view.findViewById(R.id.like5);

        ln1 = view.findViewById(R.id.likeNum1);
        ln2 = view.findViewById(R.id.likeNum2);
        ln3 = view.findViewById(R.id.likeNum3);
        ln4 = view.findViewById(R.id.likeNum4);
        ln5 = view.findViewById(R.id.likeNum5);

        c1 = view.findViewById(R.id.ib1);
        c2 = view.findViewById(R.id.ib2);
        c3 = view.findViewById(R.id.ib3);
        c4 = view.findViewById(R.id.ib4);
        c5 = view.findViewById(R.id.ib5);

        invisLike1 = view.findViewById(R.id.customLike1);
        invisLike2 = view.findViewById(R.id.customLike2);
        invisLike3 = view.findViewById(R.id.customLike3);
        invisLike4 = view.findViewById(R.id.customLike4);
        invisLike5 = view.findViewById(R.id.customLike5);

        cln1 = view.findViewById(R.id.customLikeNum1);
        cln2 = view.findViewById(R.id.customLikeNum2);
        cln3 = view.findViewById(R.id.customLikeNum3);
        cln4 = view.findViewById(R.id.customLikeNum4);
        cln5 = view.findViewById(R.id.customLikeNum5);

        invisPost1 = view.findViewById(R.id.ip1);
        invisPost2 = view.findViewById(R.id.ip2);
        invisPost3 = view.findViewById(R.id.ip3);
        invisPost4 = view.findViewById(R.id.ip4);
        invisPost5 = view.findViewById(R.id.ip5);

        invisLayout1 = view.findViewById(R.id.p1);
        invisLayout2 = view.findViewById(R.id.p2);
        invisLayout3 = view.findViewById(R.id.p3);
        invisLayout4 = view.findViewById(R.id.p4);
        invisLayout5 = view.findViewById(R.id.p5);

        cc1 = view.findViewById(R.id.cib1);
        cc2 = view.findViewById(R.id.cib2);
        cc3 = view.findViewById(R.id.cib3);
        cc4 = view.findViewById(R.id.cib4);
        cc5 = view.findViewById(R.id.cib5);

        postButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(post.getText().toString().length() == 0){
                    //do nothing
                }
                else{
//                    Context context = v.getContext();
//                    LayoutInflater inflater = LayoutInflater.from(context);
//                    LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.feed_post, null, false);
//                    ((TextView)layout.findViewById(R.id.yourpost)).setText(post.getText().toString());
//                    feed.addView(layout, 0);
                    switch (invisCount){
                        case 1:
                            invisPost1.setText(post.getText().toString());
                            invisLayout1.setLayoutParams(new
                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                            break;
                        case 2:
                            invisPost2.setText(post.getText().toString());
                            invisLayout2.setLayoutParams(new
                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                            break;
                        case 3:
                            invisPost3.setText(post.getText().toString());
                            invisLayout3.setLayoutParams(new
                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                            break;
                        case 4:
                            invisPost4.setText(post.getText().toString());
                            invisLayout4.setLayoutParams(new
                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                            break;
                        case 5:
                            invisPost5.setText(post.getText().toString());
                            invisLayout5.setLayoutParams(new
                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                            break;

                    }
                    post.setText("");
                    invisCount--;

                }
            }
        });
        invisLike1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cln1.setText(Integer.toString(Integer.parseInt(cln1.getText().toString())+1));
                } else {
                    cln1.setText(Integer.toString(Integer.parseInt(cln1.getText().toString())-1));
                }
            }
        });
        invisLike2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cln2.setText(Integer.toString(Integer.parseInt(cln2.getText().toString())+1));
                } else {
                    cln2.setText(Integer.toString(Integer.parseInt(cln2.getText().toString())-1));
                }
            }
        });
        invisLike3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cln3.setText(Integer.toString(Integer.parseInt(cln3.getText().toString())+1));
                } else {
                    cln3.setText(Integer.toString(Integer.parseInt(cln3.getText().toString())-1));
                }
            }
        });
        invisLike4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cln4.setText(Integer.toString(Integer.parseInt(cln4.getText().toString())+1));
                } else {
                    cln4.setText(Integer.toString(Integer.parseInt(cln4.getText().toString())-1));
                }
            }
        });
        invisLike5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cln5.setText(Integer.toString(Integer.parseInt(cln5.getText().toString())+1));
                } else {
                    cln5.setText(Integer.toString(Integer.parseInt(cln5.getText().toString())-1));
                }
            }
        });

        like1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ln1.setText(Integer.toString(Integer.parseInt(ln1.getText().toString())+1));
                } else {
                    ln1.setText(Integer.toString(Integer.parseInt(ln1.getText().toString())-1));
                }
            }
        });
        like2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ln2.setText(Integer.toString(Integer.parseInt(ln2.getText().toString())+1));
                } else {
                    ln2.setText(Integer.toString(Integer.parseInt(ln2.getText().toString())-1));
                }
            }
        });
        like3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ln3.setText(Integer.toString(Integer.parseInt(ln3.getText().toString())+1));
                } else {
                    ln3.setText(Integer.toString(Integer.parseInt(ln3.getText().toString())-1));
                }
            }
        });
        like4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ln4.setText(Integer.toString(Integer.parseInt(ln4.getText().toString())+1));
                } else {
                    ln4.setText(Integer.toString(Integer.parseInt(ln4.getText().toString())-1));
                }
            }
        });
        like5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ln5.setText(Integer.toString(Integer.parseInt(ln5.getText().toString())+1));
                } else {
                    ln5.setText(Integer.toString(Integer.parseInt(ln5.getText().toString())-1));
                }
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        cc1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        cc2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        cc3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        cc4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        cc5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = v.getContext();
                startActivity(new Intent(context, Pop.class));
            }
        });
        return view;
    }
}
