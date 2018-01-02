package com.openyogaland.denis.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener
{
  // constants
  final static String PLUS      = "+";
  final static String MINUS     = "-";
  final static String MULTIPLY  = "*";
  final static String DIVIDE    = "/";
  final static char   DOT       = '.';
  
  // fields
  Button[] buttons;
  TextView textField;
  double numberInMemory   = 0;
  double currentNumber    = 0;
  String currentArgument  = "";
  String choosedOperation = "";
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    // initialize textfield
    textField = findViewById(R.id.text_field);
    
    // initialize array
    buttons = new Button[16];
    
    // initialize buttons
    buttons[0]  = findViewById(R.id.seven);
    buttons[1]  = findViewById(R.id.eight);
    buttons[2]  = findViewById(R.id.nine);
    buttons[3]  = findViewById(R.id.plus);
    buttons[4]  = findViewById(R.id.four);
    buttons[5]  = findViewById(R.id.five);
    buttons[6]  = findViewById(R.id.six);
    buttons[7]  = findViewById(R.id.minus);
    buttons[8]  = findViewById(R.id.one);
    buttons[9]  = findViewById(R.id.two);
    buttons[10] = findViewById(R.id.three);
    buttons[11] = findViewById(R.id.multiply);
    buttons[12] = findViewById(R.id.zero);
    buttons[13] = findViewById(R.id.dot);
    buttons[14] = findViewById(R.id.equals);
    buttons[15] = findViewById(R.id.divide);
  
    for(Button button : buttons)
    {
      button.setOnClickListener(this);
    }
  }
  
  @Override
  public void onClick(View view)
  {
    String buttonPressed;
    
    if (view instanceof Button)
    {
      buttonPressed = (String) ((Button) view).getText();
      switch ((view).getId())
      {
        case R.id.zero:
        case R.id.one:
        case R.id.two:
        case R.id.three:
        case R.id.four:
        case R.id.five:
        case R.id.six:
        case R.id.seven:
        case R.id.eight:
        case R.id.nine:
          // check current argument and add number to it's end
          currentArgument = (String) textField.getText();
          currentArgument += buttonPressed;
          textField.setText(currentArgument);
          break;         
        case  R.id.dot:
          // check current argument and add number to it's end
          currentArgument = (String) textField.getText();
          // if dot is the first symbol in current argument
          if(currentArgument.indexOf(DOT) == 0)
          {
            currentArgument = getString(R.string.zero) + buttonPressed;
          }
          // if there is no dot in current argument
          else if(currentArgument.indexOf(DOT) == -1)
          {
            currentArgument += buttonPressed;
          }
          textField.setText(currentArgument);
          break;
        case R.id.equals:
          if(numberInMemory != 0)
          {
            currentArgument = (String) textField.getText();
            try
            {
              currentNumber = Double.parseDouble(currentArgument);
              switch(choosedOperation)
              {
                case PLUS:
                  currentNumber += numberInMemory;
                  break;
                case MINUS:
                  currentNumber = numberInMemory - currentNumber;
                  break;
                case MULTIPLY:
                  currentNumber *= numberInMemory;
                  break;
                case DIVIDE:
                  currentNumber = numberInMemory / currentNumber;
                  break;
                default:
                  break;
              }
              numberInMemory = currentNumber;
              choosedOperation = "";
              currentArgument = "" + currentNumber;
              textField.setText(currentArgument);
            }
            catch(NumberFormatException e)
            {
              textField.setText(R.string.NaN);
            }
          }
          break;
        case R.id.plus:
          currentArgument = (String) textField.getText();
          try
          {
            if((numberInMemory != 0) && (!"".equals(choosedOperation)))
            {
              currentNumber = Double.parseDouble(currentArgument);
              switch(choosedOperation)
              {
                case PLUS:
                  currentNumber += numberInMemory;
                  break;
                case MINUS:
                  currentNumber = numberInMemory - currentNumber;
                  break;
                case MULTIPLY:
                  currentNumber *= numberInMemory;
                  break;
                case DIVIDE:
                  currentNumber = numberInMemory / currentNumber;
                  break;
                default:
                  break;
              }
              numberInMemory = currentNumber;
            }
            else
            {
              numberInMemory = Double.parseDouble(currentArgument);
            }
            currentNumber = 0;
            currentArgument = "";
            choosedOperation = PLUS;
            textField.setText(currentArgument);
          }
          catch(NumberFormatException e)
          {
            textField.setText(R.string.NaN);
          }
          break;
        case R.id.minus:
          currentArgument = (String) textField.getText();
          try
          {
            if((numberInMemory != 0) && (!"".equals(choosedOperation)))
            {
              currentNumber = Double.parseDouble(currentArgument);
              switch(choosedOperation)
              {
                case PLUS:
                  currentNumber += numberInMemory;
                  break;
                case MINUS:
                  currentNumber = numberInMemory - currentNumber;
                  break;
                case MULTIPLY:
                  currentNumber *= numberInMemory;
                  break;
                case DIVIDE:
                  currentNumber = numberInMemory / currentNumber;
                  break;
                default:
                  break;
              }
              numberInMemory = currentNumber;
            }
            else
            {
              numberInMemory = Double.parseDouble(currentArgument);
            }
            currentNumber = 0;
            currentArgument = "";
            choosedOperation = MINUS;
            textField.setText(currentArgument);
          }
          catch(NumberFormatException e)
          {
            textField.setText(R.string.NaN);
          }
          break;
        case R.id.multiply:
          currentArgument = (String) textField.getText();
          try
          {
            if((numberInMemory != 0) && (!"".equals(choosedOperation)))
            {
              currentNumber = Double.parseDouble(currentArgument);
              switch(choosedOperation)
              {
                case PLUS:
                  currentNumber += numberInMemory;
                  break;
                case MINUS:
                  currentNumber = numberInMemory - currentNumber;
                  break;
                case MULTIPLY:
                  currentNumber *= numberInMemory;
                  break;
                case DIVIDE:
                  currentNumber = numberInMemory / currentNumber;
                  break;
                default:
                  break;
              }
              numberInMemory = currentNumber;
            }
            else
            {
              numberInMemory = Double.parseDouble(currentArgument);
            }
            currentNumber = 0;
            currentArgument = "";
            choosedOperation = MULTIPLY;
            textField.setText(currentArgument);
          }
          catch(NumberFormatException e)
          {
            textField.setText(R.string.NaN);
          }
          break;
        
        case R.id.divide:
          currentArgument = (String) textField.getText();
          try
          {
            if((numberInMemory != 0) && (!"".equals(choosedOperation)))
            {
              currentNumber = Double.parseDouble(currentArgument);
              switch(choosedOperation)
              {
                case PLUS:
                  currentNumber += numberInMemory;
                  break;
                case MINUS:
                  currentNumber = numberInMemory - currentNumber;
                  break;
                case MULTIPLY:
                  currentNumber *= numberInMemory;
                  break;
                case DIVIDE:
                  currentNumber = numberInMemory / currentNumber;
                  break;
                default:
                  break;
              }
              numberInMemory = currentNumber;
            }
            else
            {
              numberInMemory = Double.parseDouble(currentArgument);
            }
            currentNumber = 0;
            currentArgument = "";
            choosedOperation = DIVIDE;
            textField.setText(currentArgument);
          }
          catch(NumberFormatException e)
          {
            textField.setText(R.string.NaN);
          }
          break;
        default:
          break;
      }
    }
  }
}
