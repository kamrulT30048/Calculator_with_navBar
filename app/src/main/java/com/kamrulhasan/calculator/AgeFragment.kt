package com.kamrulhasan.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.core.graphics.green
import kotlinx.android.synthetic.main.fragment_age.*
import java.util.Calendar

class AgeFragment : Fragment() {
    var ageDay = 0
    var ageMonth = 0
    var ageYear = 0
    var currentDay = 0
    var currentMonth = 0
    var currentYear = 0
    var birthDay = 0
    var birthMonth = 0
    var birthYear = 0
    val buttonMassageAgain = "Try Again"
    val buttonMassageAge = "Calculate Age"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_age, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dateOfBirth : DatePicker = dp_birthday
        // pick the current date
        val today = Calendar.getInstance()
        currentDay = today.get(Calendar.DAY_OF_MONTH)
        currentMonth = today.get(Calendar.MONTH)
        currentYear = today.get(Calendar.YEAR)

        val currentDateMassage = "Today's Date: $currentDay/$currentMonth/$currentYear"
        tv_today_date.text = currentDateMassage
        btn_calculate_age.text = buttonMassageAge

        btn_calculate_age.setOnClickListener {
            if(btn_calculate_age.text.toString() == buttonMassageAge){
                birthDay = dateOfBirth.dayOfMonth
                birthMonth = dateOfBirth.month
                birthYear = dateOfBirth.year

                calculateAge()

                val birthDateMassage = "Date of Birth: $birthDay/$birthMonth/$birthYear"

                val massage = "Your age is \n" +
                        "$ageYear year,\n" +
                        "$ageMonth months,\n" +
                        "$ageDay days"

                tv_age_show.text = massage
                dp_birthday.visibility = View.GONE
                tv_birth_day.text = birthDateMassage
                btn_calculate_age.text = buttonMassageAgain

            }else{
                val birthDateMassage = "Today's Date: "
                tv_age_show.text = ""
                dp_birthday.visibility = View.VISIBLE
                tv_birth_day.text = birthDateMassage
                btn_calculate_age.text = buttonMassageAge
            }
        }

//        tv_birth_day.setOnClickListener {
//            dp_birthday.visibility = View.VISIBLE
//            tv_age_show.text = ""
//        }
    }

    private fun calculateAge() {
        var carry = false
        //day
        if (currentDay < birthDay) {
            ageDay = (currentDay + 30) - birthDay
            carry = true
        } else {
            ageDay = currentDay - birthDay
        }
        //month
        if (carry) {
            birthMonth += 1
            carry = false
        }
        if (currentMonth < birthMonth) {
            ageMonth = (currentMonth + 12) - birthMonth
            carry = true
        } else {
            ageMonth = currentMonth - birthMonth
        }
        //year
        if (carry) {
            ageYear = currentYear - (birthYear + 1)
        } else {
            ageYear = currentYear - birthYear
        }
    }
}