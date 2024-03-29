package com.apicela.training.ui.utils

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.apicela.training.R
import com.apicela.training.models.Exercise
import com.apicela.training.models.Muscle
import com.google.android.material.shape.ShapeAppearanceModel
import de.hdodenhof.circleimageview.CircleImageView


class ViewCreator {

    companion object {
        val defaultParam = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        fun checkChilds(mainLinearLayout: LinearLayout): ViewGroup.LayoutParams? {
            for (i in 0 until mainLinearLayout.childCount) {
                val childView = mainLinearLayout.getChildAt(i)
                if (childView is CircleImageView) {
                    return childView.layoutParams
                }
            }
            return null
        }

        fun dpToPx(dp: Int, context: Context): Int {
            val density = context.resources.displayMetrics.density
            return (dp * density).toInt()
        }

        fun convertPixelsToDp(px: Float, context: Context): Float {
            val resources = context.resources
            val metrics = resources.displayMetrics
            return px / (metrics.densityDpi / 160f)
        }

        fun createLinearLayoutForExercise(context: Context): LinearLayout {
            // Criar LinearLayout
            val linearLayout = LinearLayout(
                context,
                null,
                R.style.linearLayoutExercise,
                R.style.linearLayoutExercise
            )
            return linearLayout
        }

        fun createLinearLayoutForDivision(context: Context): LinearLayout {
            // Criar LinearLayout
            val linearLayout = LinearLayout(
                context,
                null,
                R.style.linearLayoutDivision,
                R.style.linearLayoutDivision
            )
            return linearLayout
        }


        var url =
            "https://mir-s3-cdn-cf.behance.net/project_modules/hd/5eeea355389655.59822ff824b72.gif"


        fun createCardViewForWorkout(context: Context, text: String, tag: String?): CardView {
            // Criando um novo CardView
            val cardView = CardView(context, null, R.style.CardView_Workout)
            // Definindo largura e altura do CardView
            cardView.layoutParams = defaultParam

            cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.semi_black))

            // Adicionando uma TextView dentro do CardView
            var text = Text.createTextView(context, text, tag)
            cardView.addView(text)
            val img = Image.createCircleImageView(
                context,
                "muscle_group_chest",
                null,
                context.resources.getDimensionPixelSize(R.dimen.dp75)
            )
            cardView.addView(img)

            return cardView
        }


//        fun createExerciseLine(
//            context: Context,
//            exercise : Exercise,
//            appearanceModel: ShapeAppearanceModel
//        ): LinearLayout {
//            val linearLayout = createLinearLayoutForExercise(context)
//            var img = Image.createCircleImageView(
//                context,
//                exercise.image,
//                appearanceModel,
//                context.resources.getDimensionPixelSize(R.dimen.dp50)
//            )
//            linearLayout.addView(img)
//            var text = Text.createTextView(context, exercise.exerciseName, exercise.muscleType)
//            text.textSize = 16f
//            linearLayout.addView(text)
//            val checkBox = CheckBox(context)
//            linearLayout.addView(checkBox)
//            return linearLayout
//        }

        fun createExerciseLine(
            context: Context,
            exercise: Exercise,
            appearanceModel: ShapeAppearanceModel,
            checkboxVisible : Boolean
        ): LinearLayout {
            val linearLayout = createLinearLayoutForExercise(context)
            linearLayout.orientation = LinearLayout.HORIZONTAL

            var img = Image.createCircleImageView(
                context,
                exercise.image,
                appearanceModel,
                context.resources.getDimensionPixelSize(R.dimen.dp50)
            )
            linearLayout.addView(img)
            val text = Text.createTextView(context, exercise.exerciseName, exercise.muscleType)
            text.textSize = 16f
            val textLayoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                0.7f
            )
            text.layoutParams = textLayoutParams
            linearLayout.addView(text)

            val checkBox = CheckBox(context)
            val checkBoxLayoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                0.1f
            )
            checkBox.layoutParams = checkBoxLayoutParams
            if(!checkboxVisible) { checkBox.visibility = View.INVISIBLE }
            checkBox.tag = "exercise_checkbox"

            linearLayout.addView(checkBox)

            return linearLayout
        }



        fun createDivisionLine(
            context: Context,
            text: String,
            image: String,
            appearanceModel: ShapeAppearanceModel?
        ): LinearLayout {
            val linearLayout = createLinearLayoutForDivision(context)
            linearLayout.layoutParams = defaultParam
            val img = Image.createCircleImageView(
                context,
                image,
                appearanceModel,
                context.resources.getDimensionPixelSize(R.dimen.dp50)
            )
            linearLayout.addView(img)
            val text = Text.createTextView(context, text, null)
            linearLayout.addView(text)
            return linearLayout
        }
    }

}