package com.example.stackcollabse

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group


class MainActivity : AppCompatActivity() {

    var cardView: CardView? = null
   lateinit var arrow: ImageView
  lateinit var hiddenGroup: Group
    var cardView1: CardView? = null
    lateinit var arrow1: ImageView
    lateinit var hiddenGroup1: Group

    var status = 1
    var status2 = 2

    lateinit var const1 : ConstraintLayout
    lateinit var const2 : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardView = findViewById(R.id.base_cardview);
        arrow = findViewById(R.id.show);
        hiddenGroup = findViewById(R.id.card_group);
        cardView1 = findViewById(R.id.base_cardview2);
        arrow1 = findViewById(R.id.show2);
        hiddenGroup1 = findViewById(R.id.card_group1);
        const1 = findViewById(R.id.const1);
        const2 = findViewById(R.id.const2);

        const1.setOnClickListener(View.OnClickListener { view: View? ->
            if (hiddenGroup.getVisibility() == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                hiddenGroup.setVisibility(View.GONE)
                arrow.setImageResource(android.R.drawable.arrow_down_float)
            } else {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                hiddenGroup.setVisibility(View.VISIBLE)
                status = 11
                arrow.setImageResource(android.R.drawable.arrow_up_float)
                if (status2 == 22){
                    TransitionManager.beginDelayedTransition(cardView1, AutoTransition())
                    hiddenGroup1.setVisibility(View.GONE)
                    arrow1.setImageResource(android.R.drawable.arrow_down_float)
                }
            }
        })

        const2.setOnClickListener(View.OnClickListener { view: View? ->
            if (hiddenGroup1.getVisibility() == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(cardView1, AutoTransition())
                hiddenGroup1.setVisibility(View.GONE)
                arrow1.setImageResource(android.R.drawable.arrow_down_float)
            } else {
                TransitionManager.beginDelayedTransition(cardView1, AutoTransition())
                hiddenGroup1.setVisibility(View.VISIBLE)
                arrow1.setImageResource(android.R.drawable.arrow_up_float)
                status2 = 22

                if (status == 11){
                    TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                    hiddenGroup.setVisibility(View.GONE)
                    arrow.setImageResource(android.R.drawable.arrow_down_float)
                }
            }
        })

    }

}