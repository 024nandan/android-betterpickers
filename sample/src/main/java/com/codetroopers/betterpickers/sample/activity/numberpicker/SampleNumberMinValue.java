package com.codetroopers.betterpickers.sample.activity.numberpicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codetroopers.betterpickers.numberpicker.NumberPickerBuilder;
import com.codetroopers.betterpickers.numberpicker.NumberPickerDialogFragment;
import com.codetroopers.betterpickers.sample.R;
import com.codetroopers.betterpickers.sample.activity.BaseSampleActivity;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * User: derek Date: 3/17/13 Time: 3:59 PM
 */
public class SampleNumberMinValue extends BaseSampleActivity
        implements NumberPickerDialogFragment.NumberPickerDialogHandlerV2 {

    private TextView text;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_and_button);

        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        final BigDecimal minNumberAllowed = new BigDecimal("1227");

        text.setText(R.string.no_value);
        button.setText("Set Number above " + minNumberAllowed);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberPickerBuilder npb = new NumberPickerBuilder()
                        .setFragmentManager(getSupportFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment)
                        .setMinNumber(minNumberAllowed);
                npb.show();
            }
        });
    }

    @Override
    public void onDialogNumberSet(int reference, BigInteger number, double decimal, boolean isNegative, BigDecimal fullNumber) {
        text.setText("Number: " + number + "\nDecimal: " + decimal + "\nIs negative: " + isNegative + "\nFull number: "
                + fullNumber);
    }
}
