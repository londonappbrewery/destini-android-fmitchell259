package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView m_question_text;
    Button m_answer_one;
    Button m_answer_two;
    int m_story_index_TOP = 1;
    int m_story_index_BOTTOM = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        m_question_text = findViewById(R.id.storyTextView);
        m_answer_one = findViewById(R.id.buttonTop);
        m_answer_two = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        m_answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                m_story_index_TOP +=1;

                // Completing Left-hand side story arcs.

                if (m_story_index_TOP==2 & m_story_index_BOTTOM>=1) {
                    m_question_text.setText(R.string.T3_Story);
                    m_answer_one.setText(R.string.T3_Ans1);
                    m_answer_two.setText(R.string.T3_Ans2);
                }
                else if (m_story_index_TOP>=2 & m_story_index_BOTTOM>=1) {
                    m_question_text.setText(R.string.T6_End);
                    m_answer_one.setVisibility(View.GONE);
                    m_answer_two.setVisibility(View.GONE);
                }

            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        m_answer_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                m_story_index_BOTTOM +=1;

                // Completing left-hand side story arcs.

                if (m_story_index_TOP==2 & m_story_index_BOTTOM==2) {
                    m_question_text.setText(R.string.T5_End);
                    m_answer_one.setVisibility(View.GONE);
                    m_answer_two.setVisibility(View.GONE);
                }

                // Completing right-hand side story arcs.

                else if (m_story_index_TOP==1 & m_story_index_BOTTOM==2) {
                    m_question_text.setText(R.string.T2_Story);
                    m_answer_one.setText(R.string.T2_Ans1);
                    m_answer_two.setText(R.string.T2_Ans2);

                }

                else if (m_story_index_TOP==1 & m_story_index_BOTTOM==3) {
                    m_question_text.setText(R.string.T4_End);
                    m_answer_one.setVisibility(View.GONE);
                    m_answer_two.setVisibility(View.GONE);
                }

            }
        });


    }
}
