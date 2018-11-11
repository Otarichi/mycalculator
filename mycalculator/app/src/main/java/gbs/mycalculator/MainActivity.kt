package gbs.mycalculator

import android.media.VolumeShaper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    } var opperation = false

      fun numberClick (view: View) {
        val button: Button = view as Button
        if (operationTextView.text.toString().isEmpty() && opperation == false)
            argument1TextView.text = argument1TextView.text.toString() + button.text.toString()
        else if (operationTextView.text.toString().isNotEmpty())
            argument2TextView.text = argument2TextView.text.toString() + button.text.toString()

    } fun dotClick (view: View) {
        val button: Button = view as Button
        if (!argument1TextView.text.toString().contains(".") && !argument1TextView.text.toString().equals("-") && !argument1TextView.text.toString().equals("") && operationTextView.text.toString().isEmpty())
            argument1TextView.text = argument1TextView.text.toString() + button.text.toString()
        else if (!argument2TextView.text.toString().contains(".") && !argument2TextView.text.toString().equals("-") && operationTextView.text.toString().isNotEmpty() && !argument2TextView.text.toString().equals(""))
            argument2TextView.text = argument2TextView.text.toString() + button.text.toString()

    } fun deleteClick (view: View) {
        if (argument1TextView.text.toString().isNotEmpty() || argument2TextView.text.toString().isNotEmpty() || operationTextView.text.toString().isNotEmpty()) {
            argument1TextView.text = ""
            argument2TextView.text = ""
            operationTextView.text = ""
            opperation = false
        }

    } fun operationClick (view: View) {
        val button: Button = view as Button
        if (argument1TextView.text.toString().isNotEmpty() && !argument1TextView.text.toString().equals("-") && operationTextView.text.toString().isEmpty())
             operationTextView.text = button.text.toString()

    } fun equalClick (view: View) {
        if (argument1TextView.text.toString().isNotEmpty() && argument2TextView.text.toString().isNotEmpty() && operationTextView.text.toString().isNotEmpty() &&
                !argument1TextView.text.toString().equals("-") && !argument2TextView.text.toString().equals("-")) {
            if (operationTextView.text.toString().equals("-")) {
                var equal = argument1TextView.text.toString().toFloat() - argument2TextView.text.toString().toFloat()
                argument1TextView.text = equal.toString()
                operationTextView.text = ""
                argument2TextView.text = ""
                opperation = true

            } else if (operationTextView.text.toString().equals("+")) {
                var equal = argument1TextView.text.toString().toFloat() + argument2TextView.text.toString().toFloat()
                argument1TextView.text = equal.toString()
                operationTextView.text = ""
                argument2TextView.text = ""
                opperation = true

            } else if (operationTextView.text.toString().equals("/")) {
                var equal = argument1TextView.text.toString().toFloat() / argument2TextView.text.toString().toFloat()
                argument1TextView.text = equal.toString()
                operationTextView.text = ""
                argument2TextView.text = ""
                opperation = true

            } else if (operationTextView.text.toString().equals("x")) {
                var equal = argument1TextView.text.toString().toFloat() * argument2TextView.text.toString().toFloat()
                argument1TextView.text = equal.toString()
                operationTextView.text = ""
                argument2TextView.text = ""
                opperation = true
            }
        }
    } fun substractionOperationClick (view: View) {
        val button: Button = view as Button
        if (argument1TextView.text.toString().isEmpty())
            argument1TextView.text = button.text.toString()
        else if (argument1TextView.text.toString().isNotEmpty() && !argument1TextView.text.toString().equals("-") && operationTextView.text.toString().isEmpty())
            operationTextView.text = button.text.toString()
        else if (operationTextView.text.toString().isNotEmpty() && argument2TextView.text.toString().isEmpty())
            argument2TextView.text = button.text.toString()

    } fun backClick (view: View) {
        if (argument2TextView.text.toString().isNotEmpty()) {
            val string = argument2TextView.text.toString()
            argument2TextView.text = string.substring(0,string.length-1)
        } else if (operationTextView.text.toString().isNotEmpty()) {
            val string = operationTextView.text.toString()
            operationTextView.text = string.substring(0,string.length-1)
        } else if (argument1TextView.text.toString().isNotEmpty()) {
            val string = argument1TextView.text.toString()
            argument1TextView.text = string.substring(0,string.length-1)
        }
    }
}
