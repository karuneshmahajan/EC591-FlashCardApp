package edu.bu.karunesh.ec591.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btnOperation;
    private CheckBox cbAddition;
    private CheckBox cbSubtration;
    private Boolean addition = false;
    private Boolean subtraction = false;
    private static int count = 0;

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

    public void doSubmit(View view) {

        TextView operand1 = (TextView) findViewById(R.id.operand1);
        TextView operand2 = (TextView) findViewById(R.id.operand2);
        EditText answer = (EditText) findViewById(R.id.answer);


        int firstNumber = Integer.parseInt(operand1.getText().toString());
        int secondNumber = Integer.parseInt((operand2.getText().toString()));
        int ans = Integer.parseInt(answer.getText().toString());

        TextView operator = (TextView)findViewById(R.id.operator);

        String operatorVal = operator.getText().toString();

        if(operatorVal.equals("+")){
            if(ans == (firstNumber + secondNumber)){
                count ++;
            }
        }else{
            if(ans == (firstNumber - secondNumber)){
                count ++;
            }
        }

        operand1.setText("");
        operand2.setText("");
        operator.setText("");
        answer.setText("");


    }

}


