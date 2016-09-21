package edu.bu.karunesh.ec591.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnOperation;
    private Button submitAnswer;
    private CheckBox cbAddition;
    private CheckBox cbSubtraction;
    private TextView operand1;
    private TextView operand2;
    private TextView operator;
    private EditText answer;
    private TextView opEquals;

    private Boolean addition = false;
    private Boolean subtraction = false;
    private static int count = 0;
    private static int quesCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOperation = (Button) findViewById(R.id.btnOperation);
        submitAnswer = (Button) findViewById(R.id.submitAnswer);
        cbAddition = (CheckBox) findViewById(R.id.cbAddition);
        cbSubtraction = (CheckBox) findViewById(R.id.cbSubtraction);
        answer = (EditText) findViewById(R.id.answer);
        submitAnswer.setEnabled(false);
        btnOperation.setEnabled(false);
        submitAnswer.setVisibility(View.INVISIBLE);
        answer.setEnabled(false);

    }

    protected void setOpBtn(View view){
        if(cbSubtraction.isChecked() || cbAddition.isChecked()){
            btnOperation.setEnabled(true);
        }
        else{
            btnOperation.setEnabled(false);
        }
    }

    protected void opSubmit(View view){
        if(cbAddition.isChecked()){
            addition = true;
        }
        if(cbSubtraction.isChecked()){
            subtraction = true;
        }
        cbAddition.setEnabled(false);
        cbSubtraction.setEnabled(false);
        btnOperation.setVisibility(View.INVISIBLE);
        submitAnswer.setVisibility(View.VISIBLE);

        generateQuestion();
    }

    private void generateQuestion() {
        opEquals = (TextView) findViewById(R.id.opEquals);
        operand1 = (TextView) findViewById(R.id.operand1);
        operand2 = (TextView) findViewById(R.id.operand2);
        operator = (TextView)findViewById(R.id.operator);
        opEquals.setText("=");
        answer.setEnabled(true);
        submitAnswer.setEnabled(true);

        if(addition && !subtraction){
            operand1.setText(String.valueOf(generateRand(0,99)));
            operand2.setText(String.valueOf(generateRand(1,99)));
            operator.setText("+");

        }else if(!addition && subtraction){
            int first = generateRand(1,99);
            operand1.setText(String.valueOf(first));
            operand2.setText(String.valueOf(generateRand(0,first)));
            operator.setText("-");
        }else{
            int temp = generateRand(0,99);

            int numFirst  = generateRand(0,99);
            operand1.setText(String.valueOf(numFirst));

            if(temp%2==0){
                operator.setText("+");
                operand2.setText(String.valueOf(generateRand(1,99)));
            }else{
                operator.setText("-");
                operand2.setText(String.valueOf(generateRand(0,numFirst)));
            }

        }
    }

    private int generateRand(int low, int high) {

        return low + (int)(Math.random() * high);
    }

    public void doSubmit(View view) {
        operand1 = (TextView) findViewById(R.id.operand1);
        operand2 = (TextView) findViewById(R.id.operand2);
        answer = (EditText) findViewById(R.id.answer);

        if(answer == null || answer.getText() == null || answer.getText().toString().equals("")){
            return;
        }
        quesCount++;


        int firstNumber = Integer.parseInt(operand1.getText().toString());
        int secondNumber = Integer.parseInt((operand2.getText().toString()));
        int ans = Integer.parseInt(answer.getText().toString());

        operator = (TextView)findViewById(R.id.operator);

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

        generateQuestion();
        if(quesCount == 10 ){

            operand1.setText("");
            operand2.setText("");
            operator.setText("");
            opEquals.setText("");
            cbAddition.setEnabled(true);
            cbSubtraction.setEnabled(true);
            cbAddition.setChecked(false);
            cbSubtraction.setChecked(false);
            subtraction = false;
            addition = false;
            submitAnswer.setEnabled(false);
            answer.setEnabled(false);
            btnOperation.setEnabled(false);
            submitAnswer.setVisibility(View.INVISIBLE);

            btnOperation.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "your score is : " + count, Toast.LENGTH_LONG).show();
            count = 0;
            quesCount = 0;
        }
        answer.setText("");

    }

}


