package com.kamrulhasan.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_numeric.*

class NumericFragment : Fragment() {
    private var curr_oparator = ""
    private var curr_result = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numeric, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_0.setOnClickListener { tv_result.text = tv_result.text.toString()+0 }
        btn_1.setOnClickListener { tv_result.text = tv_result.text.toString()+1 }
        btn_2.setOnClickListener { tv_result.text = tv_result.text.toString()+2 }
        btn_3.setOnClickListener { tv_result.text = tv_result.text.toString()+3 }
        btn_4.setOnClickListener { tv_result.text = tv_result.text.toString()+4 }
        btn_5.setOnClickListener { tv_result.text = tv_result.text.toString()+5 }
        btn_6.setOnClickListener { tv_result.text = tv_result.text.toString()+6 }
        btn_7.setOnClickListener { tv_result.text = tv_result.text.toString()+7 }
        btn_8.setOnClickListener { tv_result.text = tv_result.text.toString()+8 }
        btn_9.setOnClickListener { tv_result.text = tv_result.text.toString()+9 }

        btn_add.setOnClickListener {
            curr_result = tv_result.text.toString().toInt()
            curr_oparator = "+"
            tv_result.text = ""
        }
        btn_minus.setOnClickListener {
            curr_result = tv_result.text.toString().toInt()
            curr_oparator = "-"
            tv_result.text = ""
        }
        btn_mul.setOnClickListener {
            curr_result = tv_result.text.toString().toInt()
            curr_oparator = "*"
            tv_result.text = ""
        }
        btn_div.setOnClickListener {
            curr_result = tv_result.text.toString().toInt()
            curr_oparator = "/"
            tv_result.text = ""
        }

        var flag = false
        btn_equal.setOnClickListener {
            val num = tv_result.text.toString().toInt()
            when(curr_oparator){
                "+" ->{ curr_result += num}
                "-" ->{ curr_result -= num}
                "*" ->{ curr_result *= num}
                "/" ->{ curr_result /= num }
                else ->{ flag = true }
            }
            if (flag){
                tv_result.text = "Error"
            }else{
                tv_result.text = curr_result.toString()
            }
        btn_C.setOnClickListener {
            tv_result.text = "0"
            curr_result = 0
            curr_oparator = ""
            flag = false
        }  }
    }
//    fun calculate(equation: String): String{
////        val text = tvExpression.text.toString()
//        val expression = ExpressionBuilder()
//            ExpressionBuilder(equation).build()
//
//        val result = expression.evaluate()
//        val longResult = result.toLong()
//    }

}