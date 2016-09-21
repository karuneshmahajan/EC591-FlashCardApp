package edu.bu.karunesh.ec591.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private Button btnOperation;
    private CheckBox cbAddition;
    private CheckBox cbSubtration;
    private Boolean addition = false;
    private Boolean subtraction = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOperation = (Button) findViewById(R.id.btnOperation);
        cbAddition = (CheckBox) findViewById(R.id.cbAddition);
        cbSubtration = (CheckBox) findViewById(R.id.cbSubtraction);

    }

    protected void opSubmit(View view){
        if(cbAddition.isChecked()){
            addition = true;
        }
        if(cbSubtration.isChecked()){
            subtraction = true;
        }
        cbAddition.setEnabled(false);
        cbSubtration.setEnabled(false);
        btnOperation.setVisibility(View.INVISIBLE);
    }
}
